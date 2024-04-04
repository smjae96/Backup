package com.kh.thread.sync;

// ����ȭ ó�� : �޼ҵ� ��ü, �޼ҵ� �� ���� �κ�(��). synchronized(������ü) { .. }
// -> ��� ���� �ڿ�(������)�� �ٸ� �����尡 �������� ���ϵ��� �ϴ� ��.
//	  �����Ͱ� ����Ǵ� ��ġ�� ó��
class CounterSyncBlock {
	// ~count : int=0;
	int count = 0;
	
	// +increment() : void	=> count ���� 1 ����
	public void increment() {
		synchronized(this) { // (�Ű�����) �ڸ��� ���� ��ü�� ���� ��. Ŭ���� ��ü�� ������ü�̹Ƿ� this ���.
		count++;
		}
	}
	
	/**********************
	 * �޼ҵ忡 ����ȭ ó�� ����	(�� �� ����)
	 * [1]
	  	synchronized public void increment() {		
	  		count++;
	  	}
	 * [2]
	 	public synchronized void increment() {
	 		count++;
	 	}	
	 */
	
	// +decrement() : void => count ���� 1 ����
	public void decrement() {
		synchronized(this) {
		count--;
		}
	}
	
	// +getCount() : int => count ���� ��ȸ
	public int getCount() {
		return count;
	}
}
public class MutualAccessSync {
	static CounterSyncBlock csb = new CounterSyncBlock();	// ���� �ڿ����� ���� ���� static���� ����.
	
	public static void main(String[] args) {
		Runnable task1 = () -> {
			for(int i=0; i<500; i++) {
				csb.increment();
			}
		};
		Runnable task2 = () -> {
			for(int i=0; i<500; i++) {
				csb.decrement();
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		// ������ ����
		t1.start();
		t2.start();
		// ���ν����尡 �Ʒ� ��������� �۾� ������� ��ٸ����� ó�� : .join()
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		System.out.println(csb.getCount());
	}
	
}
