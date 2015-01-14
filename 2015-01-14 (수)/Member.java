public class Member{
	String id;
	String password;
	String name;
	int mileage;
	
	public Member(){}
	
	public Member(String id, String password, String name, int mileage){
		this.id = id;
		this.password = password;
		this.name = name;
		this.mileage = mileage;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setMileage(int mileage){
		this.mileage = mileage;
	}
	
	public int getMileage(){
		return mileage;
	}
	
	public String getMemberDetails(){
		return "id : " + id + ", password : " + password + ", name : " + name + ", mileage : " + mileage;
	}
}