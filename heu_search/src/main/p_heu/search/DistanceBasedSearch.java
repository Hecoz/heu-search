package p_heu.search;

import java.util.*;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.RestorableVMState;
import gov.nasa.jpf.vm.VM;
import p_heu.entity.Node;
import p_heu.entity.SearchState;
import p_heu.entity.sequence.Sequence;

public abstract class DistanceBasedSearch extends Search {

    protected Set<Sequence> correctSeqs;
    protected LinkedList<Sequence> queue;
    protected Sequence revSequence;
    protected int scheduleThreshod;
    protected Sequence errorSequence;

    protected DistanceBasedSearch(Config config, VM vm) {
        super(config, vm);
        this.correctSeqs = new HashSet<>();
        this.queue = new LinkedList<>();
        this.revSequence = null;
        scheduleThreshod = 2;
        errorSequence = null;
    }

    @Override
    public boolean requestBacktrack () {
        doBacktrack = true;
        return true;
    }

    @Override
    public boolean supportsBacktrack () {
        return true;
    }


    @Override
    public void search() {
        // TODO 编写search函数
        //每个从队列中拿出的距离最远的Sequence
        Sequence sequence = null;
        notifySearchStarted();

        //保存初始状态
        RestorableVMState init_state = vm.getRestorableState();
        while(!done){

            while(forward()){

                notifyStateAdvanced();
                //将当前的状态合并到上一状态之后，并添加到队列中
                queue.add(mergeSeq(sequence,revSequence));

                if(currentError != null){
                    notifyPropertyViolated();
                    if(hasPropertyTermination()){
                        errorSequence = sequence;
//                        System.out.println("\n\n\n\n\n - - - - - - - - - - - - - - - - INNER ERROR SEQUENCE - - - - - - - - - - - - - - - -");
//                        System.out.println(sequence);
                        break;
                    }
                }
                if(!checkStateSpaceLimit()){
                    notifySearchConstraintHit("memory limit reached: " + minFreeMemory);
                    //can't go on, we exhausted our memory
                    System.out.println("memory limit reached + + +  + + +  + + + + +");
                    break;
                }
                if(backtrack()){
                    //回溯
                    notifyStateBacktracked();
                }
            }
            notifyStateProcessed();
            //对当前队列进行排序
            sortQueue();
            //根据阈值删除队列中多余的sequence
            while(queue.size() > scheduleThreshod){
                queue.removeLast();
            }
            //判断当前队列中是否存在sequence，当队列size 小于0 表明找到一个正确的sequence
            if(queue.size() > 0){
                sequence = queue.poll();
                vm.restoreState(sequence.getLastState().getState());
            }else{
                //设置正确执行序列的状态为TRUE
                sequence.setResult(true);
                sequence.setFinished(true);
                //将正确的sequence添加到正确的序列集合中
                addCorrectSeq(sequence);
                done = false;
                vm.restoreState(init_state);
                vm.resetNextCG();
                //当前序列置为空
                sequence = null;
                //break;
            }
        }

        //System.out.println(sequence);
        //System.out.println("correctSeqs.size() ： " + correctSeqs.size());
        //errorSequence = sequence;
        notifySearchFinished();
    }

    protected  Sequence mergeSeq(Sequence seqOld,Sequence seqNew){

        if(seqOld!=null){
            SearchState currentState = seqNew.getLastState();
            return seqOld.advance(currentState.getStateId(),currentState.getState(),seqNew.getNodes());
        }else{
            return seqNew;
        }

    }

    protected void addCorrectSeq(Sequence seq) {
        correctSeqs.add(seq);
    }

    public void addCurrentSequence(Sequence seq){
        this.revSequence = seq;
    }

    public Sequence getErrorSequence() {
        return errorSequence;
    }

    public void addQueue(Sequence seq) {
        queue.add(seq);
    }

    public Set<Sequence> getCorrectSeqs() {
        return correctSeqs;
    }

    public void setCorrectSeqs(Set<Sequence> correctSeqs) {
        this.correctSeqs = correctSeqs;
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


