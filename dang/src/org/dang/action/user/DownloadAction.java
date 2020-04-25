package org.dang.action.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.dang.action.BaseAction;

public class DownloadAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private String fname;
	private InputStream fstream;
	
	@SuppressWarnings("deprecation")
	public String execute(){
		try {	
			fname = new String(fname.getBytes(), "utf-8");
			String realPath=request.getRealPath("/upload");
			String filePath=realPath+File.separatorChar+fname;
			fstream=new FileInputStream(filePath);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public InputStream getFstream() {
		return fstream;
	}
	public void setFstream(InputStream fstream) {
		this.fstream = fstream;
	}
	
	
}
