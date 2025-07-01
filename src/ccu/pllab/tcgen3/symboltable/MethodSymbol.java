package ccu.pllab.tcgen3.symboltable;

import java.util.ArrayList;
import java.util.List;

/** A method symbol is a function that lives within an aggregate/class and has a slot number. */
public class MethodSymbol extends FunctionSymbol implements MemberSymbol {
	protected int slot = -1;


	public MethodSymbol(String name, String umlID) {
		super(name, umlID);
	}

	@Override
	public int getSlotNumber() { return slot; }
	
	public List<ParameterSymbol> getParameters(){
		List<ParameterSymbol> rt  = new ArrayList<>(); 
		for(Symbol s : this.getAllSymbols()) {
			if(s instanceof ParameterSymbol p) {
				rt.add(p);
			}
		}
		return rt;
	}
	

}
