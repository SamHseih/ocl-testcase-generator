package ccu.pllab.tcgen3.symboltable.scope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ccu.pllab.tcgen3.symboltable.Symbol;

/** A scope associated with globals. */
public class GlobalScope extends BaseScope {
	public GlobalScope(Scope scope) { super(scope); }
    public String getName() { return "global"; }

	/**
	 * A map for storing type symbols indexed by their UML IDs.
	 *
	 * This supports lookup of symbol type information based on UML ID,
	 * commonly used in type resolution and symbol table operations.
	 *
	 * Author: Sam Hsieh  
	 * Date: 2025-04-01
	 */
	protected Map<String, Symbol> idsymbols = new LinkedHashMap<>();
    
	public Map<String, ? extends Symbol> getidMembers() {
		return idsymbols;
	}
	
	public Symbol getIdSymbol(String umlId) {
		return idsymbols.get(umlId);
	}
	
	public List<? extends Symbol> getIdSymbols() {
		Collection<Symbol> values = idsymbols.values();
		if ( values instanceof List ) {
			return (List<Symbol>)values;
		}
		return new ArrayList<>(values);
	}
	
	public Symbol resolveById(String umlid) {
		Symbol s = idsymbols.get(umlid);
		if ( s!=null ) {
			return s;
		}
		// if not here, check any enclosing scope
		Scope parent = getEnclosingScope();
		if ( parent != null ) return parent.resolve(umlid);
		return null; // not found
	}
	
	
	public void defineById(Symbol sym) throws IllegalArgumentException {
		if ( idsymbols.containsKey(sym.getTypeID()) ) {
			throw new IllegalArgumentException("duplicate symbol "+sym.getName());
		}
		sym.setScope(this);
		sym.setInsertionOrderNumber(idsymbols.size()); // set to insertion position from 0
		idsymbols.put(sym.getTypeID(), sym);
	}
	
	
	public List<? extends Symbol> getAllIDSymbols() {
		List<Symbol> syms = new ArrayList<>();
		syms.addAll(getSymbols());
		for (Symbol s : idsymbols.values()) {
			if ( s instanceof Scope ) {
				Scope scope = (Scope)s;
				syms.addAll(scope.getAllSymbols());
			}
		}
		return syms;
	}
	
	public int getNumberOfidSymbols() {
		return idsymbols.size();
	}
	
	public Set<String> getidSymbolIDs() {
		return idsymbols.keySet();
	}


	public String toStringid() { return idsymbols.keySet().toString(); }

}
