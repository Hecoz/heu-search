package p_heu.search;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.vm.MultiProcessVM;
import gov.nasa.jpf.vm.SingleProcessVM;
import gov.nasa.jpf.vm.VM;
import org.junit.Before;
import org.junit.Test;
import p_heu.entity.sequence.Sequence;

import java.util.Random;

public class DistanceBasedSearchTest {
    private DistanceBasedSearch search;
    private Sequence seq;
    private Random random;

    @Before
    public void init() throws Exception {
        random = new Random();
        String[] str = new String[]{
                "+classpath=../build/examples",
                "+search.class=p_heu.search.BFSearch",
                "CheckField"};
        Config config = new Config(str);
        JPF jpf = new JPF(config);
        VM vm = new SingleProcessVM(jpf, config);
        search = new DistanceBasedSearch(config, vm) {
            @Override
            protected void updateDistance(Sequence seq) {
                seq.setDistance(random.nextInt(10));
            }
        };

        seq = new Sequence();
        search.addQueue(seq);
        seq = new Sequence();
        search.addQueue(seq);
        seq = new Sequence();
        search.addQueue(seq);
    }

    @Test
    public void addCorrectSeq() throws Exception {
    }

    @Test
    public void addQueue() throws Exception {
        Sequence seq = new Sequence();
        search.addQueue(seq);
        System.out.println(search.queue.size());
    }

    @Test
    public void sortQueue() throws Exception {
        search.updateDistanceOfQueue();
        for (Sequence seq : search.queue) {
            System.out.println(seq.getDistance());
        }
        search.sortQueue();
        System.out.println("sorted:");
        for (Sequence seq : search.queue) {
            System.out.println(seq.getDistance());
        }
    }

    @Test
    public void updateDistanceOfQueue() throws Exception {
    }

    @Test
    public void updateDistance() throws Exception {
        seq = new Sequence();
        search.updateDistance(seq);
        System.out.println(seq.getDistance());
    }

}