package p_heu.search;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.VM;
import p_heu.entity.sequence.Sequence;

public abstract class DistanceBasedSearch extends Search {
	
	private LinkedList<Sequence> queue;
	private Comparator<Sequence> comparator;

	public DistanceBasedSearch(Config config, VM vm) {
		super(config, vm);
		// TODO Auto-generated constructor stub
		this.queue = new LinkedList<>();
		this.comparator = new DistanceComparator();
	}
	
	private class DistanceComparator implements Comparator<Sequence> {

		@Override
		public int compare(Sequence seq1, Sequence seq2) {
			return seq1.getDistance() == seq2.getDistance() ? 0 : (seq1.getDistance() < seq2.getDistance() ? -1 : 1);
		}
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}
	
	public void sortQueue() {
		Collections.sort(this.queue, this.comparator);
	}

}
