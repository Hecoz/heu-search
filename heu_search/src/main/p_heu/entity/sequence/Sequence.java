package p_heu.entity.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gov.nasa.jpf.vm.RestorableVMState;
import p_heu.entity.Node;
import p_heu.entity.SearchState;
import p_heu.entity.pattern.Pattern;

public class Sequence {
	private List<Node> nodes;
	private List<SearchState> states;
	private boolean finished;
	private boolean result;
	private int distance;

	//distance的值是否过期
	private boolean consist;
	
	public Sequence() {
		this.nodes = new ArrayList<>();
		this.states = new ArrayList<>();
		this.finished = false;
		this.result = false;
		this.distance = 0;
		this.consist = true;
	}

	private Sequence(List<Node> nodes, List<SearchState> states, boolean finished,
                     boolean result, int distance, boolean consist) {
	    this.nodes = new ArrayList<>();
	    this.nodes.addAll(nodes);
        this.states = new ArrayList<>();
	    this.states.addAll(states);
	    this.finished = finished;
	    this.result = result;
	    this.distance = distance;
	    this.consist = consist;
    }

	public Sequence copy() {
	    return new Sequence(nodes, states, finished, result, distance, consist);
    }
	
	public List<Node> getNodes() {
		return this.nodes;
	}
	
//	public void addNode(Node node) {
//		this.nodes.add(node);
//	}
	
	public List<SearchState> getStates() {
		return this.states;
	}

	public SearchState getLastState() {
	    if (this.states.size() == 0) {
	        return null;
        }
        else {
            return this.states.get(this.states.size() - 1);
        }
    }
	
//	public void addState(SearchState state) {
//		this.states.add(state);
//	}
	
	public boolean isFinished() {
		return this.finished;
	}

	public boolean getResult() {
	    return this.result;
    }

//    public void setResult(boolean result) {
//	    this.result = result;
//	    if (this.finished) {
//	        throw new RuntimeException("Already a finished sequence.");
//        }
//        else {
//	        this.finished = true;
//        }
//    }

    public Sequence advance(int stateId, RestorableVMState state, List<Node> nodes) {
	    Sequence seq = this.copy();
	    seq.states.add(new SearchState(stateId, state));
	    seq.nodes.addAll(nodes);
	    seq.consist = false;
	    return seq;
    }

    public Sequence advanceToEnd(int stateId, RestorableVMState state, List<Node> nodes, boolean result) {
	    Sequence seq = advance(stateId, state, nodes);
	    seq.finished = true;
	    seq.result = result;
	    return seq;
    }
	
	public int getDistance() {
	    if (consist) {
            return this.distance;
        }
        else {
	        return calculateDistance();
        }
	}

	private int calculateDistance() {
	    //TODO 计算出当前序列（或子序列）的距离
        Random random = new Random();
        this.distance = random.nextInt(10);

        this.consist = true;
        return this.distance;
    }

    //当correctSeqs发生变动时，需要调用，使distance保持更新
    public void distanceNeedUpdate() {
	    this.consist = false;
    }
	
	public List<Pattern> matchPattern() {
		//TODO 序列或子序列的pattern匹配算法
		return null;
	}


	public String toString() {
	    StringBuilder stringBuilder = new StringBuilder("Sequence {\n");
        stringBuilder.append("\tnodes:\n");
        for (Node node : nodes) {
            stringBuilder.append("\t");
            stringBuilder.append(node);
            stringBuilder.append("\n");
        }
        stringBuilder.append("\tstates:\n");
        for (SearchState state : states) {
            stringBuilder.append("\t");
            stringBuilder.append(state);
            stringBuilder.append("\n");
        }
        stringBuilder.append("\tfinished: ");
        stringBuilder.append(finished);
        stringBuilder.append("\n\tresult: ");
        stringBuilder.append(result);
        stringBuilder.append("\n\tdistance: ");
        stringBuilder.append(getDistance());
        stringBuilder.append("\n}");
	    return stringBuilder.toString();
    }
}
