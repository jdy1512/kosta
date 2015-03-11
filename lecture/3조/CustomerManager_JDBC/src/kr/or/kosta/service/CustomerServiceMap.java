package kr.or.kosta.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import kr.or.kosta.exception.CustomerNotFoundException;
import kr.or.kosta.exception.DuplicatedIdException;
import kr.or.kosta.vo.Customer;
/**
 * CustomerService를 Map을 이용한 버전으로 변경.
 *
 */
public class CustomerServiceMap {
	
	//key : id  value : Customer객체
	private HashMap<String , Customer> customerMap;
	public CustomerServiceMap(){
		//Map - 기본 크기(length-저장할 데이터의 개수)를 정하지 않고 생성
		customerMap = new HashMap<String , Customer> ();
	}
	public CustomerServiceMap(int listSize){
		//Map - 저장할 데이터의 개수를 매개변수로 받은 값을 이용해 생성.
		customerMap = new HashMap<String , Customer> (listSize);
	}
	/**
	 * 고객을 등록하는 메소드.
	 *  - 고객 id (id)는 중복될 수 없다.  
	 *  	- 등록하려는 고객의 id와 같은 id의 고객이 이미 등록된 경우 등록 처리 하지 않는다. 
	 * @param customer 등록할 고객 정보를 가진 Customer객체를 받을 매개변수.
	 * @throws DuplicatedIdException 
	 */
	public void registerCustomer(Customer customer) throws DuplicatedIdException{
		//id 중복 검사
		
		
		Customer cust = findCustomerById(customer.getId());
		if(cust!=null){
			throw new DuplicatedIdException(customer.getId()+"는 이미 등록된 ID입니다.");
		}
		/*
		if(customerMap.containsKey(customer.getId())){//이미 그 ID로 등록된 고객있다.
			return;
		}
		*/
		customerMap.put(customer.getId(), customer);
	}
	/**
	 * 등록된 모든 고객의 정보를 출력하는 메소드.
	 */
	public void printCustomerList(){
		Set<Entry<String, Customer>> entries = customerMap.entrySet();
		for(Entry<String, Customer> entry : entries){
//			Object key = entry.getKey();
//			Object value = entry.getValue();
			
			String key = entry.getKey();
			Customer value = entry.getValue();
			System.out.println(value);
		}
	}
//	조회 메소드들
	/**
	 * id로 고객을 조회하는 메소드
	 * @param id 조회할 고객의 ID
	 * @return customerList에서 조회한 고객객체. 찾는 고객이 없으면 null을 리턴한다.
	 */
	public Customer findCustomerById(String id){
		
		return customerMap.get(id);
	}
	/**
	 * 이름으로 고객을 조회하는 메소드
	 * @param name 조회할 고객의 이름
	 * @return customerList에서 조회된 고객들을 담아 리턴할 ArrayList
	 */
	public ArrayList<Customer>  findCustomerByName(String name){
		
		ArrayList<Customer> list = new ArrayList<Customer>();//찾은 고객을 담을  list
		
		Set<String> keys = customerMap.keySet();
		for(String key : keys){
			Customer cust = customerMap.get(key);
			if(name.equals(cust.getName())){
				list.add(cust);
			}
		}
		return list;
	}
	/**
	 * 마일리지 범위로 고객을 조회하는 메소드.
	 * startMileage <= 고객.mileage <=endMileage
	 * 
	 * @param startMileage 조회범위의 시작 마일리지값. 
	 * @param endMileage   조회범위의 끝 마일리지값
	 * @return customerList에서 조회된 고객들을 담아 리턴할 ArrayList
	 */
	public ArrayList<Customer>  findCustomerByMileageRange(int startMileage, int endMileage){
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		Set<String> keys = customerMap.keySet();
		for(String key : keys){
			Customer cust = customerMap.get(key);
			if(cust.getMileage()>=startMileage && cust.getMileage()<=endMileage){
				list.add(cust);
			}
		}
		return list;
	}
	/**
	 * 매개변수로 받은 고객과 같은 ID를 가진 고객정보를 찾아 변경처리.
	 *  - 수정하려는 고객의 ID가 없는 경우 처리를 진행하지 않는다.
	 * @param newCust 변경할 고객 정보
	 * @throws CustomerNotFoundException 
	 */
	public void updateCustomerInfo(Customer newCust) throws CustomerNotFoundException{
		
		Customer cust = findCustomerById(newCust.getId());
		if(cust==null){
			throw new CustomerNotFoundException(newCust.getId()+"는 없는 고객입니다.");
		}
		/*if(!customerMap.containsKey(newCust.getId())){
			return;
		}*/
		customerMap.put(newCust.getId(), newCust);
	}
	/**
	 * 매개변수로 받은 ID의 고객을 찾아 삭제 처리
	 *  - 매개변수로 받은 ID의 고객이 없으면 처리를 진행하지 않는다. 
	 * @param id
	 * @throws CustomerNotFoundException 
	 */
	public void removeCustomerById(String id) throws CustomerNotFoundException{
		Customer cust = findCustomerById(id);
		if(cust==null){
			throw new CustomerNotFoundException(id+"는 없는 고객입니다.");
		}
		customerMap.remove(id);
	}
}








