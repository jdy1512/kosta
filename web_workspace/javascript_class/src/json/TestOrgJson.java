package json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


public class TestOrgJson  {

	
	public static void test2() {
		Customer c = new Customer("id-1", "김영수", 20, 68.5, false);
		// instance변수의 값이 null인 경우는 무시
		JSONObject ovj = new JSONObject(c);
		System.out.println(ovj);
	}
	
	public static void test3() {
		Customer c1 = new Customer("id-1", "김영수", 20, 68.5, false);
		Customer c2 = new Customer("id-2", "박철수", 25, 78.5, true, new Address("111-222", "서울"));
		Customer c3 = new Customer("id-3", "최순이", 30, 48.5, true, new Address("222-333", "광주"));
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		JSONArray jArray = new JSONArray(list);
		System.out.println(jArray);
	}
	
	public static void main(String[] args) {
		TestOrgJson.test2();
		System.out.println();
		TestOrgJson.test3();
	}
}
