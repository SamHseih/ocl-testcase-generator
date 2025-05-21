package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class CollectionRange extends CollectionPart{

	//child(0) is lowerValue  , child(1) is uperValue 
	public CollectionRange(List<ASTree> children) {
		super(children);
	}

	@Override
	public Type getType() {
		if(child(0).getType().equals(child(1).getType())){
			return child(0).getType();
		}else return new InvalidType();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		String sep="..";
		sb.append(children.get(0).toString());
	    sb.append(sep);
	    sb.append(children.get(1).toString());    
	    sb.append("}");
	    return sb.toString();
	}
}
