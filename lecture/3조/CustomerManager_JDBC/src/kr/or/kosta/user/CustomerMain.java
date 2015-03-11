package kr.or.kosta.user;

import java.util.ArrayList;

import kr.or.kosta.exception.CustomerNotFoundException;
import kr.or.kosta.exception.DuplicatedIdException;
import kr.or.kosta.service.CustomerService;
import kr.or.kosta.vo.Customer;

public class CustomerMain {
	private static CustomerService service;

	public static void main(String[] args) {
		service = CustomerService.getInstance();
		
		//등록할 고객 정보
		Customer c1 = new Customer("id-1", "1111","김영수", "kys@kosta.or.kr", "02-111-2222", 40000);
		Customer c2 = new Customer("id-2", "4444","이미영", "lmy@kosta.or.kr", "031-222-3333", 5500);
		Customer c3 = new Customer("id-3", "2222","최우수", "cws@kosta.or.kr", "010-555-1212",350000);
		Customer c4 = new Customer("id-4", "3333","이미영",  "lmy@kosta.or.kr", "010-3434-5656", 2700);
		Customer c5 = new Customer("id-5", "5555","이미영",  "Rmy@kosta.or.kr", "031-532-6421", 550);
		Customer c6 = new Customer("id-6", "6666","장경수",  "cks@kosta.or.kr", "010-9011-3222", 66000);
		Customer c7 = new Customer("id-7", "7777","홍길범",  "hkb@kosta.or.kr", "010-5434-6533", 57000);
		
		Customer c8 = new Customer("id-7", "7777","홍길범", "hkb@kosta.or.kr",   "010-5434-6533",57000);
		
//		--------------------------------------------------------등록
		try {
			service.registerCustomer(c1);
			service.registerCustomer(c2);
			service.registerCustomer(c3);
			service.registerCustomer(c4);
			service.registerCustomer(c5);
			service.registerCustomer(c6);
			service.registerCustomer(c7);
			service.registerCustomer(c8);//중복 ID
		} catch (DuplicatedIdException e) {
			System.err.println(e.getMessage());
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}

//		-----------------------------------------------------전체 고객 정보 출력
		service.printCustomerList();
		
//		-----------------------------------------------------ID로  고객 조회
		String findId = "id-2";
		Customer cc;
		try {
			cc = service.findCustomerById(findId);
			System.out.println("찾은 고객의 정보 : "+cc);
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
				
		//--------------------------------------------------이름으로 조회
		String name = "이미영";
		System.out.println("----"+name+" 고객 정보-----");
		
		ArrayList<Customer> list;
		try {
			list = service.findCustomerByName(name);
		
			printList(list);
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
	
//		----------------------------------------------------마일리지 범위로 조회
		int sMileage = 1000;
		int eMileage = 200000;
		System.out.println("마일리지 범위로 체크 ("+sMileage+"~"+eMileage+")");
		try {
			list = service.findCustomerByMileageRange(sMileage, eMileage);
			
			printList(list);
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
				
//		-------------------------------------------------------고객 정보 수정 수정
		System.out.println("-------------------------수정-----------------------");

		Customer newCust = new Customer("id-3","2222","최우수","newEmail@kosta.or.kr",  "010-555-1212", 300000);
		try {
			service.updateCustomerInfo(newCust);
			service.printCustomerList();
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
		

//		--------------------------------------------------------고객 id로 고객정보 제거
		System.out.println("------------------삭제-------------------");
		
		String delId = "id-5";
		try {
			service.removeCustomerById(delId);
			service.printCustomerList();
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("-------------main 종료-------------");
	}

	public static void printList(ArrayList<Customer> list){
		for(int idx = 0; idx < list.size(); idx++){
			System.out.println(list.get(idx));
		}
	}
}















