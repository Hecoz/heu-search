package p_heu.run;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;

public class Startup {
	public static void main(String[] args) {
		String[] str = new String[]{
				"+classpath=out/production/heu_search",
//				"+search.class=p_heu.search.BFSearch",
				"pack_test.CheckField"};
		Config config = new Config(str);
		JPF jpf = new JPF(config);
		jpf.run();
	}
}
