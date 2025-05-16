package ccu.pllab.tcgen3.symboltable;

import java.util.Collections;
import java.util.List;

import ccu.pllab.tcgen3.symboltable.scope.BaseScope;
import ccu.pllab.tcgen3.symboltable.scope.Scope;

/**	ref:https://github.com/antlr/symtab/blob/master/doc/symtab.png <br> 
 * An abstract base class that houses common functionality for
 *  symbols like classes and functions that are both symbols and scopes.
 *  There is some common cut and paste functionality with {@link BaseSymbol}
 *  because of a lack of multiple inheritance in Java but it is minimal.
 */
public abstract  class SymbolWithScope extends BaseScope implements Symbol, Scope{
	
	/**  All symbols at least have a name*/
	protected final String name;  
	
	protected final String umlID; // UML ID for this symbol, if any
	
	/** insertion order from 0; compilers often need this*/
    protected int index;	
	
	public SymbolWithScope(String name, String umlID) {
		this.name = name;
		this.umlID = umlID;
	}

	@Override 
	public String getName() {
		return name;
	}
	
	@Override
	public String getTypeID(){
		return umlID;
	}
	

	@Override 
	public Scope getScope() {
		return this.enclosingScope;
	}

	@Override
	public void setScope(Scope scope) {
		this.setEnclosingScope(scope);
		
	}
	
	@Override
	public Scope getEnclosingScope() {
		return this.enclosingScope;
	}
	
	/** Return the name prefixed with the name of its enclosing scope
	 *  using '.' (dot) as the scope separator.
	 */
	public String getQualifiedName() {
		return enclosingScope.getName() + "." + name;
	}

	/** Return the name prefixed with the name of its enclosing scope. */
	public String getQualifiedName(String scopePathSeparator) {
		return enclosingScope.getName() + scopePathSeparator + name;
	}

	/** Return the fully qualified name includes all scopes from the root down
	 *  to this particular symbol.
	 */
	public String getFullyQualifiedName(String scopePathSeparator) {
		List<Scope> path = getEnclosingPathToRoot();
		Collections.reverse(path);
		
		return Utils.joinScopeNames(path, scopePathSeparator);
	}

	@Override
	public int getInsertionOrderNumber() {
		return this.index;
	}

	@Override
	public void setInsertionOrderNumber(int i) {
        this.index = i ;
	}
	
	@Override
	public int getNumberOfSymbols() {
		return this.symbols.size();
	}
	
	@Override
	public boolean equals(Object obj) {
		//check obj is Symbol
		if( !(obj instanceof Symbol) ) {
			
			return false;
		}
		if(obj == this) {//if same ref return true.
			
			return true;
		}/*If obj is a Symbol and its name is the same as this.name, 
		return true; otherwise, return false.*/
		
		return name.equals(((Symbol)obj).getName());
	}
	
	@Override
	public int hashCode() {
	    return this.name.hashCode();
	}
	
	
}
