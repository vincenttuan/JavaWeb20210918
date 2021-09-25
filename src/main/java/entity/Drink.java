package entity;

public class Drink {
	private Integer id;
	private String name;
	private Integer price;
	private Integer stock;
	
	public Drink() {
		
	}
	
	public Drink(Integer id, String name, Integer price, Integer stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	
	
	
}
