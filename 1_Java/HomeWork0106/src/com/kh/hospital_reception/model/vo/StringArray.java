package com.kh.hospital_reception.model.vo;

public class StringArray implements ArrayAction {

	protected String[] arr = new String[10];
	
	@Override
	public void add(String element) {
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

	@Override
	public void remove(String element) {
		String[] arrR = new String[arr.length];
		int index = 0;
		for(int i =0; i<arr.length; i++) {
			if(arr[i] != null && !arr[i].equals(element)) {
				arrR[index] = arr[i];
				index++;
			}
		}
		arr = arrR;
		
	}

	@Override
	public String get(int idx) {
		
		return arr[idx];
	}

	@Override
	public int find(String element) {
		int index = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals(element)) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public void print() {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] !=null) {
				System.out.print(arr[i]);
			}	
		}
	}

}
