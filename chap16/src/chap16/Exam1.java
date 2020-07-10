package chap16;
/*
 * ThreadEx3.java �ҽ��� Runnable ������� �����ϱ�
 * RunnablePriority
 */



class RunnablePriority implements Runnable{
	
	
	
	public void run() {
		try {
			Thread.sleep(200);
		}catch(InterruptedException e) {}
		for(int i =0; i<50;i++) {
			System.out.println(Thread.currentThread());
		}
	}
}


public class Exam1 {

	public static void main(String[] args) {
	System.out.println("���� �켱����:"+Thread.MAX_PRIORITY);	//10
	System.out.println("���� �켱����:"+Thread.MIN_PRIORITY);	//1   Ȯ���� ����.
	System.out.println("�⺻ �켱����:"+Thread.NORM_PRIORITY);	//5
	
	Runnable r = new RunnablePriority(); 
	
	Thread mt1 = new Thread(r,"First");
	Thread mt2 = new Thread(r,"Second");
	Thread mt3 = new Thread(r,"Third");
	mt1.setPriority(5);
	mt2.setPriority(1);
	mt3.setPriority(10);
	
	mt1.start();	mt2.start();	mt3.start();
	}

}
