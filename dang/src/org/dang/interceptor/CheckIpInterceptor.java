package org.dang.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dang.util.Constant;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckIpInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 记录所有页面
		ActionContext ac = invocation.getInvocationContext();
		Map<String, Object> session = ac.getSession();
			HttpServletRequest hsr=(HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
			String ipPath="";
			if(hsr.getQueryString()==null){
				ipPath=hsr.getRequestURI().substring(hsr.getRequestURI().lastIndexOf("/")+1);
			}else{
				ipPath=hsr.getRequestURI().substring(hsr.getRequestURI().lastIndexOf("/")+1)+"?"+hsr.getQueryString();
			}
			session.put(Constant.SESSION_IPPATH, ipPath);
			invocation.invoke();
			return null;
		
	}

}
