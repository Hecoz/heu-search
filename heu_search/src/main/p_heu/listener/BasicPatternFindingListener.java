package p_heu.listener;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.RestorableVMState;
import gov.nasa.jpf.vm.VM;

public class BasicPatternFindingListener extends ListenerAdapter {
    private int lastStateId;

    public void stateAdvanced(Search search) {
        VM vm = search.getVM();
        int currentStateId = vm.getStateId();
        RestorableVMState currentState = vm.getRestorableState();
    }
}
