package ccu.pllab.tcgen3.symboltable;

/** ref:https://github.com/antlr/symtab/blob/master/doc/symtab.png <br> 
 * A parameter is just kind of variable used as an argument to a
 *  function or method.
 */
public class ParameterSymbol extends VariableSymbol{
	private String lowerValue;
	private String upperValue;

	public ParameterSymbol(String name, String umlID) {
		super(name, umlID);
	}
	
	public void setMultiplicity(String lowerValue, String upperValue) {
		this.lowerValue = lowerValue;
		this.upperValue = upperValue;
	}
	
	public String getMultiplicity() {
		return lowerValue + ".." + upperValue;
	}
}
