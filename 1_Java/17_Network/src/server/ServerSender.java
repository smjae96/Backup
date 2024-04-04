package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class ServerSender implements Runnable {
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(1); 
				String msg = Main.msgQueue.poll();
				if(msg == null) continue;
				for(BufferedWriter bw : Main.bwList) {
					try {
						bw.write(msg);
						bw.newLine();
						bw.flush();
					} catch (SocketException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
