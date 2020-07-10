package chap16;
/*
 * 데몬스레드:
 * 1.일반스레드의 보조역할 담당함. 보통 무한 반복처리를 함.
 * 2.일반스레드가 종료되면, 데몬 스레드도 자동 종료됨.
 * 3.설정 setDaemon(true)=>New 상태에서만 설정이 가능. 만약 Runnable 상태에서 설정이 된 경우 예외 발생.(IllegalThreadStateException)
 * 
 */
class DaemonThread extends Thread{
	public void run() {
		while(true) {
			System.out.println(getName());
			try {
				sleep(100);
			}catch(InterruptedException e) {}
		}
	}
}

public class ThreadEx7 {

	public static void main(String[] args) throws InterruptedException {
	Thread t1 = new DaemonThread();//객체화시 New 상태
	Thread t2 = new DaemonThread();
	t1.setDaemon(true);//데몬 스레드 설정, New 상태에서 설정이 되어야함.
	t2.setDaemon(true);//데몬 스레드 설정
	t1.start(); t2.start();	//자기 이름만 출력하면서 0.1초씩쉼
	Thread.sleep(2000);
	System.out.print("main 스레드 종료");
	}

}
