package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclBaseVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.AdditiveExpressionContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.AdditiveOperatorContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ArgumentsCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ArrayAccessCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.CallExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ClassArrayAccessAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ClassFeatureCallAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ClassifierContextDeclContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.CollectionDeclAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.CollectionLiteralExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.CollectionRangeCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.CollectionitemContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ContextContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ContextDeclContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.FeatureCallExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.HasRturnTypeAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.IfExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ImpliciteOpCallAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.IndexExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.IterateCallAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.LetExprCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.LiteralExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.LogicalExpressionContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.LogicalOperatorContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.LoopExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.MultiplicativeExpressionContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.MultiplicativeOperatorContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.NoReturnTypeAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.NonCallExpContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.OperationCallExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.PackageDeclarationCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.PrimitiveLiteralExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.PropertyCallExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.RelationalExpressionContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.RelationalOperatorContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ResultArrayAccessAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ResultFeatureCallAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.UnaryExpressionContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.VarArrayAccessAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.VarFeatureCallAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.VariableDeclAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.VariableDeclContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.VariableExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ClassifierContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextExpAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.InvalidAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.OperationContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.PackageDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.ArrayRefExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BooleanLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionItem;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionRange;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.FeatureCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IntegerLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.LetExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.OperationCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.PropertyCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.ResultExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.SelfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.StringLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.UnaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableDeclExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableExp;
import ccu.pllab.tcgen3.symboltable.BaseSymbol;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.FieldSymbol;
import ccu.pllab.tcgen3.symboltable.FunctionSymbol;
import ccu.pllab.tcgen3.symboltable.MethodSymbol;
import ccu.pllab.tcgen3.symboltable.ParameterSymbol;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.VariableSymbol;
import ccu.pllab.tcgen3.symboltable.scope.BaseScope;
import ccu.pllab.tcgen3.symboltable.scope.GlobalScope;
import ccu.pllab.tcgen3.symboltable.scope.LocalScope;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.ArrayTypeClassSymbol;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

/**
	 * Traverse ANTLR-generated OCL parse-tree and build our domain AST while<br>
	 * performing *basic* semantic checks (duplicate declarations, unknown
	 * references, simple type lookup).<br><br>
	 * <b>Important design decisions</b>
	 * <ul>
	 *   <li>We <em>never</em> mutate the <code>Scope</code> instance passed from the UML-side
	 *       directly.  Instead, each OCL context that introduces a block (package,
	 *       context, iterate, let, etc.) creates its own {@link BaseScope} whose
	 *       <code>enclosingScope</code> is whatever is on the top of {@link #currentScope}.
	 *       This keeps look-ups correct while ensuring we do not pollute the global
	 *       table.</li>
	 *   <li>All {@code visitXXX} methods return an {@link ASTree}.  The concrete
	 *       subclasses live under <code>ccu…ast.impl</code>.  If a particular grammar rule
	 *       does not contribute to the final AST we simply delegate to
	 *       {@link #visitChildren} and return the first child.</li>
	 *   <li>Minimal, practical error-reporting: discovered problems are collected in
	 *       {@link #semanticErrors}.  Parsing continues so that we can show <em>all</em>
	 *       errors to the user in one pass.</li>
	 * </ul>
	 */
public class AstBuilderVisitor extends OclBaseVisitor<ASTree> {
	
	/* =====================================================
     *  Fields & constructor
     * ===================================================== */
    private Scope currentScope;  
    private List<String> scopeIOdetail = new ArrayList<>();;
    private final List<String> semanticErrors = new ArrayList<>();
    private boolean insidePost = false;          // debug result in pre/inv
    
    /*1. duplicate declaration 2. reference to undeclared variable.
     * Note that semantic errors are different from syntax errors.*/
    
    public AstBuilderVisitor(Scope predefinedGlobalScope) {
        if (predefinedGlobalScope == null) {
            throw new IllegalArgumentException("predefinedGlobalScope must not be null");
        }
        this.currentScope = predefinedGlobalScope;// UML generated symbols
    	}
	
    /* =====================================================
     *  Helper utilities
     * ===================================================== */
    private Scope currentScope() {
        return currentScope;
    	}

    private void enterScope(Scope s) {
    	this.currentScope = s;
    	String str = "entering: "+currentScope.getName()+":"+s.toString();
    	//System.out.println("entering: "+currentScope.getName()+":"+s);
    	scopeIOdetail.add(str);
    	}

    private void exitScope() {
    	//System.out.println("leaving: "+currentScope.getName()+":"+currentScope);
    	String str = "leaving: "+currentScope.getName()+":"+currentScope.toString();
    	scopeIOdetail.add(str);
		currentScope = currentScope.getEnclosingScope();
    	}
/*
    private void recordError(String msg, int line, int column) {
        semanticErrors.add(String.format("%s (%d:%d)", msg, line, column));
    	}*/
    private void recordError(String msg, Token t) {
        semanticErrors.add(String.format("%s (%d:%d)", msg, t.getLine(), t.getCharPositionInLine()+1));
    }
    
