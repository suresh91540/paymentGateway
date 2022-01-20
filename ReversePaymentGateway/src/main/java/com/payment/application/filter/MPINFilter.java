package com.payment.application.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class MPINFilter implements Filter {
	
	@Value("${testing.mpin}")
	private String testingMPIN;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		if (httpServletRequest.getHeader("MPIN") == null) {
			httpServletResponse.sendError(401);
			return;
		}
		
		if( httpServletRequest.getHeader("MPIN").equals(testingMPIN)) {
			httpServletResponse.setStatus(200);
		}
		
		chain.doFilter(httpServletRequest, httpServletResponse);
	}
}
