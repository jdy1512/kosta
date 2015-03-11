public class Student{
	static int studentNo;
	String name, telNo, email;
	
	public static void main (String[] grs){
		String a = "1";
		String b = new String("1");
		String c = "1";
		
		System.out.println("a == b : "+(a==b));
		System.out.println("b == c : "+(b==c));
		System.out.println("a == c : "+(a==c));
	}
	
	public static void study(String subject){
		System.out.println(subject);
		System.out.println("공부한다.");
	}
	
	public String rest(int hour){
		System.out.println(hour + "시간 쉬었다.");
		return "푹쉬었다.";
	}
}