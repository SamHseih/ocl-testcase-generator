package ccu.pllab.tcgen3.core.testmodelbuilder.clg;

public enum CLGEdgeType {
  /** �@�붶���� (AND) */
  SEQUENTIAL,
  /** �Ӧ� JUNCTION ������ (OR)�F�i�� label ���� then/else�K */
  BRANCH,
  /** Iterate �i�}�L�{���� k��k+1 �������j�� */
  ITERATION,
  /** ���N������ (k=N �� result) */
  ITERATION_MERGE
}
