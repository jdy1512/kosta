package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DataUtil {
	private static DataUtil dataUtil;
	private BasicDataSource dataSource;
	
	private DataUtil(ServletContext context) {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(context.getInitParameter("driver"));
		dataSource.setUrl(context.getInitParameter("url"));
		dataSource.setUsername(context.getInitParameter("username"));
		dataSource.setPassword(context.getInitParameter("password"));
		
		dataSource.setInitialSize(10);
		dataSource.setMaxIdle(3);
		dataSource.setMinIdle(3);
		dataSource.setMaxWait(2000);
	}
	
	public static DataUtil getInstance(ServletContext context) {
		if (dataUtil == null) {
			dataUtil = new DataUtil(context);
		}
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
