package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class IntegerLiteralExp extends LiteralExp<Integer> {
	// PrimitiveLiteralExp is a leaf node in the abstract syntax tree
	// It represents a primitive literal in the OCL expression
	// For example: 2 etc.
	
	public IntegerLiteralExp(int value, Type type) {	
		super(value, type);
	}
	
	@Override
	public <R> R accept(AstVisitor<R> visitor) {
		return visitor.visitIntegerLiteralExpContext(this);
	}
	
	@Override
	public IntegerLiteralExp clone() {
	    return new IntegerLiteralExp(this.getValue(), this.getType());
	}
	
}
