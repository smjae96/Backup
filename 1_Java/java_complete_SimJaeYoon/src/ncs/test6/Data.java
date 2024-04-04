package ncs.test6;

public class Data {
	private int value;
	private boolean isEmpty = true;
	
	public Data() {
		
	}
	public synchronized void setValue(int value) {
		if(isEmpty) {
			this.value = value;
			isEmpty = false;
		}
	}
	public synchronized int getValue(int index) {
	//	System.out.printf("======> getValue request(%d) : value(%d) \n", index, value);
		
		if(!isEmpty) {
			isEmpty = true;
			return value;
		} else {
			new EmptyException("현재 입력된 값이 없습니다. 기다리십시오." + index);
			return 0;
		}
		
		
	}
}
