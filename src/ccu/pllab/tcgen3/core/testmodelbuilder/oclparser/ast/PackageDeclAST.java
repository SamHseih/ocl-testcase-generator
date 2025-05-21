package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.List;

import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class PackageDeclAST extends ASTList {
	String packageName;
	Scope umldefinitionScope;	
	
	public PackageDeclAST(List<ASTree> children, String packageName) {
		super(children);
		this.packageName = packageName;

	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
