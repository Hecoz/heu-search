package p_heu.entity.sequence;

import java.util.ArrayList;
import java.util.List;

import p_heu.entity.Node;
import p_heu.entity.SearchState;
import p_heu.entity.pattern.Pattern;

public class Sequence {
	private List<Node> nodes;
	private List<SearchState> states;
	private boolean finished;
	private int distance;
	
	public Sequence() {
		this.nodes = new ArrayList<>();
		this.states = new ArrayList<>();
		this.finished = false;
		this.distance = 0;
	}
	
	public List<Node> getNodes() {
		return this.nodes;
	}
	
	public void addNode(Node node) {
		this.nodes.add(node);
	}
	
	public List<SearchState> getStates() {
		return this.states;
	}
	
	public void addState(SearchState state) {
		this.states.add(state);
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public List<Pattern> matchPattern() {
		//TODO ���л������е�patternƥ���㷨
		return null;
	}
}
