package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdgeType;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNodeType;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableDeclExp;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.util.AstUtil;
import ccu.pllab.tcgen3.visualization.ClgVisualization;

/**
 * Demo – exercise new graph operations (AND / OR / Closure / Insert). Run Configuration >
 * Arguments<br>
 * arg1: &lt; Papyrus WorkSpace dir &gt;<br>
 * arg2: &lt; projectname &gt;<br>
 * arg3: &lt; "DC"/"DCC"/"MCC" &gt;<br>
 */
public class DemoDCGraphOps {

  public static void main(String[] args) {
    FileLoader Loader = new FileLoader(args);
    if (args.length > 1 && args.length < 3) {
      System.out.println("Enter DC/DCC/MCC");
      System.exit(1);
    }
    ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
    astbuilder.build();
    ASTree ast = astbuilder.getAST();

    List<ASTree> iterates = new ArrayList<>();
    AstUtil.dfsPre(ast, n -> {
      if (n instanceof IterateExp)
        iterates.add(n);
    });
    List<ASTree> iterate_variabledecl = new ArrayList<>();
    AstUtil.dfsPre(iterates.get(0), n -> {
      if (n instanceof VariableDeclExp v) {
        if (v.numChildren() == 0)
          iterate_variabledecl.add(v);
      }
    });

    List<ASTree> logics = new ArrayList<>();
    AstUtil.dfsPre(ast, n -> {
      if (n instanceof BinaryExp b) {
        if (b.getGroup().equals(BinaryExp.OpGroup.LOGICAL)) {
          logics.add(n);
        }
      }
    });

    // DC AST
    ASTree ast1 = logics.get(0);
    ASTree ast2 = logics.get(1);
    ASTree ast3 = logics.get(2);


    /*
     * ================================================================ 1. Build two tiny graphs (A
     * , B) A : START → C1 → END B : START → C2 → END
     * ================================================================
     */
    // A ⋀ B
    CLGGraph gA = new CLGGraph(ast1);
    System.out.println(ClgVisualization.toGraphvizDot(gA));
    CLGGraph gB = new CLGGraph(ast2);
    System.out.println(ClgVisualization.toGraphvizDot(gB));
    gA.graphAnd(gB);
    System.out.println(
        "================================================================ gA AND gB result1 ================================================================");
    System.out.println(ClgVisualization.toGraphvizDot(gA));
    // // AB ⋀ C
    // CLGGraph gC = new CLGGraph(ast3);
    // System.out.println(ClgVisualization.toGraphvizDot(gC));
    // gA.graphAnd(gC);
    // System.out.println("================================================================gA AND gB
    // AND gC ================================================================");
    // System.out.println(ClgVisualization.toGraphvizDot(gA));

    /*
     * ================================================================ 2. Build two tiny graphs (C
     * , D) and OR them ================================================================
     */
    CLGGraph gE = new CLGGraph(ast1);
    CLGGraph gH = new CLGGraph(ast2);
    System.out.println(
        "================================================================ gE result ================================================================");
    System.out.println(ClgVisualization.toGraphvizDot(gE));
    System.out.println(
        "================================================================ gH result ================================================================");
    System.out.println(ClgVisualization.toGraphvizDot(gH));
    gE.graphOr(gH); // E ⋁ H
    System.out.println(
        "================================================================gE OR gH result ================================================================");
    System.out.println(ClgVisualization.toGraphvizDot(gE));

    /*
     * ================================================================ 3. Closure on a single-path
     * graph ================================================================ OCLExample:
     * Sequence{0..dim1}->iterate(it:int; acc:Boolean = true | acc and
     * Sequence{0..dim2}->iterate(it2:int; acc2:Boolean = true| acc2 and
     * Sequence{0..dim3}->iterate(it3:int; acc3:Boolean = true| acc3 and result.datas[it][it2][it3]
     * = self.datas[it][it2][it3] + arg.datas[it][it2][it3] ) ) )
     */
    // ABC -> Closure
    gA.graphClosure();
    System.out.println(
        "================================================================ Closure result ================================================================");
    System.out.println(ClgVisualization.toGraphvizDot(gA));



    /*
     * ================================================================ 4. Mix
     * ================================================================
     */
    // ABC -> Closure ⋁ E ⋁ H
    System.out.println(
        "================================================================ MiX result ================================================================");
    gA.graphOr(gE);
    System.out.println(ClgVisualization.toGraphvizDot(gA));

    // (ABC -> Closure ⋁ E ⋁ H ) -> Closure
    System.out.println(
        "================================================================ MiX result 2 ================================================================");
    gA.graphClosure();
    System.out.println(ClgVisualization.toGraphvizDot(gA));
  }

}
