public class TestStudent{
	public static void main(String[] args){
		Student stu1;	//StudentŬ�����κ��� ������ ��ü�� ������ ���� stu1
		stu1 = new Student();	//������
		
		Student stu2 = new Student();
		
		//��ü�� ������ �� ����
		stu1.name = "ȫ�浿";
		stu1.studentNo = 1;
		stu1.email = "abc@abc.com";
		stu1.telNo = "123-456-789";
		
		stu2.name = "��浿";
		stu2.studentNo = 2;
		stu2.email = "viva@viva.com";
		stu2.telNo = "111-222-333";
		
		System.out.println("stu1�� �̸� : " + stu1.name);
		System.out.println("stu1�� �й� : " + stu1.studentNo);
		System.out.println("stu1�� ��ȭ��ȣ : " + stu1.telNo);
		System.out.println("stu1�� �̸����ּ� : " + stu1.email);
		
		System.out.println("==================================");
		System.out.println(stu1.name);
		stu1.study("����");
		System.out.println(stu2.name);
		stu2.study("����");
		
		System.out.println("==================================");
		System.out.println(stu1.name);
		stu1.rest(1);
		System.out.println(stu2.name);
		stu2.rest(3);
		
		System.out.println("==================================");
		String str = stu1.rest(5);
		System.out.println("���� : " + str);
		
		System.out.println("==================================");
		stu2.eat("��ġ�", 1);
		stu2.eat("�ܹ���", 3);
	}
}























