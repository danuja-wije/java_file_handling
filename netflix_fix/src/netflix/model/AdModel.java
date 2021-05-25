package netflix.model;

public class AdModel {

	private String adName;
	private String userName;
	private String category;
	private String type;
	private String period;
	private String path;
	private String thumb;
	private int id;
	//constrctor
	public AdModel() {
		super();
	}
	

	
	public AdModel(String adName, String userName, String category, String type, String period, String path , String thumb) {
		super();
		this.adName = adName;
		this.userName = userName;
		this.category = category;
		this.type = type;
		this.period = period;
		this.path = path;
		this.thumb = thumb;
	}



	//setters & getters
	
	public String getAdName() {
		return adName;
	}
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getThumb() {
		return thumb;
	}



	public void setThumb(String thumb) {
		this.thumb = thumb;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public void setAdName(String adName) {
		this.adName = adName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}


	
	
}
