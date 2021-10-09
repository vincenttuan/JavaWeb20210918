package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Covid;
import service.CovidService;

@WebServlet("/servlet/covid/append")
public class COVIDServlet extends HttpServlet {
	private CovidService covidService = new CovidService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String vaccine = req.getParameter("vaccine");
		Covid covid = new Covid(id, vaccine);
		covidService.append(covid);
		
		// Client 端重導
		// 將要執行的 url 重拋給瀏覽器
		// 瀏覽器接到後會自動執行命令
		// ps: getServletContext().getContextPath() = /JavaWeb20210918
		resp.sendRedirect("http://localhost:8080" + getServletContext().getContextPath() + "/servlet/covid/list");
	}
	
}
