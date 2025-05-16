package ccu.pllab.tcgen3.symboltable;

import ccu.pllab.tcgen3.symboltable.type.Type;

public class VariableSymbol extends BaseSymbol implements SymbolHasType{
	
	public VariableSymbol(String name) {
		super(name);
	}
	
	public VariableSymbol(String name, String umlID) {
		super(name, umlID);
	}
	
	@Override
	public void setType(Type type) {
		super.setType(type);
	}

}
