package ncs.test1;

public class ArrayTest {
	public static void main(String[] args) {
		int[] array = new int[10];
		for(int i=0; i<array.length; i++) {
			int num = (int)(Math.random()*100+1);
			array[i] = num;
		}
		System.out.println("할당된 배열의 크기 : " + array.length);
		System.out.print("array : ");
		print(array);
		System.out.println();
		System.out.println("가장 큰 값 : "+ max(array));
		System.out.println("가장 작은 값 : " + min(array));
		System.out.println("짝수의 개수 : " +evenCount(array) + "개");
		System.out.println("홀수의 개수 : " +oddCount(array) + "개");
		System.out.println("합계 : " +sum(array) );
		System.out.printf("평균 : %.2f",avg(array) );
		
	}
	
	public static int sum(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	public static double avg(int[] arr) {
		int sum = 0;
		double avg = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			avg = (double)sum / arr.length;
		}
		return avg;
	}
	
	public static int max(int[] arr) {
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static int min(int[] arr) {
		int min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		return min;
	
	}
	
	public static int evenCount(int[] arr) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] %2 == 0) {
				count++;
			}
		}
		return count;
	}
	
	public static int oddCount(int[] arr) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] %2 == 1) {
				count++;
			}
		}
		return count;
	}
	
	public static void print(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
