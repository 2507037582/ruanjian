package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class filter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//???HttpSession?????ж??????
		
				HttpServletRequest servletRequest = (HttpServletRequest) arg0;
				HttpServletResponse servletResponse = (HttpServletResponse) arg1;
				HttpSession session = servletRequest.getSession(false);
				String path = servletRequest.getRequestURI();
				if(path.indexOf("/login") > -1||path.indexOf("/register")>-1) {
					   arg2.doFilter(servletRequest, servletResponse);
					   return;
					  }
				Object object = null;
				 if(session != null && (object = session.getAttribute("username"))!=null){
					 arg2.doFilter(servletRequest, servletResponse);
				 }else{
					 servletResponse.sendRedirect("/ruanjian/login");
				 }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
