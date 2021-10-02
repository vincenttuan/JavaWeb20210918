package servlet.car;

import java.io.IOException;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/car_delete")
public class CarDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String car_photo = req.getParameter("car_photo");
		File file = new File("C:/upload/" + car_photo);
		if(file.exists()) {
			file.delete();
		}
		// 重導
		resp.sendRedirect(getServletContext().getContextPath() + "/servlet/car");
	}
	
}
