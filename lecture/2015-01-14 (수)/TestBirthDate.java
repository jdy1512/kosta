public class TestBirthDate{
	public static void main(String[] ar){
		BirthDate myDate = new BirthDate(1999, 10, 20);
		System.out.println("郴积老 : " + myDate.getBirthDate());
		
		myDate.setYear(2001);
		System.out.println("斥档 : " + myDate.getYear());
		System.out.println("郴积老 : " + myDate.getBirthDate());
		
	}
}