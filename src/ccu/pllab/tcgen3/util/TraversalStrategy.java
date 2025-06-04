package ccu.pllab.tcgen3.util;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;

@FunctionalInterface
public interface TraversalStrategy {
	/** 
     * @param root   AST 根節點
     * @param action 每拜訪到一個節點就呼叫一次
     */
    void traverse(ASTree root, java.util.function.Consumer<ASTree> action);
}
