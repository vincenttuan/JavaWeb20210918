package service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import entity.Covid;

public class CovidService {
	private static List<Covid> covids;
	
	static {
		covids = new CopyOnWriteArrayList(); // thread-safe
		// 加入預設資料
		covids.add(new Covid("A111111111", "AZ"));
		covids.add(new Covid("B222222222", "BNT"));
		covids.add(new Covid("C333333333", "MVC"));
	}
	
	public void append(Covid covid) {
		covids.add(covid);
	}
	
	public List<Covid> list() {
		return covids;
	}
	
}
