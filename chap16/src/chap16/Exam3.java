package chap16;
/*
 * 1���� 500 ������ �ձ��ϱ�
 * Thread Ŭ������ ��ӹ��� SumThread Ŭ������ �����ϱ�
 * Runnable �������̽��� ����Ŭ���� SumRunnable Ŭ������ �����ϱ�
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
			tarr[i].join();	//Thread �����Ҷ����� main���
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
//	System.out.println("1~500������ ��:"+sum);
//	}
	System.out.println("1~500������ ��:"+sum);
}
}
