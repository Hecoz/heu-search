package p_heu.entity;

import gov.nasa.jpf.vm.RestorableVMState;

public class SearchState {
	private int stateId;
	private int currentNumberOfChoices;
	private RestorableVMState state;
	
	public SearchState(int stateId,int currentNumberOfChoices, RestorableVMState state) {
		this.stateId = stateId;
		this.currentNumberOfChoices = currentNumberOfChoices;
		this.state = state;
	}
	
	public int getStateId() {
		return this.stateId;
	}

	public int getCurrentNumberOfChoices() {
		return currentNumberOfChoices;
	}

	public RestorableVMState getState() {
		return this.state;
	}

	public String toString() {
	    return "SearchState[" + "stateId:" + stateId + ",currentNumberOfChoice:" + currentNumberOfChoices + "]";
    }
}
