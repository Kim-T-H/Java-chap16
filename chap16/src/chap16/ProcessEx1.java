package chap16;

public class ProcessEx1 {

	public static void main(String[] args) {
		try {
			//Runtime.getRuntime():프로세스의 실행 권한을 OS에서 얻음.
 			
			Process p1 = Runtime.getRuntime().exec("mspaint.exe");
			Process p2 = Runtime.getRuntime().exec("notepad.exe");
			p1.waitFor(); //p1 프로세스 종료할때까지 main 이 대기.
			p2.destroy(); //메모장이 강제 종료됨 
		}	catch(Exception e) {
			e.printStackTrace();
		}

	}

}
