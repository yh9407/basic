package com.example.basic.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.basic.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IPCheckFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("filter begin");
		HttpServletRequest req = (HttpServletRequest) request;
		
		// ������ ���� ���� Ȯ�� �� ó��
		HttpSession session = req.getSession();
		//���ǿ��� ��� �ڷ����¸� ��� ���� �� �����Ƿ� Object ���·� ����.
		User user = (User) session.getAttribute("user");
		if(user == null) { 
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("/login");
			//�α��� �ߴٸ�, ���ٰ���, �ƴ϶�� �ðܳ� null
		}
		
		
		String ip = request.getRemoteAddr();
		log.debug("ip : " + ip);
		chain.doFilter(req, response);
		log.debug("filter end");
	}
}