package org.dang.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dang.util.Constant;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 检查是否登陆
		ActionContext ac = invocation.getInvocationContext();
		Map<String, Object> session = ac.getSession();
		if (session.get(Constant.SESSION_USER) == null||session.get(Constant.SESSION_USER) == "") {
			HttpServletRequest hsr=(HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
			String ipPath="";
			if(hsr.getQueryString()==null){
				ipPath=hsr.getRequestURI().substring(hsr.getRequestURI().lastIndexOf("/")+1);
			}else{
				ipPath=hsr.getRequestURI().substring(hsr.getRequestURI().lastIndexOf("/")+1)+"?"+hsr.getQueryString();
			}
			session.put(Constant.SESSION_UPFILE, ipPath);
			return "login";
		} else {
			invocation.invoke();
			return null;
		}
	}

}
