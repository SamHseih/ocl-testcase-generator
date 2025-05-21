package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class InvalidExp extends ASTLeaf {
	String name = "ErrorNode";
	@Override
	public Type getType() {
		return new InvalidType();
	}

}
