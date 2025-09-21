package ccu.pllab.tcgen3.core.testmodelbuilder.test;

import java.util.ArrayList;
import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableDeclExp;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.util.AstUtil;
import ccu.pllab.tcgen3.visualization.ClgVisualization;

public class DemoDCCGraphOps {

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

    List<ASTree> ralations = new ArrayList<>();
    AstUtil.dfsPre(ast, n -> {
      if (n instanceof BinaryExp b) {
        if (b.getGroup().equals(BinaryExp.OpGroup.RELATIONAL)) {
          ralations.add(n);
        }
      }
    });

    // DCC AST
    ASTree ast1 = ralations.get(0);
    ASTree ast2 = ralations.get(1);
    ASTree ast3 = ralations.get(2);
    ASTree ast4 = ralations.get(3);
    ASTree ast5 = ralations.get(4);
    ASTree ast6 = ralations.get(5);


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

    CLGGraph gC = new CLGGraph(ast3);
    // System.out.println(ClgVisualization.toGraphvizDot(gC));
    CLGGraph gD = new CLGGraph(ast4);
    // System.out.println(ClgVisualization.toGraphvizDot(gD));
    CLGGraph gE = new CLGGraph(ast5);
    // System.out.println(ClgVisualization.toGraphvizDot(gE));
    CLGGraph gF = new CLGGraph(ast6);
    // System.out.println(ClgVisualization.toGraphvizDot(gF));
    gA.graphAnd(gC);
    gA.graphAnd(gD);
    gA.graphAnd(gE);
    gA.graphAnd(gF);
    System.out.println(
        "================================================================gA AND ....  ================================================================");
    System.out.println(ClgVisualization.toGraphvizDot(gA));

    /*
     * ================================================================ 2. Build two tiny graphs (C
     * , D) and OR them ================================================================
     */
    CLGGraph gH = new CLGGraph(ast1);
    CLGGraph gI = new CLGGraph(ast2);
    CLGGraph gJ = new CLGGraph(ast1);
    CLGGraph gK = new CLGGraph(ast2);
    gH.graphAnd(gJ);
    gI.graphAnd(gK);
    // System.out.println("================================================================ gE
    // result ================================================================");
    // System.out.println(ClgVisualization.toGraphvizDot(gH));
    // System.out.println("================================================================ gH
    // result ================================================================");
    // System.out.println(ClgVisualization.toGraphvizDot(gI));
    // H ⋁ I
    gH.graphOr(gI);
    System.out.println(
        "================================================================gE OR gH result ================================================================");
    System.out.println(ClgVisualization.toGraphvizDot(gH));

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
    gA.graphOr(gH);
    System.out.println(ClgVisualization.toGraphvizDot(gA));

    // (ABC -> Closure ⋁ E ⋁ H ) -> Closure
    System.out.println(
        "================================================================ MiX result 2 ================================================================");
    gA.graphClosure();
    System.out.println(ClgVisualization.toGraphvizDot(gA));

    /*
     * ================================================================ 5. Clone
     * ================================================================
     */
    CLGGraph gAClone = gA.clone();
    CLGGraph gX = new CLGGraph(ast1);
    CLGGraph gXClone = gX.clone();
    System.out.println(
        "================================================================ Simple graph Clone  ================================================================");
    System.out.println(ClgVisualization.toGraphvizDot(gXClone));
    System.out.println(
        "================================================================ final graph Clone  ================================================================");
    System.out.println(ClgVisualization.toGraphvizDot(gAClone));
  }
}
