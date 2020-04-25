package org.dang.interceptor;

import java.util.Map;

import org.dang.entity.User;
import org.dang.util.Constant;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckEmailIpInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac = invocation.getInvocationContext();
		Map<String, Object> session = ac.getSession();
		User user=(User)session.get(Constant.SESSION_USER);
		if(user==null){
			return "login";
		}
		String isString=user.getIs_email_verify();
		if(isString.equals(Constant.NO)){
			return "checkcode";
		}
			invocation.invoke();
			return null;
		
	}

}
