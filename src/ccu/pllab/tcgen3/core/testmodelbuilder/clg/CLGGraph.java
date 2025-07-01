package ccu.pllab.tcgen3.core.testmodelbuilder.clg;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.visualization.ClgVisualization;

/**
 * Core container for a Constraint Logic Graph (CLG).
 * <p>
 * Responsibilities:
 * <ul>
 *     <li>Maintain a global index of nodes and edges.</li>
 *     <li>Provide utility builders for adding nodes/edges while keeping in/out lists in sync.</li>
 *     <li>Offer common algorithms such as validation, path enumeration and DOT export.</li>
 * </ul>
 * <p>
 * Thread‑safe for read‑heavy workloads: structural mutations guarded by "synchronized"; look‑ups rely on
 * concurrent collections.
 */
public final class CLGGraph {

    /* =====================================================
     *  F I E L D S
     * ===================================================== */
	private String clgfilename; //packagename_filename_criterion.clg
	private String classname;
	private String methodname;
    private final Map<Integer, CLGNode> nodes = new ConcurrentHashMap<>();//<id,node>
    private final Set<CLGEdge> edges = Collections.newSetFromMap(new ConcurrentHashMap<>());

    private CLGNode start;   // unique start node
    private CLGNode end;     // unique end node

	/* =====================================================
	 *  C O N S T R U C T O R
	 * ===================================================== */
    public CLGGraph() {}
    
    // Simple Constraint Logic Graph (CLG) with a single constraint node.
	public CLGGraph(ASTree ast) {
		start = new CLGNode(CLGNodeType.START);
        CLGNode c = new CLGNode(CLGNodeType.CONSTRAINT,ast ); 
        end = new CLGNode(CLGNodeType.END);
        
        addNode(start); 
        addNode(c); 
        addNode(end);
        addEdge(start.connectTo(c, CLGEdgeType.SEQUENTIAL,"", -1));
        addEdge(c.connectTo(end, CLGEdgeType.SEQUENTIAL,"", -1));
        validate();
	}
	
    /* =====================================================
     *  P U B L I C   A P I
     * ===================================================== */
    /** Adds a node to the graph; automatically sets start/end if applicable. */
    public synchronized void addNode(CLGNode n) {
        Objects.requireNonNull(n, "node must not be null");
        nodes.putIfAbsent(n.id(), n);
        if (n.getType() == CLGNodeType.START) {
            if (start != null && start != n) {
                throw new IllegalStateException("Graph already has a start node: " + start.id());
            }
            start = n;
        } else if (n.getType() == CLGNodeType.END) {
            if (end != null && end != n) {
                throw new IllegalStateException("Graph already has an end node: " + end.id());
            }
            end = n;
        }
    }

    /**
     * Adds an edge and synchronises the in/out collections of the connected nodes.
     */
    public synchronized void addEdge(CLGEdge e) {
        Objects.requireNonNull(e, "edge must not be null");
        if (!nodes.containsKey(e.getFrom().id()) || !nodes.containsKey(e.getTo().id())) {
            throw new IllegalArgumentException("Both endpoint nodes must be present in graph before adding edge");
        }
        edges.add(e); // add to global edge set
        // use Set semantics to avoid duplicates
        /*if (edges.add(e)) {
            e.getFrom().addOutEdge(e);
            e.getTo().addInEdge(e);
        }*/
    }

    public CLGNode getStart() {
        return start;
    }

    public CLGNode getEnd() {
        return end;
    }

    public Collection<CLGNode> getNodes() {
        return Collections.unmodifiableCollection(nodes.values());
    }

    public Collection<CLGEdge> getEdges() {
        return Collections.unmodifiableCollection(edges);
    }
    
    public void setClassname(String classname) {this.classname = classname;  }
    public void setMethodname(String methodname) { this.methodname = methodname; }  
    public void setFilename(String filename) {this.clgfilename = filename;}
    public String getFilename() {return clgfilename;}
    public String getClassname() {return classname;}
    public String getMethodname() {return methodname;}

    /* =====================================================
     *  V A L I D A T I O N
     * ===================================================== */

    /**
     * Basic sanity checks: single start/end, connectivity from start to every node, no dangling edges.
     */
    public void validate() {
        if (start == null || end == null) {
            throw new IllegalStateException("Graph must contain exactly one START and one END node");
        }
        // reachability check via DFS
        Set<CLGNode> reachable = new HashSet<>();
        dfs(start, reachable);//return start to reachable node
        if (reachable.size() != nodes.size()) {
            throw new IllegalStateException("Graph contains unreachable nodes. Reachable=" + reachable.size()
                    + ", total=" + nodes.size());
        }
    }

