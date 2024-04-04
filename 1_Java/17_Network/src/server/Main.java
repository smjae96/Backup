package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static Queue<String> msgQueue = new LinkedList<>();		// Queue�� �� ���� �׻� LinkedList��
	public static List<BufferedWriter> bwList = new ArrayList<>();
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(12345);
			
			new Thread(new ServerSender()).start();
			
			while(true) {
				System.out.println("���� ����� ...");
				Socket s = ss.accept();
				System.out.println(s.getInetAddress() + " �����...");
				
				new Thread(new ServerReader(s)).start();
				bwList.add(new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "utf-8")));

			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	
	
	
}
