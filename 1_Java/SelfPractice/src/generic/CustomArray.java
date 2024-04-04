package generic;

public class CustomArray <T> {

	// public - protected - default - private
	protected Object[] arr = new Object[10];
	
	public void add(Object element) {}
	
	public void remoave(Object element) {}
	
	public T get(int idx) {
		return (T)arr[idx];		// arr[idx] 데이터 타입이 Object 타입이므로 T 타입으로 형변환
	}
	
	public int find(Object element) {
		return 0;
	}
	
	public void print() {
		
	}
	
	
}
