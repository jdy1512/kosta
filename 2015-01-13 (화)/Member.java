public class Member{
	String id;
	String password;
	String name;
	int mileage;
	
	public Member(String id, String password, String name, int mileage){
		this.id = id;
		this.password = password;
		this.name = name;
		this.mileage = mileage;
	}
	
	public Member(){}
	
	public String getMemberDetails(){
		return "id : " + id + ", password : " + password + ", name : " + name + ", mileage : " + mileage;
	}
}