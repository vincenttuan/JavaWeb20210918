package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "random", urlPatterns = {"/servlet/random", "/aaa/bbb/*"})
public class RandomServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		String amount = req.getParameter("n");
		PrintWriter out = res.getWriter(); 
		if(amount == null) {
			out.print("Please input n !");
			return;
		}
		try {
			int n = Integer.parseInt(amount);
			Set<Integer> nums = new LinkedHashSet<>();
			Random random = new Random();
			while (nums.size() < n) {
				nums.add(random.nextInt(100) + 1);
			}
			out.print(nums);
		} catch (Exception e) {
			out.print("error: " + e);
			return;
		}
	}
}
