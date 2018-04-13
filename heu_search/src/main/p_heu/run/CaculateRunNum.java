package p_heu.run;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import p_heu.entity.filter.Filter;
import p_heu.entity.sequence.Sequence;
import p_heu.listener.BasicPatternFindingListener;
import p_heu.listener.SequenceProduceListener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CaculateRunNum {

	public static void main(String[] args) throws IOException {

//		String[] testFileNames = {"consisitency.Main","critical.Critical","datarace.Main",
//				"hashcodetest.HashCodeTest","linkedlist.BugTester","mergesort.MergeSort"};

		String[] testFileNames = {"SimpleTest.Main"};
		for(String testFileName : testFileNames){
			Run(testFileName);
		}
	}



	public static Sequence getCorrectSequence(String testFileName){

		String[] str = new String[]{
				"+classpath=out/production/heu_search",
				"+search.class=p_heu.search.SingleExecutionSearch",
				testFileName};
		Config config = new Config(str);
		JPF jpf = new JPF(config);
		SequenceProduceListener listener = new SequenceProduceListener();
		Filter filter = Filter.createFilePathFilter();
		listener.setPositionFilter(filter);

		jpf.addListener(listener);
		jpf.run();
		jpf = null;
		System.gc();
		return listener.getSequence();
	}

	public static void Run(String testFileName) throws IOException {

		Sequence correctSeq = null;
		int randomTime = 0;
		Set<Sequence> correctSeqs = null;
		//String testFileName = "SimpleTest.Main";//"CheckField"
		int iteration = 100;
		int HEUNUM = 0;
		int RANDOM = 0;

		String[] str = new String[]{
				"+classpath=out/production/heu_search",
				"+search.class=p_heu.search.PatternDistanceBasedSearch",
				testFileName};
		Config config = new Config(str);
		Filter filter = Filter.createFilePathFilter();

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Number");
		HSSFRow row = null;

		for(int i = 0;i<iteration;i++){

			row = sheet.createRow(i);
			correctSeq = getCorrectSequence(testFileName);
			if(correctSeq.getResult() == true){

				correctSeqs = new HashSet<>();
				correctSeqs.add(correctSeq);
				BasicPatternFindingListener listener = new BasicPatternFindingListener(correctSeqs);
				listener.setPositionFilter(filter);
				JPF jpf = new JPF(config);
				jpf.addListener(listener);
				jpf.run();
				jpf = null;
				row.createCell(0).setCellValue(i);
				//row.createCell(1).setCellValue(listener.getRUNMBER());
				row.createCell(1).setCellValue(listener.getCorrectSeqs().size()+1);
				HEUNUM += (listener.getCorrectSeqs().size()+1);
				System.gc();

			}else{
				row.createCell(0).setCellValue(i);
				row.createCell(1).setCellValue(1);
				HEUNUM += 1;
				System.gc();
			}
		}
		System.out.println("heuend");

		for(int i = 0;i<iteration;i++){
			row = sheet.getRow(i);
			randomTime = 1;
			while(getCorrectSequence(testFileName).getResult()){
				randomTime++;
			}
			RANDOM += randomTime;
			row.createCell(2).setCellValue(randomTime);
		}
		row = sheet.createRow(100);
		row.createCell(0).setCellValue("average:");
		row.createCell(1).setCellValue(HEUNUM/100.0);
		row.createCell(2).setCellValue(RANDOM/100.0);
		FileOutputStream fos = new FileOutputStream("./result/result4/" + testFileName + "_" + iteration + ".xls");
		workbook.write(fos);
		fos.close();
	}
}
