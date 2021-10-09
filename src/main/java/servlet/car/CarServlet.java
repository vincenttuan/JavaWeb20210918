package servlet.car;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/car")
public class CarServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		File file = new File("c:/upload");
		String[] fileNames = file.list();
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/car_form.jsp");
		req.setAttribute("fileNames", fileNames);
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		// 顯示 HTTP 文件 Header(Part 2)
		Enumeration headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement().toString();
			String headerValue = req.getHeader(headerName);
			out.println(headerName + " = " + headerValue + "<br />");
		}
		out.println("<hr>");
		out.println(req.getHeader("accept-language"));
		out.println("<hr>");
		// 顯示 HTTP 文件內容(Part 4)
		InputStreamReader isr = new InputStreamReader(req.getInputStream()); // 取得 HTTP 文件串流
		char[] buffer = new char[1];
		while(isr.read(buffer) != -1) {
			out.println(new String(buffer));
		}
		
	}
	
}
