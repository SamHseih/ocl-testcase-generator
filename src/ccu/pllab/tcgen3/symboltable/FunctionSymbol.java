package ccu.pllab.tcgen3.symboltable;

import org.antlr.v4.runtime.ParserRuleContext;

import ccu.pllab.tcgen3.symboltable.type.Type;

/** ref:https://github.com/antlr/symtab/blob/master/doc/symtab.png<br> 
 * This symbol represents a function ala C, not a method ala Java.
 *  You can associate a node in the parse tree that is responsible
 *  for defining this symbol.
 */
public class FunctionSymbol extends SymbolWithScope implements SymbolHasType{ 
	protected ParserRuleContext defNode;
	protected Type retType;
	
	public FunctionSymbol(String name, String umlID) {
		super(name, umlID);
	}
	
	public void setDefNode(ParserRuleContext defNode) {
		this.defNode = defNode;
	}
	
	public ParserRuleContext getDefNode() {
		return defNode;
	}

	@Override
	public Type getType() {
		return retType;
	}

	@Override
	public void setType(Type type) {
		this.retType = type;
	}
	
	/** Return the number of VariableSymbols specifically defined in the scope.
	 *  This is useful as either the number of parameters or the number of
	 *  parameters and locals depending on how you build the scope tree.
	 */
	public int getNumberOfVariables() {
		return Utils.filter(symbols.values(), s -> s instanceof VariableSymbol).size();
	}

	public int getNumberOfParameters() {
		return Utils.filter(symbols.values(), s -> s instanceof ParameterSymbol).size();
	}

	public String toString() { 
		return name+":"+super.toString(); 
		}
}
