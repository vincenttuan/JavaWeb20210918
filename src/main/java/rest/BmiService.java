package rest;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

@Path("/bmi")
public class BmiService {
	
	// url 規格: /rest/bmi/身高/體重 --> 範例: /rest/bmi/170/60
	@Path("/{h}/{w}")
	@GET
	@Produces("application/json")
	public String getBmiInfo(@PathParam("h") Double h, @PathParam("w") Double w) {
		double bmi = w / Math.pow(h/100, 2);
		Map<String, Double> map = new LinkedHashMap<>();
		map.put("身高", h);
		map.put("體重", w);
		map.put("BMI", bmi);
		// Map 物件要透過 Gson 去轉成 json 字串
		return new Gson().toJson(map);
	}
	
	
}
