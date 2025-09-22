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
    private  List<String> lexicalErrors  = new ArrayList<>();
    private  List<String> syntaxErrors   = new ArrayList<>();
    private  List<String> semanticErrors = new ArrayList<>();
    private List<String> scopeIOdetail;
    
	public Oclparser(Path ocl, Scope predefinedUmlScope) {
		this.symbolTable = predefinedUmlScope;
		oclFile = ocl;
	}
	
	/** �@�������GParseTree �� AST �� �Ÿ����X�R */
    public void build() throws IOException {
        buildParseTree();
        this.syntaxErrors = CollectingSyntaxErrorListener.errors;
        if(CollectingSyntaxErrorListener.hasError) {
        	System.out.println(syntaxErrors);
        }else { 
        	buildAstAndSymbolTable();
        	if(!(semanticErrors.isEmpty())) {
        		System.out.println("SemanticErrors!\n");
        		System.out.println(semanticErrors);
        	}
        	}
    }
    
    public Scope  getSymbolTable() { return symbolTable; }
    public ASTree getAst()         { return ast;         }
    
    public List<String> getLexicalErrors()  { return lexicalErrors;  }
    public List<String> getSyntaxErrors()   { return syntaxErrors;   }
    public List<String> getSemanticErrors() { return semanticErrors; }
    
    public boolean hasError() {
    	if(lexicalErrors.isEmpty() && this.syntaxErrors.isEmpty() && this.semanticErrors.isEmpty())
    		return true;
    	else return false;
    }
    
 // ---------- internal steps ---------- //
    /** �إ� ANTLR ParseTree�F�Y�w�إ߫h�����^�� */
    private void buildParseTree() throws IOException {
        if (parseTree != null) return;

        if (!Files.exists(oclFile))
            throw new IOException("OCL file not found: " + oclFile.toAbsolutePath());

        CharStream input = CharStreams.fromString(Files.readString(oclFile));

        // Lexer
        OclLexer lexer = new OclLexer(input);
//        lexer.removeErrorListeners();
//        lexer.addErrorListener(new CollectingSyntaxErrorListener());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CollectingSyntaxErrorListener.reset();
        // Parser
        OclParser parser = new OclParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new CollectingSyntaxErrorListener());

        /* �ھ� g4 �̤W�h rule ���M��z���y�k�ɡG
           �o�̰��]�� packageDeclarationCS() */
        parseTree = parser.packageDeclarationCS();
    }
    /** ���X ParseTree ���o AST�A�P���X�R�Ÿ���æ����y�N���~ */
    private void buildAstAndSymbolTable() {
        AstBuilderVisitor visitor = new AstBuilderVisitor(symbolTable);
        ast          = visitor.visit(parseTree);
        symbolTable  = visitor.getCurrentGlobalScope(); // �Y Visitor ���s�W�Ÿ�
        semanticErrors = visitor.getSemanticErrors();
        scopeIOdetail = visitor.getScopeIOdetail();
    }
 



	

}
