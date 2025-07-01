package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.symboltable.Symbol;

/**
 * A dedicated AST node for the implicit <code>self</code> variable in OCL.
 * <p>
 *  Distinguishing <code>self</code> from ordinary {@link VariableExp}
 *  allows:
 *  <ul>
 *    <li>Special semantic checks (e.g., no reassignment allowed).</li>
 *    <li>Cleaner pattern‑matching when generating target code.</li>
 *    <li>More explicit intent when reading the AST.</li>
 *  </ul>
 *
 *  The node still carries a {@link VariableSymbol} so that the type,
 *  declaration position, and other metadata remain accessible.
 */
public class SelfExp extends VariableExp {
	
	/**
     * Constructs a new <code>SelfExp</code>.
     *
     * @param isMarkedPre  whether this occurrence is annotated with <code>@pre</code>
     * @param symbol       the {@link VariableSymbol} representing the implicit declaration
     */
	public SelfExp(boolean isMarkedPre, Symbol symbol) {
		super("self", isMarkedPre, symbol);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ASTree clone() {
	    // varname、isMarkedPre 為不可變型別；symbol 依約定可安全共用
	    return new SelfExp(this.isMarkedPre(),this.getSymbol() );
	}
	
	

}
