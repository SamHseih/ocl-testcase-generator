package ccu.pllab.tcgen3.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNodeType;

public class ClgUtil {
  /** 由一條 Path（edge list）收集所有運算式節點，保持原始順序。 */
  public static List<CLGNode> collectAllNodes(List<CLGEdge> path) {
    List<CLGNode> exprsnodes = new ArrayList<>();
    Iterator<CLGEdge> it = path.iterator();
    CLGEdge edge = it.next();
    if (edge.getFrom().getType() == CLGNodeType.START)
      exprsnodes.add(edge.getFrom()); // 加入起始節點
    while (it.hasNext()) {
      CLGNode next = edge.getTo();
      exprsnodes.add(next);
      edge = it.next();
    }
    if (edge.getTo().getType() == CLGNodeType.END)
      exprsnodes.add(edge.getTo()); // 加入終止節點
    return exprsnodes;
  }

  // 不包含起始節點與終止節點的運算式節點收集方法
  public static List<CLGNode> collectExprNodes(List<CLGEdge> path) {
    List<CLGNode> exprsnodes = new ArrayList<>();
    Iterator<CLGEdge> it = path.iterator();
    while (it.hasNext()) {
      CLGNode next = it.next().getTo();
      if (next.getType() == CLGNodeType.CONSTRAINT || next.getType() == CLGNodeType.ITERATE)
        exprsnodes.add(next);
    }
    return exprsnodes;
  }

  /**
   * 深度複製整條路徑（<em>不</em>進行任何 operator 取代）。
   */
  public static List<CLGEdge> deepClonePath(List<CLGNode> oriconstraints, List<CLGEdge> oriedges) {
    List<CLGEdge> copy = new ArrayList<>();
    Map<Integer, CLGNode> nodeMap = new HashMap<>();
    for (CLGNode n : oriconstraints) {
      CLGNode cloned = n.clone();
      nodeMap.put(n.id(), cloned);
    }
    // 3. 複製所有邊
    for (CLGEdge e : oriedges) {
      CLGNode fromClone = nodeMap.get(e.getFrom().id());
      CLGNode toClone = nodeMap.get(e.getTo().id());
      CLGEdge edgeClone =
          fromClone.connectTo(toClone, e.getType(), e.getLabel(), e.getIterationIndex());

      if (e.isCovered()) {
        edgeClone.setCovered(true);
      }
      copy.add(edgeClone);
    }

    return copy;
  }

  public static boolean isIterateNode(CLGGraph clg) {
    for (CLGNode node : clg.getNodes()) {
      if (node.getType() == CLGNodeType.ITERATE) {
        return true;
      }
    }
    return false;
  }

}
