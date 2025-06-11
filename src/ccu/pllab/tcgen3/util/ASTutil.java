package ccu.pllab.tcgen3.util;

import java.lang.reflect.Constructor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;

import ccu.pllab.tcgen3.core.testmodelbuilder.ASTBuilder;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTList;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ASTree;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.ContextExpAST;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.BinaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.FeatureCallExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IfExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.IterateExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.LetExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.UnaryExp;
import ccu.pllab.tcgen3.core.testmodelbuilder.oclparser.ast.oclexpr.VariableExp;
import ccu.pllab.tcgen3.io.FileLoader;
import ccu.pllab.tcgen3.symboltable.Symbol;

public final  class AstUtil  {
	private AstUtil() {}          // 工具類別，禁止實例化

	/* ---------- 1. Pre-order DFS (root → left → right) ---------- */
	/**
	 * Performs a <em>pre-order</em> depth-first search (DFS) on the specified
	 * Abstract Syntax Tree (AST) node.  
	 * <p>
	 * In pre-order traversal the current node is visited <strong>before</strong>
	 * any of its children, producing a <i>root-first</i> visitation sequence.
	 * </p>
	 *
	 * @param node   the root of the subtree to traverse; if {@code null} the method
	 *               returns immediately
	 * @param action a callback invoked exactly once for every node that is visited
	 *               (never {@code null})
	 */
    public static void dfsPre(ASTree node, Consumer<ASTree> action) {
        if (node == null) return;
        action.accept(node);                    // 1. 先處理自己
        node.children().forEachRemaining(       // 2. 再遞迴處理子節點
            child -> dfsPre(child, action)
        );
    }

