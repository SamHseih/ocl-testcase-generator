package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class InvalidAST extends ASTLeaf {
	String name = "ErrorNode";
	@Override
	public Type getType() {
		return new InvalidType();
	}
	
	@Override
	public String toString(){
		return name;
	}

}
