package chap16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *  1. Ÿ�� ���� ���� ���α׷� �����ϱ�
  String[] data = { "�¿�", "����", "����", "ȿ��", "����", "����", "Ƽ�Ĵ�", "���", "����ī" };
  List<String> words = new ArrayList<String>();
  3�ʿ� �ѹ��� words�� data �� ������ �̸��� �߰��ϱ�. 
    => ������(DataAddThread)�� �ۼ�.
       DataAddThread ������� ���� ������� �����ϱ�
   ȭ�鿡 �Էµ� �̸���, words�� ����� �̸��� ���� ��� words���� �Էµ� �̸��� �����Ѵ�.
  words�� ��� �����Ͱ� ���� �Ǹ� ���α׷��� �����Ѵ�. 
 */
class DataAddThread extends Thread {
	String[] data = { "�¿�", "����", "����", "ȿ��", "����", "����", "Ƽ�Ĵ�", "���", "����ī" };
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
		System.out.println("���α׷� ����");
	}
	
}