    /* =====================================================
     *  Package  Syntax..
     *  packageDeclarationCShg : 'package' pathNameCS ownedMemberDeclaration* 'endpackage' ;
     * ===================================================== */
	@Override
	public ASTree visitPackageDeclarationCS(PackageDeclarationCSContext ctx) {
		
		List<ASTree> contextdecls = new ArrayList<>();
        for (ContextDeclContext memberCtx : ctx.contextDecl()) {
            ASTree child = visit(memberCtx);
            if (child != null) {
            	contextdecls.add(child);
            }
        }
        
        String pkgName = ctx.pathNameCS().getText();
		PackageDeclAST pkgNode = new PackageDeclAST(contextdecls,pkgName);
        return pkgNode;
		}
	/* =====================================================
     *  ContextDecl
     *  contextDecl : classifierContextDecl context* | operationContextDecl context* ;
     * ===================================================== */
	@Override
	public ASTree visitContextDecl(ContextDeclContext ctx) {
		ASTree  declcontext = (ctx.classifierContextDecl() != null ?
                visit(ctx.classifierContextDecl()) : visit(ctx.operationContextDecl()));
		
		List<ASTree> contextExps = new ArrayList<>();
        // 後面可能跟著多個 inv/pre/post 等 constraint
        for (ContextContext cctx : ctx.context()) {
        	contextExps.add((ContextExpAST) visit(cctx)); 
        }
        
        ContextDeclAST decl = new ContextDeclAST(declcontext, contextExps);
        
        while(!(currentScope() instanceof ClassSymbol)) {
			exitScope(); // 進入 class scope 時，會多一層 scope
		}
        exitScope();//Into Global scope
        
        return decl;
	}
	/* =====================================================
	 *  classifierContextDecl : context' className=pathNameCS
	 * =====================================================*/
	@Override
	public ASTree visitClassifierContextDecl(ClassifierContextDeclContext ctx) {
		String className = ctx.pathNameCS().getText();
        Token tok = ctx.getStart();
        Symbol s = currentScope().resolve(className);
        if (!(s instanceof ClassSymbol)) {
        	recordError("ContestDecl Error: UnDefined classifier " + className, tok);
        	}
        enterScope((ClassSymbol)s);
        /* inject implicit 'self' variable , type Class*/
		ClassSymbol clazz = (ClassSymbol) s;        
        if (clazz.resolve("self") == null) {
        	FieldSymbol selfSym = new FieldSymbol("self", "<implicit>");
            selfSym.setType(clazz); //Return type
            clazz.define(selfSym);          // 在 class scope
        }
        return new ClassifierContextDeclAST(className);
    }

	/* ===================================================== 
	 * operationContextDecl  
	 * : 'context' className=pathNameCS '::' operationName = ID '(' contextOpParameters? ')'  # NoRturnTypeAlt
	 * | 'context' className=pathNameCS '::' operationName = ID '(' contextOpParameters? ')' ':' type # HasRturnTypeAlt
	 * ;
	 * =====================================================*/
	@Override
	public ASTree visitNoReturnTypeAlt(NoReturnTypeAltContext ctx) {
		String clsName = ctx.pathNameCS().getText();
        String opName  = ctx.ID().getText();
        Token  tok     = ctx.getStart();

        Symbol clsSym = currentScope().resolve(clsName);
        if (!(clsSym instanceof ClassSymbol)) {
            recordError("ContestDecl Error: UnDefined classifier " + clsName, tok);
            return null;
        }
        enterScope((Scope) clsSym); // 進入 class scope
        
        ClassSymbol clazz   = (ClassSymbol) clsSym;
        MethodSymbol method = clazz.resolveMethod(opName);
        if (method == null) {
           recordError("ContestDecl Error: UnDefined operation " + opName, tok);
           return null;
        }

        enterScope(method); 
        /* inject implicit 'self' variable , type Class*/
        if (clazz.resolve("self") == null) {
        	FieldSymbol selfSym = new FieldSymbol("self", "<implicit>");
            selfSym.setType(clazz); //Return type
            clazz.define(selfSym);          // 在 class scope
        }
        /* inject implicit 'result' variable*/
        if (method.resolve("result") == null) {
            VariableSymbol res = new VariableSymbol("result", "<implicit>");
            res.setType(method.getType()); //Return type          
            method.define(res);
        }
        
        //set parameters
        List<ASTree> params = new ArrayList<>();
        if (ctx.variableDecls() != null) {
        	for (VariableDeclContext vctx : ctx.variableDecls().variableDecl()) {
        		 ASTree pAst = visit(vctx);
                if (pAst != null) {
                	params.add(pAst);
                }
            }
        }
        OperationContextDeclAST decl = new OperationContextDeclAST(params, opName, clsName);
        return decl; 
	}
	
	@Override
	public ASTree visitHasRturnTypeAlt(HasRturnTypeAltContext ctx) {
		String clsName = ctx.pathNameCS().getText();
		String opName  = ctx.ID().getText();
        Token  tok     = ctx.getStart();

        Symbol clsSym = currentScope().resolve(clsName);
        if (!(clsSym instanceof ClassSymbol)) {
            recordError("OperationContestDecl Error: UnDefined classifier " + clsName, tok);
            return null;
        }
        enterScope((Scope) clsSym); // 進入 class scope

        ClassSymbol clazz   = (ClassSymbol) clsSym;
        MethodSymbol method = clazz.resolveMethod(opName);
        if (method == null) {
           recordError("OperationContestDecl Error: UnDefined operation " + opName, tok);
           return null;
        }

        enterScope(method); 
        
        /* inject implicit 'self' variable , type Class*/
        if (clazz.resolve("self") == null) {
        	FieldSymbol selfSym = new FieldSymbol("self", "<implicit>");
            selfSym.setType(clazz); //Return type
            clazz.define(selfSym);          // 在 class scope
        }
        /* inject implicit 'result' variable*/
        if (method.resolve("result") == null) {
            VariableSymbol res = new VariableSymbol("result", "<implicit>");
            res.setType(method.getType()); //Return type          
            method.define(res);
        }
        
        //set parameters
        List<ASTree> params = new ArrayList<>();
        if (ctx.variableDecls() != null) {
        	for (VariableDeclContext vctx : ctx.variableDecls().variableDecl()) {
        		 ASTree pAst = visit(vctx);
                if (pAst != null) {
                	params.add(pAst);
                }
            }
        }
        OperationContextDeclAST opdeclast = new OperationContextDeclAST(params, opName, clsName);
        
        
        //set return type
        String ret = ctx.type().getText();
        Token rtk = ctx.type().getStart();
        FunctionSymbol f = (FunctionSymbol) currentScope();
        Type returntype  = f.getType();
        if (returntype == null) {
			recordError("OperationContestDecl Error: UnDefined return type " + ret, rtk);
			return null;
		}
        if(ret.contains("[]")) {
        	if(!(returntype instanceof ArrayTypeClassSymbol)) {
        		recordError("OperationContestDecl Error: UML or Ocl defined different return type " + ret, rtk);
        	}
        }
        opdeclast.setReturnType(returntype);
        
        return opdeclast; // pop 一層留給 visitContextDecl
	}
	/* ===================================================== 
	 * context  
	 * : 'inv'  ID? ':' oclExpressionCS 
	 * | 'pre'  ID? ':' oclExpressionCS 
	 * | 'post' ID? ':' oclExpressionCS 
	 * ;
	 * =====================================================*/
	@Override
	public ASTree visitContext(ContextContext ctx) {
		String kw = ctx.getChild(0).getText();
        String label = ctx.ID() == null ? "" : ctx.ID().getText();
        
        /* debug result area*/
        boolean old  = this.insidePost;
        this.insidePost   = "post".equals(kw);
        /* debug result end*/
        
        ASTree exp = visit(ctx.oclExpressionCS());
        
        /* debug result area*/
        insidePost   = old; 
        /* debug result end*/
        
        return new ContextExpAST(List.of(exp), kw, label);
	}
	/* =====================================================
     *  Variable declarations
     * ===================================================== */

