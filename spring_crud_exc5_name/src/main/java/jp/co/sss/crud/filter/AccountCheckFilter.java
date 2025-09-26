/*package jp.co.sss.crud.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;


public class AccountCheckFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String requestURL = request.getRequestURI();
		HttpSession session = request.getSession();
		

		if (requestURL.indexOf("/html/") != -1 || requestURL.indexOf("/css/") != -1 ||
				requestURL.indexOf("/img/") != -1 || requestURL.indexOf("/js/") != -1
				|| requestURL.endsWith("/favicon.ico")){
			chain.doFilter(request, response);
		}

		if (requestURL.endsWith("/delete/check") || requestURL.indexOf("/regist/") != -1 || requestURL.indexOf("/delete/") != -1) {
			EmployeeBean loginUser = (EmployeeBean) session.getAttribute("loginUser");
			System.out.println(loginUser.getAuthority());
			
			if (loginUser.getAuthority() == 1 || loginUser == null) {
				session.invalidate();
				response.sendRedirect("/spring_crud/");
				return;
			}
		} else {
			chain.doFilter(request, response);
						
		}
		if (requestURL.endsWith("/")){
			session.invalidate();
			
		}

	}
}
*/