package kr.or.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import kr.or.kosta.util.DataUtil;
import kr.or.kosta.vo.Customer;

public class CustomerDAO {
	private static CustomerDAO customerDAO = new CustomerDAO();
	private DataUtil dataUtil;

	private CustomerDAO() {
		dataUtil = DataUtil.getInstance();
	}

	public static CustomerDAO getInstance() {
		return customerDAO;
	}

	public int insertCustomer(String id, String pwd, String name, String email, String phone, int mileage) throws SQLException {
		String sql = "insert into customer values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultCount = 0;
		
		try {
			conn = dataUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setInt(6, mileage);
			
			resultCount = pstmt.executeUpdate();
		} finally {
			dataUtil.close(conn, pstmt);
		}
		return resultCount;
	}

	public Customer selectCustomerById(String id) throws SQLException {
		String sql = "select * "
				+ "from customer "
				+ "where c_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer customer = null;
		
		try {
			conn = dataUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();

			if (rset.next()) {
				customer = new Customer(
					rset.getString(1), rset.getString(2), rset.getString(3), 
					rset.getString(4), rset.getString(5), rset.getInt(6)
				);
			}
		} finally {
			dataUtil.close(conn, pstmt, rset);
		}
		return customer;
	}

	public ArrayList<Customer> selectAllCustomers() throws SQLException {
		String sql = "select * "
				+ "from customer";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		try {
			conn = dataUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer customer = new Customer(
					rset.getString(1), rset.getString(2), rset.getString(3), 
					rset.getString(4), rset.getString(5), rset.getInt(6)
				);
				customerList.add(customer);
			}
		} finally {
			dataUtil.close(conn, pstmt, rset);
		}
		Collections.sort(customerList);
		return customerList;
	}

	public ArrayList<Customer> selectCustomerByName(String name) throws SQLException {
		String sql = "select * "
				+ "from customer "
				+ "where c_name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		try {
			conn = dataUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer customer = new Customer(
					rset.getString(1), rset.getString(2), rset.getString(3), 
					rset.getString(4), rset.getString(5), rset.getInt(6)
				);
				customerList.add(customer);
			}
		} finally {
			dataUtil.close(conn, pstmt, rset);
		}
		Collections.sort(customerList);
		return customerList;
	}

	public ArrayList<Customer> selectCustomerByMileageRange(int startMileage, int endMileage) throws SQLException {
		String sql = "select * "
				+ "from customer "
				+ "where c_mileage between ? and ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		try {
			conn = dataUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startMileage);
			pstmt.setInt(2, endMileage);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Customer customer = new Customer(
					rset.getString(1), rset.getString(2), rset.getString(3), 
					rset.getString(4), rset.getString(5), rset.getInt(6)
				);
				customerList.add(customer);
			}
		} finally {
			dataUtil.close(conn, pstmt, rset);
		}
		Collections.sort(customerList);
		return customerList;
	}

	public int updateCustomerInfo(String id, String pwd, String name, String email, String phone, int mileage) throws SQLException {
		String sql = "update customer "
				+ "set c_id = ?, c_pwd = ?, c_name = ?, c_email = ?, c_phone = ?, c_mileage = ? "
				+ "where c_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultCount = 0;
		
		try {
			conn = dataUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setInt(6, mileage);
			pstmt.setString(7, id);
			
			resultCount = pstmt.executeUpdate();
		} finally {
			dataUtil.close(conn, pstmt);
		}
		return resultCount;
	}

	public int deleteCustomerById(String id) throws SQLException {
		String sql = "delete "
				+ "from customer "
				+ "where c_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultCount = 0;
		
		try {
			conn = dataUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			resultCount = pstmt.executeUpdate();
		} finally {
			dataUtil.close(conn, pstmt);
		}
		return resultCount;
	}
}
