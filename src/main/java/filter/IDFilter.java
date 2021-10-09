package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(value = {"/servlet/covid/append"})
public class IDFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		String id = req.getParameter("id");
		// 檢查 id
		if(id.length() == 10) {
			// pass
			chain.doFilter(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.print("Stop: ID Error");
		}
		
	}
	
}
