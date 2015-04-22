package category.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object resData = request.getAttribute("res_data");
		//배열이거나 Collection이면 JSONArray 아니면 JSONObject이용
		String returnValue = null;
		if(resData instanceof Collection || resData.getClass().isArray()){
			JSONArray jarr;
			try {
				if(resData instanceof Collection){
					Collection c = (Collection)resData;//배열은 Object 타입으로 넣어도 되지만 Collection은 형변환해서 넣어야 한다.
					jarr = new JSONArray(c);
				}else{
					jarr = new JSONArray(resData);
				}
				
				returnValue = jarr.toString();
			} catch (JSONException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}else{
			JSONObject jobj = new JSONObject(resData);
			returnValue = jobj.toString();
		}
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter out = response.getWriter();
		out.print(returnValue);
				
	}

}
