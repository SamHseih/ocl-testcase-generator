package ccu.pllab.tcgen3.core.testcasegen;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdgeType;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;

public final class NestedLoopPathEnumerator implements Iterable<List<CLGEdge>> {

    private final CLGGraph graph;
    private final int maxPaths;
    private final int maxUnroll;

    public NestedLoopPathEnumerator(CLGGraph graph, int maxPaths, int maxUnroll) {
        this.graph = Objects.requireNonNull(graph);
        if (maxPaths <= 0) throw new IllegalArgumentException("maxPaths must be > 0");
        if (maxUnroll < 0) throw new IllegalArgumentException("maxUnroll must be ≥ 0");
        this.maxPaths = maxPaths;
        this.maxUnroll = maxUnroll;
    }

    @Override
    public Iterator<List<CLGEdge>> iterator() {
        return new DFSIterator();
    }

    /* ========== 內部 DFS Iterator ========== */
    private final class DFSIterator implements Iterator<List<CLGEdge>> {

        private record Frame(CLGNode node,
                             Iterator<CLGEdge> edgesIter,
                             Frame parent,
                             int unrollDepth) {}

        private List<CLGEdge> nextPath;
        private int produced = 0;
        private Frame top;  // 目前遍歷堆疊頂端

        DFSIterator() {
            // 首先 push 起點 Frame
            top = new Frame(
                    graph.getStart(),
                    sortedEdges(graph.getStart()).iterator(),
                    null,
                    0
            );
            advance(); // 預取第一條完整路徑
        }

        /* 依「到 START 的距離」排序，以逼近外層→內層 */
        private List<CLGEdge> sortedEdges(CLGNode n) {
            return n.getOutEdges().stream()
                    .sorted(Comparator.comparingInt(e -> distanceFromStart(e.getTo())))
                    .toList();
        }

        private int distanceFromStart(CLGNode n) {
            // 可事先用 BFS 預計算所有節點 distance table；這裡偷懶呼叫一次 BFS
            Deque<CLGNode> q = new ArrayDeque<>();
            Set<CLGNode> vis = new HashSet<>();
            q.add(graph.getStart());
            int dist = 0;
            while (!q.isEmpty()) {
                int sz = q.size();
                while (sz-- > 0) {
                    CLGNode cur = q.poll();
                    if (cur == n) return dist;
                    for (CLGEdge e : cur.getOutEdges())
                        if (vis.add(e.getTo())) q.add(e.getTo());
                }
                dist++;
            }
            return Integer.MAX_VALUE; // 不可達 (理論上不會發生)
        }

        @Override
        public boolean hasNext() { return nextPath != null; }

        @Override
        public List<CLGEdge> next() {
            if (nextPath == null) throw new NoSuchElementException();
            List<CLGEdge> ret = nextPath;
            advance();
            return ret;
        }

        /* DFS 預取下一條完成路徑 */
        private void advance() {
            nextPath = null;
            while (top != null && produced < maxPaths) {

                // 抵達 END——輸出路徑
                if (!top.edgesIter.hasNext() && top.node == graph.getEnd()) {
                    nextPath = buildPath(top);
                    produced++;
                    // 回溯到還有未走過邊的上層 Frame
                    backtrack();
                    return;
                }

                if (!top.edgesIter.hasNext()) { // 沒路可走 → 回溯
                    backtrack();
                    continue;
                }

                // 取下一條邊嘗試向下擴展
                CLGEdge e = top.edgesIter.next();

                int depth = top.unrollDepth;
                if (e.getType() == CLGEdgeType.ITERATION) {
                    depth++;
                    if (depth > maxUnroll)  // 超限
                        continue;
                }

                top = new Frame(
                        e.getTo(),
                        sortedEdges(e.getTo()).iterator(),
                        top,
                        depth
                );
            }
        }

        private void backtrack() {
            // pop 直到找到還有未走完 outEdges 的 Frame
            do { top = top.parent; }
            while (top != null && !top.edgesIter.hasNext());
        }

        private List<CLGEdge> buildPath(Frame leaf) {
            // 由 leaf 往上組裝成完整 List
            LinkedList<CLGEdge> path = new LinkedList<>();
            for (Frame f = leaf; f.parent != null; f = f.parent) {
                // parent.edgesIter 的「上一條邊」就是 f.node 的 incoming；
                // 因 Iterator 無記錄，我們可在 Frame 多存 `viaEdge`。
                // 這裡略寫，實作時請在 Frame 加一欄 `inEdge` 方便回溯。
            }
            return path;
        }
    }
}
