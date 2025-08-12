package ccu.pllab.tcgen3.core.testcasegen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import ccu.pllab.tcgen3.core.testmodelbuilder.Criterion;
import ccu.pllab.tcgen3.core.testmodelbuilder.TestmodelBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNodeType;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.AstVisitor;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.util.ClgUtil;

/**
 * Boundary value enumerator.<br/>
 * <p>
 * Given a <em>feasible path</em> (i.e., a sequence of {@link CLGEdge}s that is satisfiable), this
 * component enumerates additional paths that satisfy the <strong>Boundary Value Analysis
 * (BVA)</strong> strategy:
 * <ul>
 * <li>For every relational operator {@code <=} or {@code >=} appearing in a constraint node,
 * generate an <em>on‑boundary</em> path by replacing the operator with {@code =}.</li>
 * <li>If the coverage criterion is <em>Decision Coverage</em> (DC) and the constraint is a
 * conjunction/disjunction of multiple boundary operators, enumerate all combinations in which
 * exactly one predicate is placed on the boundary while the others keep their original form.</li>
 * <li>Finally, generate exactly one <em>interior‑point</em> path by replacing every {@code <=} with
 * {@code <} and every {@code >=} with {@code >} for all boundary predicates on the path.</li>
 * </ul>
 * The result is a list of cloned paths that can be fed into downstream test‑ case generators.
 */
public final class BoundaryEnumerator {

  /** The original feasible path provided by the path enumerator. */
  private final List<CLGEdge> feasiblePath;

  /**
   * Creates a new enumerator.
   *
   * @param fesiablePath a non‑null, feasible CLG path
   */
  public BoundaryEnumerator(List<CLGEdge> fesiablePath) {
    this.feasiblePath = Objects.requireNonNull(fesiablePath, "path must not be null");
  }

  /**
   * Enumerates boundary and interior paths derived from the original feasible path.
   *
   * @return a (possibly empty) list of <strong>cloned</strong> paths; the original path instance is
   *         never modified
   */
  public List<List<CLGEdge>> getBoundaryPath() {
    List<List<CLGEdge>> returnlist = new ArrayList<>();
    // Collect all nodes appearing on the feasible path (start → end).
    List<CLGNode> allCLGNodes = ClgUtil.collectAllNodes(this.feasiblePath);
    // Tracks those nodes that contain at least one boundary operator (>=, <=).
    Map<Integer, CLGNode> boundarynodes = new HashMap<>();// 用於追蹤節點 封閉邊界結點
    boolean nextconstraintSkip = false;
    // ----- Boundary-on-point test cases -----------------------------------
    for (CLGNode node : allCLGNodes) {
      if (node.getType().equals(CLGNodeType.ITERATE)) {
        nextconstraintSkip = true;// loop condition "<=" or ">="doesn't need BVA.
      }
      if (detectBoundaryOperator(node.getExpr()) && !nextconstraintSkip) {
        boundarynodes.put(node.id(), node);
        if (TestmodelBuilder.criterion == Criterion.DC) {
          // DC: enumerate one path per boundary predicate inside a conjunction.
          // Example: A>=0 \and B<=0 ⇒ {A==0 ∧ B<=0, A>=0 ∧ B==0}
          for (List<CLGEdge> path : processDCboundaryPath(allCLGNodes, feasiblePath, node)) {
            returnlist.add(path);
          }
        } else// DCC or MCC
          returnlist.add(processBoundaryPath(allCLGNodes, feasiblePath, node.id()));
      }
      if (!node.getType().equals(CLGNodeType.ITERATE) && nextconstraintSkip) {
        nextconstraintSkip = false;
      }
    }
    // ----- Boundary-interior test case ------------------------------------
    if (!boundarynodes.isEmpty())
      returnlist.add(processInteriorPath(allCLGNodes, feasiblePath, boundarynodes));
    else {
      // No boundary predicates at all – fall back to the original path.
      returnlist.add(this.feasiblePath);
    }
    return returnlist;
  }

  /* ------------------------------------------------------------------ */
  /* Helper Methods */
  /* ------------------------------------------------------------------ */

  /**
   * Recursively checks whether the given AST contains {@code >=} or {@code <=} operators.
   *
   * @param root the AST root (may be {@code null})
   * @return {@code true} if a boundary operator is found, otherwise {@code false}
   */
  private boolean detectBoundaryOperator(ASTree root) {
    if (root == null) // StartNode、EndNode、ConnectionNode, etc.
      return false;
    if (root instanceof BinaryExp bin) {
      // Handle logical connectors recursively.
      if (bin.getOperator().equals("and") || bin.getOperator().equals("or")) {
        return detectBoundaryOperator(bin.left()) || detectBoundaryOperator(bin.right());
      }
      // Base case: actual relational operator.
      return bin.getOperator().equals("<=") || bin.getOperator().equals(">=");
    }
    return false;// Without BD Op Expr
  }

