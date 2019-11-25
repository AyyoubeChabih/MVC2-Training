package org.mql.biblio.web.actions;

import javax.servlet.http.HttpServletRequest;

public class WebContext implements Context {
	private HttpServletRequest request;
	
	public WebContext() {
	}

	public WebContext(HttpServletRequest request) {
		super();
		this.request = request;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getParameter(String name) {
		return request.getParameter(name);
	}

	public void setModel(String key, Object model) {
		request.setAttribute(key, model);
	}

	public Object getModel(String key) {
		return request.getAttribute(key);
	}
}
