package ncs.test6;

public class MultiThreadTest {

	public static void main(String[] args) {
		Data data = new Data();	// ����������
		Thread putThread;
		Thread getThread;
		
		// data�� �����ϴ� Provider �� Customer ��ü ���� : Thread ��ü ������
		putThread = new Provider(data);
		getThread = new Customer(data);
		

		// ������ ����
		putThread.start();
		getThread.start();
	}

}
