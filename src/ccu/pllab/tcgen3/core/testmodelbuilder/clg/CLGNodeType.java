package ccu.pllab.tcgen3.core.testmodelbuilder.clg;

public enum CLGNodeType {
	START,          // 起始節點 
	END,            // 終止節點 ◎
    CONSTRAINT,       // 限制式節點 ▭
    DISJUNCTION, 	  // 或分支起點 ◇
    ITERATE 		  // iterate 節點 ⬢
}
