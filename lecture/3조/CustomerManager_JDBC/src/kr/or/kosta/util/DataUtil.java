package kr.or.kosta.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataUtil {
	private static DataUtil dataUtil = new DataUtil();
	private BasicDataSource dataSource;
	
	private DataUtil() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		
		dataSource.setInitialSize(3);
		dataSource.setMaxTotal(10);
		dataSource.setMaxWaitMillis(1000);
		dataSource.setMaxIdle(3);
		dataSource.setMinIdle(3);
	}
	
	public static DataUtil getInstance() {
		return dataUtil;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void close(Connection conn, Statement stmt) throws SQLException {
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
	
	public void close(Connection conn, Statement stmt, ResultSet rset) throws SQLException {
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
}
