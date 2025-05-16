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
	
	/* 錯誤收集 */
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
	
	/** 一次完成：ParseTree → AST → 符號表擴充 */
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
    
    /** 建立 ANTLR ParseTree；若已建立則直接回傳 */
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

        /* 根據 g4 最上層 rule 取決於您的語法檔：
           這裡假設為 packageDeclarationCS() */
        parseTree = parser.packageDeclarationCS();
    }

    /** 走訪 ParseTree 取得 AST，同時擴充符號表並收集語意錯誤 */
    private void buildAstAndSymbolTable() {
        AstBuilderVisitor visitor = new AstBuilderVisitor(symbolTable);
        
        ast          = visitor.visit(parseTree);
        symbolTable  = visitor.getCurrentGlobalScope(); // 若 Visitor 有新增符號
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
		
		// 建立 Lexer 和 Token Stream
		OclLexer lexer = new OclLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// 建立 Parser
		OclParser parser = new OclParser(tokens);
		//PackageDeclarationCSContext is instance of ParseTree
		ParseTree tree = parser.packageDeclarationCS(); // 根據你的語法規則名稱修改
		
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
