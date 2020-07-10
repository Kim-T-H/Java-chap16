package chap16;
/*
 * 동기화:synchronized 예약어로 표현됨
 * 	동기화블럭:ThreadEx9.java
 * 		lock 객체를 소유한 스레드만 동기화 영역을 실행 할 수 있음.
 * 		lock 은 객체이어야 함. 기본자료형은 lock 사용 불가
 * 		lock 객체는 유일해야함. 모든스레드가 공유하는 공유 객체여야함.(static을 붙여야됨.)
 * 	동기화메서드: ThreadEx10.java
 * 
 */

class PrintThread2 extends Thread{
	char ch;
	static Object Lock=new Object();	//static 필수
	//static int Lock=0; 기본형은  lock 사용불가     static Integer Lock=0; 사용가능  static int[] Lock={}; 배열은 사용가능
	PrintThread2(char ch){
		this.ch=ch;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			synchronized (Lock) {	//t1이 가지고갔다.   동기화 블럭
				for(int j=0; j<80;j++) {
					System.out.print(ch);
				}
					System.out.println();
			}
		}
	}
}
public class ThreadEx9 {

	public static void main(String[] args) {
		PrintThread2 t1= new PrintThread2('A');
		PrintThread2 t2= new PrintThread2('B');//lock pool 대기상태
		PrintThread2 t3= new PrintThread2('C');//lock pool 대기상태
		t1.start(); t2.start(); t3.start();

	}

}
