package com.kh.hospital_reception.model.vo;

public class StringArray2<T>  {

	protected Object[] arr = new Object[10];
	


	public void add(Object element) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == null) {
				arr[i] = element;
				break;
			}
			
		}
//		for(int i=0; i<arr.length; i++) {
//			if(arr == null) {
//				arr[i] = element;
//			}
//		}
	}

	public void remove(Object element) {
		Object[] arrR = new Object[arr.length];
		int index = 0;
		for(int i =0; i<arr.length; i++) {
			if(arr[i] != null && !arr[i].equals(element)) {
				arrR[index] = arr[i];
				index++;
			}
		}
		arr = arrR;
		
	}
	// get 메소드에 타입 매개변수 적용
	
	public T get(int idx) {
//		for(int i=0; i<arr.length; i++) {
//			t = arr[i]
//				
//		}
		return (T)arr[idx];		// arr[idx] 데이터 타입이 Object 타입이므로 T 타입으로 형변환
	}

	public int find(Object element) {
		int index = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals(element)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void print() {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] !=null) {
				System.out.println(i+1 +"번째 책 : " +arr[i]);
			}	
		}
	}
	
}
