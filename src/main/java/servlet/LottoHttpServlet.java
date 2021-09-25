package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/lotto"})
public class LottoHttpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 解決中文問題, 編碼 utf-8
		req.setCharacterEncoding("UTF-8");  // 請求的編碼
		resp.setCharacterEncoding("UTF-8"); // 回應的編碼
		resp.setContentType("text/html;charset=UTF-8"); // 文件編碼
		
		// 539 樂透: 1~39 之間取出 5 個不重複的數字
		Set<Integer> nums = new LinkedHashSet<>();
		Random r = new Random();
		while (nums.size() < 5) {
			nums.add(r.nextInt(39) + 1);
		}
		// 印出樂透號碼
		PrintWriter out = resp.getWriter();
		out.println("539 樂透: " + nums);
		
	}
	
}
