package ccu.pllab.tcgen3.core.testmodelbuilder.clg;

import java.util.concurrent.atomic.AtomicLong;

public class CLGEdge {
	 /* === 1. Metadata === */
    private static final AtomicLong COUNTER = new AtomicLong();
    private final long id= COUNTER.getAndIncrement();                 // 邊的唯一識別

    private final CLGNode from;            // 起點
    private final CLGNode to;              // 終點
    private final CLGEdgeType type;        // 邊類型

    /* === 2. Optional attributes === */
    private final String label;            // branch name，Ex: "then" / "else"
    private final int iterationIndex;      // 若為 ITERATION，可紀錄第幾次展開
    private volatile boolean covered;      // 測試覆蓋標記 (thread-safe)

    /* === 3. Constructor === */
    private CLGEdge(Builder b) {
        this.from = b.from;
        this.to = b.to;
        this.type = b.type;
        this.label = b.label;
        this.iterationIndex = b.iterationIndex;
        this.covered = false;
    }
    /** === 4. Builder Pattern for readability === */
    public static  class Builder {
    	private final CLGNode from;
        private final CLGNode to;
        private CLGEdgeType type = CLGEdgeType.SEQUENTIAL;
        private String label = "";
        private int iterationIndex = -1;

        public Builder(CLGNode from, CLGNode to) {
            this.from = from; 
            this.to = to;
        }
        public Builder type(CLGEdgeType t)          { this.type = t; return this; }
        public Builder label(String l)              { this.label = l; return this; }
        public Builder iterationIndex(int idx)      { this.iterationIndex = idx; return this; }
        public CLGEdge build()                      { return new CLGEdge(this); }
    }
    /* === 5. Getters (唯讀) === */
    public long getId()               { return id; }
    public CLGNode getFrom()          { return from; }
    public CLGNode getTo()            { return to; }
    public CLGEdgeType getType()      { return type; }
    public String getLabel()          { return label; }
    public int getIterationIndex()    { return iterationIndex; }
    
    /* === 6. Coverage 支援 === */
    public boolean isCovered()        { return covered; }
    public void markCovered()         { this.covered = true; }

    /* === 7. equals/hashCode ⇒ 以 id 為準 === */
    @Override
    public int hashCode() { return Long.hashCode(id); }

    @Override
    public boolean equals(Object o) {
        return (this == o) || (o instanceof CLGEdge e && this.id == e.id);
    }

    /* === 8. 方便除錯的 toString() === */
    @Override
    public String toString() {
        return "Edge#" + id + "(" + from.id() + "→" + to.id() +
               ", type=" + type + (label.isEmpty()? "" : ", label=" + label) + ")";
    }
    
}
