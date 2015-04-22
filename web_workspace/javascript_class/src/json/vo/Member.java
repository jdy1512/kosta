package json.vo;

public class Member {
	private String id;
	private String name;
	private String email;
	private int mileage;
	private boolean marriage;

	public Member(String id, String name, String email, int mileage,
			boolean marriage) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mileage = mileage;
		this.marriage = marriage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public boolean isMarriage() {
		return marriage;
	}

	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}

}
