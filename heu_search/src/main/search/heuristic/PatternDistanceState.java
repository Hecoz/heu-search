package search.heuristic;

import gov.nasa.jpf.vm.RestorableVMState;

public class PatternDistanceState {
	protected int parentId;
	protected RestorableVMState[] children;
	
	public PatternDistanceState(int parentId, RestorableVMState[] children) {
		this.parentId = parentId;
		this.children = children;
	}
	
	public int getParentId() {
		return parentId;
	}
	
	public RestorableVMState[] getChildren() {
		return children;
	}
}
