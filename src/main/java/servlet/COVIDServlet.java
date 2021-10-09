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
		
		PrintWriter out = resp.getWriter();
		out.print("COVID Append OK:<p />");
		out.print(covidService.list());
	}
	
}
