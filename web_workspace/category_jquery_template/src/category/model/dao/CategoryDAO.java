package category.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import category.util.DBUtil;
import category.vo.Category;
import category.vo.Product;
//싱글톤
public class CategoryDAO {
	private static CategoryDAO instance = new CategoryDAO();
	private DBUtil util;
	private CategoryDAO(){
		util = DBUtil.getInstance();
	}
	public static CategoryDAO getInstance(){
		return instance;
	}
	/**
	 * 대분류 상품 카테고리 조회
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Category> selectAllFirstCategory() throws SQLException{
		String sql = "select first_category_id, first_category_name from first_category";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> list = new ArrayList<Category>();
		try{
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()){
				list.add(new Category(rset.getString(1), rset.getString(2)));
				
			}
		}finally{
			util.close(conn, pstmt, rset);
		}
		return list;
	}
	/**
	 * 중분류 상품 카테고리 조회
	 * @param firstCategory 대분류 ID
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Category> selectSecondCategoryByFId(String firstCategoryId) throws SQLException{
		String sql = "select second_category_id, second_category_name from second_category where first_category_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> list = new ArrayList<Category>();
		try{
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, firstCategoryId);
			rset = pstmt.executeQuery();
			while(rset.next()){
				list.add(new Category(rset.getString(1), rset.getString(2)));
			}
		}finally{
			util.close(conn, pstmt, rset);
		}
		return list;
	}
	/**
	 * 소분류 상품 카테고리 조회
	 * @param secondCategory 중분류  ID
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Category> selectThirdCategoryBySId(String secondCategoryId) throws SQLException{
		String sql = "select third_category_id, third_category_name from third_category where second_category_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Category> list = new ArrayList<Category>();
		try{
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, secondCategoryId);
			rset = pstmt.executeQuery();
			while(rset.next()){
				list.add(new Category(rset.getString(1), rset.getString(2)));
			}
		}finally{
			util.close(conn, pstmt, rset);
		}
		return list;
	}
	/**
	 * 소분류를 받아 그 소분류에 속한 상품 리스트를 조회
	 * @param categoryId : 조회할 소분류 ID
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Product> selectProductInfoByTId(String thirdCategoryId) throws SQLException{
		String sql = "select product_id, product_name, product_price, product_maker, product_info, third_category_id from product where third_category_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try{
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thirdCategoryId);
			rset = pstmt.executeQuery();
			while(rset.next()){
				list.add(new Product(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5), rset.getString(6)));
			}
		}finally{
			util.close(conn, pstmt, rset);
		}
		return list;
	}
	public Product selectProductById(String productId) throws SQLException{
		String sql = "select product_id, product_name, product_price, product_maker, product_info, third_category_id from product where product_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product p = null;
		try{
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);
			rset = pstmt.executeQuery();
			while(rset.next()){
				p = new Product(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5), rset.getString(6));
			}
		}finally{
			util.close(conn, pstmt, rset);
		}
		return p;
	}
}
