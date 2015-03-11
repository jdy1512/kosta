package kr.or.kosta.service;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.dao.CustomerDAO;
import kr.or.kosta.exception.CustomerNotFoundException;
import kr.or.kosta.exception.DuplicatedIdException;
import kr.or.kosta.vo.Customer;

public class CustomerService {
	private static CustomerService customerService = new CustomerService();
	private CustomerDAO customerDAO;

	public static CustomerService getInstance() {
		return customerService;
	}

	private CustomerService() {
		customerDAO = CustomerDAO.getInstance();
	}


	/**
	 * ���� ����ϴ� �޼ҵ�.
	 *  - �� id (id)�� �ߺ��� �� ����.  
	 *  	- ����Ϸ��� ���� id�� ���� id�� ���� �̹� ��ϵ� ��� ��� ó�� ���� �ʴ´�. 
	 * @param customer ����� �� ������ ���� Customer��ü�� ���� �Ű�����.
	 * @throws DuplicatedIdException 
	 * @throws CustomerNotFoundException 
	 * @throws CustomerDataAccessException 
	 */
	public void registerCustomer(Customer customer) throws DuplicatedIdException, CustomerNotFoundException {
		if (customer == null) {
			throw new CustomerNotFoundException("����� ���� �����ϴ�.");
		}
		
		// id �ߺ� �˻�
		Customer duplicateCustomer = null;
		try {
			duplicateCustomer = findCustomerById(customer.getId());
			if (duplicateCustomer != null){
				// �̹� �� ID�� ��ϵ� �����ִ�.
				throw new DuplicatedIdException(customer.getId()+"�� �̹� �ִ� ���̵� �Դϴ�.");
			}
		} catch (CustomerNotFoundException e) {
		}
		
		// �� ���
		String id = customer.getId();
		String pwd = customer.getPassword();
		String name = customer.getName();
		String email = customer.getEmail();
		String phone = customer.getPhoneNumber();
		int mileage = customer.getMileage();
		try {
			customerDAO.insertCustomer(id, pwd, name, email, phone, mileage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ϵ� ��� ���� ������ ����ϴ� �޼ҵ�.
	 */
	public void printCustomerList() {
		ArrayList<Customer> customerList = null;
		
		try {
			customerList = customerDAO.selectAllCustomers();
			for (Customer c : customerList) {
				System.out.println(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * id�� ���� ��ȸ�ϴ� �޼ҵ�
	 * @param id ��ȸ�� ���� ID
	 * @return customerList���� ��ȸ�� ����ü.
	 * @throws CustomerNotFoundException ã�� ���� ������ exception �߻�
	 */
	public Customer findCustomerById(String id) throws CustomerNotFoundException {
		if (id == null) {
			throw new CustomerNotFoundException("��ȸ�� ID�� �����ϴ�.");
		}

		Customer customer = null;
		try {
			customer = customerDAO.selectCustomerById(id);
			if (customer == null) {
				throw new CustomerNotFoundException("�ش� ID�� ��ȸ�� ���� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	/**
	 * �̸����� ���� ��ȸ�ϴ� �޼ҵ�
	 * @param name ��ȸ�� ���� �̸�
	 * @return customerList���� ��ȸ�� ������ ��� ������ ArrayList
	 */
	public ArrayList<Customer> findCustomerByName(String name) throws CustomerNotFoundException {
		if (name == null) {
			throw new CustomerNotFoundException("��ȸ�� �̸��� �����ϴ�.");
		}
		
		ArrayList<Customer> customerList = null;
		
		try {
			customerList = customerDAO.selectCustomerByName(name);
			if (customerList.size() == 0) {
				throw new CustomerNotFoundException("�ش� �̸����� ��ȸ�� ���� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	/**
	 * ���ϸ��� ������ ���� ��ȸ�ϴ� �޼ҵ�.
	 * startMileage <= ��.mileage <=endMileage
	 * 
	 * @param startMileage ��ȸ������ ���� ���ϸ�����. 
	 * @param endMileage   ��ȸ������ �� ���ϸ�����
	 * @return customerList���� ��ȸ�� ������ ��� ������ ArrayList
	 */
	public ArrayList<Customer>  findCustomerByMileageRange(int startMileage, int endMileage) throws CustomerNotFoundException {
		if (startMileage < 0 || endMileage < 0 || startMileage > endMileage) {
			throw new CustomerNotFoundException("���ϸ��� ������ �ùٸ��� �ʽ��ϴ�.");
		}
		
		ArrayList<Customer> customerList = null;
		
		try {
			customerList = customerDAO.selectCustomerByMileageRange(startMileage, endMileage);
			if (customerList.size() == 0) {
				throw new CustomerNotFoundException("�ش� ���ϸ��� ������ ��ȸ�� ���� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	/**
	 * �Ű������� ���� ���� ���� ID�� ���� �������� ã�� ����ó��.
	 *  - �����Ϸ��� ���� ID�� ���� ��� ó���� �������� �ʴ´�.
	 * @param newCust ������ �� ����
	 * @throws CustomerNotFoundException 
	 */
	public void updateCustomerInfo(Customer newCustomer) throws CustomerNotFoundException {
		if (newCustomer == null) {
			throw new CustomerNotFoundException("������ ���� �����ϴ�.");
		}
		
		int result = 0;
		
		try {
			// �� ���泻�� ���
			String id = newCustomer.getId();
			String pwd = newCustomer.getPassword();
			String name = newCustomer.getName();
			String email = newCustomer.getEmail();
			String phone = newCustomer.getPhoneNumber();
			int mileage = newCustomer.getMileage();
			result = customerDAO.updateCustomerInfo(id, pwd, name, email, phone, mileage);
			if (result == 0) {
				throw new CustomerNotFoundException("�ش� �������� ����� ���� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �Ű������� ���� ID�� ���� ã�� ���� ó��
	 *  - �Ű������� ���� ID�� ���� ������ ó���� �������� �ʴ´�. 
	 * @param id
	 * @throws CustomerNotFoundException 
	 */
	public void removeCustomerById(String id) throws CustomerNotFoundException{
		if (id == null) {
			throw new CustomerNotFoundException("������ ID�� �����ϴ�.");
		}
		
		int result = 0;
		
		try {
			result = customerDAO.deleteCustomerById(id);
			if (result == 0) {
				throw new CustomerNotFoundException("�ش� �������� ������ ���� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}