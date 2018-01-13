package p_heu.run;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import p_heu.entity.filter.Filter;
import p_heu.entity.sequence.Sequence;
import p_heu.listener.BasicPatternFindingListener;
import p_heu.listener.SequenceProduceListener;

import java.util.HashSet;
import java.util.Set;

public class Startup {
	public static void main(String[] args) {

		boolean isCorrect = false;
		Sequence correctSeq = null;

		while(!isCorrect){
			correctSeq = getCorrectSequence();
			isCorrect = correctSeq.getResult();
		}

		System.out.println("\n\n\n\n查找到正确执行序列：\n");

		Set<Sequence> correctSeqs = new HashSet<>();
		correctSeqs.add(correctSeq);

		String[] str = new String[]{
				"+classpath=out/production/heu_search",
//				"+search.class=p_heu.search.BFSearch",
				//"+search.class=p_heu.search.SingleExecutionSearch",
				"+search.class=p_heu.search.PatternDistanceBasedSearch",
				"CheckField"};

		Config config = new Config(str);
		BasicPatternFindingListener listener = new BasicPatternFindingListener(correctSeqs);
		Filter filter = Filter.createFilePathFilter();
		listener.setPositionFilter(filter);
		JPF jpf = new JPF(config);
		jpf.addListener(listener);
		jpf.run();

		//System.out.println(listener.getSequence());
	}

	public static Sequence getCorrectSequence(){

		String[] str = new String[]{
				"+classpath=out/production/heu_search",
				"+search.class=p_heu.search.SingleExecutionSearch",
				"CheckField"};
		Config config = new Config(str);
		JPF jpf = new JPF(config);
		SequenceProduceListener listener = new SequenceProduceListener();
		Filter filter = Filter.createFilePathFilter();
		listener.setPositionFilter(filter);

		jpf.addListener(listener);
		jpf.run();
		return listener.getSequence();
	}
}
