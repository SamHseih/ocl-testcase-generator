package ccu.pllab.tcgen3.core.testmodelbuilder.clg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;

/**
 * Immutable‐id CLG node.
 * <p>
 * – The node type and id are final. <br>
 * – The in/out edge lists are mutable only during graph construction. <br>
 * – ASTree is stored only for CONSTRAINT / ITERATE nodes (may be null).
 * </p>
 */
public class CLGNode implements Cloneable {

  /*
   * ------------------------------------------------------------------ 1. Static counter for
   * globally unique ids ------------------------------------------------------------------
   */
  private static final AtomicInteger COUNTER = new AtomicInteger(0);

  /*
   * ------------------------------------------------------------------ 2. Core fields
   * ------------------------------------------------------------------
   */
  private final int id;
  private final CLGNodeType type;
  private final ASTree expr; // null if not required

  /* Keep insertion order for deterministic traversal */
  private final List<CLGEdge> out = new ArrayList<>();
  private final List<CLGEdge> in = new ArrayList<>();

  /*
   * ------------------------------------------------------------------ 3. Constructors
   * ------------------------------------------------------------------
   */
  public CLGNode(CLGNodeType type) {
    this(type, null);
  }

  public CLGNode(CLGNodeType type, ASTree expr) {
    this.id = COUNTER.getAndIncrement();
    this.type = Objects.requireNonNull(type, "node type must not be null");
    this.expr = expr; // allowed to be null
  }

  /*
   * ------------------------------------------------------------------ 4. Getters
   * ------------------------------------------------------------------
   */
  public int id() {
    return id;
  }

  public CLGNodeType getType() {
    return type;
  }

  public ASTree getExpr() {
    return expr;
  }

  /** Returns an unmodifiable view – outside code cannot mutate directly. */
  public List<CLGEdge> getOutEdges() {
    return Collections.unmodifiableList(out);
  }

  public List<CLGEdge> getInEdges() {
    return Collections.unmodifiableList(in);
  }

  /*
   * ------------------------------------------------------------------ 5. Graph-building helpers
   * (package-private) ------------------------------------------------------------------
   */
  void addOutEdge(CLGEdge e) {
    out.add(e);
  }

  void addInEdge(CLGEdge e) {
    in.add(e);
  }

  /* Accessible only within the clg package */
  void clearOutEdges() {
    out.clear();
  }

  void clearInEdges() {
    in.clear();
  }

  void removeOutEdge(CLGEdge e) {
    out.remove(e);
  }

  void removeInEdge(CLGEdge e) {
    in.remove(e);
  }

  /**
   * Convenience factory: create an edge from <code>this</code> to <code>target</code>, register it
   * on both nodes, and return it.
   */
  public CLGEdge connectTo(CLGNode target, CLGEdgeType edgeType, String label, int iterationIdx) {
    CLGEdge edge = new CLGEdge.Builder(this, target).type(edgeType).label(label)
        .iterationIndex(iterationIdx).build();
    this.out.add(edge);
    target.in.add(edge);
    return edge;
  }

  /*
   * ------------------------------------------------------------------ 6. Equality / hashing (id is
   * unique and sufficient) ------------------------------------------------------------------
   */
  @Override
  public int hashCode() {
    return Integer.hashCode(id);
  }

  @Override
  public boolean equals(Object obj) {
    return (this == obj) || (obj instanceof CLGNode other && this.id == other.id);
  }

  /*
   * ------------------------------------------------------------------ 7. Deep clone (edges are NOT
   * copied) ------------------------------------------------------------------
   */
  @Override
  public CLGNode clone() {
    CLGNode copy = null;
    if (expr != null)
      copy = new CLGNode(type, expr.clone());
    else
      copy = new CLGNode(type);
    copy.in.clear();
    copy.out.clear();
    return copy;
  }

  /*
   * ------------------------------------------------------------------ 8. Debug helper
   * ------------------------------------------------------------------
   */
  @Override
  public String toString() {
    if (this.type.equals(CLGNodeType.DISJUNCTION)) {
      return "<" + id + ">";
    } else if (this.type.equals(CLGNodeType.ITERATE)) {
      return "<" + id + ">*\n";
    } else if (this.type.equals(CLGNodeType.START)) {
      return "StartNode";
    } else if (this.type.equals(CLGNodeType.END)) {
      return "EndNode";
    } else
      return "[" + id + "] ";
    // return "CLGNode#" + id + "(" + type +
    // (expr != null ? ", expr=" + expr.toString() : "") + ")";
  }
}