	@Override
	public ASTree visitVariableDeclAlt(VariableDeclAltContext ctx) {
		//ID is a method generated to correspond to the token ID in the source grammar.
		// variableDeclAlt : ID ':' type ('=' expression)? ;
        Token idToken = ctx.ID().getSymbol();
        String varName = idToken.getText();
        String typeName = ctx.type().getText();

        Type typeSym = currentScope().resolveType(typeName);
  
        if(typeName.contains("[]")) {
        	Symbol sym = currentScope().resolve(varName);
        	if(sym == null | !(sym instanceof ParameterSymbol)) {
        		recordError("VariableDecl Error: UnDefined Parameter '" + varName + "'", idToken);
        	} else if(sym instanceof ParameterSymbol p){
        		typeSym = p.getType();
        	}	
        }
        
        if(typeSym == null) {
    		recordError("VariableDecl Error: UnDefined Type '" + varName +":"+ typeName+"'", idToken);
        }
        
        
        if(currentScope() instanceof LocalScope) {
        	if (currentScope().resolve(varName) != null) {
        		recordError("VariableDecl Error: Duplicate declaration of variable '" + varName + "'", idToken);
        	}
            if (typeSym == null || !(typeSym instanceof Type)) {
            	recordError("VariableDecl Error: Unknown type '" + typeName + "'", idToken);
            }
            
            // Create a new VariableSymbol and add it to the current scope
            VariableSymbol varSym = new VariableSymbol(varName, "localVar"); // id not needed here
            varSym.setType((Type) typeSym);
            currentScope().define(varSym);
            
        }else {
        	if (currentScope().resolve(varName) == null) {
			recordError("VariableDecl Error: UnDefined variable '" + varName + "'", idToken);
			return null;
			}
        }
        
        //check Var initializ
        if(ctx.oclExpressionCS() != null) {
			ASTree initExp = visit(ctx.oclExpressionCS());
			if (initExp == null) {
				recordError("VariableDecl Error: UnDefined variable init" + varName + "'", idToken);
				return null;
			}
			
			return new VariableDeclExp(List.of(initExp),varName, (Type)typeSym);
		}
  
		return new VariableDeclExp(List.of(),varName, (Type)typeSym);
	}
	
	//Only for LocalScope
	@Override
	public ASTree visitCollectionDeclAlt(CollectionDeclAltContext ctx) {
		Token idToken = ctx.getStart();
        String collectionName = ctx.collectionTypeIdentifierCS().getText();
        String typeName = ctx.type().getText();
        
        Type typeSym = currentScope().resolveType(typeName);

        
        if(currentScope() instanceof LocalScope) {
        	if (currentScope().resolve(collectionName) != null) {
            recordError("VariableDecl Error: Duplicate declaration of variable '" + collectionName + "'", idToken);
        	}
            if (typeSym == null || !(typeSym instanceof Type)) {
            recordError("VariableDecl Error: Unknown type '" + typeName + "'", idToken);
            }
            
            // Create a new VariableSymbol and add it to the current scope
            VariableSymbol varSym = new VariableSymbol(collectionName, "localVar"); // id not needed here
            varSym.setType((Type) typeSym);
            currentScope().define(varSym);
            
        }else {
			recordError("CollectionDecl Error: CollectionDecl only for LocalScope'" + collectionName + "'", idToken);
			return null;
        }
        return new VariableDeclExp(List.of(),collectionName, (Type)typeSym);
	}

	/* =====================================================
     *  OCL EXPRESSIONS - BinaryExp 
     * ===================================================== */
	
	@Override
	public ASTree visitLogicalExpression(LogicalExpressionContext ctx) {	
		List<RelationalExpressionContext> terms = ctx.relationalExpression();        
		if(ctx.logicalOperator() != null) {
		    List<LogicalOperatorContext> ops    = ctx.logicalOperator();      
		    
			ASTree left = visit(ctx.relationalExpression(0));
			for (int i = 0; i < ops.size(); i++) {
				String op = ctx.logicalOperator(i).getText();
				ASTree right = visit(ctx.relationalExpression(i + 1));
				left = new BinaryExp(List.of(left, right), op);
			}
			
			return left;
		} else {
			return visit(terms.get(0));
		}
	}

	@Override
	public ASTree visitRelationalExpression(RelationalExpressionContext ctx) {
		List<AdditiveExpressionContext> terms = ctx.additiveExpression();        // at least 1 

	    if(ctx.relationalOperator() != null) {
			List<RelationalOperatorContext> ops        = ctx.relationalOperator();  
			ASTree left = visit(ctx.additiveExpression(0));
			for (int i = 0; i < ops.size(); i++) {
				String op = ctx.relationalOperator(i).getText();
				ASTree right = visit(ctx.additiveExpression(i + 1));
				left = new BinaryExp(List.of(left, right), op);
			}
			
			return left;
	    } else {
	    	return visit(terms.get(0));
	    }
	}

