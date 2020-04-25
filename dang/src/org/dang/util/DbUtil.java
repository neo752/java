package org.dang.util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

//dbcp,c3p0,proxool
public class DbUtil {
	private static DataSource ds;//连接池类型
	private static ThreadLocal<Connection> connLocal = new ThreadLocal<Connection>();
	static {
		try{
			Properties props = new Properties();
			InputStream in = DbUtil.class.getClassLoader()
				.getResourceAsStream("dbcp.properties");
			props.load(in);//加载连接池配置参数
			ds = BasicDataSourceFactory
				.createDataSource(props);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		//当前线程第一次调用时，新建一个返回
		//当前线程再次调用，返回第一次创建的
		Connection conn = connLocal.get();
		if(conn==null){
		conn=ds.getConnection();//获取连接
		connLocal.set(conn);
		}
		return conn;
	}
	
	public static void closeConnection() throws Exception{
		//清空threadlocal
		//关闭conn
		Connection conn= connLocal.get();
		connLocal.set(null);
		if(conn != null){
			conn.close();//放回连接池
		}
	}
	
	public static void main(String[] args){
		try {
			System.out.println(getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void beginTransaction() throws Exception{
		Connection conn = getConnection();
		conn.setAutoCommit(false);
	}
	public static void commit(){
		try {
			Connection conn = getConnection();
			conn.commit();
		} catch (Exception e) {
		}
	}
	public static void rollack(){
		try {
			Connection conn = getConnection();
			conn.rollback();
		} catch (Exception e) {
		}
	}
}
