package filter.encoding;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// <filter>, <filter-mapping> → @WebFilter
@WebFilter("/*")// 모든 요청에 호출 되는 필터.
public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// 사전 작업
		arg0.setCharacterEncoding("utf-8");
		arg1.setContentType("text/html;charset=utf-8");
		System.out.println("Filter 전처리");
		
		arg2.doFilter(arg0, arg1);// 다음 컴포넌트 (필터, 서블릿, ...) 호출
		
		// 후처리 작업
		System.out.println("Filter 후처리");
		
	}
}
