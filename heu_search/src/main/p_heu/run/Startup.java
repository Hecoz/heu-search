package p_heu.run;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;

public class Startup {
	public static void main(String[] args) {
		String[] str = new String[]{
				"+classpath=heu_search/build/examples",
				"+search.class=p_heu.search.BFSearch",
				"CheckField"};
		Config config = new Config(str);
		JPF jpf = new JPF(config);
		jpf.run();
	}
}
