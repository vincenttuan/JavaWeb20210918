package servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/servlet/circlecalc")
public class CircleCalcHttpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/circle_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String radius = req.getParameter("radius");
		String[] items = req.getParameterValues("item");
		System.out.println("radius: " + radius);
		System.out.println("items: " + Arrays.toString(items));
		
		double r = Double.parseDouble(radius);
		for(String item : items) {
			switch (item) {
				case "A":
					System.out.println("直徑:" + (2*r));
					break;
				case "B":
					System.out.println("圓周:" + ((2*r) * Math.PI));
					break;
				case "C":
					System.out.println("面積:" + (Math.PI * Math.pow(r, 2)));
					break;
				case "D":
					System.out.println("體積:" + (4/3 * Math.PI * Math.pow(r, 3)));
					break;	
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/circle_result.jsp");
		rd.forward(req, resp);
	}
	
}
