public class Student{
	static int studentNo;
	String name, telNo, email;
	
	public static void study(String subject){
		System.out.println(subject);
		System.out.println("�����Ѵ�.");
	}
	
	public String rest(int hour){
		System.out.println(hour + "�ð� ������.");
		return "ǫ������.";
	}
	
	public void eat(String food, int hour){
		System.out.println(food+"�� "+hour+"�ð����� �Ծ���.");
	}
}