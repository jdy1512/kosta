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
	 * 고객을 등록하는 메소드.
	 *  - 고객 id (id)는 중복될 수 없다.  
	 *  	- 등록하려는 고객의 id와 같은 id의 고객이 이미 등록된 경우 등록 처리 하지 않는다. 
	 * @param customer 등록할 고객 정보를 가진 Customer객체를 받을 매개변수.
	 * @throws DuplicatedIdException 
	 * @throws CustomerNotFoundException 
	 * @throws CustomerDataAccessException 
	 */
	public void registerCustomer(Customer customer) throws DuplicatedIdException, CustomerNotFoundException {
		if (customer == null) {
			throw new CustomerNotFoundException("등록할 고객이 없습니다.");
		}
		
		// id 중복 검사
		Customer duplicateCustomer = null;
		try {
			duplicateCustomer = findCustomerById(customer.getId());
			if (duplicateCustomer != null){
				// 이미 그 ID로 등록된 고객이있다.
				throw new DuplicatedIdException(customer.getId()+"는 이미 있는 아이디 입니다.");
			}
		} catch (CustomerNotFoundException e) {
		}
		
		// 고객 등록
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
	 * 등록된 모든 고객의 정보를 출력하는 메소드.
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
	 * id로 고객을 조회하는 메소드
	 * @param id 조회할 고객의 ID
	 * @return customerList에서 조회한 고객객체.
	 * @throws CustomerNotFoundException 찾는 고객이 없으면 exception 발생
	 */
	public Customer findCustomerById(String id) throws CustomerNotFoundException {
		if (id == null) {
			throw new CustomerNotFoundException("조회할 ID가 없습니다.");
		}

		Customer customer = null;
		try {
			customer = customerDAO.selectCustomerById(id);
			if (customer == null) {
				throw new CustomerNotFoundException("해당 ID로 조회된 고객이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	/**
	 * 이름으로 고객을 조회하는 메소드
	 * @param name 조회할 고객의 이름
	 * @return customerList에서 조회된 고객들을 담아 리턴할 ArrayList
	 */
	public ArrayList<Customer> findCustomerByName(String name) throws CustomerNotFoundException {
		if (name == null) {
			throw new CustomerNotFoundException("조회할 이름이 없습니다.");
		}
		
		ArrayList<Customer> customerList = null;
		
		try {
			customerList = customerDAO.selectCustomerByName(name);
			if (customerList.size() == 0) {
				throw new CustomerNotFoundException("해당 이름으로 조회된 고객이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	/**
	 * 마일리지 범위로 고객을 조회하는 메소드.
	 * startMileage <= 고객.mileage <=endMileage
	 * 
	 * @param startMileage 조회범위의 시작 마일리지값. 
	 * @param endMileage   조회범위의 끝 마일리지값
	 * @return customerList에서 조회된 고객들을 담아 리턴할 ArrayList
	 */
	public ArrayList<Customer>  findCustomerByMileageRange(int startMileage, int endMileage) throws CustomerNotFoundException {
		if (startMileage < 0 || endMileage < 0 || startMileage > endMileage) {
			throw new CustomerNotFoundException("마일리지 범위가 올바르지 않습니다.");
		}
		
		ArrayList<Customer> customerList = null;
		
		try {
			customerList = customerDAO.selectCustomerByMileageRange(startMileage, endMileage);
			if (customerList.size() == 0) {
				throw new CustomerNotFoundException("해당 마일리지 범위로 조회된 고객이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	/**
	 * 매개변수로 받은 고객과 같은 ID를 가진 고객정보를 찾아 변경처리.
	 *  - 수정하려는 고객의 ID가 없는 경우 처리를 진행하지 않는다.
	 * @param newCust 변경할 고객 정보
	 * @throws CustomerNotFoundException 
	 */
	public void updateCustomerInfo(Customer newCustomer) throws CustomerNotFoundException {
		if (newCustomer == null) {
			throw new CustomerNotFoundException("변경할 고객이 없습니다.");
		}
		
		int result = 0;
		
		try {
			// 고객 변경내용 등록
			String id = newCustomer.getId();
			String pwd = newCustomer.getPassword();
			String name = newCustomer.getName();
			String email = newCustomer.getEmail();
			String phone = newCustomer.getPhoneNumber();
			int mileage = newCustomer.getMileage();
			result = customerDAO.updateCustomerInfo(id, pwd, name, email, phone, mileage);
			if (result == 0) {
				throw new CustomerNotFoundException("해당 고객정보로 변경된 고객이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 매개변수로 받은 ID의 고객을 찾아 삭제 처리
	 *  - 매개변수로 받은 ID의 고객이 없으면 처리를 진행하지 않는다. 
	 * @param id
	 * @throws CustomerNotFoundException 
	 */
	public void removeCustomerById(String id) throws CustomerNotFoundException{
		if (id == null) {
			throw new CustomerNotFoundException("삭제할 ID가 없습니다.");
		}
		
		int result = 0;
		
		try {
			result = customerDAO.deleteCustomerById(id);
			if (result == 0) {
				throw new CustomerNotFoundException("해당 고객정보로 삭제된 고객이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}