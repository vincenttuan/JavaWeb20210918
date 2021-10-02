package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/car_download")
public class CarDownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String car_photo = req.getParameter("car_photo");
		// 1. 取得圖檔名稱
		if(car_photo == null) {
			resp.getWriter().print("Please input car_photo");
			return;
		}
		
		// 2. 取得圖檔路徑
		File file = new File("c:/upload/" + car_photo);
		if(!file.exists()) {
			resp.getWriter().print("File not found: " + car_photo);
			return;
		}
		
		// 3. 將圖檔傳給 client 端
		Files.copy(file.toPath(), resp.getOutputStream());
		
	}
	
	
}
