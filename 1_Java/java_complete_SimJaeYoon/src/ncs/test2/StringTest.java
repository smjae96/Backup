package ncs.test2;

public class StringTest {

	public static void main(String[] args) {
		String str = " A, b, c, D, a, B, C, d, f, F";
		String[] st = str.split(", ");
		char[] data = new char[st.length];
//		for(int i=0; i<st.length; i++) {
//			data = st[i].toCharArray();
//			System.out.print(data);
//		}

		int count = 0;
		for(String s : st) {
			data[count] = s.trim().charAt(0);
			count++;
		}
//		int count = 0;
//		while(count<data.length) {
//				if(!Character.isUpperCase(data[count])) {
//						
//						continue;
//				} else {
//					System.out.println("data["+count+"] : " + data[count]);
//				}
//				count++;
//			
//		}
		int idx = 0;
		while(idx < data.length) {
			if(Character.isUpperCase(data[idx])) {
				System.out.println("data["+idx+"] : " +data[idx]);
			}
			idx++;
		}
		
//		for(int i=0; i<data.length; i++) {
//			if(Character.isUpperCase(data[i])) {
//				System.out.println(data[i]);
//			}
//		}	
	}	
}
