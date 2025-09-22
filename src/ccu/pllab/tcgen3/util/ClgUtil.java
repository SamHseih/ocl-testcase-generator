package ccu.pllab.tcgen3.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNodeType;

public class ClgUtil {
	/** �Ѥ@�� Path�]edge list�^�����Ҧ��B�⦡�`�I�A�O����l���ǥB�����ơC */
	public static List<CLGNode> collectExprNodes_nouse(List<CLGEdge> path) {
	    List<CLGNode> exprs = new ArrayList<>();
	    path.stream()
	        .flatMap(e -> e.getConstraintNode().stream())
	        //.filter(n -> !exprs.contains(n))          // �Y�Q�קK����
	        .forEach(exprs::add);
	    return exprs;
	}
	
	public static List<CLGNode> collectExprNodes(List<CLGEdge> path){
		List<CLGNode> exprsnodes = new ArrayList<>();
		Iterator<CLGEdge> it = path.iterator();
		while(it.hasNext()) {
			CLGNode next = it.next().getTo();
			if(next.getType() == CLGNodeType.CONSTRAINT || next.getType() == CLGNodeType.ITERATE)
				exprsnodes.add(next);
		}
		return exprsnodes;
	}

}
