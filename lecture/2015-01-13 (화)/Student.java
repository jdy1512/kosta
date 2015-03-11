public class Student{
	static int studentNo;
	String name, telNo, email;
	
	public static void study(String subject){
		System.out.println(subject);
		System.out.println("공부한다.");
	}
	
	public String rest(int hour){
		System.out.println(hour + "시간 쉬었다.");
		return "푹쉬었다.";
	}
	
	public void eat(String food, int hour){
		System.out.println(food+"를 "+hour+"시간동안 먹었다.");
	}
}