package p_heu.entity;

import gov.nasa.jpf.vm.RestorableVMState;

public class SearchState {
	private int parentStateId;
	private RestorableVMState[] children;
	
	public SearchState(int parentStateId, RestorableVMState[] children) {
		this.parentStateId = parentStateId;
		this.children = children;
	}
	
	public int getParentStateId() {
		return this.parentStateId;
	}
	
	public RestorableVMState[] getChildren() {
		return this.children;
	}
}
