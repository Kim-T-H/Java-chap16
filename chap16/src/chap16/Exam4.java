package chap16;
/*
 * CarMarket Ŭ����: �ڵ��� �Ǹż�
 * ��� ����: String car;
 * ����޼��� 
 * synchronized void push()
 * 	car = {"�ҳ�Ÿ","SM5","�׷���", "���׽ý�", "K9"} �� �Ѱ��� car�� ����
 * 	car == null �� ��츸 ���� ������.
 * 	car != null �� ���� wait ���·� ����
 * synchronized void pop()
 * 	car==null wait ���·� ����
 * 	car != null car + �ǸſϷ� �޼��� ����ϰ�, car = null ��ȯ.
 */
class CarMarket {
	String car;	
	synchronized void push() {
		String []cars= {"�ҳ�Ÿ","SM5","�׷���","���׽ý�","K9"};
		while(car!=null) {
			try {
				wait();
			}catch (InterruptedException e) {}
		}
		car = cars[(int)(Math.random()*cars.length)];
		notifyAll();
		System.out.println(Thread.currentThread().getName() + ":" + car + "�԰��Ϸ�");
	}
	
	synchronized void pop() {
		while(car==null) {
			try {
				wait();
			}catch (InterruptedException e) {}
		}
		notifyAll();
		System.out.println(Thread.currentThread().getName() + ":" + car + "�ǸſϷ�");
		car=null;
	}
}

class Seller extends Thread{
	CarMarket market; //Ŭ���� ��üȭ
	Seller(CarMarket market){
		super("�Ǹ���");
		this.market=market;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			market.pop();
			try {
				sleep((int)(Math.random()*2000));
			}catch(InterruptedException e) {}
		}
	}
}

class Producer extends Thread{
	CarMarket market;
	Producer(CarMarket market){
		super("������");
		this.market=market;
	}
	public void run() {
		for(int i = 0;i<20;i++);{
			market.push();
		try {
			sleep((int)(Math.random()*5000));
		}catch(InterruptedException e) {}
	}
}
}



public class Exam4 {

	public static void main(String[] args) {
		CarMarket market =new CarMarket();
		Seller s = new Seller(market);
		Producer p = new Producer(market);
		s.start(); p.start();

	}

}