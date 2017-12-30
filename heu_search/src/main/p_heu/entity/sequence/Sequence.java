package p_heu.entity.sequence;

import java.util.ArrayList;
import java.util.List;

import p_heu.entity.Node;
import p_heu.entity.pattern.Pattern;

public class Sequence {
	private List<Node> nodes;
	private boolean finished;
	
	public Sequence() {
		this.nodes = new ArrayList<>();
		this.finished = false;
	}
	
	public List<Node> getNodes() {
		return this.nodes;
	}
	
	public void addNode(Node node) {
		this.nodes.add(node);
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public List<Pattern> matchPattern() {
		//TODO 序列或子序列的pattern匹配算法
		return null;
	}
}
