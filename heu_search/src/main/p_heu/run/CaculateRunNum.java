package p_heu.run;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import p_heu.entity.filter.Filter;
import p_heu.entity.sequence.Sequence;
import p_heu.listener.BasicPatternFindingListener;
import p_heu.listener.SequenceProduceListener;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CaculateRunNum {
	public static void main(String[] args) throws IOException {

		Sequence correctSeq = null;
		Set<Sequence> correctSeqs = null;
		FileWriter fw = new FileWriter("./test.txt");

		String[] str = new String[]{
				"+classpath=out/production/heu_search",
				"+search.class=p_heu.search.PatternDistanceBasedSearch",
				"CheckField"};
		Config config = new Config(str);
		Filter filter = Filter.createFilePathFilter();

		for(int i = 0;i<100;i++){

			correctSeq = getCorrectSequence();
			if(correctSeq.getResult() == true){

				correctSeqs = new HashSet<>();
				correctSeqs.add(correctSeq);
				BasicPatternFindingListener listener = new BasicPatternFindingListener(correctSeqs);
				listener.setPositionFilter(filter);
				JPF jpf = new JPF(config);
				jpf.addListener(listener);
				jpf.run();
				fw.write((i+1) + " " + (listener.getCorrectSeqs().size()+1) + "\n");

			}else{
				fw.write((i+1) + " " + 1 + "\n");
			}

		}
		fw.close();
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
