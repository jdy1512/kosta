public class TestStudent{
	public static void main(String[] args){
		Student stu1;	//Student클래스로부터 생성된 객체를 대입할 변수 stu1
		stu1 = new Student();	//생성자
		
		Student stu2 = new Student();
		
		//객체의 변수에 값 대입
		stu1.name = "홍길동";
		stu1.studentNo = 1;
		stu1.email = "abc@abc.com";
		stu1.telNo = "123-456-789";
		
		stu2.name = "김길동";
		stu2.studentNo = 2;
		stu2.email = "viva@viva.com";
		stu2.telNo = "111-222-333";
		
		System.out.println("stu1의 이름 : " + stu1.name);
		System.out.println("stu1의 학번 : " + stu1.studentNo);
		System.out.println("stu1의 전화번호 : " + stu1.telNo);
		System.out.println("stu1의 이메일주소 : " + stu1.email);
		
		System.out.println("==================================");
		System.out.println(stu1.name);
		stu1.study("수학");
		System.out.println(stu2.name);
		stu2.study("영어");
		
		System.out.println("==================================");
		System.out.println(stu1.name);
		stu1.rest(1);
		System.out.println(stu2.name);
		stu2.rest(3);
		
		System.out.println("==================================");
		String str = stu1.rest(5);
		System.out.println("메인 : " + str);
		
		System.out.println("==================================");
		stu2.eat("김치찌개", 1);
		stu2.eat("햄버거", 3);
	}
}























