package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.type.Type;

public class CollectionLiteralExp extends ASTList implements Expression {
	//Onlyt for Sequence
	private Type elemType; // 若為 untyped literal，為 null
	private final boolean isRange ;

	    /* Ex1 Sequence{1,2,3} child is element */
		/* Ex2 Sequence{0..5}
		 * child(0) is uperValue  , child(1) is lowerValue */
	public CollectionLiteralExp(Type elemType, List<ASTree> elements, boolean isRange) {
		super(elements);
		this.elemType = elemType;
		this.isRange = isRange;
	    }

	public boolean hasType() { return elemType != null; }
	public boolean isRange() { return isRange; }
	
	/* 若 isRange == false，回傳元素列表；否則回傳單一 CollectionRangeNode */
	public List<Expression> parts() {
		int start = hasType() ? 1 : 0;
		List<Expression> out = new ArrayList<>(numChildren() - start);
		for (int i = start; i < numChildren(); i++) out.add((Expression) child(i));  
		
		return out;
	}
	
	@Override
	public Type getType() {
		return elemType;
	}
	

}
