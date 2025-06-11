package ccu.pllab.tcgen3.core.testcasegen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdge;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGEdgeType;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGGraph;
import ccu.pllab.tcgen3.core.testmodelbuilder.clg.CLGNode;

/**
 * <strong>PathEnumerator</strong> — an <em>interactive</em> enumerator that generates
 * complete paths from {@code START → … → END} within a {@link CLGGraph}.
 * <p>
 * Key features:
 * <ul>
 *   <li>Implements {@link Iterable}{@code <List<CLGEdge>>}, allowing you to obtain
 *       one path at a time via {@code for-each} or an explicit {@code Iterator}.</li>
 *   <li>Uses <em>Breadth-First Search</em> (BFS) so that shorter paths are produced first.</li>
 *   <li>Supports loop edges ({@link CLGEdgeType#ITERATION}); the number of times an
 *       iteration edge can be unrolled in a single path is bounded by {@code maxUnroll}.</li>
 *   <li>Still provides <code>enumerate()</code> and <code>stream()</code> batch / lazy APIs;
 *       both delegate to the underlying iterator.</li>
 * </ul>
 * <h2>Basic usage</h2>
 * <pre>{@code
 * PathEnumerator pe = new PathEnumerator(clg, 1000, 3);  // up to 1,000 paths, unroll loops at most 3 times
 * for (List<CLGEdge> path : pe) {
 *     // handle each complete path from START to END
 * }
 * }
 * </pre>
 */
public final class PathEnumerator implements Iterable<List<CLGEdge>> {

    private final CLGGraph graph;
    private final int maxPaths;
    private final int maxUnroll;

    /**
     * @param graph     the target {@link CLGGraph} (must not be {@code null})
     * @param maxPaths  the maximum number of paths to enumerate (use
     *                  {@link Integer#MAX_VALUE} for no limit)
     * @param maxUnroll the maximum number of times an {@code ITERATION} edge may be
     *                  unrolled in a single path (must be ≥ 0)
     */
    public PathEnumerator(CLGGraph graph, int maxPaths, int maxUnroll) {
        this.graph = Objects.requireNonNull(graph, "graph must not be null");
        if (maxPaths <= 0) throw new IllegalArgumentException("maxPaths must be positive");
        if (maxUnroll < 0)  throw new IllegalArgumentException("maxUnroll must be ≥ 0");
        this.maxPaths = maxPaths;
        this.maxUnroll = maxUnroll;
    }

    /** Convenience constructor: enumerate <em>all</em> paths with the given {@code maxUnroll} limit. */
    public PathEnumerator(CLGGraph graph, int maxUnroll) {
        this(graph, Integer.MAX_VALUE, maxUnroll);
    }

    /* ========= Iterable ========= */
    @Override
    public Iterator<List<CLGEdge>> iterator() {
        return new BFSIterator();
    }

    /* ========= Batch／Stream APIs ========= */
    /** Collects <em>all</em> paths eagerly into a list. */
    public List<List<CLGEdge>> enumerate() {
        List<List<CLGEdge>> all = new ArrayList<>();
        iterator().forEachRemaining(all::add);
        return all;
    }

    /** Returns a <em>lazy</em> {@link Stream} view of the paths. */
    public Stream<List<CLGEdge>> stream() {
    	return StreamSupport.stream(spliterator(), false);
    }

    /* ========= Internal Iterator ========= */
    private final class BFSIterator implements Iterator<List<CLGEdge>> {
        private record Frame(CLGNode node, List<CLGEdge> path, int unroll) {}

        private final Deque<Frame> q = new ArrayDeque<>();
        private int produced = 0;
        private List<CLGEdge> nextPath;  // look-ahead cache

        BFSIterator() {     	
            q.add(new Frame(graph.getStart(), List.of(), 0));
            advance();
        }

        @Override
        public boolean hasNext() {
            return nextPath != null;
        }

        @Override
        public List<CLGEdge> next() {
            if (nextPath == null) throw new NoSuchElementException();
            List<CLGEdge> current = nextPath;
            advance();   // prefetch the next path
            return current;
        }

        /** Prefetch the next complete path using BFS. */
        private void advance() {
            nextPath = null;
            while (!q.isEmpty() && produced < maxPaths) {
                Frame f = q.poll();
                if (f.node() == graph.getEnd()) {
                    nextPath = f.path();
                    produced++; 
                    return; // a complete path is cached in nextPath
                }
                for (CLGEdge e : f.node().getOutEdges()) {
                    int depth = f.unroll();
                    if (e.getType() == CLGEdgeType.ITERATION) {
                        depth += 1;
                        if (depth > maxUnroll) continue; // 超出展開上限→剪枝
                    }
                    List<CLGEdge> next = new ArrayList<>(f.path());
                    next.add(e);
                    q.add(new Frame(e.getTo(), next, depth));
                }
            }
        }
    }
}
