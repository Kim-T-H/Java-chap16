package chap16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DataAddThread extends Thread {
	List<String> words;
	String[] data;
	int interval;

	public DataAddThread(List<String> words, String[] data, int interval) {
		this.words = words;
		this.data = data;
		this.interval = interval;
	}

	public void run() {
		while (true) {
			try {
				sleep(interval);
			} catch (InterruptedException e) {}
			words.add(data[(int) (Math.random() * data.length)]);
		}
	}
}

public class answer13 {

	public static void main(String[] args) {
		String[] data = { "태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카" };
		List<String> words = new ArrayList<String>();
		int interval = 3 * 1000;
		Scanner scan = new Scanner(System.in);
		words.add(data[0]);
		DataAddThread t1 = new DataAddThread(words, data, interval);
		t1.setDaemon(true);
		t1.start(); // run() 메서드: interval 만큼 대기하다가 임의의 이름을 words에 추가
		while (true) {
			System.out.println(words);
			System.out.println(">>");
			String input = scan.next().trim();
			words.remove(input);
			if (words.size() == 0)
				break;
		}
		System.out.println("프로그램 종료");

	}

}
