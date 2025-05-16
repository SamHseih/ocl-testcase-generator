package ccu.pllab.tcgen3.symboltable;

import ccu.pllab.tcgen3.symboltable.scope.BaseScope;
import ccu.pllab.tcgen3.symboltable.scope.GlobalScope;
import ccu.pllab.tcgen3.symboltable.type.InvalidType;
import ccu.pllab.tcgen3.symboltable.type.Type;

/**
 * SymbolTable.java
 * 
 * This class represents the symbol table for the compiler. It contains the
 * predefined symbols (By UML ClassDiagram) and the global scope.
 * 
 * @version 1.0
 */
public class SymbolTable {
	public static final Type INVALID_TYPE = new InvalidType();

	private BaseScope UML_PREDEFINED;
	public GlobalScope GLOBALS;
	
	public SymbolTable(BaseScope predefined) {
		this.UML_PREDEFINED = predefined;
		this.GLOBALS = new GlobalScope(predefined);
		
	}

	public void initTypeSystem() {
	}

	public void definePredefinedSymbol(Symbol s) {
		UML_PREDEFINED.define(s);
	}

	public void defineGlobalSymbol(Symbol s) {
		GLOBALS.define(s);
	}
}
