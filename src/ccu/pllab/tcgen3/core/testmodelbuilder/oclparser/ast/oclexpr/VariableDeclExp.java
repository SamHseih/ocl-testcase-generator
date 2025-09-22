package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTLeaf;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class VariableDeclExp extends ASTLeaf implements Expression {
	// VariableDeclExp is a list node in the abstract syntax tree
	// It represents a variable declaration in the OCL expression
	// For example: let x : Integer 
	// or iterate(X:Integer ...)
	private final String varname;
	private final Type vartype;

	
	/** VariableDeclExp
	 * �u�w�w child(0) : expressionExp  (for var init)
	 * */
	public VariableDeclExp(String varname, Type vartype) {
		this.varname = varname;
		this.vartype = vartype;
	}
	
	public String getVarname() {
		return varname;
	}

	@Override
	public Type getType() {
		return vartype;
	}
	
	@Override
	public String toString() {
		return varname;
	}
	
	@Override
	public String toAstString() {
		StringBuilder sb = new StringBuilder();
		sb.append(varname).append(" : ").append(vartype.getTypeName());
		return sb.toString();
	}
	
	@Override
	public String toClgString() {
		return varname;
	}
	
	@Override
	public <R> R accept(AstVisitor<R> visitor) {
		return visitor.visitVariableDeclExpContext(this);
	}
	
	@Override
	public ASTree clone() {
	    /*// 1.�`�h�ƻs��l�ƹB�⦡ (varinit)
	    java.util.List<ASTree> clonedInit = new ArrayList<>();
	    for (ASTree child : this.children) {
	        clonedInit.add(child.clone());
	    }

	    // 2. �ϥνƻs�᪺ child �M��A�إ߷s VariableDeclExp
	    //    - varname �� String�]immutable�^�� �����a�J
	    //    - vartype �� Type�]�̥��e���w���i�ܡ^�� �����@�ΧY�i*/
	    return new VariableDeclExp(this.varname, this.vartype);
	}
}
