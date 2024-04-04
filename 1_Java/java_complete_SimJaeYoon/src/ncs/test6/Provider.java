package ncs.test6;

public class Provider extends Thread {
	private Data data;
	public Provider(Data data) {
		this.data = data;
	}
	@Override
	public synchronized void run() {
		for(int i=0; i<10; i++) {
			int num = (int)(Math.random()*100+1);
			data.setValue(num);
			System.out.println("값이 입력되었습니다.");
			System.out.println("put value :" +data.getValue(num));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}
