package test2021;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class MakeTestClass {
	public static void main(String[] args) {
		
		createFile();
		
	}
	
	public static void createFile() {
		LocalDate dt = LocalDate.now();
		int yyyy = dt.getYear();
		String mm = dt.getMonthValue() < 10 ? "0"+dt.getMonthValue() : dt.getMonthValue()+"";
		String dd = dt.getDayOfMonth() < 10 ? "0"+dt.getDayOfMonth() : dt.getDayOfMonth()+"";
		
		DecimalFormat df = new DecimalFormat("000");
		int number = 1;
		String index = df.format(number);
		
		String fileNm = "Test"+yyyy+mm+dd+"_"+index+".java";
		File file = new File("./src/test2021/"+fileNm);

		while(file.exists()) {
			number++;
			index = df.format(number);
			System.out.println(index);
			fileNm = "Test"+yyyy+mm+dd+"_"+index+".java";
			file = new File("./src/test2021/"+fileNm);
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			System.out.println("File생성 완료");
			System.out.println("File 명 : " + fileNm);
			
			fos.close();
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write("package test2021;\n\n");
			writer.write("public class "+fileNm.split(".java")[0] + "{"
					+ "\n"
					+ "\tpublic static void main(String[] args) {"
					+ "\n"
					+ "\n"
					+"\t}"
					+ "\n}");
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("File생성 error발생");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
