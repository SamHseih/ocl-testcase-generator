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
	 * 走訪 OCL 抽象語法樹（AST）並逐步建構
	 * {@link ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph CLG} 的訪客介面。<br>
	 * <p>
	 * 型別參數 {@code <R>} 為各 {@code visit*Context} 方法的回傳型別。<br>
	 * 常見做法是回傳整張 {@code CLGGraph}，亦可依需求改成
	 * {@code Boolean}、{@code Optional<CLGGraph>}、{@code Void} … 等。
	 * </p>
	 *
	 * <p><strong>實作要點：</strong><br>
	 * - 為「需要特別處理」的每一種 AST 節點撰寫對應的
	 *   {@code visitXxxContext} 方法。<br>
	 * - 不需處理的型別可落回 {@link #visitDefault(ASTree)}。<br>
	 * - 若在走訪途中偵測到語意錯誤，請透過 {@link #getErrorMesg()} 收集，
	 *   方便呼叫端一次檢視所有問題。
	 * </p>
	 *
	 * <h2>使用範例</h2>
	 * <pre>{@code
	 * // 1. 建立具體訪客
	 * CLGAstVisitor<CLGGraph> builder = new DcCLGBuilderVisitor();
	 *
	 * // 2. 交由根節點觸發走訪（雙重分派）
	 * CLGGraph graph = rootAstNode.accept(builder);
	 *
	 * // 3. 檢查診斷訊息
	 * builder.getErrorMesg().forEach(System.err::println);
	 * }</pre>
	 *
	 * @param <R> 各 {@code visit*Context} 方法的回傳型別
	 */
	public abstract <R> R accept(AstVisitor<R> visitor);
	//R 是回傳型別（我們要的是 CLGGraph）。 
	/** deep clone the ASTree */
	public abstract ASTree clone();
}
	