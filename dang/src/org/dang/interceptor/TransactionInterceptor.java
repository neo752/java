package org.dang.interceptor;

import org.dang.util.DbUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TransactionInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//开启事务控制，关闭自动提交
		DbUtil.beginTransaction();
		try {
			//调用Action，result
			invocation.invoke();
			//提交或回滚事务
			DbUtil.commit();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			DbUtil.rollack();//回滚
			throw e;
		}
		finally{
			DbUtil.closeConnection();
		}
	}

}
