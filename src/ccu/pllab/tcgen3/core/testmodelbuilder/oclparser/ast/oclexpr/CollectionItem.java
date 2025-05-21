package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.Iterator;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class CollectionItem extends CollectionPart{

	//prohibit empty collection !!!
	/* {1,2,3,4}
	 * child(0) = IntegerLiteralExp.getValue = 1
	 * child(1) = IntegerLiteralExp.getValue = 2
	 * child(2) = IntegerLiteralExp.getValue = 3
	 * child(3) = IntegerLiteralExp.getValue = 4
	 * */
	public CollectionItem(List<ASTree> children) {
		super(children);
	}
	
	@Override
	public Type getType() {
		return child(0).getType();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < numChildren(); i++) {
	        sb.append(children.get(i).toString());
	        if (i < children.size() - 1) {
	            sb.append(", ");
	        }
	    }
	    sb.append("}");
	    return sb.toString();
	}
}
