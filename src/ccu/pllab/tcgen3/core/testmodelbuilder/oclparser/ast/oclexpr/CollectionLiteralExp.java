package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class CollectionLiteralExp extends ASTList implements Expression {
	//Onlyt for Sequence
	//prohibit empty collection !!!
	//private String collectionType; // "Set", "Bag", "Sequence", "OrderedSet"
	// only for Primitive "int"
	    /* Two kinds of Collection Parts
		 * Ex1 Sequence{1,2,3}  Ex2 Sequence{0..5} */
	
	public CollectionLiteralExp(List<ASTree> elements) {
		super(elements);
	    }
	
	@Override
	public Type getType() {
		return child(0).getType();
	}
	
	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Sequence");
		sb.append(child(0).toString());
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return "Sequence";
	}
	
	@Override
	public String toAstString() {
		return "Sequence";
	}
	
	@Override
	public String toClgString() {
		return "Sequence";
	}
	
	@Override
	public <R> R accept(AstVisitor<R> visitor) {
		return visitor.visitCollectionLiteralExpContext(this);
	}
	
	@Override
	public ASTree clone() {
	    List<ASTree> clonedChildren = new ArrayList<>();
	    for (ASTree child : this.children) {
	        clonedChildren.add(child.clone());
	    }
	    return new CollectionRange(clonedChildren);
	}
}
