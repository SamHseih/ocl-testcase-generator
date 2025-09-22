package ccu.pllab.tcgen3.util;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;

@FunctionalInterface
public interface TraversalStrategy {
	/** 
     * @param root   AST �ڸ`�I
     * @param action �C���X��@�Ӹ`�I�N�I�s�@��
     */
    void traverse(ASTree root, java.util.function.Consumer<ASTree> action);
}
