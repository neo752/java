package org.dang.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware,
		SessionAware, ServletContextAware, ParameterAware, ServletRequestAware,
		ServletResponseAware, ApplicationAware {
	private static final long serialVersionUID = 1L;
	protected  HttpServletRequest request;
	protected  HttpServletResponse response;
	protected  HttpSession session;
	protected  ServletContext application;

	protected  Map<String, Object> requestMap;
	protected  Map<String, Object> sessionMap;
	protected  Map<String, Object> applicationMap;
	protected  Map<String, String[]> parameterMap;

	public void  setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}

	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

	public void setServletContext(ServletContext arg0) {
		this.application = arg0;
	}

	public void setParameters(Map<String, String[]> arg0) {
		this.parameterMap = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
		this.session = request.getSession();
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public void setApplication(Map<String, Object> arg0) {
		this.applicationMap = arg0;
	}
}
