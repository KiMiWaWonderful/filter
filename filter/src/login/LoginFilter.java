package login;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.HttpFilter;

public class LoginFilter extends HttpFilter{

	//1.��Web.xml�ļ��л�ȡsessionKey,redirectURL,uncheckedURLs
	private String sessionKey;
	private String redirectURL;
	private String uncheckedURLs;
	
	@Override
	protected void init() {
		ServletContext servletContext = getFilterConfig().getServletContext();
		
		sessionKey = servletContext.getInitParameter("userSessionKey");
		redirectURL = servletContext.getInitParameter("rediretPage");
		///login/a.jsp,/login/list.jsp,/login/login.jsp,/login/doLogin.jsp
		uncheckedURLs = servletContext.getInitParameter("uncheckedUrls");
		System.out.println("fff");
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		//1.��ȡ�����servletPath
		//http://localhost:8080/filter/login/list.jsp
		//String requestURL=request.getRequestURL().toString();
		///filter/login/list.jsp
		//String requestURI=request.getRequestURI();
		///login/list.jsp
		String servletPath=request.getServletPath();
		
		//2.���1�л�ȡ��servletPath�Ƿ�Ϊ����Ҫ����URL�е�һ�������ǣ���ֱ�ӷ��У���������
		List<String> urls = Arrays.asList(uncheckedURLs.split(","));
		if(urls.contains(servletPath)){
			filterChain.doFilter(request, response);
			return;
		}
		//3.��session�л�ȡsessionKey��Ӧ��ֵ����ֵ�����ڣ����ض���redirectURL
		Object user = request.getSession().getAttribute(sessionKey);
		if(user == null){
			response.sendRedirect(request.getContextPath() + redirectURL);
			return;
		}
		System.out.println("fff");
		//4.�����ڣ�����У��������
		filterChain.doFilter(request, response);
	}

}
