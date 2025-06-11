package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.Type;

public abstract class CollectionPart extends ASTList implements Expression {

	
	/** not allow Empty*/
	public CollectionPart(List<ASTree> children) {
		super(children);
	}

	
	public abstract String size();
	public abstract ASTree clone();

}
