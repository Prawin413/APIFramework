package readExcel;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	
	public static void main(String[] args) throws IOException{
		
		ReadExcelData red = new ReadExcelData();
		ArrayList<String> data= red.getData("2","Sheet1");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));

	}

}
