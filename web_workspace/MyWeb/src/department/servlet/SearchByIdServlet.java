package department.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DataUtilListener;

public class SearchByIdServlet extends HttpServlet {
	private DataUtilListener dataUtilListener;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		dataUtilListener = DataUtilListener.getInstance();
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String id = req.getParameter("id");
		if (id == null) resp.getWriter().println("ID를 입력하세요.");
		try {
			Integer.parseInt(id);
		} catch (NumberFormatException nfe) {
			resp.getWriter().println("ID는 숫자만 입력하세요.");
		}
		
		String sql = "select * from department where department_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = "";
		try {
			conn = dataUtilListener.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				result += "id : " + rset.getInt("department_id") + ", name : "
						+ rset.getString("department_name") + ", loc : "
						+ rset.getString("location") + "<br/>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dataUtilListener.close(conn, pstmt, rset);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		req.setAttribute("resultMessage", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/department/search_result.jsp");
		dispatcher.forward(req, resp);
	}
}
