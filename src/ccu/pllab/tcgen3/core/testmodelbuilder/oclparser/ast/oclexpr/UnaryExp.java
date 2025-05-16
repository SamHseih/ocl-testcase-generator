package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class UnaryExp extends ASTList implements Expression {
	private final String operator;

	public UnaryExp(List<ASTree> expr, String operator) {
		super(expr);
		this.operator = operator;
	}

	public String getOperator() { return operator; }
    public ASTree expr() { return child(0); }
    @Override public String toString() { return "(" + operator + " " + expr() + ")"; }

	@Override
	public Type getType() {
		return null;
	}
}
