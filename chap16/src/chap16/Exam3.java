package chap16;
/*
 * 1부터 500 까지의 합구하기
 * Thread 클래스를 상속받은 SumThread 클래스를 구현하기
 * Runnable 인터페이스의 구현클래스 SumRunnable 클래스를 구현하기
 */
class SumRunnable implements Runnable{
	int sum,start,end;
	SumRunnable(int start, int end){
		this.start=start;
		this.end=end;
	}
	public void run() {
		for(int i=start;i<=end;i++)
			sum+=i;
	}
}
public class Exam3 {

	public static void main(String[] args) throws InterruptedException {
		SumRunnable[] rarr = new SumRunnable[5];
		Thread[] tarr =new Thread[5];

		
		for(int i=0; i<rarr.length;i++) {
			rarr[i]=new SumRunnable((i*100)+1,(i+1)*100);
			tarr[i]=new Thread(rarr[i]);
			tarr[i].start();
			
		}
		
		int sum=0;
		for(int i=0;i<rarr.length;i++) {
			tarr[i].join();	//Thread 종료할때까지 main대기
			sum+=rarr[i].sum;
		}
//		arr[0] = new SumThread(1, 100);
//		arr[1] = new SumThread(101, 200);
//		arr[2] = new SumThread(201, 300);
//		arr[3] = new SumThread(301, 400);
//		arr[4] = new SumThread(401, 500);	
		
//		Thread t0=new Thread(arr[0]);
//		Thread t1=new Thread(arr[1]);
//		Thread t2=new Thread(arr[2]);
//		Thread t3=new Thread(arr[3]);
//		Thread t4=new Thread(arr[4]);
//		t0.start(); t1.start(); t2.start();	t3.start();	t4.start();
//		try {
//			t0.join(); t1.join(); t2.join(); t3.join(); t4.join();
//		}catch(Exception e){}
//		
//		for(SumThread s: arr) {
//	
//		sum += s.sum;
//		}
//	System.out.println("1~500까지의 합:"+sum);
//	}
	System.out.println("1~500까지의 합:"+sum);
}
}
