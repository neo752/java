package org.dang.action.main;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.dang.dao.MainDao;
import org.dang.dao.main.MainDaoImpl;
import org.dang.entity.Product;

public class HotAction {
	private List<Product> plist;
	private int datewhere;
	private boolean ok;
	public String hot(){
		MainDao mDao=new MainDaoImpl();
		int size=8;
		try {
			plist=mDao.findAllTopProduct(size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String newhot(){
		MainDao mDao=new MainDaoImpl();
		int size=10;
		long begin=0;
		long end = 0;
		if(datewhere==1){
			Date d=new Date(System.currentTimeMillis());
			begin=getFirstDayOfWeek(d);
			end=begin+(86400000L);
		}else if(datewhere==2){
			Date d=new Date(System.currentTimeMillis());
			Date d1=new Date((d.getYear()+1900)+"/"+(d.getMonth()+1)+"/1");
			begin=d1.getTime();
			end=begin+(2592000000L);
		}else{
			Date d1=new Date(datewhere+"/1/1");
			begin=d1.getTime();
			end=begin+(31536000000L);
		}
		System.out.println(222);
		try {
			plist=mDao.findAllHotNewTopProduct(size,begin,end);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	  public static long getFirstDayOfWeek(Date date) {
		  Calendar c = new GregorianCalendar();
		  c.setFirstDayOfWeek(Calendar.MONDAY);
		  c.setTime(date);
		  c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); 
		  return c.getTime().getTime();
		  } 

	public boolean getOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public List<Product> getPlist() {
		return plist;
	}

	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
	public int getDatewhere() {
		return datewhere;
	}
	public void setDatewhere(int datewhere) {
		this.datewhere = datewhere;
	}
	
	
//	public static void main(String[] args) {
//		Date d=new Date(System.currentTimeMillis());
//		String s=(d.getYear()+1900)+"/"+(d.getMonth()+1)+"/1";
//		Date d1=new Date((d.getYear()+1900)+"/"+(d.getMonth()+1)+"/1");
//		long begin=d1.getTime();
//		long end=begin+(31536000000L);
//		System.out.println(d1);
//	}
}
