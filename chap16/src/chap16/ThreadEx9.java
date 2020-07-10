package chap16;
/*
 * ����ȭ:synchronized ������ ǥ����
 * 	����ȭ��:ThreadEx9.java
 * 		lock ��ü�� ������ �����常 ����ȭ ������ ���� �� �� ����.
 * 		lock �� ��ü�̾�� ��. �⺻�ڷ����� lock ��� �Ұ�
 * 		lock ��ü�� �����ؾ���. ��罺���尡 �����ϴ� ���� ��ü������.(static�� �ٿ��ߵ�.)
 * 	����ȭ�޼���: ThreadEx10.java
 * 
 */

class PrintThread2 extends Thread{
	char ch;
	static Object Lock=new Object();	//static �ʼ�
	//static int Lock=0; �⺻����  lock ���Ұ�     static Integer Lock=0; ��밡��  static int[] Lock={}; �迭�� ��밡��
	PrintThread2(char ch){
		this.ch=ch;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			synchronized (Lock) {	//t1�� ��������.   ����ȭ ��
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
		PrintThread2 t2= new PrintThread2('B');//lock pool ������
		PrintThread2 t3= new PrintThread2('C');//lock pool ������
		t1.start(); t2.start(); t3.start();

	}

}
