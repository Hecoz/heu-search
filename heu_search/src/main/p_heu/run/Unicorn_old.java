package p_heu.run;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import p_heu.entity.filter.Filter;
import p_heu.entity.pattern.Pattern;
import p_heu.entity.sequence.Sequence;
import p_heu.listener.SequenceProduceListener;

import java.util.HashSet;
import java.util.Set;

public class Unicorn_old {
    public static void main(String[] args) {
        Pattern.setPatternSet("unicorn");
        String[] str = new String[]{
                "+classpath=out/production/heu_search",
                "+search.class=p_heu.search.SingleExecutionSearch",
                "account.Main"};
        Config config = new Config(str);
        JPF jpf = new JPF(config);
        SequenceProduceListener listener = new SequenceProduceListener();
        Filter filter = Filter.createFilePathFilter();
        listener.setPositionFilter(filter);

        jpf.addListener(listener);
        jpf.run();
        Sequence seq = listener.getSequence();
        Set<Pattern> patterns = seq.getPatterns();
        Set<Pattern> filtedPatterns = new HashSet<>();
        for (Pattern pattern : patterns) {
            boolean contains = false;
            for (Pattern p : filtedPatterns) {
                if (pattern.isSameExecptThread(p)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                filtedPatterns.add(pattern);
            }
        }

        System.out.println(patterns.size());
        System.out.println(filtedPatterns.size());
    }
}
