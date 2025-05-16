package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclBaseListener;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.antlrgen.OclParser;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.SymbolTable;
import ccu.pllab.tcgen3.symboltable.VariableSymbol;
import ccu.pllab.tcgen3.symboltable.scope.LocalScope;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

public class DefSymbolTableListener extends OclBaseListener{
	private SymbolTable symboltable;
	private Scope currentScope;
	
	public DefSymbolTableListener(SymbolTable symboltable) {
		this.symboltable = symboltable;
		this.currentScope = symboltable.GLOBALS;
	}
	
	@Override public void enterPackageDeclarationCS(OclParser.PackageDeclarationCSContext ctx) {
		ctx.scope = this.currentScope;
		pushScope(this.currentScope);
	}

	@Override public void enterClassifierContextDecl(OclParser.ClassifierContextDeclContext ctx) { 
		String classname = ctx.className.getText();
		LocalScope contextInvScope = new LocalScope(currentScope, classname);
		ctx.scope = contextInvScope;
		pushScope(contextInvScope);
	}

	@Override public void enterNoRturnTypeAlt(OclParser.NoRturnTypeAltContext ctx) {
		String classname = ctx.className.getText();
		String methodName = ctx.operationName.getText();
		LocalScope contextMethodScope = new LocalScope(currentScope, classname+"::"+methodName);
		ctx.scope = contextMethodScope;
		pushScope(contextMethodScope);
	}

	@Override public void enterHasRturnTypeAlt(OclParser.HasRturnTypeAltContext ctx) {
		String classname = ctx.className.getText();
		String methodName = ctx.operationName.getText();
		LocalScope contextMethodScope = new LocalScope(currentScope, classname+"::"+methodName);
		ctx.scope = contextMethodScope;
		pushScope(contextMethodScope);
	}
	
	@Override public void enterVariableDeclAlt(OclParser.VariableDeclAltContext ctx) {
		Symbol symbol = currentScope.resolve(ctx.variableName.getText());
		if (symbol == null) {
			String varName = ctx.variableName.getText();
			VariableSymbol variableSymbol = new VariableSymbol(varName);
			currentScope.define(variableSymbol);
		}
		System.out.println("enterVariableDeclAlt\n"+ctx.type().basetype().getText()+ctx.variableName.getText());
	}

	@Override public void enterType(OclParser.TypeContext ctx) {
		//System.out.println("enter type: \n"+ ctx.variableName);
		
		
		
	} 

	@Override public void enterBasetype(OclParser.BasetypeContext ctx) {
		String typeName = ctx.getText();
		System.out.println("enter basetype: "+typeName);
	}

	
	@Override public void exitNoRturnTypeAlt(OclParser.NoRturnTypeAltContext ctx) {
		popScope();
		System.out.println("exit method: "+ctx.operationName.getText());
	}
	
	@Override public void exitHasRturnTypeAlt(OclParser.HasRturnTypeAltContext ctx) {
		popScope();
	}

	
	@Override public void exitClassifierContextDecl(OclParser.ClassifierContextDeclContext ctx) {
		popScope();
	}

	
	@Override public void exitPackageDeclarationCS(OclParser.PackageDeclarationCSContext ctx) {
		popScope();
	}
	
	private void pushScope(Scope s) {
		currentScope = s;
		System.out.println("entering: "+currentScope.getName()+":"+s);
	}

	private void popScope() {
		System.out.println("leaving: "+currentScope.getName()+":"+currentScope);
		currentScope = currentScope.getEnclosingScope();
	}
	
	public SymbolTable getSymboltable() {
		return this.symboltable;
	}
}
