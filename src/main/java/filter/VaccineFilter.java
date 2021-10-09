package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 請實作一個 VaccineFilter 可以過濾正確的名稱
// 若不正確則印出 "Vaccine name Error"

@WebFilter(value = {"/servlet/covid/append"})
public class VaccineFilter extends HttpFilter {
	// 合法疫苗名稱
	private List<String> vaccineNames = Arrays.asList("AZ", "BNT", "MVC");

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		String vaccine = req.getParameter("vaccine");
		if(vaccineNames.contains(vaccine)) {
			chain.doFilter(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.print("Stop: Vaccine name error");
		}
		
	}
	
	
	
}
