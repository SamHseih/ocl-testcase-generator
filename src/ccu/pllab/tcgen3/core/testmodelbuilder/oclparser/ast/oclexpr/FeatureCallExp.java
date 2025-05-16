package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;

public abstract class FeatureCallExp extends ASTList implements Expression{
	protected boolean isPre;
	
	public FeatureCallExp(List<ASTree> children, boolean isPre) {
		super(children);
		this.isPre = isPre;
		// TODO Auto-generated constructor stub
	}
	
	public boolean isPre() {
		return isPre;
	}
	
	public abstract ASTree getSource();
	public abstract String getName();
	//public abstract void setSource(ASTree source);

}
