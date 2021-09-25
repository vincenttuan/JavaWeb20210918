package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Drink;
import service.DrinkService;

@WebServlet(value = "/servlet/drink")
public class DrinkHttpServlet extends HttpServlet {
	
	private DrinkService drinkService = new DrinkService();
	
	// 訂單明細列表
	private List<Map> list = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deleteRowId = req.getParameter("deleteRowId");
		if(deleteRowId != null) {
			// 進行刪單處理
			// 取得單號
			int index = Integer.parseInt(deleteRowId);
			// 得到該筆定單
			Map item = list.get(index);
			// 回滾庫存
			int id = Integer.parseInt(item.get("id").toString());
			int amount = Integer.parseInt(item.get("amount").toString());		
			drinkService.updateStock(id, amount * -1);
			// 移除訂單
			list.remove(index);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/drink_form.jsp");
		req.setAttribute("list", list);
		req.setAttribute("drinks", drinkService.queryAll());
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Integer amount = Integer.parseInt(req.getParameter("amount"));
		
		// 根據 id 取得 drink 物件
		Drink drink = drinkService.getDrink(id);
		// map 裡面存放的就是要顯示的訂單明細
		Map map = new LinkedHashMap<>();
		map.put("id", id);
		map.put("name", drink.getName());
		map.put("amount", amount);
		map.put("subtotal", amount * drink.getPrice());
		// 庫存檢查/更新
		boolean check = drinkService.updateStock(id, amount);
		if(check) {
			map.put("memo", "訂購成功");
		} else {
			map.put("memo", "庫存不足");
		}
		// 加入到訂單明細列表
		list.add(map);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/drink_form.jsp");
		req.setAttribute("list", list);
		req.setAttribute("drinks", drinkService.queryAll());
		rd.forward(req, resp);
	}
	
}
