package ccu.pllab.tcgen3.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;

public class ClgUtil {
	/** �Ѥ@�� Path�]edge list�^�����Ҧ��B�⦡�`�I�A�O����l���ǥB�����ơC */
	public static List<CLGNode> collectExprNodes(List<CLGEdge> path) {
	    List<CLGNode> exprs = new ArrayList<>();
	    path.stream()
	        .flatMap(e -> e.getConstraintNode().stream())
	        .filter(n -> !exprs.contains(n))          // �Y�Q�קK����
	        .forEach(exprs::add);
	    return exprs;
	}

}
