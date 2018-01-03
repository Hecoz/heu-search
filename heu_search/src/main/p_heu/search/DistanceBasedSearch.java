package p_heu.search;

import java.util.*;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.VM;
import p_heu.entity.Node;
import p_heu.entity.sequence.Sequence;

public abstract class DistanceBasedSearch extends Search {

    protected Set<Sequence> correctSeqs;
	protected LinkedList<Sequence> queue;

	protected DistanceBasedSearch(Config config, VM vm) {
		super(config, vm);
        this.correctSeqs = new HashSet<>();
		this.queue = new LinkedList<>();
	}

	@Override
	public void search() {
		// TODO 编写search函数
		
	}

    protected void addCorrectSeq(Sequence seq) {
	    correctSeqs.add(seq);
    }

    protected void addQueue(Sequence seq) {
	    queue.add(seq);
    }

    protected Sequence findSequenceByLastState(int lastStateId) {
	    for (Sequence seq : queue) {
	        if (seq.getLastState().getStateId() == lastStateId) {
	            return seq;
            }
        }
        return null;
    }

    public void stateAdvance(int lastStateId, List<Node> nodes) {
	    Sequence seq = findSequenceByLastState(lastStateId);
	    queue.remove(seq);

    }

    protected void sortQueue() {
		Collections.sort(this.queue, getComparator());
	}

    protected abstract Comparator<Sequence> getComparator();
}
