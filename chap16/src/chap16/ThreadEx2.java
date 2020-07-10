package chap16;
/*
 * Runnable 인터페이스를 구현하여 스레드 생성하기
 */
class Runnable1 implements Runnable{	//Thread 클래스 아님. Runnable 인터페이스의 구현클래스임
	@Override
	public void run() {
		for(int i=0; i<5;i++) {
			//Thread.currentThread(): 지금현재 Running 상태인 스레드 객체
			System.out.println(i+"="+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);  ///스레드에 있는 메서드
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx2 {

	public static void main(String[] args) {
		System.out.println("main 스레드 시작");
		Runnable r = new Runnable1();
		
		Thread t1 =new Thread(r,"First"); //New 상태, t1이 병렬처리
		//r.run() 메서드를 실행하고, 이름이 First인  Thread 객체 생성
		Thread t2 =new Thread(r,"Second");//New 상태
		t1.start();
		t2.start();
		
		//    t1.run();// r.run() 실행됨. main이 나옴  스레드가 메인이기 때문에.
		
		System.out.println("main 스레드 종료");
	}

}
