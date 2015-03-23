package kr.co.kosta.study.moviereservation.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilManager {
	private static UtilManager dataUtil = new UtilManager();
	
	// 각종 Listener 관리
	private DataUtilListener dataUtilListener;
	
	private UtilManager() {
		dataUtilListener = DataUtilListener.getInstance();
	}
	
	public static UtilManager getInstance() {
		return dataUtil;
	}
	

	// ------------------------- DataUtilListener -------------------------
	
	public Connection getConnectionWithPool() throws SQLException {
		return dataUtilListener.getConnection();
	}
	
	public void close(Connection conn, Statement stmt) throws SQLException {
		dataUtilListener.close(conn, stmt);
	}
	
	public void close(Connection conn, Statement stmt, ResultSet rset) throws SQLException {
		dataUtilListener.close(conn, stmt, rset);
	}
	
	// ------------------------- End Of DataUtilListener -------------------------
	
}
