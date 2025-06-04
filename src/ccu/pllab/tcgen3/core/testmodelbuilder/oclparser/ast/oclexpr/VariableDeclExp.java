package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.CLGAstVisitor;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class VariableDeclExp extends ASTList implements Expression {
	// VariableDeclExp is a list node in the abstract syntax tree
	// It represents a variable declaration in the OCL expression
	// For example: let x : Integer = 5 in x + 1
	// The variable declaration part is "let x : Integer = 5"
	
	private String varname;
	private Type vartype;
	//boolean hasInit = false;
	
	/** VariableDeclExp
	 * ├── child(0) : expressionExp  (for var init)
	 * */
	public VariableDeclExp(List<ASTree> varinit, String varname, Type vartype) {
		super(varinit);
		this.varname = varname;
		this.vartype = vartype;
		/*if (varinit.size() > 0) {
			hasInit = true;
		}*/

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
		StringBuilder sb = new StringBuilder();
		sb.append(varname);
		if (numChildren()>0) {
			sb.append(" = ").append(child(0));
		}
		return sb.toString();
	}
	
	@Override
	public String toAstString() {
		StringBuilder sb = new StringBuilder();
		sb.append(varname).append(" : ").append(vartype.getTypeName());
		if (numChildren()>0) {
			sb.append(" = node(").append(child(0).id()).append(")");
		}
		return sb.toString();
	}
	
	@Override
	public String toClgString() {
		StringBuilder sb = new StringBuilder();
		sb.append(varname);
		if (numChildren()>0) {
			sb.append(" = ").append(child(0));
		}
		return sb.toString();
	}
	
	@Override
	public <R> R accept(CLGAstVisitor<R> visitor) {
		return visitor.visitVariableDeclExpContext(this);
	}
	
	@Override
	public ASTree clone() {
	    // 1.深層複製初始化運算式 (varinit)
	    java.util.List<ASTree> clonedInit = new ArrayList<>();
	    for (ASTree child : this.children) {
	        clonedInit.add(child.clone());
	    }

	    // 2. 使用複製後的 child 清單，建立新 VariableDeclExp
	    //    - varname 為 String（immutable）→ 直接帶入
	    //    - vartype 為 Type（依先前約定不可變）→ 直接共用即可
	    return new VariableDeclExp(clonedInit, this.varname, this.vartype);
	}
}
