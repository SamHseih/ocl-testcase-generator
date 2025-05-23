package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTLeaf;
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
	private final boolean isMarkedPre;
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
		return varname;
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
	
}
