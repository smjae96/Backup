package com.kh.thread;

public class ThreadPractice {
	/*
	 * ������ : ���μ��� �� �۾� ����
	 * 			- ���μ��� : �������� ���α׷�
	 * * �̱� ������ : �� ���μ��� ���� �ϳ��� ������ ����
	 * * ��Ƽ ������ : �� ���μ��� ���� ���� ���� ������ ����
	 * 
	 * * ������ ����
	 * 
	 * 		[1] Thread Ŭ������ ����Ͽ� ����
	 * 			// Thread Ŭ���� ���
	 * 		ex)	public class Sender extends Thread {
	 * 				// run �޼ҵ� �������̵�
	 * 				@Override
	 * 				public void run() {
	 * 					// ������� ������ �۾�
	 * 				}
	 * 			}
	 * 
	 * 		// �ٸ� Ŭ���� �� �޼ҵ忡�� �����
	 * 		Sender sThread = new Sender();
	 * 		sThread.start();			// ������ ����
	 * 
	 * 		[2] Runnable �������̽��� �����Ͽ� ����	=> ��ȣ�ϴ� ��� ( �ڹٿ����� ���� ��Ӹ� �����ϹǷ�, �ٸ� Ŭ���� ����� �����ϱ� ����! )
	 * 			// Runnable �������̽� ����
	 * 		ex) public class Receiver implements Runnable {
	 * 				// run �޼ҵ� �������̵�
	 * 				@Override
	 * 				public void run() {
	 * 					// ������� ������ �۾�
	 * 				}
	 * 			}
	 * 
	 * 		// �ٸ� Ŭ���� �� �޼ҵ忡�� �����
	 * 		Receiver task = new Receiver();
	 * 		Thread thread1 = new Thread(task);
	 * 		thread1.start();				// ������ ����
	 */
}
