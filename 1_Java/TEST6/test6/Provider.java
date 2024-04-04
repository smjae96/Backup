package ncs.test6;

public class Provider extends Thread {
	private Data data;
	
	public Provider(Data data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			int num = (int)(Math.random()*100+1);
			System.out.printf("======> setValue before request (%d)\n", i);
			
			data.setValue(num, i);
//			System.out.println("값이 입력되었습니다.");
//			System.out.println("put Value: " + num);
			
			System.out.printf("값이 입력되었습니다.\nput value: %d\n", num);
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
