package chap16;
/*
 * 1. src/chap15 ������ .java ���� �� InputStream ���� ��� �ҽ���  
InputStream����.txt  ���Ϸ� �����ϱ�
 InputStream ���� ��� �ҽ� : XXXInputStreamXXX.java
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
			out = new FileOutputStream("InputStream����.txt");
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
