package ccu.pllab.tcgen3.core.testmodelbuilder.clg;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;

public abstract class CLGNode implements Iterable<ASTree>{
	/** The number of CLG nodes. */
	private static final AtomicInteger COUNTER = new AtomicInteger(0);
	
	/** The id of the CLG node. */
	private final int id = COUNTER.getAndIncrement();
	
	
	public final int id() { return id; }


	@Override
	public Iterator<ASTree> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
