package servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/car")
public class CarServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		// 顯示 HTTP 文件內容(Part 4)
		InputStreamReader isr = new InputStreamReader(req.getInputStream()); // 取得 HTTP 文件串流
		char[] buffer = new char[1];
		while(isr.read(buffer) != -1) {
			out.println(new String(buffer));
		}
		
	}
	
}
