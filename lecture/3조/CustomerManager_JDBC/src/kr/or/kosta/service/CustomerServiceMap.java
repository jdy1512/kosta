package kr.or.kosta.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import kr.or.kosta.exception.CustomerNotFoundException;
import kr.or.kosta.exception.DuplicatedIdException;
import kr.or.kosta.vo.Customer;
/**
 * CustomerService�� Map�� �̿��� �������� ����.
 *
 */
public class CustomerServiceMap {
	
	//key : id  value : Customer��ü
	private HashMap<String , Customer> customerMap;
	public CustomerServiceMap(){
		//Map - �⺻ ũ��(length-������ �������� ����)�� ������ �ʰ� ����
		customerMap = new HashMap<String , Customer> ();
	}
	public CustomerServiceMap(int listSize){
		//Map - ������ �������� ������ �Ű������� ���� ���� �̿��� ����.
		customerMap = new HashMap<String , Customer> (listSize);
	}
	/**
	 * ���� ����ϴ� �޼ҵ�.
	 *  - �� id (id)�� �ߺ��� �� ����.  
	 *  	- ����Ϸ��� ���� id�� ���� id�� ���� �̹� ��ϵ� ��� ��� ó�� ���� �ʴ´�. 
	 * @param customer ����� �� ������ ���� Customer��ü�� ���� �Ű�����.
	 * @throws DuplicatedIdException 
	 */
	public void registerCustomer(Customer customer) throws DuplicatedIdException{
		//id �ߺ� �˻�
		
		
		Customer cust = findCustomerById(customer.getId());
		if(cust!=null){
			throw new DuplicatedIdException(customer.getId()+"�� �̹� ��ϵ� ID�Դϴ�.");
		}
		/*
		if(customerMap.containsKey(customer.getId())){//�̹� �� ID�� ��ϵ� ���ִ�.
			return;
		}
		*/
		customerMap.put(customer.getId(), customer);
	}
	/**
	 * ��ϵ� ��� ���� ������ ����ϴ� �޼ҵ�.
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
//	��ȸ �޼ҵ��
	/**
	 * id�� ���� ��ȸ�ϴ� �޼ҵ�
	 * @param id ��ȸ�� ���� ID
	 * @return customerList���� ��ȸ�� ����ü. ã�� ���� ������ null�� �����Ѵ�.
	 */
	public Customer findCustomerById(String id){
		
		return customerMap.get(id);
	}
	/**
	 * �̸����� ���� ��ȸ�ϴ� �޼ҵ�
	 * @param name ��ȸ�� ���� �̸�
	 * @return customerList���� ��ȸ�� ������ ��� ������ ArrayList
	 */
	public ArrayList<Customer>  findCustomerByName(String name){
		
		ArrayList<Customer> list = new ArrayList<Customer>();//ã�� ���� ����  list
		
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
	 * ���ϸ��� ������ ���� ��ȸ�ϴ� �޼ҵ�.
	 * startMileage <= ��.mileage <=endMileage
	 * 
	 * @param startMileage ��ȸ������ ���� ���ϸ�����. 
	 * @param endMileage   ��ȸ������ �� ���ϸ�����
	 * @return customerList���� ��ȸ�� ������ ��� ������ ArrayList
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
	 * �Ű������� ���� ���� ���� ID�� ���� �������� ã�� ����ó��.
	 *  - �����Ϸ��� ���� ID�� ���� ��� ó���� �������� �ʴ´�.
	 * @param newCust ������ �� ����
	 * @throws CustomerNotFoundException 
	 */
	public void updateCustomerInfo(Customer newCust) throws CustomerNotFoundException{
		
		Customer cust = findCustomerById(newCust.getId());
		if(cust==null){
			throw new CustomerNotFoundException(newCust.getId()+"�� ���� ���Դϴ�.");
		}
		/*if(!customerMap.containsKey(newCust.getId())){
			return;
		}*/
		customerMap.put(newCust.getId(), newCust);
	}
	/**
	 * �Ű������� ���� ID�� ���� ã�� ���� ó��
	 *  - �Ű������� ���� ID�� ���� ������ ó���� �������� �ʴ´�. 
	 * @param id
	 * @throws CustomerNotFoundException 
	 */
	public void removeCustomerById(String id) throws CustomerNotFoundException{
		Customer cust = findCustomerById(id);
		if(cust==null){
			throw new CustomerNotFoundException(id+"�� ���� ���Դϴ�.");
		}
		customerMap.remove(id);
	}
}








