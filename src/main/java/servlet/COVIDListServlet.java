package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Covid;
import service.CovidService;

@WebServlet("/servlet/covid/list")
public class COVIDListServlet extends HttpServlet {
	private CovidService covidService = new CovidService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Covid> covids = covidService.list();
		
		// 建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/covid_list.jsp");
		// 配置/新增 request 屬性
		req.setAttribute("covids", covids);
		// 重導
		rd.forward(req, resp);
	}
	
}
