public class TestMember{

	public static void main(String[] args){
		Member m1 = new Member("aaaa", "1111", "��ö��", 20000);
		Member m2 = new Member("bbbb", "2222", "�����", 30000);
		String m1Info = m1.getMemberDetails();
		System.out.println("m1���� : " + m1Info);
		m1.mileage = 25000;
		m1Info = m1.getMemberDetails();
		System.out.println("m1 ������ ���� : " + m1Info);
		
		String m2Info = m2.getMemberDetails();
		System.out.println("m2���� : " + m2Info);
		m2.mileage += 3000;
		m2Info = m2.getMemberDetails();
		System.out.println("m2 ������ ���� : " + m2Info);
	}
}