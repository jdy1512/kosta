public class VariableTest {
	static int age;
	public static void main(String[] args){
		//변수 선언 - DataType 식별자(이름);
		age = 20;
		System.out.println(age);
		age = 40;
		System.out.println(age);
		System.out.println("======================");
		String name = "김철수";
		System.out.println(name);
		name = "박영수";
		System.out.println(name);
		System.out.println("======================");
		String id, password, email;
		int price, mileage=2000, quantity;
		System.out.println(mileage);
	}
}