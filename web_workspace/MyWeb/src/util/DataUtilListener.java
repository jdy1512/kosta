package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DataUtilListener implements ServletContextListener {
	private static DataUtilListener dataUtil;
	private BasicDataSource dataSource;
	
	public static DataUtilListener getInstance() {
		return dataUtil;
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		dataUtil = this;
		
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

	// app. 종료 - BasicDataSource객체.close() => ConnectionPool내의 모든 Connection들을 close()
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			dataSource.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
