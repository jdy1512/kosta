package json;

public class Customer {
	private String id;
	private String name;
	private int age;
	private double weight;
	private boolean marriage;
	private Address address;

	public Customer(String id, String name, int age, double weight,
			boolean marriage) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.marriage = marriage;
	}

	public Customer(String id, String name, int age, double weight,
			boolean marriage, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.marriage = marriage;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isMarriage() {
		return marriage;
	}

	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
