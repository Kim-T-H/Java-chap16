package chap16;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * 다른 프로세스의 결과를 콘솔에 출력하기
 */

public class Process2 {

	public static void main(String[] args) throws IOException {
		Process p=Runtime.getRuntime().exec("ping 192.168.0.95");
		Reader r = new InputStreamReader(p.getInputStream());
		int data=0;
		while((data=r.read())  !=-1) {
			System.out.print((char)data);
		}
	}

}
