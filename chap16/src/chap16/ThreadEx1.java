package chap16;
/*
 * Thread ����1
 * Thread ����
 * 		1.Thread Ŭ���� ��� =>ThreadEx1.java
 * 		2.Runnable �������̽� ����=> ThreadEx2.java
 * 
 *�������� �켱 ���� ������ ���Ҽ� ����.
 */

class Thread1 extends Thread{ //Thread
	Thread1(String name){
		super(name);
	
	}
	public void run() {		//Running ����. ��Ȯ�ϰ� ����.
		for(int i=0; i<5;i++) {
			System.out.println(i+"="+getName());	//getName(): ������ �̸�
			try {
				sleep(1000);//1�ʴ��, ��� ����, ���� Runnable ���·� ��ȯ
			}catch(InterruptedException e) {}
		}
	}
}//Dead ����. Thread ����

public class ThreadEx1 {

	public static void main(String[] args) {	//main �� ��������.
		System.out.println("main ������ ����");
		Thread1 t1 =new Thread1("First");// New ����
		Thread1 t2 =new Thread1("second");// New ����
		//t1.run  // ��� ȣ��
		
		t1.start();	//Runnable ����
		t2.start();	//Runnable ����
		/*
		 * start() �޼��� ���
		 * 1.���� ������ ����ȭ ��.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * 2.����ȭ�� ���ÿ� run() �޼��� ȣ����.
		 */
		
		
		System.out.println("main ������ ����");
		

	}

}
