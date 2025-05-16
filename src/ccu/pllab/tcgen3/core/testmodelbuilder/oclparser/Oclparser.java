package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclLexer;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.SymbolTable;
import ccu.pllab.tcgen3.symboltable.scope.BaseScope;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

/** Tcgen = Test Case generate <br>
 * input: oclfile  , output: AST and Symbol table Structure*/
public class Oclparser {
	private Scope symbolTable;
	private ParseTree parseTree;
	private Path oclFile;
	private ASTree ast;
	
	/* ���~���� */
    private final List<String> lexicalErrors  = new ArrayList<>();
    private final List<String> syntaxErrors   = new ArrayList<>();
    private final List<String> semanticErrors = new ArrayList<>();
    
	public Oclparser(Path ocl, Scope predefinedUmlScope) {
		this.symbolTable = predefinedUmlScope;
		oclFile = ocl;
	}

	public boolean hasErrors() {
        return !lexicalErrors.isEmpty() ||
               !syntaxErrors.isEmpty()  ||
               !semanticErrors.isEmpty();
    }
	
	/** �@�������GParseTree �� AST �� �Ÿ����X�R */
    public void build() throws IOException {
        buildParseTree();
        buildAstAndSymbolTable();
    }
    
    public Scope  getSymbolTable() { return symbolTable; }
    public ASTree getAst()         { return ast;         }
    
    public List<String> getLexicalErrors()  { return lexicalErrors;  }
    public List<String> getSyntaxErrors()   { return syntaxErrors;   }
    public List<String> getSemanticErrors() { return semanticErrors; }
    
 // ---------- internal steps ---------- //
    
    /** �إ� ANTLR ParseTree�F�Y�w�إ߫h�����^�� */
    private void buildParseTree() throws IOException {
        if (parseTree != null) return;

        if (!Files.exists(oclFile))
            throw new IOException("OCL file not found: " + oclFile.toAbsolutePath());

        CharStream input = CharStreams.fromString(Files.readString(oclFile));

        // Lexer
        OclLexer lexer = new OclLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new CollectingErrorListener(lexicalErrors));
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Parser
        OclParser parser = new OclParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new CollectingErrorListener(syntaxErrors));

        /* �ھ� g4 �̤W�h rule ���M��z���y�k�ɡG
           �o�̰��]�� packageDeclarationCS() */
        parseTree = parser.packageDeclarationCS();
    }

    /** ���X ParseTree ���o AST�A�P���X�R�Ÿ���æ����y�N���~ */
    private void buildAstAndSymbolTable() {
        AstBuilderVisitor visitor = new AstBuilderVisitor(symbolTable);
        
        ast          = visitor.visit(parseTree);
        symbolTable  = visitor.getCurrentGlobalScope(); // �Y Visitor ���s�W�Ÿ�
    }
    
    
	private void buildparseTree() {
		String s = null;
		try {
			s = Files.readString(oclFile);
		} catch (IOException e) {
			System.err.println("Error reading file: " + oclFile);
			e.printStackTrace();
		}
		CharStream input = CharStreams.fromString(s);
		
		// �إ� Lexer �M Token Stream
		OclLexer lexer = new OclLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// �إ� Parser
		OclParser parser = new OclParser(tokens);
		//PackageDeclarationCSContext is instance of ParseTree
		ParseTree tree = parser.packageDeclarationCS(); // �ھڧA���y�k�W�h�W�٭ק�
		
		parseTree =  tree;
	}
	
	/** treverse the parse tree and build AST */
	/*public SymbolTable buildsymboltable() {
		OclListener listener = new OclListener(symboltable);
		ParseTreeWalker walker = new ParseTreeWalker();
		if (this.parseTree == null) {
			System.err.println("Parse tree is null");
			return null;
		}
		walker.walk(listener,this.parseTree);
		symboltable = listener.getSymboltable();
		return listener.getSymboltable();
	}*/

	public void buildast() {
		buildparseTree();
		AstBuilderVisitor astVisitor = new AstBuilderVisitor(symbolTable);
		this.ast = astVisitor.visit(parseTree);
	}


	

}
