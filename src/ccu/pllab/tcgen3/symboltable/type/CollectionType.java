package ccu.pllab.tcgen3.symboltable.type;

import java.util.Collection;
import java.util.Iterator;

import ccu.pllab.tcgen3.symboltable.BaseSymbol;

public class CollectionType<T extends Type>  extends BaseSymbol implements Type {
	private T type;
	public CollectionType(String typename) {
		super(typename);
		// TODO Auto-generated constructor stub
	}
	
	public String getTypeName() {
		return this.name+"("+type.getTypeName()+")";
	};
	
	//return elementID
	public String getTypeID() {
		return type.getTypeID();
	}

	@Override
	public int getTypeIndex() {
		// TODO Auto-generated method stub
		return 0;
	};

	
}
