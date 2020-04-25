package org.dang.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoggerInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("记录信息");
		//action及result之前，并执行Log记录操作。
		invocation.invoke();
		//action及result之后
		System.out.println("结束记录");
		return null;//最后的返回值需要没有使用invoke（）方法的情况下有用。
	}

}
