package ccu.pllab.tcgen3.core.testmodelbuilder.clg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CLGGraph {
	private CLGStartNode startNode;
	private CLGEndNode endNode;
	private HashMap<Integer,CLGConnectionNode> connectionNodes = new HashMap<Integer,CLGConnectionNode>();
	private HashMap<Integer, CLGConstraintNode> constraintNodes = new HashMap<Integer, CLGConstraintNode>();

	public CLGGraph() {
		this.startNode = new CLGStartNode();
		this.endNode = new CLGEndNode();
		this.startNode.addSuccessor(this.endNode);//起點 繼承者設為 終點
		this.endNode.addPredecessor(this.startNode);//終點 前者設定為起點
	}
}