	@Override
	public ASTree visitAdditiveExpression(AdditiveExpressionContext ctx) {
		List<MultiplicativeExpressionContext> terms = ctx.multiplicativeExpression();        // 至少 1 個
	    
	    if(ctx.additiveOperator() != null) {
	    	List<AdditiveOperatorContext> ops        = ctx.additiveOperator();      // at least 1
			
			ASTree left = visit(terms.get(0));
			for (int i = 0; i < ops.size(); i++) {
				String op = ctx.additiveOperator(i).getText();
				ASTree right = visit(ctx.multiplicativeExpression(i + 1));
				left = new BinaryExp(List.of(left, right), op);
			}
			return left;
	    } else {
	    	return visit(terms.get(0));
	    }
	}

	@Override
	public ASTree visitMultiplicativeExpression(MultiplicativeExpressionContext ctx) {
		List<UnaryExpressionContext> terms = ctx.unaryExpression(); // at least 1 
		
	    if(ctx.multiplicativeOperator() != null) {
			List<MultiplicativeOperatorContext> ops    = ctx.multiplicativeOperator();     
		   
			ASTree left = visit(terms.get(0));
			for (int i = 0; i < ops.size(); i++) {
				String op = ctx.multiplicativeOperator(i).getText();
				ASTree right = visit(ctx.unaryExpression(i + 1));
				left = new BinaryExp(List.of(left, right), op);
			}
			
			return left;
	    }else {
	    	return visit( terms.get(0) );
		}
	}

	@Override
	public ASTree visitUnaryExpression(UnaryExpressionContext ctx) {
		if (ctx.unaryOperator() != null) {
            String op = ctx.unaryOperator().getText();
            ASTree operand = visit(ctx.postfixExpression());
            return new UnaryExp(List.of(operand), op);
        }else if(ctx.postfixExpression() != null){
        	return visit(ctx.postfixExpression());
        }else {
			recordError("Variable FeatureError: Wrong OCL Spec'" , ctx.getStop());
        	return new InvalidAST();
        }
        	
		
	}

	/*------------------------------------------------------------------
	 * OCL EXPRESSIONS -PostfixExpression And CallExpCS
	 *------------------------------------------------------------------*/
	@Override
	public ASTree visitNonCallExp(NonCallExpContext ctx) {
		return visit(ctx.primaryExpression());
	}
	
	//Variable CallExp include <CollectionVar>->iterateCall
	@Override
	public ASTree visitVarFeatureCallAlt(VarFeatureCallAltContext ctx) {
		boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
		String varname = ctx.variableExpCS().ID().getText();
		if (isPre && !insidePost) {
	        recordError("@pre can only be used inside postconditions", ctx.variableExpCS().isMarkedPreCS().stop);
	    }
		Symbol sym =  currentScope().resolve(varname);
		if (sym == null) {
			recordError("Variable FeatureError: UnDefined variable '" + varname + "'", ctx.variableExpCS().getStart());
			return new InvalidAST();
		}
		
		ASTree current = new VariableExp(varname, isPre, sym);
		
		/* recursive callExp*/
	    for (CallExpCSContext callCtx : ctx.callExpCS()) {
	    	current = buildCallExp(callCtx, current);
	        if (current == null) {             // build 失敗即提早終止
	            recordError("Variable FeatureError: fail to build feature call", callCtx.getStart());
	            break;
	        }
	    }
	    return current;
	}
	
	//For CollectionLiteral IteratCall
	@Override
	public ASTree visitIterateCallAlt(IterateCallAltContext ctx) {
		/* ------------ 1. Analysis CollectionLiteral Source ---------------- */
	    ASTree current = visit(ctx.literalExpCS());      // <source>
	    if (current == null) {
	        recordError("CollectionLiteralIterateCall Error: UnDefined CollectionLiteral source ", ctx.getStart());
	    }
	    
	    /* 折疊後續呼叫 */
	    for (CallExpCSContext callCtx : ctx.callExpCS()) {
	    	current = buildCallExp(callCtx, current);
	        if (current == null) {             // build 失敗即提早終止
	            recordError("Self FeatureCall Error: fail to build feature call", callCtx.getStart());
	            break;
	        }
	    }
	    return current;
	}

	@Override
	public ASTree visitImpliciteOpCallAlt(ImpliciteOpCallAltContext ctx) {
		/* 找最近的 class scope，製造隱含 self 變數 */
	    Scope s = currentScope();
	    while (s != null && !(s instanceof ClassSymbol)) s = s.getEnclosingScope();
		//check if the class is defined
	    Symbol existing = s.resolve("self");
	    if (existing == null) {
	    	recordError("ImpliciteOpCall Error: 'Implicite self' used outside classifier context", ctx.getStart());
	    } 

	    ASTree current = new SelfExp(false, existing);
		return buildCallExp(ctx.callExpCS(), current);
	}

	@Override
	public ASTree visitClassFeatureCallAlt(ClassFeatureCallAltContext ctx) {
		boolean isPre = ctx.isMarkedPreCS() != null;
		if (isPre && !insidePost) {
	        recordError("@pre can only be used inside postconditions", ctx.isMarkedPreCS().stop);
	    }
	    /* 找最近的 class scope，製造隱含 self 變數 */
	    Scope s = currentScope();
	    while (s != null && !(s instanceof ClassSymbol)) s = s.getEnclosingScope();
	    
	    //check if the class is defined
	    VariableSymbol existing = (VariableSymbol) s.resolve("self");
	    if (existing == null) {
	    	recordError("Self FeatureCall Error: 'self' used outside classifier context", ctx.SELF().getSymbol());
	    } 

	    ASTree current = new SelfExp(isPre, existing);

	    /* 折疊後續呼叫 */
	    for (CallExpCSContext callCtx : ctx.callExpCS()) {
	    	current = buildCallExp(callCtx, current);
	        if (current == null) {             // build 失敗即提早終止
	            recordError("Self FeatureCall Error: fail to build feature call", callCtx.getStart());
	            break;
	        }
	    }
	    return current;
	}

