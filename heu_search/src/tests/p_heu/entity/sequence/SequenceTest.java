package p_heu.entity.sequence;

import org.junit.Before;
import org.junit.Test;
import p_heu.entity.Node;
import p_heu.entity.ReadWriteNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SequenceTest {
    private Sequence seq;

    @Before
    public void init() throws Exception {
        seq = new Sequence();
        List<Node> nodes = new ArrayList<>();
        nodes.add(new ReadWriteNode(1, "aa", "xx", "read", "t1", "12"));
        seq = seq.advance(1, null, nodes);
        nodes = new ArrayList<>();
        nodes.add(new ReadWriteNode(2, "aa", "xx", "read", "t2", "13"));
        nodes.add(new ReadWriteNode(3, "aa", "xx", "write", "t2", "13"));
        seq = seq.advance(2, null, nodes);
    }

    @Test
    public void copy() throws Exception {
    }

    @Test
    public void getNodes() throws Exception {
        List<Node> nodes = seq.getNodes();
        System.out.println(nodes);
    }

    @Test
    public void getStates() throws Exception {
    }

    @Test
    public void getLastState() throws Exception {
    }

    @Test
    public void isFinished() throws Exception {
        System.out.println(seq.isFinished());
        List<Node> nodes = new ArrayList<>();
        nodes.add(new ReadWriteNode(1, "aa", "xx", "read", "t1", "12"));
        seq = seq.advanceToEnd(4, null, nodes, false);
        System.out.println(seq.isFinished());
    }

    @Test
    public void getResult() throws Exception {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new ReadWriteNode(1, "aa", "xx", "read", "t1", "12"));
        seq = seq.advanceToEnd(4, null, nodes, true);
        System.out.println(seq.getResult());
    }

    @Test
    public void advance() throws Exception {
    }

    @Test
    public void advanceToEnd() throws Exception {
    }

    @Test
    public void getDistance() throws Exception {
    }

    @Test
    public void distanceNeedUpdate() throws Exception {
    }

    @Test
    public void matchPattern() throws Exception {
    }

}