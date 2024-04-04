package com.kh.thread.sync;

class Counter {
	// ~count : int=0;
	int count = 0;
	
	// +increment() : void	=> count ���� 1 ����
	public void increment() {
		count++;
	}
	
	// +decrement() : void => count ���� 1 ����
	public void decrement() {
		count--;
	}
	
	// +getCount() : int => count ���� ��ȸ
	public int getCount() {
		return count;
	}
}

// ����ȭ �������� �ʰ� �׽�Ʈ
public class MutualAccess {
	// +cnt:Counter = new Counter(); (����)...
	public static Counter cnt = new Counter();	// ���� �ڿ����� ���� ���� static���� ����.
	
	// +main(args:String[]):void (����)
	public static void main(String[] args) {
		// Thread 2�� ����
		
		// ���ٽ��� ����Ͽ� Thread
		Runnable task1 = () -> {
			// run() �޼ҵ忡 �������� �۾�
			for(int i=0; i<100; i++) {
				cnt.increment();
			}
		};
		
		Runnable task2 = () -> {
			for(int i=0; i<100; i++) {
				cnt.decrement();
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);

		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(cnt.getCount());
	}
}