  /**
   * DC-specific expansion: for a constraint node whose AST is a conjunction (e.g.,
   * {@code A>=0 and B<=0}), create a new path for each predicate where exactly <em>one</em>
   * relational operator is forced to equality.
   */
  private List<List<CLGEdge>> processDCboundaryPath(List<CLGNode> allnodes,
      List<CLGEdge> feasiablePath, CLGNode bdnode) {
    List<List<CLGEdge>> rtPaths = new ArrayList<>();

    Map<Integer, CLGNode> nodeMap = new HashMap<>();
    // First, break the original constraint node into k boundary nodes where
    // the selected predicate uses "=" while the others stay unchanged.
    List<CLGNode> newbdclgnodes = bdprocess(bdnode.getExpr(), bdnode);

    // For every synthesized boundary node create a deep clone of the path.
    CLGNode cloned = null;
    for (CLGNode ithbdnode : newbdclgnodes) {
      List<CLGEdge> clonePath = new ArrayList<>();

      // 1) clone / substitute nodes ---------------------------------------
      for (CLGNode n : allnodes) {
        if (n.id() == bdnode.id()) {
          cloned = ithbdnode;
        } else {
          cloned = n.clone();
        }
        nodeMap.put(n.id(), cloned);
      }

      // 2) clone edges ------------------------------------------------------
      for (CLGEdge e : feasiablePath) {
        CLGNode fromClone = nodeMap.get(e.getFrom().id());
        CLGNode toClone = nodeMap.get(e.getTo().id());
        CLGEdge edgeClone =
            fromClone.connectTo(toClone, e.getType(), e.getLabel(), e.getIterationIndex());

        if (e.isCovered()) {
          edgeClone.setCovered(true);
        }
        clonePath.add(edgeClone);
      }
      rtPaths.add(clonePath);
    }

    return rtPaths;
  }

  /**
   * Breaks a single constraint node whose AST contains multiple relational operators joined by
   * {@code and}. Each generated node has exactly one predicate changed from {@code >=}/{@code <=}
   * to {@code =}.
   */
  private List<CLGNode> bdprocess(ASTree current, CLGNode bdnode) {
    List<CLGNode> returnlist = new ArrayList<>();

    if (current instanceof BinaryExp bin) {
      String op = bin.getOperator();
      // Case 1: logical conjunction – process both operands separately.
      if ("and".equals(op)) {
        current = bin.left();
        returnlist.addAll(bdprocess(current, bdnode));
        current = bin.right();
        returnlist.addAll(bdprocess(current, bdnode));
      }
      // Case 2: actual boundary operator – clone node and replace with '='.
      else if (">=".equals(op) || "<=".equals(op)) {
        String ori = op;// Preserve original operator.
        bin.setOperator("=");// Temporarily switch to equality.
        CLGNode boundaryNode = bdnode.clone();
        bin.setOperator(ori); // Restore original operator.
        returnlist.add(boundaryNode);
      }
      // Other operators are ignored.
    }

    return returnlist;
  }

  /**
   * Creates a single on‑boundary path by cloning every node and replacing the relational operator
   * at the specified <code>bdpoint</code> with equality.
   */
  private List<CLGEdge> processBoundaryPath(List<CLGNode> allnodes, List<CLGEdge> feasiablePath,
      int bdpoint) {

    Map<Integer, CLGNode> nodeMap = new HashMap<>();
    List<CLGEdge> clonePath = new ArrayList<>();

    // 1) clone nodes (apply operator substitution on the boundary node)
    for (CLGNode n : allnodes) {
      CLGNode cloned = n.clone();
      if (bdpoint == n.id()) {
        if (cloned.getExpr() instanceof BinaryExp bin) {
          if (bin.getOperator().equals("<=") || bin.getOperator().equals(">=")) {
            bin.setOperator("=");// OCL operator
          }
        }
      }
      nodeMap.put(n.id(), cloned);
    }
    // 2) clone edges
    for (CLGEdge e : feasiablePath) {
      CLGNode fromClone = nodeMap.get(e.getFrom().id());
      CLGNode toClone = nodeMap.get(e.getTo().id());
      CLGEdge edgeClone =
          fromClone.connectTo(toClone, e.getType(), e.getLabel(), e.getIterationIndex());
      if (e.isCovered()) {
        edgeClone.setCovered(true);
      }
      clonePath.add(edgeClone);
    }

    return clonePath;
  }

  /**
   * Generates exactly one interior‑point path by turning every boundary predicate along the
   * feasible path from {@code <=}/{@code >=} to {@code <}/{@code >} respectively.
   */
  private List<CLGEdge> processInteriorPath(List<CLGNode> allnodes, List<CLGEdge> feasiablePath,
      Map<Integer, CLGNode> bdpoint) {

    Map<Integer, CLGNode> nodeMap = new HashMap<>();
    List<CLGEdge> clonePath = new ArrayList<>();
    // 1) clone nodes (apply strict‑inequality substitution where necessary)
    for (CLGNode n : allnodes) {
      CLGNode cloned = n.clone();
      if (cloned != null) {

        if (bdpoint.containsKey(n.id())) {// node has bd op
          // Use a visitor to transform every >= / <= inside the node to > / <.
          AstVisitor<ASTree> visitor = new BoundaryInteriorVisitor<ASTree>();
          ASTree opchangeAST = cloned.getExpr().accept(visitor);// retrun for check
          // System.out.println(opchangeAST.toAstString());
        }
        nodeMap.put(n.id(), cloned);
      } else
        System.out.println("gen. Interrior TestCase BVA Error. ");

    }
    // 2) clone edges
    for (CLGEdge e : feasiablePath) {
      CLGNode fromClone = nodeMap.get(e.getFrom().id());
      CLGNode toClone = nodeMap.get(e.getTo().id());
      CLGEdge edgeClone =
          fromClone.connectTo(toClone, e.getType(), e.getLabel(), e.getIterationIndex());

      if (e.isCovered()) {
        edgeClone.setCovered(true);
      }

      clonePath.add(edgeClone);
    }

    return clonePath;
  }


}
