package run;

import variablepractice.VariablePractice1plus;
public class Run {

	public static void main(String[] args) {
		VariablePractice1plus vc1 = new VariablePractice1plus();
		//vc1.example1();
		
		String a = "���ξ���, ���, �ٳ���, ����, ����, ����, ���ξ���, Ű��, �丶��, ����丶��, ��, ��, ��, ������";
		String[]b = a.split(", ");
		int j =0;
		for(int i = 0; i<b.length; i++) {
			
			if (b[i].equals("���ξ���")) {
				j++;
			} else {
				
			}
			
		}
		System.out.println("���ξ����� ã�ҽ��ϴ�. �� ���� " +j);
		
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
