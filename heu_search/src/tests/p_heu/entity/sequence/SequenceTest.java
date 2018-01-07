package p_heu.entity.sequence;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import org.junit.Before;
import org.junit.Test;
import p_heu.entity.Node;
import p_heu.entity.ReadWriteNode;
import p_heu.entity.filter.Filter;
import p_heu.entity.pattern.Pattern;
import p_heu.listener.SequenceProduceListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class SequenceTest {
    private Sequence sequence;

    @Before
    public void init() throws Exception {
        String[] str = new String[]{
                "+classpath=../../out/production/heu_search",
                "+search.class=p_heu.search.SingleExecutionSearch",
                "pack_test.CheckField"};
        Config config = new Config(str);
        JPF jpf = new JPF(config);
        SequenceProduceListener listener = new SequenceProduceListener();
        listener.setPositionFilter(Filter.createFilePathFilter());
        jpf.addListener(listener);
        jpf.run();
        sequence = listener.getSequence();
    }

    @Test
    public void copy() throws Exception {
    }

    @Test
    public void getNodes() throws Exception {
        List<Node> nodes = sequence.getNodes();
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
        System.out.println(sequence.isFinished());
        List<Node> nodes = new ArrayList<>();
        nodes.add(new ReadWriteNode(1, "aa", "xx", "read", "t1", "12"));
        sequence = sequence.advanceToEnd(4, null, nodes, false);
        System.out.println(sequence.isFinished());
    }

    @Test
    public void getResult() throws Exception {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new ReadWriteNode(1, "aa", "xx", "read", "t1", "12"));
        sequence = sequence.advanceToEnd(4, null, nodes, true);
        System.out.println(sequence.getResult());
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
    public void matchPatterns() throws Exception {
    }

    @Test
    public void matchPairs() throws Exception {
        System.out.println(sequence);
        Set<Pattern> patterns = sequence.matchPatterns("falcon");
        for (Pattern p : patterns) {
            if (p.getNodes().length != 2) {
                System.out.println(p);
            }
        }
    }

}