package ccu.pllab.tcgen3.visualization;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;

public class ClgVisualization {
	private ClgVisualization() {
	}

    /** Escape for DOT */
    private static String esc(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static Map<CLGNode, Integer> buildDisplayId(CLGGraph g) {
        Map<CLGNode, Integer> map = new LinkedHashMap<>();
        int counter = 0;
        for (CLGNode n : g.getNodes()) {          // 迭代順序可自訂：插入順序 / BFS / 拓樸…
            map.put(n, counter++);
        }
        return map;
    }
     
    /** 產生 GraphViz DOT 字串 */
    public static String toGraphvizDot(CLGGraph g) {
    	Map<CLGNode,Integer> disp = buildDisplayId(g);             
        StringBuilder sb = new StringBuilder()
   
                .append("digraph CLG {\n");
        /* ---------- Nodes ---------- */
        for (CLGNode n : g.getNodes()) { 
        	int dId = disp.get(n);//再看看要不要用
            sb.append("  ").append(n.id()).append(" ");        // dot-id
            switch (n.getType()) {
                case DISJUNCTION:   // ＝你的 DISJUNCTION
                    sb.append("[shape=\"diamond\", label=\"\", ")
                      .append("xlabel=\"<").append(n.id()).append(">\", ")
                      .append("style=filled, fillcolor=aquamarine, ")
                      .append("fixedsize=true, width=.2, height=.2];\n");
                    break;

                case START:
                    sb.append("[style=filled, fillcolor=black, ")
                      .append("shape=\"circle\", label=\"\", ")
                      .append("fixedsize=true, width=.2, height=.2, ")
                      .append("xlabel=\"[").append(0).append("]\"];\n");
                    break;

                case END:
                    sb.append("[style=filled, fillcolor=black, ")
                      .append("shape=\"doublecircle\", label=\"\", ")
                      .append("fixedsize=true, width=.2, height=.2, ")
                      .append("xlabel=\"[").append(-1).append("]\"];\n");
                    break;

                case CONSTRAINT:
                    String txt = n.getExpr() != null ? esc(n.getExpr().toClgString()) : "";
                    
                    sb.append("[shape=\"box\", label=\"").append(txt).append("\", ")
                      .append("style=filled, fillcolor=yellow, ")
                      .append("xlabel=\"[").append(n.id()).append("]\"];\n");
                    break;

                case ITERATE:    // 自訂一個預設
                	String txt2 ="";
                	if(n.getExpr() instanceof IterateExp i)txt2 = i.toClgString();
                    sb.append("[shape=\"hexagon\", label=\"").append(txt2).append("\", ")
                      .append("style=filled, fillcolor=coral1, ")
                      .append("fixedsize=true, width=2.9, height=1, ")
                      .append("xlabel=\"[").append(n.id()).append("]\"];\n");
                    break;
            }
        }

        /* ---------- Edges ---------- */
        for (CLGEdge e : g.getEdges()) {
            sb.append("  ")
              .append(e.getFrom().id())
              .append(" -> ")
              .append(e.getTo().id());
           
            /*sb.append("[xlabel=").append("\"{").append(e.getId()).append("}\" ");
            if (!e.getLabel().isEmpty()) {
                sb.append(",label=\"").append(esc(e.getLabel())).append("\"]");
            } else sb.append("]");*/
            

            if (!e.getLabel().isEmpty()) {
                sb.append("[label=\"").append(esc(e.getLabel())).append("_")
                .append(e.getId()).append("\"]");
            } 
            sb.append(";\n");
            
        }
        
        return sb.append("}\n").toString();
    }
    
    public static void printGraphvizSvg(Path dotpath, Path svgpath, CLGGraph clg) {
    	try {
		 	String astcontent = toGraphvizDot(clg);
            Files.createDirectories(dotpath.getParent());
            Files.writeString(dotpath, astcontent, StandardCharsets.UTF_8);
            System.out.println("CLG DOT file output successfully：" + dotpath);
            DotFileConverter.convertDotToImage(dotpath, svgpath);
            System.out.println("CLG SVG file output successfully：" + svgpath);
        } catch (Exception e) {
            System.err.println("CLG Write file fail：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
