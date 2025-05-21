package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.Symbol;

public abstract class FeatureCallExp extends ASTList implements Expression{
	protected boolean isPre;
	protected Symbol sym;
	
	public FeatureCallExp(List<ASTree> children, boolean isPre,Symbol sym) {
		super(children);
		this.isPre = isPre;
		this.sym = sym;
		// TODO Auto-generated constructor stub
	}
	
	public boolean isMarkedPre() {
		return isPre;
	}
	
	public abstract ASTree getSource();
	public abstract String getName();
	//public abstract void setSource(ASTree source);
	
	public Symbol getSymbol() {return sym;}
}