	@Override
	public ASTree visitResultFeatureCallAlt(ResultFeatureCallAltContext ctx) {
		/* 1. 確認在 post 子句 */
	    if (!insidePost) {
	        recordError("Result FeatureCall Error : 'result' Only in PostCondition", ctx.getStart());
	    }

	    /* 2. 找最近的 MethodSymbol */
	    Scope s = currentScope();
	    while (s != null && !(s instanceof MethodSymbol)) {
	        s = s.getEnclosingScope();
	    }
	    if (!(s instanceof MethodSymbol method)) {
	        recordError("Result FeatureCall Error : 'result' used outside any operation context", ctx.getStart());
	        return new InvalidAST();
	    }

	    VariableSymbol resultSym = (VariableSymbol) method.resolve("result");
	    if (resultSym == null) {
	    	recordError("Result FeatureCall Error : 'result' used outside classifier context", ctx.getStart());
	    } 
	    /* 4. 基底節點 */
	    ASTree current = new ResultExp(resultSym);    
	    
	    /* 5. 依序折疊後續 callExpCS* */
	    for (CallExpCSContext callCtx : ctx.callExpCS()) {
	    	current = buildCallExp(callCtx, current);
	        if (current == null) {             // build 失敗即提早終止
	            recordError("Result FeatureCall Error : fail to build feature call", callCtx.getStart());
	            break;
	        }                        // 向外推進
	    }
	    return current;
	}

	@Override
	public ASTree visitIndexExpCS(IndexExpCSContext ctx) {
		return visit(ctx.expression());
	}

	/*------------------------------------------------------------------
	 * OCL EXPRESSIONS - Directly Access Array  ps.need shange
	 *------------------------------------------------------------------*/
	@Override
	public ASTree visitVarArrayAccessAlt(VarArrayAccessAltContext ctx) {
		String varname = ctx.variableExpCS().getText();
		boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
		
		ASTree source = visit(ctx.variableExpCS());
		
		Symbol sym = currentScope().resolve(varname);
		if(sym == null ) 
			recordError("Variable Array Access Error : UnDefined array "+ varname,ctx.variableExpCS().start);
		Type t ;
		if(sym instanceof ArrayTypeClassSymbol a) {
			t = a;
		}else if(sym instanceof BaseSymbol b) {
			if( b.getType() instanceof ArrayTypeClassSymbol a) {
				t = a;
			} else {
				recordError("Variable Array Access Error : Variable "+varname+" isn't ArrayTypeClassSymbol ",ctx.variableExpCS().start);
			}
		} 
		
		List<ASTree> indices = new ArrayList<>(); 	
		indices.add(source);
		IndexExpCSContext x = ctx.indexExpCS(0);
		for (int i = 0; i < ctx.indexExpCS().size(); i++) {
			ASTree index = visit(ctx.indexExpCS(i));
			if (index == null) {
				recordError("Variable Array Access Error : UnDefined array index ",ctx.variableExpCS().start);
					break;
				}
				indices.add(index);
			}
		ArrayRefExp rt = new ArrayRefExp(indices,isPre, sym,varname);
		return rt;
	}

	@Override
	public ASTree visitClassArrayAccessAlt(ClassArrayAccessAltContext ctx) {
		boolean isPre = ctx.isMarkedPreCS() != null;
		if (isPre && !insidePost) {
	        recordError("@pre can only be used inside postconditions", ctx.isMarkedPreCS().stop);
	    }
	    /* 找最近的 class scope，製造隱含 self 變數 */
	    Scope s = currentScope();
	    while (s != null && !(s instanceof ClassSymbol)) s = s.getEnclosingScope();
	    
	    //check if the class is defined
	   Symbol existing = s.resolve("self");
	   	if(existing == null)
	   		recordError("Self Array Access Error : 'self' used outside classifier context", ctx.SELF().getSymbol());
	    if (!(existing instanceof ArrayTypeClassSymbol)) 
	    	recordError("Self Array Access Error : 'self' isn't ArrayTypeClassSymbol", ctx.SELF().getSymbol());
	    
	    ASTree source = new SelfExp(isPre, existing);
	    
	    List<ASTree> indices = new ArrayList<>(); 	
		indices.add(source);
		for (int i = 0; i < ctx.indexExpCS().size(); i++) {
			ASTree index = visit(ctx.indexExpCS(i));
			if (index == null) {
				recordError("Variable Array Access Error : UnDefined array index ",ctx.getStart());
					break;
				}
				indices.add(index);
			}
		ArrayRefExp rt = new ArrayRefExp(indices,isPre,existing, "self");
		return rt;
	}

	@Override
	public ASTree visitResultArrayAccessAlt(ResultArrayAccessAltContext ctx) {
		//step1 
		/* 1. check at post clause */
	    if (!insidePost) {
	        recordError("Result Array Access Error : 'result' Only in PostCondition", ctx.getStart());
	    }

	    /* 2. fined the closest MethodSymbol */
	    Scope s = currentScope();
	    while (s != null && !(s instanceof MethodSymbol)) {
	        s = s.getEnclosingScope();
	    }
	    if (!(s instanceof MethodSymbol method)) {
	        recordError("Result Array Access Error : 'result' used outside any operation context", ctx.getStart());
	        return new InvalidAST();
	    }
	    Symbol resultSym = method.resolve("result");
	    if (resultSym == null) 
	    	recordError("Result Array Access Error : 'result' used outside classifier context", ctx.getStart());
	    if (!(resultSym instanceof ArrayTypeClassSymbol)) 
	    	recordError("Self Array Access Error : 'self' isn't ArrayTypeClassSymbol", ctx.RESULT().getSymbol());

	    ASTree source = new ResultExp(resultSym);  
	    
		//step2
	    List<ASTree> indices = new ArrayList<>(); 	
		indices.add(source);
		for (int i = 0; i < ctx.indexExpCS().size(); i++) {
			ASTree index = visit(ctx.indexExpCS(i));
			if (index == null) {
				recordError("Variable Array Access Error : UnDefined array index ",ctx.getStart());
					break;
				}
				indices.add(index);
			}
		ArrayRefExp rt = new ArrayRefExp(indices,false,resultSym, "self");
		return rt;
	}
	
