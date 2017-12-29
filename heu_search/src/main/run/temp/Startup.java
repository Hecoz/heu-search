package run.temp;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;

public class Startup {
	public static void main(String[] args) {
		String[] str = new String[]{
				"+classpath=build/examples", 
				"+search.class=search.BFSearch",
				"CheckField"};
		Config config = new Config(str);
		JPF jpf = new JPF(config);
		jpf.run();
	}
}
