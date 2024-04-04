package ncs.test1;

public class ArrayTest {
	public static void main(String[] args) {
		int[] array = new int[10];
		for(int i=0; i<array.length; i++) {
			int num = (int)(Math.random()*100+1);
			array[i] = num;
		}
		System.out.println("�Ҵ�� �迭�� ũ�� : " + array.length);
		System.out.print("array : ");
		print(array);
		System.out.println();
		System.out.println("���� ū �� : "+ max(array));
		System.out.println("���� ���� �� : " + min(array));
		System.out.println("¦���� ���� : " +evenCount(array) + "��");
		System.out.println("Ȧ���� ���� : " +oddCount(array) + "��");
		System.out.println("�հ� : " +sum(array) );
		System.out.printf("��� : %.2f",avg(array) );
		
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
