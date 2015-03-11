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
		
		//����� �� ����
		Customer c1 = new Customer("id-1", "1111","�迵��", "kys@kosta.or.kr", "02-111-2222", 40000);
		Customer c2 = new Customer("id-2", "4444","�̹̿�", "lmy@kosta.or.kr", "031-222-3333", 5500);
		Customer c3 = new Customer("id-3", "2222","�ֿ��", "cws@kosta.or.kr", "010-555-1212",350000);
		Customer c4 = new Customer("id-4", "3333","�̹̿�",  "lmy@kosta.or.kr", "010-3434-5656", 2700);
		Customer c5 = new Customer("id-5", "5555","�̹̿�",  "Rmy@kosta.or.kr", "031-532-6421", 550);
		Customer c6 = new Customer("id-6", "6666","����",  "cks@kosta.or.kr", "010-9011-3222", 66000);
		Customer c7 = new Customer("id-7", "7777","ȫ���",  "hkb@kosta.or.kr", "010-5434-6533", 57000);
		
		Customer c8 = new Customer("id-7", "7777","ȫ���", "hkb@kosta.or.kr",   "010-5434-6533",57000);
		
//		--------------------------------------------------------���
		try {
			service.registerCustomer(c1);
			service.registerCustomer(c2);
			service.registerCustomer(c3);
			service.registerCustomer(c4);
			service.registerCustomer(c5);
			service.registerCustomer(c6);
			service.registerCustomer(c7);
			service.registerCustomer(c8);//�ߺ� ID
		} catch (DuplicatedIdException e) {
			System.err.println(e.getMessage());
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}

//		-----------------------------------------------------��ü �� ���� ���
		service.printCustomerList();
		
//		-----------------------------------------------------ID��  �� ��ȸ
		String findId = "id-2";
		Customer cc;
		try {
			cc = service.findCustomerById(findId);
			System.out.println("ã�� ���� ���� : "+cc);
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
				
		//--------------------------------------------------�̸����� ��ȸ
		String name = "�̹̿�";
		System.out.println("----"+name+" �� ����-----");
		
		ArrayList<Customer> list;
		try {
			list = service.findCustomerByName(name);
		
			printList(list);
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
	
//		----------------------------------------------------���ϸ��� ������ ��ȸ
		int sMileage = 1000;
		int eMileage = 200000;
		System.out.println("���ϸ��� ������ üũ ("+sMileage+"~"+eMileage+")");
		try {
			list = service.findCustomerByMileageRange(sMileage, eMileage);
			
			printList(list);
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
				
//		-------------------------------------------------------�� ���� ���� ����
		System.out.println("-------------------------����-----------------------");

		Customer newCust = new Customer("id-3","2222","�ֿ��","newEmail@kosta.or.kr",  "010-555-1212", 300000);
		try {
			service.updateCustomerInfo(newCust);
			service.printCustomerList();
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
		

//		--------------------------------------------------------�� id�� ������ ����
		System.out.println("------------------����-------------------");
		
		String delId = "id-5";
		try {
			service.removeCustomerById(delId);
			service.printCustomerList();
		} catch (CustomerNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("-------------main ����-------------");
	}

	public static void printList(ArrayList<Customer> list){
		for(int idx = 0; idx < list.size(); idx++){
			System.out.println(list.get(idx));
		}
	}
}















