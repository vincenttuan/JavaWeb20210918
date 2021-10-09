package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CovidService;

// 檢查是否該 id 已經申請過 ?
@WebFilter(value = {"/servlet/covid/append"})
public class AlreadyAppliedFilter extends HttpFilter {
	private CovidService covidService = new CovidService();
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		final String id = req.getParameter("id");
		boolean exist = covidService.list()
							.stream()
							.filter(c -> c.getId().equalsIgnoreCase(id))
							.findAny()
							.isPresent();
		if(exist) {
			PrintWriter out = resp.getWriter();
			out.print("Stop: Id " + id + " already applied");
		} else {
			chain.doFilter(req, resp);
		}
							
	}
	
}
