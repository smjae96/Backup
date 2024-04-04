package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.practice.book.model.vo.Book;

public class BookDAO {

	private Book[] bArr = new Book[10];
	
	public void fileSave(Book[] bArr) {
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("book.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		ObjectOutputStream oos=null;
		
			try {
				oos = new ObjectOutputStream(fos);
				if(bArr != null) {
					oos.writeObject(bArr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally { 
					try {
						if(oos!= null) oos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

			
			

	}
	public Book[] fileRead() {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("book.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(fis);
			Object obj;
//			int i=0;
			for(int i=0; (obj = ois.readObject()) != null; i++) {
				bArr[i] = (Book)obj;
			}
//			while((obj = ois.readObject())!=null) { 
//				bArr[i] = (Book)obj;
//			}
		} catch (EOFException e) {
			//e.printStackTrace();
		}
		catch ( IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}  
		finally {
			if(ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return bArr;
	}
}