    /**
     * Performs a breadth-first search (BFS), also known as level-order traversal,
     * starting from the supplied AST root.  
     * <p>
     * Nodes are visited layer by layer, ensuring that all nodes at depth
     * {@code d} are processed before any node at depth {@code d + 1}.
     * </p>
     *
     * @param root   the root of the AST to traverse; if {@code null} the method
     *               returns immediately
     * @param action a callback invoked exactly once for every node that is dequeued
     *               during traversal (never {@code null})
     */
    public static void bfs(ASTree root, Consumer<ASTree> action) {
        if (root == null) return;
        Queue<ASTree> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ASTree node = queue.remove();
            action.accept(node);                // 1. 取出並處理
            node.children().forEachRemaining(   // 2. 將子節點排入佇列
                queue::add
            );
        }
    }
    
    /* ---------- 3. Post-order DFS (left → right → root) ---------- */
    /**
     * Performs a <em>post-order</em> depth-first search (DFS) on the specified
     * AST node.  
     * <p>
     * In post-order traversal every child subtree is visited <strong>before</strong>
     * the current node, producing a <i>leaf-first</i> visitation sequence that is
     * useful when parent processing depends on child results.
     * </p>
     *
     * @param node   the root of the subtree to traverse; if {@code null} the method
     *               returns immediately
     * @param action a callback invoked exactly once for every node after all of its
     *               children have been visited (never {@code null})
     */
    public static void dfsPost(ASTree node, Consumer<ASTree> action) {
        if (node == null) return;
        node.children().forEachRemaining(       // 1. 先遞迴處理子節點
            child -> dfsPost(child, action)
        );
        action.accept(node);                    // 2. 處理自己
    }

    /* ---------- 4. In-order DFS (left → root → right) ---------- */
    /**
     * Classic in-order traversal: visit left subtree, then root, then right subtree.
     * <p>For a strictly binary AST this matches the usual infix order used to
     * print arithmetic expressions.  If a node has more than two children, the
     * first child is treated as the “left” subtree and the remaining children
     * are visited in declaration order as a flattened “right-chain”.</p>
     *
     * @param node   the subtree root to traverse
     * @param action callback executed for every visited node
     */
    public static void dfsIn(ASTree node, Consumer<ASTree> action) {
    	if (node == null) return;

        Iterator<ASTree> it = node.children();//Use Call Ones

        /* 1) traverse the left subtree (first child, if present) */
        if (it.hasNext()) {
            ASTree left = it.next();
            dfsIn(left, action);
        }

        /* 2) visit the current (root) node */
        action.accept(node);

        /* 3) traverse the right subtree(s) – remaining children */
        while (it.hasNext()) {
            dfsIn(it.next(), action);
        }
    }
    
    /**
     * Prints the IDs of every node in an {@link ASTree} according to the traversal
     * order supplied by the given {@code strategy}.  
     * <p>
     * The output format is:  
     * <pre>
     * Visit [id0] -> Visit [id1] -> … -> Visit [idN]
     * </pre>
     * Every {@code lineBreak} nodes a line-break is inserted, so the arrow (“→”)
     * never appears at the start of a new line and never trails after the final
     * node on a line.  
     * </p>
     *
     * <h4>Example usage</h4>
     * <pre>{@code
     * printAST(astRoot, ASTutil::dfsPre, 10);   // pre-order DFS
     * printAST(astRoot, ASTutil::dfsPre, 8);   // post-order DFS
     * printAST(astRoot, ASTutil::dfsPre, 12);      // BFS
     * }</pre>
     *
     * <h4>Thread safety</h4>
     * The internal node counter is an {@link java.util.concurrent.atomic.AtomicInteger}
     * so this method is safe to call from multiple threads <i>if</i> the supplied
     * {@code TraversalStrategy} itself is thread-safe and the {@code ASTree}
     * structure is not being mutated concurrently.
     *
     * @param root       the root of the AST; if {@code null} nothing is printed
     * @param strategy   the traversal strategy to use (e.g. DFS pre, DFS post, BFS)
     * @param lineBreak  number of nodes to print per line before inserting
     *                   a line-break; must be {@code > 0}
     */
    public static void printAST(ASTree root, TraversalStrategy strategy,
            int lineBreak) {
    	if (root == null) return;
    	if(lineBreak == 0) {System.out.println("lineBreak == 0 Error."); return;}
    	//System.out.println("=== DFSPre ===");
        AtomicInteger counter = new AtomicInteger();   // 執行緒安全，也能用在並行場景
        strategy.traverse(root, n -> {
        	int cur = counter.getAndIncrement();
        	
        	/* 1. 換行：當 cur 是 lineBreak 的倍數（且不是第一個）就先換行 */
            if (cur > 0 && cur % lineBreak == 0) {
            	System.out.println("");
            }
            /* 2. 箭頭：除了每行第一個節點，其餘都先印 " -> " */
            if (cur % lineBreak != 0) {
                System.out.print(" -> ");
            }
            /* 3. 印節點 */
            System.out.print("Visit [" + n.id() + "]");
        });
        System.out.println();
    }
    
    /**
     * 依德摩根定律將
     *   (A and B)  →  (not A) or (not B)
     *   (A or  B)  →  (not A) and (not B)
     */
    /** 入口：對傳入節點取反並展開德摩根律。 */
    public static ASTree transformPost(
            ASTree node,
            Function<ASTree, ASTree> rewrite) {

        if (node == null) return null;

        // 1) 先遞迴處理子節點
        List<ASTree> newKids = new ArrayList<>();
        node.children().forEachRemaining(
            child -> newKids.add(transformPost(child, rewrite))
        );

        // 2) 如果任何子節點被換掉，就重建目前節點
        ASTree current = node;
        if (node instanceof ASTList &&          // 只示範 ASTList
            newKids.stream().anyMatch(k -> k != null)) {
            try {
                Constructor<? extends ASTree> ctor =
                    node.getClass().getConstructor(List.class);
                current = ctor.newInstance(newKids);
            } catch (Exception e) {
                current = node.clone();          // 後援：至少 clone
            }
        }

        // 3) 最後把「自己」交給 rewrite() 再回傳
        return rewrite.apply(current);
    }
    /* ======================= 內部遞迴 ======================= */
    public static ASTree DeMorgan(ASTree n) {
    	/* ---------- 1) BinaryExp ---------- */
        if (n instanceof BinaryExp bin ) {

            // 1-a) 先遞迴取反左右子樹
            ASTree newLeft  = DeMorgan(bin.left());
            ASTree newRight = DeMorgan(bin.right());

            // 1-b) 決定新運算子
            String op  = bin.getOperator();
            String nop = switch (bin.getGroup()) {
                case LOGICAL -> switch (op) {
                    case "and" -> "or";
                    case "or"  -> "and";
                    default    -> op;          // xor / implies … 不處理
                };
                case RELATIONAL -> switch (op) {
                    case  ">"  -> "<=";
                    case  "<"  -> ">=";
                    case "<="  ->  ">";
                    case ">="  ->  "<";
                    case  "="  -> "<>";
                    case "<>"  ->  "=";
                    default    -> op;
                };
                default -> op;                 // additive / multiplicative … 不動
            };

            return new BinaryExp(List.of(newLeft, newRight), nop);
        } 
        if(n instanceof IterateExp iter) {
        	boolean isPre = false; Symbol sym = null;
    	    if (iter.getSource() instanceof VariableExp v) {isPre = v.isMarkedPre(); sym = v.getSymbol();}
    	    if(iter.getSource() instanceof FeatureCallExp f) {isPre = f.isMarkedPre(); sym = f.getSymbol();}
        	ASTree newbody = DeMorgan(iter.getBody());
        	return new IterateExp(List.of(iter.getSource().clone(),iter.getIteratorDecl().clone(),iter.getResultDecl().clone(),newbody),isPre,sym);
        } 
        if (n instanceof IfExp ifexp) {
        	ASTree newcond = DeMorgan(ifexp.getCondition());
        	return newcond;
        } 
        if(n instanceof LetExp lt) {
        	List<ASTree> Vardecl =lt.getVariabledecls();
        	List<ASTree> newchildren = new ArrayList<>();
        	for(ASTree decl : Vardecl) {
        		newchildren.add(decl.clone());
        	}
        	ASTree exp = DeMorgan(lt.getOclExpression());
        	newchildren.add(exp);
        	return new LetExp(newchildren);
        }
        if (n instanceof UnaryExp  un) {
        	if(un.getOperator().equals("not")||un.getOperator().equals("!")) {
        		ASTree newchild = un.getExpr().clone();
        		return new UnaryExp(List.of(newchild),"");
        	}
        }
        if (n instanceof ContextExpAST ctx) {
        	return DeMorgan(ctx.getConstraint());
        }//variableExp, FeatureCallExp, LiterialExp, InvalidAST, etc. 直接Clone
		return n.clone();
	}
    
    

	/* ======== Quick Start ======== */
     public static void main(String[] args) {
    	/* Program args:
    	F:\papyrus\WorkSpace Grade DC */
    	FileLoader Loader = new FileLoader(args);
		if(args.length>1 && args.length<3) {
			System.out.println("Enter DC/DCC/MCC");
			System.exit(1);
		}
		 ASTBuilder astbuilder = new ASTBuilder(Loader.getOclPath(), Loader.getUmlPath());
		 astbuilder.build();
    	ASTree ast = astbuilder.getAST();           // 假設你有自己的 AST root
        System.out.println("=== PRE-ORDER DFS ===");
        printAST(ast, AstUtil::dfsPre, 9);
        System.out.println("=== POST-ORDER DFS ===");
        printAST(ast, AstUtil::dfsPost, 9);
        System.out.println("=== IN-ORDER DFS ===");
        printAST(ast, AstUtil::dfsIn, 9);
        System.out.println("=== BFS ===");
        printAST(ast, AstUtil::bfs, 9);
        
     }
    /** 僅示範用途：用你實際建立的 AST 取代這段即可 */
    private static ASTree buildDummyAst() { return null; }
}
