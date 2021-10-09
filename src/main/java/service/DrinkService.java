package service;

import java.util.ArrayList;
import java.util.List;

import entity.Drink;

public class DrinkService {
	private static List<Drink> drinks;
	
	static {
		drinks = new ArrayList<>();
		drinks.add(new Drink(1, "珍奶", 50, 100));
		drinks.add(new Drink(2, "咖啡", 70, 100));
		drinks.add(new Drink(3, "綠茶", 30, 100));
	}
	
	public List<Drink> queryAll() {
		return drinks;
	}
	
	// 修改庫存
	public boolean updateStock(Integer id, Integer amount) {
		Drink drink = drinks.stream().filter(d -> d.getId() == id).findFirst().get();
		if(drink.getStock() >= amount) {
			drink.setStock(drink.getStock() - amount);
			return true;
		} else {
			return false;
		}
	}
	
	// 取得飲料物件
	public Drink getDrink(Integer id) {
		Drink drink = drinks.stream().filter(d -> d.getId() == id).findFirst().get();
		return drink;
	}
	
}
