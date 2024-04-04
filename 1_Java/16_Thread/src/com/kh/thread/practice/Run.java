package com.kh.thread.practice;

public class Run {

	public static void main(String[] args) {
		// ���� ������ : �ٸ� ������ �����ϴ� ������ �ϴ� ������.
		// 			  �ٸ� ��������� ����Ǹ� ������ �����.
		System.out.println("---- ���α׷� ���� -----");
		ThreadClass daemon = new ThreadClass("daemon");
		daemon.setDaemon(true);	// ���� ������ ����
		daemon.start();
		try {
			daemon.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("---- ���α׷� ���� ----");
	}
	
	
	public static void threadTest02() {	
		// Thread ��ü 3�� ����
		ThreadClass t1 = new ThreadClass("������1");
		ThreadClass t2 = new ThreadClass("������2");
		ThreadClass t3 = new ThreadClass("������3");
		
		//t3 �����尡 ���� ���� �����ϵ��� ó��
		//	setPriority(�켱������) : �켱���� �⺻ ��(5)
		t1.setPriority(1);
		t2.setPriority(5);
		t3.setPriority(10);
		
		
		t1.start();
		t2.start();
		t3.start();
	}
	public static void threadTest01() {	
		System.out.println("** ���α׷� ���� **");
		// 1. Thread Ŭ������ ������� ���
		Thread tc = new Thread();
		tc.start();
		
		//2. Runnable �������̽��� ������ ���
		ThreadInterface ti = new ThreadInterface();
		Thread t2 = new Thread(ti);
		t2.start();
		
		// main �����尡 t2 �������� �۾��� ��ٸ��� �Ϸ���? .join()
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("** ���α׷� ���� **");
		
		// main��������� �� 3���� �۾��� �и��Ǿ� ���ÿ� ����ǰ� �ִ�!
	}

}
