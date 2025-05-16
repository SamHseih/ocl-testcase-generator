package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import ccu.pllab.tcgen3.symboltable.type.Type;

public class ClassifierContextDeclAST extends ASTLeaf {
	String pathName;
	
	public ClassifierContextDeclAST(String pathName) {
		this.pathName = pathName;
	}
	
	@Override
	public String toString() {
		return pathName;
	}

	
}
