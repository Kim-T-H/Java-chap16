package chap16;
/*
 * 동기화영역
 * 	동기화 블럭: ThreadEx9.java
 * 	동기화 메서드: ThreadEx10.java
 * 		1.공유 객체의 메서드여야함.
 * 		2.공유 객체: 모든 스레드가 하나의 객체를 공유하고 있는 객체!!!!!!!
 */

class Printer {
	//t1
	public synchronized void printChar(char ch) {	//동기화 메서드
		for (int i = 0; i < 80; i++) {		//가로로 80칸
			System.out.print(ch);
		}
		System.out.println();
	}
}

class PrintThread3 extends Thread {
	Printer ptr;
	char ch;

	PrintThread3(Printer ptr, char ch) {
		this.ptr = ptr;
		this.ch = ch;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			ptr.printChar(ch);
		}
	}
}

public class ThreadEx10 {

	public static void main(String[] args) {
		Printer ptr = new Printer();
		Thread t1 = new PrintThread3(ptr, 'A');
		Thread t2 = new PrintThread3(ptr, 'B');
		Thread t3 = new PrintThread3(ptr, 'C');
//		Thread t1 = new PrintThread3(new Printer(), 'A');
//		Thread t2 = new PrintThread3(new Printer(), 'B');		//각각의 Printer 객체라서 뒤죽박죽 섞임.
//		Thread t3 = new PrintThread3(new Printer(), 'C');

		t1.start();
		t2.start();
		t3.start();
	}

}
