package ccu.pllab.tcgen3.visualization;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;

public class AstVisualization {

  public static String toGraphvizDot(ASTree root) {
    StringBuilder sb = new StringBuilder();
    sb.append("digraph AST {\n");
    sb.append("  node [shape=box];\n");

    Set<ASTree> visited = new HashSet<>();
    Queue<ASTree> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      ASTree node = queue.poll();
      if (!visited.add(node))
        continue;

      String nodeId = getNodeId(node);
      String label = escape(node.toAstString());
      String type = node.getType().getTypeName();
      String xlabel = "(" + node.id() + ")" + type;


      sb.append("  ").append(nodeId).append(" [label=\"").append(label).append("\", ")
          .append("xlabel=\"").append(escape(xlabel)).append("\"];\n");

      for (ASTree child : node) {
        if (child != null) {
          String childId = getNodeId(child);
          sb.append("  ").append(nodeId).append(" -> ").append(childId).append(";\n");
          queue.add(child);
        }
      }
    }

    sb.append("}\n");
    return sb.toString();
  }

  private static String getNodeId(ASTree node) {
    return "n" + node.id();
  }

  private static String escape(String label) {
    return label.replace("\"", "\\\"");
  }

  public static void printGraphvizSvg(Path dotpath, Path svgpath, ASTree ast) {
    try {
      String astcontent = toGraphvizDot(ast);
      Files.createDirectories(dotpath.getParent());
      Files.writeString(dotpath, astcontent, StandardCharsets.UTF_8);
      System.out.println("AST DOT file output successfully¡G" + dotpath);
      DotFileConverter.convertDotToImage(dotpath, svgpath);
      System.out.println("AST SVG file output successfully¡G" + svgpath);
    } catch (Exception e) {
      System.err.println("CLG Write file fail¡G" + e.getMessage());
      System.err.println("dot dir¡G" + dotpath);
      System.err.println("svg dir¡G" + svgpath);
      System.err.println("Check GraphViz set  ?  https://graphviz.org/");
      e.printStackTrace();
    }
  }

}
