package com.cg.training.ZuulDemo;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {

	private static Logger log = Logger.getLogger(PreFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();

	    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

	    return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
