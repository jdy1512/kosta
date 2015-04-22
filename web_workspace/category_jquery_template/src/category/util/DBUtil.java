package category.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

//싱글톤패턴
public class DBUtil {

	private static DBUtil instance = new DBUtil();
	private BasicDataSource dataSource;//객체 생성 -> 생성자
	
	private DBUtil(){
		//BasiceDataSource객체 생성후 property 설정
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		
		dataSource.setInitialSize(50);
		dataSource.setMaxActive(100);
		dataSource.setMaxIdle(60);
	}
	public static DBUtil getInstance(){
		return instance;
	}
	public BasicDataSource getDataSource(){
		return dataSource;
	}
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public void close(Connection conn, PreparedStatement pstmt) throws SQLException{
		
		if(pstmt!=null){
			pstmt.close();			
		}
		if(conn!=null){
			conn.close();
		}
		
	}
	public void close(Connection conn, PreparedStatement pstmt,
								ResultSet rset) throws SQLException{
		
		if(rset!=null){
			rset.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}	
		if(conn!=null){
			conn.close();
		}
	}
}










