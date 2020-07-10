package chap16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *  1. 타자 연습 게임 프로그램 구현하기
  String[] data = { "태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카" };
  List<String> words = new ArrayList<String>();
  3초에 한번씩 words에 data 중 임의의 이름을 추가하기. 
    => 스레드(DataAddThread)로 작성.
       DataAddThread 스레드는 데몬 스레드로 설정하기
   화면에 입력된 이름과, words에 저장된 이름이 같은 경우 words에서 입력된 이름을 삭제한다.
  words에 모든 데이터가 삭제 되면 프로그램을 종료한다. 
 */
class DataAddThread extends Thread {
	String[] data = { "태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카" };
	List<String> words = new ArrayList<String>();

	public void run() {
		while (true) {
			int rand = (int) (Math.random() * data.length);
			words.add(data[rand]);
			try {
				sleep(3000);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class test22 {

	public static void main(String[] args) {

		DataAddThread t = new DataAddThread();
		t.setDaemon(true);
		t.start();
		Scanner scan = new Scanner(System.in);
		while (t.words.size() !=0) {
			System.out.println(t.words);
			String name = scan.next();
			for (int i = 0; i < t.words.size(); i++) {
				if (name.equals(t.words.get(i))) {
					t.words.remove(i);
				}
			}
			
		}
		System.out.println("프로그램 종료");
	}
	
}
