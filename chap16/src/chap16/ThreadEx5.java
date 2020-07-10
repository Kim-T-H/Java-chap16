package chap16;
/*
 * join() : 스레드가 종료될때 까지 대기
 */

class Thread100 extends Thread{
	int sum=0;
	public void run() {
		for(int i=0; i<=100;i++) {
			sum+=i;
		}
	}
}

public class ThreadEx5 {

	public static void main(String[] args) {
		Thread100 t = new Thread100();
		t.start();//병렬환경이 되기때문에 
		try {
			t.join();	//현재 t를 실행한 main 이 대기..... t스레드가 종료시까지 main 스레드 대기함.
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}System.out.println("1~100까지의 합:"+t.sum);

	}

}
