package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.List;

import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.Type;

/** AST Root*/
public class PackageDeclAST extends ASTList {
	String packageName;
	Scope umldefinitionScope;	
	
	public PackageDeclAST(List<ASTree> children, String packageName) {
		super(children);
		this.packageName = packageName;

	}
	
	public String getASTfilname() {
		StringBuilder sb = new StringBuilder();
		sb.append(packageName).append("_");
		if(child(0) instanceof ContextDeclAST c) {
			if(c.getContextDecl() instanceof ClassifierContextDeclAST clazz) {
				sb.append(clazz.toString());
			}else if(c.getContextDecl() instanceof OperationContextDeclAST clazz){
				sb.append(clazz.getPathName()).append("_");
				sb.append(clazz.getMethodName());
			}
		}
		return sb.toString();
	}

	@Override
	public Type getType() {
		return child(0).getType();
	}
	
	@Override
	public String toString() {
		return "PackageName: "+this.packageName;
	}
}
