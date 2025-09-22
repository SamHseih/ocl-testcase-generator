package ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.Expression;
import ccu.pllab.tcgen3.symboltable.type.Type;

public abstract class ASTree implements Iterable<ASTree>,Expression{
	
	/** The number of AST nodes. */ 
	private static final AtomicInteger COUNTER = new AtomicInteger(0);
	
	/** The id of the AST node. */
	private final int id = COUNTER.getAndIncrement();
	
	
	public final int id() { return id; }
	
	/** @return returns the i-th ASTnode.*/
	public abstract ASTree child(int i);
	
	/** @return returns the number of children (or 0 if none).*/
	public abstract int numChildren();
	
	/** @return returns a iterator for traversal childnodes*/
	public abstract Iterator<ASTree> children();
	
	/** @return returns a string that represents the position of an abstract
	 *  syntax tree (AST) node within the program. */
	public abstract String location();
	
	/** @return returns a iterator for traversal childnodes*/
	public Iterator<ASTree> iterator() {
		return children();
		}
	
	/** for {@link AstVisualization} Visualize*/
	public abstract String toAstString();
	
	/** for {@link ClgVisualization} Visualize*/
	public abstract String toClgString();

	
	/**
	 * ���X OCL ��H�y�k��]AST�^�óv�B�غc
	 * {@link ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph CLG} ���X�Ȥ����C<br>
	 * <p>
	 * ���O�Ѽ� {@code <R>} ���U {@code visit*Context} ��k���^�ǫ��O�C<br>
	 * �`�����k�O�^�Ǿ�i {@code CLGGraph}�A��i�̻ݨD�令
	 * {@code Boolean}�B{@code Optional<CLGGraph>}�B{@code Void} �K ���C
	 * </p>
	 *
	 * <p><strong>��@�n�I�G</strong><br>
	 * - ���u�ݭn�S�O�B�z�v���C�@�� AST �`�I���g������
	 *   {@code visitXxxContext} ��k�C<br>
	 * - ���ݳB�z�����O�i���^ {@link #visitDefault(ASTree)}�C<br>
	 * - �Y�b���X�~��������y�N���~�A�гz�L {@link #getErrorMesg()} �����A
	 *   ��K�I�s�ݤ@���˵��Ҧ����D�C
	 * </p>
	 *
	 * <h2>�ϥνd��</h2>
	 * <pre>{@code
	 * // 1. �إߨ���X��
	 * CLGAstVisitor<CLGGraph> builder = new DcCLGBuilderVisitor();
	 *
	 * // 2. ��Ѯڸ`�IĲ�o���X�]���������^
	 * CLGGraph graph = rootAstNode.accept(builder);
	 *
	 * // 3. �ˬd�E�_�T��
	 * builder.getErrorMesg().forEach(System.err::println);
	 * }</pre>
	 *
	 * @param <R> �U {@code visit*Context} ��k���^�ǫ��O
	 */
	public abstract <R> R accept(AstVisitor<R> visitor);
	//R �O�^�ǫ��O�]�ڭ̭n���O CLGGraph�^�C 
	/** deep clone the ASTree */
	public abstract ASTree clone();
}
	