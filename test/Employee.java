public class Employee{
	int pay;
	String contractDate;
	String contractType;
	String joinDate;
	String name;
	String gender;
	int age;

	public Employee(){}
	
	public Employee(int pay, String contractDate, String contractType, 
		String joinDate, String name, String gender, int age){
		this.pay = pay;
		this.contractDate = contractDate;
		this.contractType = contractType;
		this.joinDate = joinDate;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String toString(){
		return "pay : "+pay+", contractDate "+contractDate+", contractType "+contractType+", joinDate "
			+joinDate+", name "+name+", gender "+gender+", age "+age;
	}
}