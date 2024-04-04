package IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOselfPractice {
	public static void main(String[] args) {
		InputStream in;
		in=System.in;
		try {
			int a = in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileInputStream in1 = (FileInputStream) System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("문자열을 입력하세요. : ");
			String[] s = reader.readLine().split(" ");
			for(String item : s) {
				System.out.print(item);
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
