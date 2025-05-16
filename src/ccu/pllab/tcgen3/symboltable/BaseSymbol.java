package ccu.pllab.tcgen3.symboltable;

import org.antlr.v4.runtime.ParserRuleContext;

import ccu.pllab.tcgen3.symboltable.scope.Scope;
import ccu.pllab.tcgen3.symboltable.type.Type;

public abstract class BaseSymbol implements Symbol{

	protected final String name;   		 // All symbols at least have a name
	protected Type type;				 // If language statically typed, record type
	protected Scope scope;      		 // All symbols know what scope contains them.
	protected ParserRuleContext defNode; // points at definition node in tree
	protected int lexicalOrder; 		 // order seen or insertion order from 0; compilers often need this
	protected String umlId; // UML ID for the symbol, if applicable	
	
	/** for OclParser*/
	public BaseSymbol(String name) { this.name = name; }
	
	/** for umlParser*/
	public BaseSymbol(String name, String umlId) { 
		this.name = name;
		this.umlId = umlId;
		}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getTypeID() {
		return umlId;
	}

	@Override
	public Scope getScope() {
		return scope;
	}

	@Override
	public void setScope(Scope scope) {
		this.scope = scope;
		
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type=type;
		}
	
	@Override
	public int getInsertionOrderNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override	
	public void setInsertionOrderNumber(int i) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		//check obj is Symbol
		if( !(obj instanceof Symbol) ) {
			
			return false;
		}
		if(obj == this) {//if same ref return true.
			
			return true;
		}
		/*If obj is a Symbol and its name is the same as this.name, 
		return true; otherwise, return false.*/
		return name.equals(((Symbol)obj).getName());
	}
	
	public boolean equalsByID(Object obj) {
		//check obj is Symbol
		if( !(obj instanceof Symbol) ) {
			
			return false;
		}
		if(obj == this) {//if same ref return true.
			
			return true;
		}
		/*If obj is a Symbol and its name is the same as this.name, 
		return true; otherwise, return false.*/
		return umlId.equals(((Symbol)obj).getTypeID());
	}
}
