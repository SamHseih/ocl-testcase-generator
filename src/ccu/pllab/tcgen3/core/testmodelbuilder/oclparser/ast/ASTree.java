package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.Expression;
import ccu.pllab.tcgen3.symboltable.type.Type;

public abstract class ASTree implements Iterable<ASTree>,Expression{
	
	/** The number of AST nodes. */
	private static final AtomicInteger COUNTER = new AtomicInteger(0);
	
	/** The id of the AST node. */
	private final int id = COUNTER.getAndIncrement();
	
	
	public final int id() { return id; }
	
	/** @return returns the i-th ASTnode.*/
	public abstract ASTree child(int i);
	
	/** @return returns the number of children (or 0 if none).*/
	public abstract int numChildren();
	
	/** @return returns a iterator for traversal childnodes*/
	public abstract Iterator<ASTree> children();
	
	/** @return returns a string that represents the position of an abstract
	 *  syntax tree (AST) node within the program. */
	public abstract String location();
	
	/** @return returns a iterator for traversal childnodes*/
	public Iterator<ASTree> iterator() {
		return children();
		}
	
}
	