public class TestProduct{
	public static void main(String[] args){
		Product p1 = new Product();
		Product p2 = new Product(1, "우유", 1700, "서울우유");
		Product p3 = new Product(2, "사이다", 980, "이마트", 37, "유통 마진을 낮춰 싼 가격에 판매하는 이마트 사이다");
		
		System.out.println("p1 : " + p1.getDetails());
		System.out.println("p2 : " + p2.getDetails());
		System.out.println("p3 : " + p3.getDetails());
	}
}