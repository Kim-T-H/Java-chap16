package chap16;
/*
 * 1. src/chap15 폴더의 .java 파일 중 InputStream 관련 모든 소스를  
InputStream예제.txt  파일로 생성하기
 InputStream 관련 모든 소스 : XXXInputStreamXXX.java
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class test {

	public static void main(String[] args) {
		
		try {
			OutputStream out= null;
			FileInputStream fis=new FileInputStream("src/chap15/XXXInputStreamXXX.java");
			out = new FileOutputStream("InputStream예제.txt");
			int data =0;
			while((data=fis.read()) !=-1){
					out.write(data);
			}
		} catch(FileNotFoundException e) {
			
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
