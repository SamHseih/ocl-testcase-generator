package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdgeType;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNodeType;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.visualization.ClgVisualization;

/** Quick demo: build a tiny CLG, validate, enumerate paths, print DOT. */
public class DemoCLGgraph {

    public static void main(String[] args) {
    	FileLoader Loader = new FileLoader(args);
		if(args.length>1 && args.length<3) {
			System.out.println("Enter DC/DCC/MCC");
			System.exit(1);
		}
		 ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
		 astbuilder.build();
		 ASTree ast = astbuilder.getAST();

		
		 
        /* --------------------------------------------
         * 1. Create basic nodes 
         * -------------------------------------------- */
        CLGNode s      = new CLGNode(CLGNodeType.START);
        CLGNode cond   = new CLGNode(CLGNodeType.CONSTRAINT,ast);
        CLGNode split  = new CLGNode(CLGNodeType.DISJUNCTION);
        CLGNode thenCt = new CLGNode(CLGNodeType.CONSTRAINT);
        CLGNode elseCt = new CLGNode(CLGNodeType.CONSTRAINT);
        CLGNode e      = new CLGNode(CLGNodeType.END);

        /* --------------------------------------------
         * 2. Build graph container & register nodes
         * -------------------------------------------- */
        CLGGraph g = new CLGGraph();
        g.addNode(s); 
        g.addNode(cond); 
        g.addNode(split);
        g.addNode(thenCt); 
        g.addNode(elseCt); 
        g.addNode(e);

        /* --------------------------------------------
         * 3. Wire edges (and register to graph)
         * -------------------------------------------- */
        CLGEdge e1 = s     .connectTo(cond  , CLGEdgeType.SEQUENTIAL, "",     -1);
        CLGEdge e2 = cond  .connectTo(split , CLGEdgeType.SEQUENTIAL, "",     -1);
        CLGEdge e3 = split .connectTo(thenCt, CLGEdgeType.BRANCH   , "then" , -1);
        CLGEdge e4 = split .connectTo(elseCt, CLGEdgeType.BRANCH   , "else" , -1);
        CLGEdge e5 = thenCt.connectTo(e     , CLGEdgeType.SEQUENTIAL, ""    , -1);
        CLGEdge e6 = elseCt.connectTo(e     , CLGEdgeType.SEQUENTIAL, ""    , -1);
        g.addEdge(e1); 
        g.addEdge(e2); 
        g.addEdge(e3);
        g.addEdge(e4); 
        g.addEdge(e5); 
        g.addEdge(e6);

        /* --------------------------------------------
         * 4. Sanity-check graph
         * -------------------------------------------- */
        g.validate();   // throws if start/end 重複或有孤立節點:contentReference[oaicite:1]{index=1}

        /* --------------------------------------------
         * 5. Enumerate all complete paths
         *    (max 10 paths, iterate unroll ≤ 2)
         * -------------------------------------------- */
        List<List<CLGEdge>> paths = g.enumeratePaths(10, 2);  // :contentReference[oaicite:2]{index=2}
        System.out.println("Found " + paths.size() + " path(s):");
        for (List<CLGEdge> p : paths) {
            System.out.println("  " + p);
        }

        /* --------------------------------------------
         * 6. Export to GraphViz DOT for quick visual check
         * -------------------------------------------- */
        System.out.println("\n--- DOT ---");
        System.out.println(split.getOutEdges().size());
        System.out.println(ClgVisualization.toGraphvizDot(g));   // :contentReference[oaicite:3]{index=3}
    }
}