	/* =====================================================
     * Private CallExp helpers
     * ===================================================== */
	private ASTree buildCallExp(CallExpCSContext ctx, ASTree source) {
	    if (ctx.featureCallExpCS() != null) {
	    	FeatureCallExpCSContext feature = ctx.featureCallExpCS();
	    		if(feature.propertyCallExpCS() != null) {
	    			return buildPropertyCall(ctx.featureCallExpCS().propertyCallExpCS(), source);
	    		} else if(feature.operationCallExpCS() != null) {
	    			return buildOperationCall(ctx.featureCallExpCS().operationCallExpCS(), source);
	    		} else if(feature.arrayAccessCS() != null) {
	    			return buildArrayAccessCall(ctx.featureCallExpCS().arrayAccessCS(), source);
	    		} else {
	    			recordError("CallExp Error : UnDefined CallExp ",ctx.getStart());
	    			return new InvalidAST();
	    		}
	    } else return buildLoopCall(ctx.loopExpCS(),source);     
	    	//PropertyCallExpCSContext prop = ctx.featureCallExpCS().propertyCallExpCS();
	    	//if source is self, need sourceName and selfisPre
	    	//return buildArrayAccessCall(prop, source);
	    
	}
	/** Source Must be ClassSymbol then class scope can resolve MethodSymbol*/
	private ASTree buildOperationCall(OperationCallExpCSContext ctx, ASTree source) {
		boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
		String opname = ctx.variableExpCS().ID().getText();
		if (isPre && !insidePost) {
	        recordError("@pre can only be used inside postconditions", ctx.variableExpCS().isMarkedPreCS().stop);
	    }
		
		Type returnType = null;
		Symbol sym = null ;
		
		/* Ex. obj1.operation()*/
		if(source instanceof VariableExp ) {
			
			sym = ((VariableExp) source).getSymbol();
			
			if (sym instanceof ClassSymbol) {
				ClassSymbol classSym = (ClassSymbol) sym;
				MethodSymbol methodSym = classSym.resolveMethod(opname);
				
				if (methodSym == null) {
					recordError("Build OperationCall Error: UnDefined MethodSymbol " + opname + "in" +classSym.getName() , ctx.getStart());
					returnType = new InvalidType();
				}
				if (methodSym.getType() != null) {
					if (methodSym.resolveType(methodSym.getType().getTypeName()) == null) {
						recordError("Build OperationCall Error: UnDefined returnType " + methodSym.getType().getTypeName() + "in" + opname, ctx.getStart());
						returnType = new InvalidType();
					}
					sym = methodSym;
					returnType = methodSym.getType();
				}
				//FieldSymbol Type is ArrayType
			} else if(sym instanceof BaseSymbol) {
				if(((BaseSymbol) sym).getType() instanceof ClassSymbol c) {
					MethodSymbol methodSym = (MethodSymbol) c.resolve(opname);
					returnType = methodSym.getType();
					sym = methodSym;
				}
			}
			else {
				recordError("Build OperationCall Error: Source must be Class " + opname + " in " +source , ctx.getStart());
				returnType = new InvalidType();
			}
		/* Ex. obj1.obj2.operation()*/
		} else if( source instanceof FeatureCallExp) {
			
			String sourceName = ((FeatureCallExp) source).getName(); 
			sym = currentScope.resolve(sourceName);
			
			if (sym instanceof ClassSymbol classSym) {
				MethodSymbol methodSym = classSym.resolveMethod(opname);
				if (methodSym == null) {
					recordError("Build OperationCallExp Error: UnDefined Method " + opname + " in " +classSym.getName() , ctx.getStart());
					returnType = new InvalidType();
				} 
				if (methodSym.getType() != null) {
					if (methodSym.resolveType(methodSym.getType().getTypeName()) == null) {
						recordError("Build OperationCallExp Error: UnDefined returnType " + methodSym.getType().getTypeName() + " in " + opname, ctx.getStart());
						returnType = new InvalidType();
					}
					returnType = methodSym.getType();
					sym = methodSym;
				}
			} else if (sym instanceof BaseSymbol) {
				Type type = ((BaseSymbol) sym).getType();
				if (type instanceof ClassSymbol) {
					MethodSymbol methodSym = ((ClassSymbol) type).resolveMethod(opname);
					if (methodSym == null) {
						recordError("Build OperationCallExp Error: UnDefined Method " + opname + " in " +((ClassSymbol) type).getName() , ctx.getStart());
						returnType = new InvalidType();
						sym = methodSym;
					} 
					if (methodSym.getType() != null) {
						
						if ( methodSym.resolveType(methodSym.getType().getTypeName()) == null) {
							recordError("Build OperationCallExp Error: UnDefined returnType " + methodSym.getType().getTypeName() + " in " + opname, ctx.getStart());
							returnType = new InvalidType();
						}
						else {
							returnType = methodSym.getType();
							sym = methodSym;
							}
					}
				}
			} 	
			else {
				recordError("Build OperationCall Error: UnDefined source operationCall " + opname + "in" +source , ctx.getStart());
				returnType = new InvalidType();
			}
			
			
		}
		/* Args */
		List<ASTree> args = gatherArguments(ctx.argumentsCS());
		
		if(sym instanceof MethodSymbol m) {
			if(args.size() != m.getNumberOfSymbols()) {
				recordError("Build OperationCall Error: Parameter Error "  + " in " +source +" call "+ opname, ctx.getStart());
			}
		}
	    return new OperationCallExp(source, args, returnType, isPre, opname, ctx.ARROW() != null ? "->" : ".",sym);
	}
	
