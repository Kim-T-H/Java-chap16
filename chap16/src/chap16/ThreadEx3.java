package chap16;

class ThreadPriority extends Thread{
	ThreadPriority(String name , int p){
	super(name);	//스레드의 이름을 설정
	setPriority(p);	//p로 우선 순위 결정. (1~10값)
}
	public void run() {
		try {
			sleep(20);
		}catch(InterruptedException e) {}
		for(int i =0; i<50;i++) {
			System.out.println(this); //this: ThreadPriority 객체
										//Thread[First,5,main]:Thread[스레드이름, 우선수위, 스레드그룹]
		}
	}
}
public class ThreadEx3 {

	public static void main(String[] args) {
		System.out.println("높은 우선순위:"+Thread.MAX_PRIORITY);	//10
		System.out.println("낮은 우선순위:"+Thread.MIN_PRIORITY);	//1   확률이 낮다.
		System.out.println("기본 우선순위:"+Thread.NORM_PRIORITY);	//5
		Thread t1 = new ThreadPriority("First",5);
		Thread t2 = new ThreadPriority("Second",1);
		Thread t3 = new ThreadPriority("Third",10);
		t1.start(); t2.start(); t3.start();
	}

}
