package chap16;
/*
 * 1부터 500 까지의 합구하기
 * Thread 클래스를 상속받은 SumThread 클래스를 구현하기
 * 
 */

class SumThread extends Thread {
	public int sum;
	int a, b;

	SumThread(int i, int j) {
		this.a = i;
		this.b = j;
	}

	public void run() {
		for (int i = a; i <= b; i++) {
			sum += i;
		}
	}

}

public class Exam2 {
	public static void main(String[] args) {
		SumThread[] arr = new SumThread[5];
		arr[0] = new SumThread(1, 100);
		arr[1] = new SumThread(101, 200);
		arr[2] = new SumThread(201, 300);
		arr[3] = new SumThread(301, 400);
		arr[4] = new SumThread(401, 500);
		int sum = 0;

		for (SumThread t : arr) {
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum += t.sum;
		}
		
		System.out.println("1~500까지의 합:" + sum);
	}

}
