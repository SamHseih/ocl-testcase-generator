package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.CLGAstVisitor;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class StringLiteralExp extends LiteralExp<String> {
	// StringLiteralExp is a leaf node in the abstract syntax tree
	// It represents a string literal in the OCL expression
	// For example: "Hello, World!", "OCL", etc.
	
	public StringLiteralExp(String value, Type type) {
		super(value, type);
	}
	
	@Override
	public <R> R accept(CLGAstVisitor<R> visitor) {
		return visitor.visitStringLiteralExpContext(this);
	}
	
	@Override
	public StringLiteralExp clone() {
	    return new StringLiteralExp(this.getValue(), this.getType());
	}
}