    private void dfs(CLGNode n, Set<CLGNode> vis) {
        if (!vis.add(n)) return;//Set not allow duplicate
        for (CLGEdge e : n.getOutEdges()) {
            dfs(e.getTo(), vis);
        }
    }

    /* =====================================================
     *  P A T H   E N U M E R A T I O N
     * ===================================================== */

    /**
     * Enumerates complete paths (Start→End) in breadth‑first order.
     * @param maxPaths   stop after collecting this many paths (use Integer.MAX_VALUE for all)
     * @param maxUnroll  maximum times to unfold an ITERATE edge; safeguards against infinite paths
     */
    public List<List<CLGEdge>> enumeratePaths(int maxPaths, int maxUnroll) {
        List<List<CLGEdge>> paths = new ArrayList<>();
        if (start == null || end == null) return paths;

        record Frame(CLGNode node, List<CLGEdge> path, int iterateDepth) {}
        Deque<Frame> queue = new ArrayDeque<>();
        queue.add(new Frame(start, new ArrayList<>(), 0));

        while (!queue.isEmpty() && paths.size() < maxPaths) {
            Frame f = queue.poll();
            if (f.node == end) {
                paths.add(f.path);
                continue;
            }
            for (CLGEdge e : f.node.getOutEdges()) {
                int depth = f.iterateDepth;
                // control iterate unrolling
                if (e.getType() == CLGEdgeType.ITERATION) {
                    depth += 1;
                    if (depth > maxUnroll) continue; // skip over‑unrolling
                }
                List<CLGEdge> nextPath = new ArrayList<>(f.path);
                nextPath.add(e);
                queue.add(new Frame(e.getTo(), nextPath, depth));
            }
        }
        return paths;
    }
	/* =====================================================
	 *  G R A P H   O P E R A T I O N S   I M P L E M E N T A T I O N
	 * ===================================================== */  
    public void graphAnd (CLGGraph rhs) {
    	validate();                  // optional – ensure both graphs sane
    	rhs.validate();
    	
        CLGNode thisLast   = this.getEnd();  // last real node
        CLGNode rhsFirst   = rhs.getStart();
        CLGNode thisLastConstraint = thisLast.getInEdges().getFirst().getFrom();
        CLGNode rhsfirstConstraint = rhsFirst.getOutEdges().getFirst().getTo();
        
        // 2. detach Node and Edge
        removeEdgefromGraph(thisLastConstraint,thisLast,this);
        removeEdgefromGraph(rhsFirst,rhsfirstConstraint,rhs);

        removeNodefromGraph(thisLast,this);
        this.end = rhs.end;
        
        // 3. bring nodes & edges of rhs into current graph
        rhs.getNodes().forEach(n -> {
            if (n.getType() != CLGNodeType.START) {
                this.addNode(n);
            }
        });
        
        // 4. link and Merge new Edge
        //CLGEdge graphand = thisConeected.connectTo(rhsConnected, CLGEdgeType.SEQUENTIAL, "graphAnd", -1);
        this.addEdge(thisLastConstraint.connectTo(rhsfirstConstraint, CLGEdgeType.SEQUENTIAL, "graphAnd", -1)); 
        for(CLGEdge e : rhs.getEdges()) {
        	if (e.getFrom().getType() != CLGNodeType.START ) {
                this.addEdge(e);
            }
        }
        // 5. Final Check
        validate();  
    }

