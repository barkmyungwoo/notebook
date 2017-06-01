package ncs.test5;

import java.io.FileOutputStream;
import java.util.*;

public class PhoneMapTest {

	public static void main(String[] args) {
		Map<String, Phone> map = new HashMap<String, Phone>();
		Properties prop = new Properties();

		// Phone 객체를 3개 생성하여 맵에 모델을 key로 객체를 저장한다.
		map.put("galaxy S7", new Phone("galaxy S7", 563500, "삼성", 7));
		map.put("iphone 6s", new Phone("iphone 6s", 840000, "애플", 3));
		map.put("G5", new Phone("G5", 563500, "LG", 5));

		// 맵에 저장된 객체 정보를 연속 출력 한다.– Map.EntrySet<String, Phone> 사용할 것
		Iterator kit = map.keySet().iterator();		//2줄을 1줄로 
		
		while (kit.hasNext()) {
			Object kob = kit.next();
			System.out.println(kob+" : "+map.get(kob));

			prop.setProperty(kob+"", map.get(kob)+"");
		}

		try {
			prop.storeToXML(new FileOutputStream("phone.xml"), "what the.... hell...");
			System.out.println("xml 저장완료!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
