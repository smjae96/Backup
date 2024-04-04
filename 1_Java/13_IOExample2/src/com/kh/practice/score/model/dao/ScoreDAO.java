package com.kh.practice.score.model.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ScoreDAO {

	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		DataOutputStream dos =  null;
		dos =  new DataOutputStream(System.out);
		try {
			dos.writeChars(name);
			dos.write(kor);
			dos.write(eng);
			dos.write(math);
			dos.write(sum);
			dos.writeDouble(avg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dos != null)
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		
		
	}
	public DataInputStream readScore() throws FileNotFoundException {
		DataInputStream dis = null;
		dis = new DataInputStream(System.in);
		try {
			dis.read();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dis != null)
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return dis;
	}
}
