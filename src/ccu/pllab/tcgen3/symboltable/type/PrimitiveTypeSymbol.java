package ccu.pllab.tcgen3.symboltable.type;

import ccu.pllab.tcgen3.symboltable.BaseSymbol;

public class PrimitiveTypeSymbol extends BaseSymbol implements Type{
	protected int typeIndex; 
	
	public PrimitiveTypeSymbol(String name) {
		super(name);
	}
	
	public PrimitiveTypeSymbol(String name,String umlID) {
		super(name,umlID);
	}

	@Override
	public int getTypeIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTypeName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.umlId;
	}

	
	
}
