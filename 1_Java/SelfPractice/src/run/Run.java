package run;

import variablepractice.VariablePractice1plus;
public class Run {

	public static void main(String[] args) {
		VariablePractice1plus vc1 = new VariablePractice1plus();
		//vc1.example1();
		
		String a = "파인애플, 사과, 바나나, 포도, 수박, 레몬, 파인애플, 키위, 토마토, 방울토마토, 배, 감, 귤, 오렌지";
		String[]b = a.split(", ");
		int j =0;
		for(int i = 0; i<b.length; i++) {
			
			if (b[i].equals("파인애플")) {
				j++;
			} else {
				
			}
			
		}
		System.out.println("파인애플을 찾았습니다. 그 값은 " +j);
		
		String str = "hi";
		String str2 = new String("hi");
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode("hi"));
		System.out.println(System.identityHashCode(str2));
		if(str == "hi") {
			System.out.println("true");
		}
	}	
}
