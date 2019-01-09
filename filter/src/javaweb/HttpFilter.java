package javaweb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * �Զ���� HttpFilter, ʵ���� Filter �ӿ�
 *
 */
public abstract class HttpFilter implements Filter {

	/**
	 * ���ڱ��� FilterConfig ����. 
	 */
	private FilterConfig filterConfig;
	
	/**
	 * ������̳еĳ�ʼ������. ����ͨ�� getFilterConfig() ��ȡ FilterConfig ����. 
	 */
	protected void init(){
		
	}
	
	/**
	 * ֱ�ӷ��� init(ServletConfig) �� FilterConfig ����
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	/**
	 * ԭ���� doFilter ����, �ڷ����ڲ��� ServletRequest �� ServletResponse 
	 * תΪ�� HttpServletRequest �� HttpServletResponse, �������� 
	 * doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	 * 
	 * ����д Filter �Ĺ��˷���������ֱ�Ӽ̳и÷���. ������̳�
	 * doFilter(HttpServletRequest request, HttpServletResponse response, 
	 *		FilterChain filterChain) ����
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)rep;
 
		doFilter(request, response, chain);
	}
	
	/**
	 * ���󷽷�, Ϊ Http ������. ����ʵ�ֵķ���. 
	 */
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain)
			throws IOException,ServletException;

	/**
	 * ����������ֱ�Ӹ���. ��ֱ�Ӹ���, �����ܻᵼ�� filterConfig ��Ա������ʼ��ʧ��
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
		init();
	}
	
	/**
	 * �յ� destroy ������ 
	 */
	@Override
	public void destroy() {
		
	}
}
