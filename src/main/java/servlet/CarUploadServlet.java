package servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/servlet/car_upload")
@MultipartConfig(
		fileSizeThreshold =  1024 * 1024 * 1, // 1MB
		maxFileSize       = 1024 * 1024 * 10, // 10MB
		maxRequestSize    = 1024 * 1024 * 50 , // 50MB
		location          = "c:/upload")
public class CarUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		// 分析 Parts
		// 單一上傳
		//req.getPart("car_photo").write("car.png");
		// 多筆上傳
		req.getParts()
			.stream()
			.filter(part -> part.getName().equals("car_photo"))
			.forEach(part -> {
				try {
					part.write(part.getSubmittedFileName());
					out.println("Upload OK~");
				} catch (Exception e) {
					out.println("Upload Error: " + e);
				}
			});
		// 取得 car_name
		String car_name = IOUtils.toString(req.getPart("car_name").getInputStream(), StandardCharsets.UTF_8.name());
		// 取得 car_cc
		String car_cc = IOUtils.toString(req.getPart("car_cc").getInputStream(), StandardCharsets.UTF_8.name());
				
		out.print("car_name = " + car_name);
		out.print("car_cc = " + car_cc);
		
		// 重導
		resp.sendRedirect(getServletContext().getContextPath() + "/servlet/car");
	}
	
}
