package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclBaseVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.AdditiveExpressionContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.AdditiveOperatorContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ArgumentsCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.CallExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ClassArrayAccessAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ClassFeatureCallAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ClassifierContextDeclContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ContextContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ContextDeclContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.HasRturnTypeAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.IfExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.ImpliciteOpCallAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.IterateCallAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.LetExprCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.LiteralExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.LogicalExpressionContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.LogicalOperatorContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.MultiplicativeExpressionContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.MultiplicativeOperatorContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.NoRturnTypeAltContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.NormoalSequenceLiteralContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.OperationCallExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.PackageDeclarationCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.PrimitiveLiteralExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.PropertyCallExpCSContext;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser.RangeSequenceLiteralContext;
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
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.OperationContextDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.PackageDeclAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.ArrayRefExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BooleanLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.FeatureCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IntegerLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.OperationCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.PropertyCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.ResultExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.SelfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.StringLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.UnaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableDeclExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.letExp;
import ccu.pllab.tcgen3.symboltable.BaseSymbol;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.FieldSymbol;
import ccu.pllab.tcgen3.symboltable.MethodSymbol;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.VariableSymbol;
import ccu.pllab.tcgen3.symboltable.scope.BaseScope;
import ccu.pllab.tcgen3.symboltable.scope.GlobalScope;
import ccu.pllab.tcgen3.symboltable.scope.LocalScope;
import ccu.pllab.tcgen3.symboltable.scope.Scope;
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
    	System.out.println("entering: "+currentScope.getName()+":"+s);
    	}

    private void exitScope() {
    	System.out.println("leaving: "+currentScope.getName()+":"+currentScope);
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
        	return null;
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
	public ASTree visitNoRturnTypeAlt(NoRturnTypeAltContext ctx) {
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
        
        
        //set return type
        String ret = ctx.type().getText();
        Type returntype  = currentScope().resolveType(ret);
        if (returntype == null) {
			recordError("ContestDecl Error: UnDefined return type " + ret, tok);
			return null;
		}
        decl.setReturnType(returntype);
        
        return decl; // pop 一層留給 visitContextDecl
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
	
	/* =====================================================
     *  OCL EXPRESSIONS - BinaryExp 
     * ===================================================== */
	
	@Override
	public ASTree visitLogicalExpression(LogicalExpressionContext ctx) {	
		List<RelationalExpressionContext> terms = ctx.relationalExpression();        // 至少 1 個
	    List<LogicalOperatorContext> ops        = ctx.logicalOperator();      // 可能 0 個

	    if (ops.isEmpty()) {
	        return visit(terms.get(0));
	    }
		
		ASTree left = visit(ctx.relationalExpression(0));
		for (int i = 0; i < ops.size(); i++) {
			String op = ctx.logicalOperator(i).getText();
			ASTree right = visit(ctx.relationalExpression(i + 1));
			left = new BinaryExp(List.of(left, right), op);
		}
		
		return left;
	}

	@Override
	public ASTree visitRelationalExpression(RelationalExpressionContext ctx) {
		List<AdditiveExpressionContext> terms = ctx.additiveExpression();        // 至少 1 個
	    List<RelationalOperatorContext> ops        = ctx.relationalOperator();      // 可能 0 個

	    if (ops.isEmpty()) {
	        return visit(terms.get(0));
	    }
		
		ASTree left = visit(ctx.additiveExpression(0));
		for (int i = 0; i < ops.size(); i++) {
			String op = ctx.relationalOperator(i).getText();
			ASTree right = visit(ctx.additiveExpression(i + 1));
			left = new BinaryExp(List.of(left, right), op);
		}
		
		return left;
	}

	@Override
	public ASTree visitAdditiveExpression(AdditiveExpressionContext ctx) {
		List<MultiplicativeExpressionContext> terms = ctx.multiplicativeExpression();        // 至少 1 個
	    List<AdditiveOperatorContext> ops        = ctx.additiveOperator();      // 可能 0 個

	    if (ops.isEmpty()) {
	        return visit(terms.get(0));
	    }
		
		ASTree left = visit(terms.get(0));
		for (int i = 0; i < ops.size(); i++) {
			String op = ctx.additiveOperator(i).getText();
			ASTree right = visit(ctx.multiplicativeExpression(i + 1));
			left = new BinaryExp(List.of(left, right), op);
		}
		
		return left;
	}

	@Override
	public ASTree visitMultiplicativeExpression(MultiplicativeExpressionContext ctx) {
		List<UnaryExpressionContext> terms = ctx.unaryExpression();        // 至少 1 個
	    List<MultiplicativeOperatorContext> ops        = ctx.multiplicativeOperator();      // 可能 0 個

	    // 沒有乘除 => 直接回傳唯一運算元
	    if (ops.isEmpty()) {
	        return visit(terms.get(0));
	    }
	    
		ASTree left = visit(terms.get(0));
		for (int i = 0; i < ops.size(); i++) {
			String op = ctx.multiplicativeOperator(i).getText();
			ASTree right = visit(ctx.unaryExpression(i + 1));
			left = new BinaryExp(List.of(left, right), op);
		}
		
		return left;
	}

	@Override
	public ASTree visitUnaryExpression(UnaryExpressionContext ctx) {
		if (ctx.unaryOperator() != null) {
            String op = ctx.unaryOperator().getText();
            ASTree operand = visit(ctx.postfixExpression());
            return new UnaryExp(List.of(operand), op);
        }
        return visit(ctx.postfixExpression());
	}

	/*------------------------------------------------------------------
	 * OCL EXPRESSIONS -PostfixExpression And CallExpCS
	 *------------------------------------------------------------------*/
	
	@Override
	public ASTree visitVarFeatureCallAlt(VarFeatureCallAltContext ctx) {
		boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
		String varname = ctx.variableExpCS().ID().getText();
		
		Symbol sym =  currentScope().resolve(varname);
		if (sym == null) {
			recordError("Variable FeatureError: UnDefined variable '" + varname + "'", ctx.variableExpCS().getStart());
			return null;
		}
		
		ASTree current = new VariableExp(varname, isPre, sym);
		
		/* recursive callExp*/
	    for (CallExpCSContext callCtx : ctx.callExpCS()) {
	    	current = buildFeatureCall(callCtx, current);
	        if (current == null) {             // build 失敗即提早終止
	            recordError("Variable FeatureError: fail to build feature call", callCtx.getStart());
	            break;
	        }
	    }
	    return current;
	}
	
	@Override
	public ASTree visitIterateCallAlt(IterateCallAltContext ctx) {
		/* ------------ 1. 解析來源 collection ---------------- */
	    ASTree source = visit(ctx.literalExpCS());      // <source>
	    if (source == null) {
	        recordError("IterateCall Error: UnDefined collection source ", ctx.getStart());
	        return null;
	    }
 
	    /* ------------ 2. 折疊 isMarkedPreCS? ---------------- */
	    boolean isPre = ctx.isMarkedPreCS() != null;

	    /* ------------ 3. 建立 iterate 區域 Scope ------------ */
	    LocalScope iterScope = new LocalScope(currentScope(), "iterate LocalScope");
	    enterScope(iterScope);

	    /* ------------ 4. iterator 與 result VarDecl --------- */
	    VariableDeclContext iteratorDeclcontext = ctx.callExpCS(0).loopExpCS().iterateExpCS().variableDecl(0);
	    VariableDeclContext resultDeclcontext   = ctx.callExpCS(0).loopExpCS().iterateExpCS().variableDecl(1);

	    ASTree iteratorDecl = visit(iteratorDeclcontext); // it : E
	    ASTree resultDecl   = visit(resultDeclcontext);   // acc : R = init

	    /* ------------ 5. build body  --------------------- */
	    ASTree body = visit(ctx.callExpCS(0).loopExpCS().iterateExpCS().expression()); 
	    if (body == null) {
	        recordError("IterateCall Error: ：no body no body but..", ctx.getStart());
	        exitScope();
	        return null;
	    }

	    /* ------------ 6. 離開區域 Scope -------------------- */
	    exitScope();

	    /* ------------ 7. 建立 AST 節點 ---------------------- */
	    // children: 0-source, 1-iteratorDecl, 2-resultDecl, 3-body 
	    return new IterateExp(
	            List.of(source, iteratorDecl, resultDecl, body),
	            isPre);
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
		return buildFeatureCall(ctx.callExpCS(), current);
	}

	@Override
	public ASTree visitClassFeatureCallAlt(ClassFeatureCallAltContext ctx) {
		boolean isPre = ctx.isMarkedPreCS() != null;

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
	    	current = buildFeatureCall(callCtx, current);
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
	        return null;
	    }

	    VariableSymbol resultSym = (VariableSymbol) method.resolve("result");
	    if (resultSym == null) {
	    	recordError("Result FeatureCall Error : 'result' used outside classifier context", ctx.getStart());
	    } 
	    /* 4. 基底節點 */
	    ASTree current = new ResultExp(resultSym);    
	    
	    /* 5. 依序折疊後續 callExpCS* */
	    for (CallExpCSContext callCtx : ctx.callExpCS()) {
	    	current = buildFeatureCall(callCtx, current);
	        if (current == null) {             // build 失敗即提早終止
	            recordError("Result FeatureCall Error : fail to build feature call", callCtx.getStart());
	            break;
	        }                        // 向外推進
	    }
	    return current;
	}

	/*------------------------------------------------------------------
	 * OCL EXPRESSIONS - Directly Access Array  ps.need shange
	 *------------------------------------------------------------------*/
	@Override
	public ASTree visitVarArrayAccessAlt(VarArrayAccessAltContext ctx) {
		boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
		String varname = ctx.variableExpCS().ID().getText();
		
		Symbol sym =  currentScope().resolve(varname);
		if (sym == null) {
			recordError("Variable Array Access Error : UnDefined variable '" + varname + "'", ctx.variableExpCS().getStart());
			return null;
		}		
		ASTree source = new VariableExp(varname, isPre, sym);
		
		List<ASTree> indices = new ArrayList<>(); 	
		indices.add(source);
		for (int i = 0; i < ctx.arrayAccessCS().expression().size(); i++) {
			ASTree index = visit(ctx.arrayAccessCS().expression(i));
			if (index == null) {
				recordError("Variable Array Access Error : UnDefined array index ", ctx.arrayAccessCS().getStart());
					break;
				}
				indices.add(index);
			}
		return new ArrayRefExp(indices,isPre, varname);
	}

	@Override
	public ASTree visitClassArrayAccessAlt(ClassArrayAccessAltContext ctx) {
		boolean isPre = ctx.isMarkedPreCS() != null;

	    /* 找最近的 class scope，製造隱含 self 變數 */
	    Scope s = currentScope();
	    while (s != null && !(s instanceof ClassSymbol)) s = s.getEnclosingScope();
	    
	    //check if the class is defined
	    VariableSymbol existing = (VariableSymbol) s.resolve("self");
	    if (existing == null) {
	    	recordError("Self Array Access Error : 'self' used outside classifier context", ctx.SELF().getSymbol());
	    } 
	    ASTree source = new SelfExp(isPre, existing);
	    
	    List<ASTree> indices = new ArrayList<>(); 	
		indices.add(source);
		for (int i = 0; i < ctx.arrayAccessCS().expression().size(); i++) {
			ASTree index = visit(ctx.arrayAccessCS().expression(i));
			if (index == null) {
				recordError("Self Array Access Error : UnDefined array index ", ctx.arrayAccessCS().getStart());
					break;
				}
				indices.add(index);
			}
		return new ArrayRefExp(indices,isPre, "self");
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
	        return null;
	    }
	    VariableSymbol resultSym = (VariableSymbol) method.resolve("result");
	    if (resultSym == null) {
	    	recordError("Result Array Access Error : 'result' used outside classifier context", ctx.getStart());
	    } 
	    ASTree source = new ResultExp(resultSym);  
	    
		//step2
		List<ASTree> indices = new ArrayList<>(); 	
		indices.add(source);
		for (int i = 0; i < ctx.arrayAccessCS().expression().size(); i++) {
			ASTree index = visit(ctx.arrayAccessCS().expression(i));
			if (index == null) {
				recordError("Result Array Access Error : UnDefined array index ", ctx.arrayAccessCS().getStart());
					break;
				}
				indices.add(index);
			}
		return new ArrayRefExp(indices,false, "self");
	}
	
	/* =====================================================
     * Private FeatureCall helpers
     * ===================================================== */
	private ASTree buildFeatureCall(CallExpCSContext ctx, ASTree source) {
	/* ------------ OperationCallExpCS -------------------------------- */
	    if (ctx.featureCallExpCS().operationCallExpCS() != null) {
	    	return buildOperationCall(ctx.featureCallExpCS().operationCallExpCS(), source);
	    } else if (ctx.featureCallExpCS().propertyCallExpCS().arrayAccessCS() == null){
	/* ------------ PropertyCallExpCS -------------------------------- */
	    	PropertyCallExpCSContext prop = ctx.featureCallExpCS().propertyCallExpCS();
	    	return buildPropertyCall(prop, source);
	    } else {
	/* ------------ arrayAccessCS -------------------------------- */
	    	PropertyCallExpCSContext prop = ctx.featureCallExpCS().propertyCallExpCS();
	    	//if source is self, need sourceName and selfisPre
	    	return buildArrayAccessCall(prop, source);
	    }
	}

	/** Source Must be ClassSymbol then class scope can resolve MethodSymbol*/
	private ASTree buildOperationCall(OperationCallExpCSContext ctx, ASTree source) {
		boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
		String opname = ctx.variableExpCS().ID().getText();
		/* Ex. obj1.operation()*/
		Type returnType = null;
		if(source instanceof VariableExp ) {
			
			Symbol sym = ((VariableExp) source).getSymbol();
			
			if (sym instanceof ClassSymbol) {
				ClassSymbol classSym = (ClassSymbol) sym;
				MethodSymbol methodSym = classSym.resolveMethod(opname);
				if (methodSym == null) {
					recordError("Builde OperationCall Error: UnDefined MethodSymbol " + opname + "in" +classSym.getName() , ctx.getStart());
					returnType = new InvalidType();
				}
				if (methodSym.getType() != null) {
					if (methodSym.resolveType(methodSym.getType().getTypeName()) == null) {
						recordError("Builde OperationCall Error: UnDefined returnType " + methodSym.getType().getTypeName() + "in" + opname, ctx.getStart());
						returnType = new InvalidType();
					}
					returnType = methodSym.getType();
				}
			} else {
				recordError("Builde OperationCall Error: Source must be Class " + opname + " in " +source , ctx.getStart());
				returnType = new InvalidType();
			}
		/* Ex. obj1.obj2.operation()*/
		} else if( source instanceof FeatureCallExp) {
			
			String sourceName = ((FeatureCallExp) source).getName(); 
			Symbol sym = currentScope.resolve(sourceName);
			
			if (sym instanceof ClassSymbol) {
				ClassSymbol classSym = (ClassSymbol) sym;
				MethodSymbol methodSym = classSym.resolveMethod(opname);
				if (methodSym == null) {
					recordError("Builde OperationCall Error: UnDefined MethodSymbol " + opname + " in " +classSym.getName() , ctx.getStart());
					returnType = new InvalidType();
				} 
				if (methodSym.getType() != null) {
					if (methodSym.resolveType(methodSym.getType().getTypeName()) == null) {
						recordError("Builde OperationCall Error: UnDefined returnType " + methodSym.getType().getTypeName() + " in " + opname, ctx.getStart());
						returnType = new InvalidType();
					}
					returnType = methodSym.getType();
				}
			} else if (sym instanceof BaseSymbol) {
				Type type = ((BaseSymbol) sym).getType();
				if (type instanceof ClassSymbol) {
					MethodSymbol methodSym = ((ClassSymbol) type).resolveMethod(opname);
					if (methodSym == null) {
						recordError("Builde OperationCall Error: UnDefined MethodSymbol " + opname + " in " +((ClassSymbol) type).getName() , ctx.getStart());
						returnType = new InvalidType();
					} 
					if (methodSym.getType() != null) {
						
						if ( methodSym.resolveType(methodSym.getType().getTypeName()) == null) {
							recordError("Builde OperationCall Error: UnDefined returnType " + methodSym.getType().getTypeName() + " in " + opname, ctx.getStart());
							returnType = new InvalidType();
						}
						else returnType = methodSym.getType();
					}
				}
			} 	
			else {
				recordError("Builde OperationCall Error: UnDefined source operationCall " + opname + "in" +source , ctx.getStart());
				returnType = new InvalidType();
			}
		}
	    return new OperationCallExp(source, gatherArguments(ctx.argumentsCS()), returnType, isPre, opname, ctx.ARROW() != null ? "->" : ".");
	}


	private ASTree buildPropertyCall(PropertyCallExpCSContext ctx, ASTree source) {
		String propName = ctx.variableExpCS().ID().getText();
		boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
		
		Symbol sym = currentScope().resolve(propName);
		if (sym == null) {
			recordError("Builde PropertyCall Error: UnDefined property " + propName + "in" +currentScope() , ctx.getStart());
			return null;
		}
		
		Type type = null;
		if (sym instanceof BaseSymbol) {
			type = ((BaseSymbol) sym).getType();
			if (type == null) {
				recordError("Builde PropertyCall Error: UnDefined type " + propName + "in" +currentScope() , ctx.getStart());
				return null;
			}
		}else if(sym instanceof ClassSymbol){
			type =  currentScope().resolveType(propName);
			if (type == null) {
				recordError("Builde PropertyCall Error: UnDefined type " + propName + "in" +currentScope() , ctx.getStart());
				return null;
			}
		}
		
		return new PropertyCallExp(List.of(source), propName, type, isPre);
	}
	
	
	private ASTree buildArrayAccessCall(PropertyCallExpCSContext ctx, ASTree source) {
			String arrayName = ctx.variableExpCS().ID().getText();
			boolean isPre = ctx.variableExpCS().isMarkedPreCS() != null;
			Type typecheck = null;
			Symbol sym = null ;
			if(source instanceof VariableExp) {
				Type type = ((VariableExp)source).getType();
				if (type instanceof ClassSymbol) {
					typecheck = ((ClassSymbol)type).resolveType(arrayName);
					if (typecheck == null) {
						recordError("Builde ArrayFeatureCall Error: UnDefined Arraytype at" + ((VariableExp)source).getName(), ctx.getStart());
					}
				} else {
					recordError("Builde ArrayFeatureCall Error: Source must be ClassSymbol " + ((VariableExp)source).getName(), ctx.getStart());
				}
			} else if(source instanceof FeatureCallExp) {
				Type type = ((FeatureCallExp)source).getType();
				if (type instanceof ClassSymbol) {
					sym = ((ClassSymbol)type).resolve(arrayName);
					if(sym instanceof VariableSymbol) {
						typecheck = ((VariableSymbol)sym).getType();
					}
					if (typecheck == null) {
						recordError("Builde ArrayFeatureCall Error: UnDefined Arraytype at" + ((FeatureCallExp)source).getName(), ctx.getStart());
					}
				} else {
					recordError("Builde ArrayFeatureCall Error: Source must be ClassSymbol " + ((FeatureCallExp)source).getName(), ctx.getStart());
				}
			} 
    		
    		List<ASTree> indices = new ArrayList<>(); 	
    		indices.add(source);
    		for (int i = 0; i < ctx.arrayAccessCS().expression().size(); i++) {
    			ASTree index = visit(ctx.arrayAccessCS().expression(i));
    			if (index == null) {
    				recordError("Builde ArrayFeatureCall Error: UnDefined array index ", ctx.arrayAccessCS().getStart());
   					break;
   				}
   				indices.add(index);
   			}
    		ArrayRefExp arr = new ArrayRefExp(indices, isPre, arrayName);		
    		arr.setSymbol(sym);
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
		Symbol sym = currentScope().resolve("dim1");
		return new letExp(children);
	}

	@Override
	public ASTree visitVariableExpCS(VariableExpCSContext ctx) {
		boolean isMarkedPre = ctx.isMarkedPreCS() != null;
		Token tok = ctx.getStart();
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
        
        
        return new VariableExp(name,isMarkedPre,sym);
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
        return null; // fallback (should not really happen)
	}
	@Override
	public ASTree visitNormoalSequenceLiteral(NormoalSequenceLiteralContext ctx) {
		String typeName = ctx.basetype().getText();
		Type type = (Type) currentScope().resolve(typeName) ;

		if (type == null) {
			recordError("Collection Literal Error: UnDefined type " + typeName, ctx.getStart());
			return null;
		}
		List<ASTree> parts = new ArrayList<>();
		if (ctx.collectionLiteralPartsCS() != null) {
			for ( LiteralExpCSContext partCtx : ctx.collectionLiteralPartsCS().literalExpCS()) {
				ASTree part = visit(partCtx);
				if (part != null) {
				parts.add(part);
				}
			}
			return new CollectionLiteralExp(type, parts, false);
		}else {
			return new CollectionLiteralExp(type, List.of(), false);
		}
	}

	@Override
	public ASTree visitRangeSequenceLiteral(RangeSequenceLiteralContext ctx) {
		String typeName = ctx.basetype().getText();
		Type inttype = (Type) currentScope().resolve("int"); //find int primtivetype
		
		if (inttype == null) {
			recordError("Collection Literal Range Error: UnDefined  int type! " + typeName, ctx.getStart());
			return null;
		}
		ASTree from = visit(ctx.collectionRangeCS().expression(0));
        ASTree to   = visit(ctx.collectionRangeCS().expression(1));
        if(from.getType() != inttype | to.getType()!= inttype) {
        	recordError("Collection Literal Range Error: Only for  int type! " + typeName, ctx.getStart());
			return null;
        }

        return new CollectionLiteralExp(inttype, List.of(from, to), true);
	}


	/* =====================================================
     *  Default/fallback – delegate to children so we do not need to implement every rule.
     * ===================================================== */

	
	/* =====================================================
     *  Public API helpers
     * ===================================================== */
    /** Returns a <em>copy</em> of the semantic error list collected so far. */
    public List<String> getSemanticErrors() {
        return new ArrayList<>(semanticErrors);
    }

	
	public Scope getCurrentGlobalScope() {
		return currentScope;
	}
    
}
