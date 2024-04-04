package prop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Testing {
	
	public static void main(String[] args) {
	Properties prop = new Properties();
	Properties prop2 = new Properties();
	prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
	prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
	prop.setProperty("username", "C##JDBC");
	prop.setProperty("password", "JDBC");
	
	prop2.setProperty("insertMember", "INSERT INTO MEMBER "
			+ "VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE");
	prop2.setProperty("selectAllList", "SELECT * FROM MEMBER");
	prop2.setProperty("searchId", "SELECT * FROM MEMBER WHERE USERID = ?");
	prop2.setProperty("searchByName", "SELECT * FROM MEMBER WHERE USERNAME LIKE ?");
	prop2.setProperty("updateMember", "UPDATE MEMBER SET USERPW = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE"
						+ "USERID = ?");
	prop2.setProperty("deleteMember", "DELETE FROM MEMBER WHERE USERID = ?");
	
	
	try {
		prop.store(new FileOutputStream("resources/driver.properties"), "driver.properties");
		prop2.storeToXML(new FileOutputStream("resources/query.xml"), "query.xml");
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	try {
		prop.load(new FileInputStream("resources/driver.properties"));
		prop2.loadFromXML(new FileInputStream("resources/query.xml"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
