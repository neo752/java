package org.dang.action;

import org.dang.util.Constant;


public class CheckCodeAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private String code;
	private boolean ok=false;
	public String execute(){
		int scode1=(Integer) session.getAttribute(Constant.SESSION_CODEUP);
		String scode=String.valueOf(scode1);
		if(code.equals(scode)){
			ok=true;
		}else{ok=false;
		}
		return"success";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
}
