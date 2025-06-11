package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTLeaf;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.CLGAstVisitor;
import ccu.pllab.tcgen3.symboltable.BaseSymbol;
import ccu.pllab.tcgen3.symboltable.ClassSymbol;
import ccu.pllab.tcgen3.symboltable.Symbol;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class VariableExp extends ASTLeaf implements Expression {
	// VariableExp is a leaf node in the abstract syntax tree
	// It represents a variable in the OCL expression
	// For example: x, y, z, etc.
	
	private final String varname;
	private  boolean isMarkedPre;
	private Symbol symbol;
	
	public VariableExp(String name,boolean isMarkedPre,Symbol symbol) {
		this.varname = name;
		this.isMarkedPre = isMarkedPre;
		this.symbol = symbol;
	}
	
	public String getid() {
		return varname;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(varname);
		sb.append(isMarkedPre ? "@pre" : "");
		return sb.toString();
	}
	
	@Override
	public String toAstString() {
		return varname;
	}
	
	@Override
	public String toClgString() {
		StringBuilder sb = new StringBuilder();
		sb.append(varname);
		sb.append(isMarkedPre ? "@pre" : "");
		return sb.toString();
	}

	public String getName() {
		return varname;
	}
	
	public Symbol getSymbol() {
		return symbol;
	}
	
	public boolean isMarkedPre() {
		return isMarkedPre;
	}
	
	public void setisMarkedPre(boolean isMarkedPre) {
		this.isMarkedPre = isMarkedPre;
	}
	

	@Override
	public Type getType() {
		if (symbol instanceof BaseSymbol) {
			return ((BaseSymbol) symbol).getType();
		} else if(symbol instanceof ClassSymbol) {
			return (ClassSymbol)this.symbol;
		} else {
			return new InvalidType();
		}

	}
	
	@Override
	public <R> R accept(CLGAstVisitor<R> visitor) {
		return visitor.visitVariableExpContext(this);
	}
	
	@Override
	public ASTree clone() {
	    // varname、isMarkedPre 為不可變型別；symbol 依約定可安全共用
	    return new VariableExp(this.varname, this.isMarkedPre, this.symbol);
	}
	
}
