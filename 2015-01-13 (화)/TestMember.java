public class TestMember{

	public static void main(String[] args){
		Member m1 = new Member("aaaa", "1111", "이철수", 20000);
		Member m2 = new Member("bbbb", "2222", "김순이", 30000);
		String m1Info = m1.getMemberDetails();
		System.out.println("m1정보 : " + m1Info);
		m1.mileage = 25000;
		m1Info = m1.getMemberDetails();
		System.out.println("m1 변경후 정보 : " + m1Info);
		
		String m2Info = m2.getMemberDetails();
		System.out.println("m2정보 : " + m2Info);
		m2.mileage += 3000;
		m2Info = m2.getMemberDetails();
		System.out.println("m2 변경후 정보 : " + m2Info);
	}
}