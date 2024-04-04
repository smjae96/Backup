package com.kh.thread.practice2;

public class TestThread {
	// - Thread Ŭ������ ��Ƽ ������(��Ƽ ������ ������� ����)
	public static void main(String[] args) {
		Runnable i = new Increment(30);
		Thread t1 = new Thread(i);
		Runnable d = new Decrement(15, 2);
		Thread t2 = new Thread(d);
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Runnable task3 = () -> {	// ���ٽ��� �̿��ϸ� ThreadŬ������ ����ų�, Runnable �������̽��� ������ Ŭ������ ���� �ʿ� ���� 
									// main�޼ҵ忡�� �ٷ� ������ ���� �� ���� ����.
			System.out.println("������");
		};
		
		Thread t3 = new Thread(task3);
		t3.start();
		
		Thread t4 = new Thread(() -> {
			System.out.println("���ٽ� �����");
		});
		t4.start();
	}
}
