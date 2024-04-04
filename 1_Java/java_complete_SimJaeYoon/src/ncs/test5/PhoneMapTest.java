package ncs.test5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PhoneMapTest {

	public static void main(String[] args) {
		Map<String, Phone> map = new HashMap<String, Phone>();
		Phone p1 = new Phone("galaxy S7", 563500, "삼성", 7);
		Phone p2 = new Phone("iphone 6s", 840000, "애플", 3);
		Phone p3 = new Phone("G5", 563500, "LG", 5);
		
		map.put("galaxy S7", p1);
		map.put("iphone 6s", p2);
		map.put("G5", p3);
		
		for(Map.Entry<String, Phone> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " +entry.getValue());
		}
		Iterator<String> iterator = map.keySet().iterator();
		
		Properties prop = new Properties();
	
		while(iterator.hasNext()) {
			String key = iterator.next();
			prop.setProperty(key, map.get(key).toString());
		}
		
		try (OutputStream os = new FileOutputStream("phone.xml");) {
			prop.storeToXML(os, "phone 정보");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
