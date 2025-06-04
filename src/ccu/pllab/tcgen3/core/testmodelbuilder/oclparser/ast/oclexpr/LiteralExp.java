package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTLeaf;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.Type;

public abstract class LiteralExp<T> extends ASTLeaf implements Expression{
	private final T value;
	protected final Type type;
	
	public LiteralExp(T value,Type type) {
		this.value = value;
		this.type = type;
	}
	
	public T getValue() {
		return value;
	}
	
	public Type getType() {
		return type;
	}
	
	public String toString() {
		return value.toString();
	}
	
	@Override
	public String toAstString() {
		return value.toString();
	}
	
	@Override
	public String toClgString() {
		return value.toString();
	}
	
	public abstract ASTree clone();
}
