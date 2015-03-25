package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BasicFilter implements Filter {
   public void init(FilterConfig config){
      System.out.println("BasicFilter.init()호출");
   }
   public void destroy(){
      System.out.println("BasicFilter.destroy() 호출");
   }
   
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException{
      System.out.println("BasicFilter.doFilter()호출 - 전처리");
      chain.doFilter(request,response);
      System.out.println("BasicFilter.doFilter()호출 - 후처리");
   }
}