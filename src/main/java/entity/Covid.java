package entity;

public class Covid {
	private String id;
	private String vaccine;
	
	public Covid() {
		
	}
	
	public Covid(String id, String vaccine) {
		this.id = id;
		this.vaccine = vaccine;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	@Override
	public String toString() {
		return "Covid [id=" + id + ", vaccine=" + vaccine + "]";
	}
	
	
	
}
