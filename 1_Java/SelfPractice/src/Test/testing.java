package Test;

public class testing {

	public static void main(String[] args) {
		int j = 1;
		int k = 4;
		j++;
		
		System.out.println(j+k);
		System.out.println(math(4));
	}
	
	public static int math(int x) {
		int j = 1;
		
		if(x ==4) {
			j++;
		}
		
		return j+x;
	}

}
