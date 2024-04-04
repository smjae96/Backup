package ncs.test6;

public class MultiThreadTest {

	public static void main(String[] args) {
		Data data = new Data();	// 공유데이터
		Thread putThread;
		Thread getThread;
		
		// data를 공유하는 Provider 와 Customer 객체 생성 : Thread 객체 생성함
		putThread = new Provider(data);
		getThread = new Customer(data);
		

		// 쓰레드 구동
		putThread.start();
		getThread.start();
	}

}
