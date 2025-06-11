package ccu.pllab.tcgen3.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;

public class ClgUtil {
	/** 由一條 Path（edge list）收集所有運算式節點，保持原始順序且不重複。 */
	public static List<CLGNode> collectExprNodes(List<CLGEdge> path) {
	    List<CLGNode> exprs = new ArrayList<>();
	    path.stream()
	        .flatMap(e -> e.getConstraintNode().stream())
	        .filter(n -> !exprs.contains(n))          // 若想避免重複
	        .forEach(exprs::add);
	    return exprs;
	}

}
