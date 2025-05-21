package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;

public abstract class CollectionPart extends ASTList implements Expression {

	public CollectionPart(List<ASTree> children) {
		super(children);
	}
	
	

}
