package generic;

public class CustomArray <T> {

	// public - protected - default - private
	protected Object[] arr = new Object[10];
	
	public void add(Object element) {}
	
	public void remoave(Object element) {}
	
	public T get(int idx) {
		return (T)arr[idx];		// arr[idx] ������ Ÿ���� Object Ÿ���̹Ƿ� T Ÿ������ ����ȯ
	}
	
	public int find(Object element) {
		return 0;
	}
	
	public void print() {
		
	}
	
	
}
