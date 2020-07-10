package chap16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class answer {

	public static void main(String[] args) throws IOException {
		File f1 = new File("src/chap15");
		String [] flist = f1.list();
		int len;
		FileOutputStream fos = new FileOutputStream("InputStream¿¹Á¦. txt");
		byte [] buf = new byte[1024];
		for(String fname : flist) {
			File f2 = new File(f1,fname);
			if(f2.isFile() && fname.indexOf("InputStream")>=0 &&fname.endsWith(".java")) {
				FileInputStream fis = new FileInputStream(f2);
				fos.write(("\n\n************"+fname+"*************\n\n").getBytes());
				while ((len=fis.read(buf))  !=-1) {
					fos.write(buf,0,len);
				}
				fis.close();
			}
		}
		fos.flush();
		fos.close();
	}

}