	private ASTree buildPropertyCall(PropertyCallExpCSContext ctx, ASTree source) {
		String propName = ctx.variableExpCS().ID().getText();
		boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
		if (isPre && !insidePost) {
	        recordError("@pre can only be used inside postconditions", ctx.variableExpCS().isMarkedPreCS().stop);
	    }
		Symbol sym = currentScope().resolve(propName);
		if (sym == null) {
			recordError("Build PropertyCall Error: UnDefined property " + propName + "in" +currentScope() , ctx.getStart());

		}
		Type type = null;
		if (sym instanceof BaseSymbol) {
			type = ((BaseSymbol) sym).getType();
			if (type == null) {
				recordError("Build PropertyCall Error: UnDefined type " + propName + "in" +currentScope() , ctx.getStart());
			}
		}else if(sym instanceof ClassSymbol){
			type =  currentScope().resolveType(propName);
			if (type == null) {
				recordError("Build PropertyCall Error: UnDefined type " + propName + "in" +currentScope() , ctx.getStart());
			}
		}
		
		return new PropertyCallExp(List.of(source), propName, type, isPre, sym);
	}
	
	private ASTree buildArrayAccessCall(ArrayAccessCSContext ctx, ASTree source) {
			String arrayName = ctx.variableExpCS().ID().getText();
			boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
			if (isPre && !insidePost) {
		        recordError("@pre can only be used inside postconditions", ctx.variableExpCS().isMarkedPreCS().getStart());
		    }
			Symbol sym = null ;

			//not source chain Ex. self.datas[it][it2][it3] , self(VariableExp)
			if(source instanceof VariableExp) {
				Type sourcesym = ((VariableExp) source).getType();
				if(sourcesym instanceof ClassSymbol ) {
					sym = ((ClassSymbol) sourcesym).resolve(arrayName);
					//source is 'self' or 'result' FieldSymbol
					if(sym instanceof ClassSymbol)
						if(!(sym instanceof ArrayTypeClassSymbol)) {
							recordError("Build ArrayFeatureCall Error: " + arrayName +" must be ArrayTypeClassSymbol", ctx.getStart());
						}
					if(sym instanceof BaseSymbol) {
						Type targettype = ((BaseSymbol) sym).getType();
						if (!(targettype instanceof ArrayTypeClassSymbol)) {
							recordError("Build ArrayFeatureCall Error: " + arrayName +" must be ArrayTypeClassSymbol", ctx.getStart());
						}
					}
				}else {
					recordError("Build ArrayFeatureCall Error: Source must be ClassSymbol " + ((VariableExp)source).getName(), ctx.getStart());
				}
						
				
			//source chain Ex. arg.datas.array[1][2][3]  ,arg.datas(PropertyCallExp)
			} else if(source instanceof FeatureCallExp) {
				Type type = ((FeatureCallExp)source).getType();
				if (type instanceof ArrayTypeClassSymbol) {
					sym = ((ClassSymbol)type).resolve(arrayName);
					if(sym==null) {
						recordError("Build ArrayFeatureCall Error: ArrayTypeClassSymbol "+((FeatureCallExp)source).getName()+" does't have MultiplicityListType: " +arrayName, ctx.getStart());
					}
					if (!(sym instanceof ArrayTypeClassSymbol)) {
						recordError("Build ArrayFeatureCall Error: " +arrayName +" isn't ArrayTypeClassSymbol", ctx.getStart());
					}
				} else {
					recordError("Build ArrayFeatureCall Error: ArraySource must be ArrayTypeClassSymbol " + ((FeatureCallExp)source).getName(), ctx.getStart());
				}
			} 
    		
    		List<ASTree> indices = new ArrayList<>(); 	
    		indices.add(source);
    		for (int i = 0; i < ctx.indexExpCS().size(); i++) {
    			ASTree index = visit(ctx.indexExpCS(i));
    			if (index == null) {
    				recordError("Variable Array Access Error : UnDefined array index ",ctx.getStart());
    					break;
    				}
    				indices.add(index);
    			}
    		ArrayRefExp arr = new ArrayRefExp(indices, isPre, sym, arrayName);		
    		return arr;
	}
	
	private List<ASTree> gatherArguments(ArgumentsCSContext ctx) {
	    if (ctx == null) return List.of();
	    List<ASTree> list = new ArrayList<>();
	    ArgumentsCSContext cur = ctx;
	    while (cur != null) {  // 右遞迴展開
	        list.add(visit(cur.oclExpressionCS()));
	        cur = cur.argumentsCS();
	    }
	    return list;
	}

	private ASTree buildLoopCall(LoopExpCSContext ctx, ASTree source) {
	    /* ------------ 2. isMarkedPreCS ---------------- */
	    boolean isPre = false;
	    Symbol sym = null;
	    if (source instanceof VariableExp v) {isPre = v.isMarkedPre(); sym = v.getSymbol();}
	    if(source instanceof FeatureCallExp f) {isPre = f.isMarkedPre(); sym = f.getSymbol();}

	    /* ------------ 3. Create Iterate Scope ------------ */
	    LocalScope iterScope = new LocalScope(currentScope(), "iterate LocalScope");
	    enterScope(iterScope);

	    /* ------------ 4. iterator and result VarDecl --------- */
	    ASTree iteratorDecl = visit(ctx.iterateExpCS().variableDecl().get(0)); 
	    ASTree resultDecl   = visit(ctx.iterateExpCS().variableDecl().get(1)); 

	    /* ------------ 5. build body  --------------------- */
	    ASTree body = visit(ctx.iterateExpCS().expression()); 
	    if (body == null) {
	        recordError("IterateCall Error: ：no body no body but..", ctx.getStart());
	        exitScope();
	    }
	    /* ------------ 6. Exit Scope -------------------- */
	    exitScope();
	    /* ------------ 7. new AST IterateNode ---------------------- */
	    // children: 0-source, 1-iteratorDecl, 2-resultDecl, 3-body 
	    return new IterateExp(
	            List.of(source, iteratorDecl, resultDecl, body)
	            ,isPre, sym);
	}

