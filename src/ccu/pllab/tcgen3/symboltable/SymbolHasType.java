package ccu.pllab.tcgen3.symboltable;

import ccu.pllab.tcgen3.symboltable.type.Type;

public interface SymbolHasType {
	Type getType();
	void setType(Type type);
}
