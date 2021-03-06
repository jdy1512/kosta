package servlet.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * init() - 파일에서 값을 읽어 counter 변수에 대입
 * destroy() - counter변수의 값을 파일에 저장
 */
public class CounterServlet extends HttpServlet {
//	private String filePath = "C:\\Users\\KOSTA_03_001_\\Desktop\\kosta\\file_storage\\counter.bat";
	private String filePath; // 초기 파라미터로 부터 조회
	private int counter;// 요청자의 counter 값(몇번째 요청한 것인지)를 저장할 변수.
	
	
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		filePath = config.getInitParameter("filePath");
		DataInputStream dis = null;
		try {
			File file = new File(filePath);
			dis = new DataInputStream(new FileInputStream(file));
			counter = dis.readInt();
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void destroy() {
		DataOutputStream dos = null;
		try {
			File file = new File(filePath);
			dos = new DataOutputStream(new FileOutputStream(file));
			dos.writeInt(counter);
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	// Client의 요청을 처리하는 메소드, 요청방식 - GET : doGet(), POST : doPost()
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 응답 헤더에 content-type을 지정
		resp.setContentType("text/html;charset=UTF-8");
		// 요청한 클라이언트와 연결된 출력Stream
		PrintWriter out = resp.getWriter();
		out.println("<!doctype html>");
		out.println("<html><head><title>카운터서블릿</title></head>");
		out.println("<body>");
		counter++;
		out.println("당신은 " + counter + " 번째 요청자 입니다.");
		out.println("</body></html>");
	}
}
