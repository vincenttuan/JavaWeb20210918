package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = {"/servlet/session/result"})
public class SessionResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		out.println("get: ");
		String sessionId = session.getId();
		out.println("session id = " + sessionId);
		// 查看資料
		if(session.getAttribute("data") == null) {
			out.println("Empty");
		} else {
			String[] data = (String[])session.getAttribute("data");
			out.println(Arrays.toString(data));
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); // req.getSession(true)
		String[] data = req.getParameterValues("data");
		// 將 data 存放到 session 變數中
		session.setAttribute("data", data);
		// 取得 session id
		String sessionId = session.getId();
		PrintWriter out = resp.getWriter();
		out.println("post: saved OK ! " );
		out.println("session id = " + sessionId);
	}
	
}
