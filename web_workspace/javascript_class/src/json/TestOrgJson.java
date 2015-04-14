package json;

import org.json.JSONObject;


public class TestOrgJson  {

	
	public static void test2() {
		Customer c = new Customer("id-1", "김영수", 20, 68.5, false);
		// instance변수의 값이 null인 경우는 무시
		JSONObject ovj = new JSONObject(c);
		System.out.println(ovj);
	}
	
	public static void test3() {
		Customer c = new Customer("id-2", "박철수", 20, 78.5, true, new Address("111-222", "서울"));

		JSONObject ovj = new JSONObject(c);
		System.out.println(ovj);
	}
	
	public static void main(String[] args) {
		TestOrgJson.test2();
		System.out.println(
				);

		TestOrgJson.test3();
	}
}
