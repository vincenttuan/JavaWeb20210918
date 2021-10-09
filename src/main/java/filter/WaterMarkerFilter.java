package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/servlet/covid/list")
public class WaterMarkerFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 建立自己的 response 物件
		MyResponse myResponse = new MyResponse(resp);
		// 往下走
		chain.doFilter(req, myResponse);
		// 得到 html 資料
		String html = myResponse.getResult();
		// 加上浮水印
		String ws = "background='" + getServletContext().getContextPath() + "/example.jpg'"; 
		html = html.replaceAll("<body", "<body " + ws);
		// 回寫給 client 端
		resp.getWriter().print(html);
		
	}
	
	
	
}
