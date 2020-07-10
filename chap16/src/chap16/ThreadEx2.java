package chap16;
/*
 * Runnable �������̽��� �����Ͽ� ������ �����ϱ�
 */
class Runnable1 implements Runnable{	//Thread Ŭ���� �ƴ�. Runnable �������̽��� ����Ŭ������
	@Override
	public void run() {
		for(int i=0; i<5;i++) {
			//Thread.currentThread(): �������� Running ������ ������ ��ü
			System.out.println(i+"="+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);  ///�����忡 �ִ� �޼���
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx2 {

	public static void main(String[] args) {
		System.out.println("main ������ ����");
		Runnable r = new Runnable1();
		
		Thread t1 =new Thread(r,"First"); //New ����, t1�� ����ó��
		//r.run() �޼��带 �����ϰ�, �̸��� First��  Thread ��ü ����
		Thread t2 =new Thread(r,"Second");//New ����
		t1.start();
		t2.start();
		
		//    t1.run();// r.run() �����. main�� ����  �����尡 �����̱� ������.
		
		System.out.println("main ������ ����");
	}

}