	/* =====================================================
     *  OCL EXPRESSIONS - PrimaryExpr
     *  ifExpCS、letExprCS、literalExpCS、'(' expression ')'、variableExpCS
     * ===================================================== */
	
	@Override
	public ASTree visitIfExpCS(IfExpCSContext ctx) {
		ASTree condionast = visit(ctx.expression(0));
		ASTree thenast = visit(ctx.expression(1));
		ASTree elseast = visit(ctx.expression(2));
        return new IfExp(List.of(condionast, thenast, elseast));
	}

	@Override
	public ASTree visitLetExprCS(LetExprCSContext ctx) {
		// letExprCS : 'let' variableDecls* 'in' oclExpressionCS ;
		LocalScope letScope = new LocalScope(currentScope(), "let LocalScope");
		enterScope(letScope);
		List<ASTree> children = new ArrayList<>();
		for (VariableDeclContext varCtx : ctx.variableDecls().variableDecl()) {
			children.add(visit(varCtx));
		}
		children.add(visit(ctx.oclExpressionCS()));
		
		exitScope();
		return new LetExp(children);
	}

	@Override
	public ASTree visitVariableExpCS(VariableExpCSContext ctx) {
		boolean isPre = ctx.isMarkedPreCS() != null;
		Token tok = ctx.getStart();
		if (isPre && !insidePost) {
	        recordError("@pre can only be used inside postconditions", tok);
	    }
        String name= ctx.ID().getText();
        Type type;
        //check if the variable is defined
        Symbol sym = currentScope().resolve(name);
        if (sym == null) {
            recordError("Variable Ref Error: UnDefined variable '" + name + "'", tok);
        }
        
        //check if the variable is operation
        if(sym instanceof MethodSymbol) {
        	if ( ((MethodSymbol) sym).getType() != null) {
        		String typename  = ((MethodSymbol) sym).getType().getTypeName();
				if(currentScope().resolve(typename)== null) {
					recordError("Variable Ref Error: UnDefined type " + typename, tok);
				}
				else {
					type = ((MethodSymbol)sym).getType();
				}
        	}
		}
        
        if(sym instanceof VariableSymbol) {
			type = ((VariableSymbol)sym).getType();
			if (type == null) {
				recordError("Variable Ref Error: UnDefined type " + name, tok);
			}
		}
        
        
        return new VariableExp(name,isPre,sym);
	}

	/* =====================================================
     * OCL EXPRESSIONS - literalExpCS
     * ===================================================== */
	@Override
	public ASTree visitPrimitiveLiteralExpCS(PrimitiveLiteralExpCSContext ctx) {
		/* 找最近的 global scope */
	    Scope s = currentScope();
	    while (s != null && !(s instanceof GlobalScope)) s = s.getEnclosingScope();
		
		if (ctx.integerLiteralExpCS() != null) {
			Type inttype = s.resolve("int") instanceof Type ? (Type) s.resolve("int") : null;
			if (inttype == null) {
				recordError("PrimitiveListeral Error: UnDefined type 'int'", ctx.getStart());
			}
        	String intLitText = ctx.integerLiteralExpCS().INTEGER().getText();
            return new IntegerLiteralExp(Integer.parseInt(intLitText),inttype);
        } else if (ctx.booleanLiteralExpCS() != null) {
        	Type booltype = s.resolve("Boolean") instanceof Type ? (Type) s.resolve("Boolean") : null;
        	if (booltype == null) {
				recordError("PrimitiveListeral Error: UnDefined type 'Boolean'", ctx.getStart());
			}
        	String boolLitText = ctx.booleanLiteralExpCS().getChild(0).getText();
            return new BooleanLiteralExp(Boolean.parseBoolean(boolLitText),booltype);
        } else if (ctx.stringLiteralExpCS() != null) {
        	Type strtype = s.resolve("String") instanceof Type ? (Type) s.resolve("String") : null;
        	if (strtype == null) {
        		recordError("PrimitiveListeral Error: UnDefined type 'String'", ctx.getStart());
        	}
            String raw = ctx.stringLiteralExpCS().STRING_LITERAL().getText();
            return new StringLiteralExp(raw.substring(1, raw.length() - 1),strtype);
        }
        recordError("PrimitiveListeral Error: Unknown primitive literal", ctx.getStart());
        return new InvalidAST(); // fallback (should not really happen)
	}
	@Override
	public ASTree visitCollectionLiteralExpCS(CollectionLiteralExpCSContext ctx) {
		ASTree collectionParts = visit(ctx.collectionLiteralPartsCS());
		return collectionParts;
	}

	@Override
	public ASTree visitCollectionitem(CollectionitemContext ctx) {
		List<ASTree> parts = new ArrayList<>();
		for ( LiteralExpCSContext partCtx : ctx.literalExpCS()) {
			ASTree part = visit(partCtx);
			if (part != null) {
			parts.add(part);
			}
		}
		return new CollectionItem(parts);	
	}

	@Override
	public ASTree visitCollectionRangeCS(CollectionRangeCSContext ctx) {
		ASTree from = visit(ctx.expression(0));
        ASTree to   = visit(ctx.expression(1));
        return new CollectionRange(List.of(from,to));
	}

	/* =====================================================
     *  Default/fallback – delegate to children so we do not need to implement every rule.
     * ===================================================== */

	
	/* =====================================================
     *  Public API helpers
     * ===================================================== */
    /** Returns a <em>copy</em> of the semantic error list collected so far. */
    public List<String> getSemanticErrors() {
        return semanticErrors;
    }

	
	public Scope getCurrentGlobalScope() {
		return currentScope;
	}

	
	public List<String> getScopeIOdetail() {
		return scopeIOdetail;
	}
    
}