	public void graphOr(CLGGraph rhs) {
        validate(); 
        rhs.validate();

        CLGNode thisLast   = this.getEnd();
        CLGNode thisFirst = this.getStart();
        CLGNode rhsFirst   = rhs.getStart();
        CLGNode rhsLast   = rhs.getEnd();
        
        CLGNode thisfirstConstraint = thisFirst.getOutEdges().getFirst().getTo();
        CLGNode thislastConstraint = thisLast.getInEdges().getFirst().getFrom();
     
        CLGNode rhsfirstConstraint = rhsFirst.getOutEdges().getFirst().getTo();
        CLGNode rhslastConstraint = rhsLast.getInEdges().getFirst().getFrom();

     // 2. detach Node and Edge
        removeEdgefromGraph(thisFirst,thisfirstConstraint,this);
        removeEdgefromGraph(thislastConstraint,thisLast,this);
        removeEdgefromGraph(rhsFirst,rhsfirstConstraint,rhs);
        //rhsMergenode.clearOutEdges();
        removeEdgefromGraph(rhslastConstraint,rhsLast,rhs);
        //remove thisLast node
        removeNodefromGraph(thisLast,this);
        this.end = rhs.end;
        
     // 3. bring nodes & edges of rhs into current graph
        rhs.getNodes().forEach(n -> {
            if (n.getType() != CLGNodeType.START) {
                this.addNode(n);
            }
        });
     // 4. New DISJUNCTION node  
        CLGNode split  = new CLGNode(CLGNodeType.DISJUNCTION); 
        CLGNode merge  = new CLGNode(CLGNodeType.DISJUNCTION);
        this.addNode(split);
        this.addNode(merge);
        
     // 5. link and Merge new Edge 
        CLGEdge graphslpit = thisFirst.connectTo(split, CLGEdgeType.BRANCH, "graphOr_start", -1);
        CLGEdge slpit1 = split.connectTo(thisfirstConstraint, CLGEdgeType.BRANCH, "split1", -1);
        CLGEdge slpit2 = split.connectTo(rhsfirstConstraint, CLGEdgeType.BRANCH, "split2", -1);
        
        CLGEdge merge1 = thislastConstraint.connectTo(merge, CLGEdgeType.BRANCH, "merge1", -1);
        CLGEdge merge2 = rhslastConstraint.connectTo(merge, CLGEdgeType.BRANCH, "merge2", -1);
        CLGEdge graphsmerge = merge.connectTo(rhsLast, CLGEdgeType.BRANCH, "graphOr_end", -1);
        this.addEdge(graphslpit); 
        this.addEdge(slpit1);
        this.addEdge(slpit2);
        this.addEdge(merge1);
        this.addEdge(merge2);
        this.addEdge(graphsmerge);
        
        rhs.getEdges().forEach(e -> {
            if (e.getFrom().getType() != CLGNodeType.START) {
                this.addEdge(e);
            }
        });
        // 5. Final Check
        validate();  
    }
    
    /** Create a self-loop between last and first constraint → (A)+ 形式 */
    public void graphClosure() {
        validate(); 
        //System.out.println("graphClosure Before: \n"+ClgVisualization.toGraphvizDot(this));
        CLGNode thisLast   = this.getEnd();
        CLGNode thisFirst = this.getStart();
        CLGNode thisFirstConstraint = thisFirst.getOutEdges().getFirst().getTo();
        CLGNode thisLastConstraint = thisLast.getInEdges().getFirst().getFrom();
        removeEdgefromGraph(thisFirst,thisFirstConstraint,this);
        removeEdgefromGraph(thisLastConstraint,thisLast,this);
        CLGNode branchnode = new CLGNode(CLGNodeType.ITERATE);        
        this.addNode(branchnode);
         
        CLGEdge ITERATION_START = thisFirst.connectTo(branchnode, CLGEdgeType.SEQUENTIAL, "", -1);
        CLGEdge ITERATION = branchnode.connectTo(thisFirstConstraint, CLGEdgeType.ITERATION, "iterate", -1);
        CLGEdge ITERATION_MERGE = thisLastConstraint.connectTo(branchnode, CLGEdgeType.ITERATION_MERGE, "iterate", -1);
        CLGEdge ITERATION_END = branchnode.connectTo(thisLast, CLGEdgeType.SEQUENTIAL, "", -1);
        this.addEdge(ITERATION_START); 
        this.addEdge(ITERATION);
        this.addEdge(ITERATION_MERGE);
        this.addEdge(ITERATION_END);
        //System.out.println("graphClosure After: \n"+ClgVisualization.toGraphvizDot(this));

        validate(); 
    }
    /* =====================================================
     *  H E L P E R – removeEdge / removeNode 
     * ===================================================== */
    private void removeEdgefromGraph(CLGNode from,CLGNode to, CLGGraph g) {
    	//remove fromNode to edge 
    	if(g.getNodes().contains(from) && g.getNodes().contains(from)) {
    		// 1. 先收集
    	    List<CLGEdge> toRemove = new ArrayList<>();
    	    for (CLGEdge e : from.getOutEdges()) {
    	        if (e.getTo() == to) {
    	            toRemove.add(e);
    	        }
    	    }

    	    // 2. 一次實際刪除
    	    for (CLGEdge e : toRemove) {
    	        from.removeOutEdge(e);
    	        to.removeInEdge(e);
    	        g.edges.remove(e);   // 全域集合
    	    }
       } else 
    	   System.out.print("There has no node in graph "+g.toString()); 
    }
    
    private void removeNodefromGraph(CLGNode thisLast, CLGGraph clgGraph) {
    	clgGraph.nodes.remove(thisLast.id());
	}


}

