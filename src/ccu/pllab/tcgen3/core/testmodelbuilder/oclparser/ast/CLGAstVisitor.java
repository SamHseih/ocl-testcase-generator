package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.List;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.ArrayRefExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BooleanLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionItem;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.CollectionRange;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IntegerLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.LetExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.OperationCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.PropertyCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.StringLiteralExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.UnaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableDeclExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableExp;

public interface CLGAstVisitor<R> {
	/* ======== ���� Context ======== */
	R visitPackageDeclASTContext(PackageDeclAST node);
	R visitContextDeclAST(ContextDeclAST node);
	R visitClassifierContext(ClassifierContextDeclAST node);
	R visitOperationContext(OperationContextDeclAST node);
    R visitContextExp(ContextExpAST node);
    R visitInvalidASTContext(InvalidAST node);
    
    /* ======== ��L OCL Expression �`�I ... ======== */
    // �Ҧp  IfExpAST / IterateExpAST / LetExpAST / LiteralExpAST ...
    // �i���u��A�u���Ψ쪺�����C
    R visitBinaryExpContext(BinaryExp node);
    R visitIfExpContext(IfExp node);
    R visitVariableExpContext(VariableExp node);
    R visitPropertyCallExpContext(PropertyCallExp node);
    R visitOperationCallExpContext(OperationCallExp node);
    R visitIntegerLiteralExpContext(IntegerLiteralExp node);
    R visitStringLiteralExpContext(StringLiteralExp node);
    R visitArrayRefExpContext(ArrayRefExp node);
    R visitBooleanLiteralExpContext(BooleanLiteralExp node);
    R visitCollectionItemContext(CollectionItem node);
    R visitCollectionLiteralExpContext(CollectionLiteralExp node);
    R visitCollectionRangeContext(CollectionRange node);
    R visitIterateExpContext(IterateExp node);
    R visitLetExpContext(LetExp node);
    R visitUnaryExpContext(UnaryExp node);
    R visitVariableDeclExpContext(VariableDeclExp node);

    
    /* ======== Fallback�]�i��^ ======== */
    default R visitDefault(ASTree node) {
        throw new UnsupportedOperationException(
            "Visitor ����@�`�I " + node.getClass().getSimpleName());
    }
    
    public abstract List<String> getErrorMesg();
    
}
