package readExcel;

import java.io.IOException;
import java.util.ArrayList;

public class readingExcelUsingInheritance extends ReadExcelData {

	public static void main(String[] args) throws IOException {
		
		readingExcelUsingInheritance d = new readingExcelUsingInheritance();
		ArrayList<String> readData = d.getData("1","Sheet1");
		System.out.println(readData.get(0));
		System.out.println(readData.get(1));
		System.out.println(readData.get(2));
		System.out.println(readData.get(3));

	}

}
