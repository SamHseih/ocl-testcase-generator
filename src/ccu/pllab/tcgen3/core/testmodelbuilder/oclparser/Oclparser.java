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
    private  List<String> lexicalErrors  = new ArrayList<>();
    private  List<String> syntaxErrors   = new ArrayList<>();
    private  List<String> semanticErrors = new ArrayList<>();
    private List<String> scopeIOdetail;
    
	public Oclparser(Path ocl, Scope predefinedUmlScope) {
		this.symbolTable = predefinedUmlScope;
		oclFile = ocl;
	}
	
	/** 一次完成：ParseTree → AST → 符號表擴充 */
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
    /** 建立 ANTLR ParseTree；若已建立則直接回傳 */
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

        /* 根據 g4 最上層 rule 取決於您的語法檔：
           這裡假設為 packageDeclarationCS() */
        parseTree = parser.packageDeclarationCS();
    }
    /** 走訪 ParseTree 取得 AST，同時擴充符號表並收集語意錯誤 */
    private void buildAstAndSymbolTable() {
        AstBuilderVisitor visitor = new AstBuilderVisitor(symbolTable);
        ast          = visitor.visit(parseTree);
        symbolTable  = visitor.getCurrentGlobalScope(); // 若 Visitor 有新增符號
        semanticErrors = visitor.getSemanticErrors();
        scopeIOdetail = visitor.getScopeIOdetail();
    }
 



	

}
