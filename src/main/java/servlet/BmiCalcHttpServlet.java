package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = {"/servlet/bmicalc"})
public class BmiCalcHttpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得參數資料
		String height = req.getParameter("height"); // 取得表單 height 欄位的資料
		String weight = req.getParameter("weight"); // 取得表單 weight 欄位的資料
		// 轉型
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(weight);
		// 計算 bmi
		double bmi = w / Math.pow(h/100, 2);
		
		PrintWriter out = resp.getWriter();
		out.print(bmi);
	}
	
}
