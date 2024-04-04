package prop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Testing {
	
	public static void main(String[] args) {
	Properties prop = new Properties();
	
	prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
	prop.setProperty("url", "jdbc:oracle:tin:@localhos:1521:xe");
	prop.setProperty("username", "C##JDBC");
	prop.setProperty("password", "JDBC");
	
	try {
		FileOutputStream fos = new FileOutputStream("driver.properties");
		prop.store(fos, "driver.properties");
		
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		
	}
	
	try {
		prop.load(new FileInputStream("driver.properties"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
