package p_heu.search;

import java.util.*;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.VM;
import p_heu.entity.sequence.Sequence;

public abstract class DistanceBasedSearch extends Search {

    protected Set<Sequence> correctSeqs;
	protected LinkedList<Sequence> queue;
	protected Comparator<Sequence> comparator;

	public DistanceBasedSearch(Config config, VM vm) {
		super(config, vm);
		// TODO Auto-generated constructor stub
        this.correctSeqs = new HashSet<>();
		this.queue = new LinkedList<>();
		this.comparator = new DistanceComparator();
	}
	
	private class DistanceComparator implements Comparator<Sequence> {

		@Override
		public int compare(Sequence seq1, Sequence seq2) {
			return Integer.compare(seq1.getDistance(), seq2.getDistance());
		}
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

    protected void addCorrectSeq(Sequence seq) {
	    correctSeqs.add(seq);
    }

    protected void addQueue(Sequence seq) {
	    queue.add(seq);
    }

    protected void sortQueue() {
		Collections.sort(this.queue, this.comparator);
	}

    protected void updateDistanceOfQueue() {
	    for (Sequence seq : queue) {
	        updateDistance(seq);
        }
    }

    protected abstract void updateDistance(Sequence seq);
}
