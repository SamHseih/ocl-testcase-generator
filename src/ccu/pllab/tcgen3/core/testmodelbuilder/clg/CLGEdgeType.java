package ccu.pllab.tcgen3.core.testmodelbuilder.clg;

public enum CLGEdgeType {
  /** 一般順序邊 (AND) */
  SEQUENTIAL,
  /** 來自 JUNCTION 的分支 (OR)；可用 label 辨識 then/else… */
  BRANCH,
  /** Iterate 展開過程中第 k→k+1 次的遞迴邊 */
  ITERATION,
  /** 迭代收斂邊 (k=N → result) */
  ITERATION_MERGE
}
