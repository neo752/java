package org.dang.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dang.dao.FileDao;
import org.dang.entity.UpFile;
import org.dang.util.DbUtil;


public class FileDaoImpl implements FileDao{

	public List<UpFile> FindAllById(int id) throws Exception {
		Connection conn=null;
		String sql="select * from d_upfile where userid=?";
		List<UpFile> flist=new ArrayList<UpFile>();
		try {
			conn=DbUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()){
				UpFile 	f=new UpFile();
				f.setFilename(rs.getString("filename"));
				f.setFiletype(rs.getString("filetype"));
				f.setContenttype(rs.getString("contenttype"));
				f.setAddtime(rs.getDate("addtime"));
				f.setUserid(id);
				f.setId(rs.getInt("id"));
				flist.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		return flist;
	}
	public void addfile(UpFile uf) throws Exception {
		Connection conn=null;
		String sql="insert into d_upfile(filename,filetype,contenttype,userid,addtime) value(?,?,?,?,?)";
		try {
			conn=DbUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, uf.getFilename());
			ps.setString(2, uf.getFiletype());
			ps.setString(3, uf.getContenttype());
			ps.setInt(4, uf.getUserid());
			ps.setDate(5,uf.getAddtime());
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
	}
	public List<UpFile> DelFileByFileName(int id, String mfFileName)throws Exception {
		Connection conn=null;
		String sql="delete from d_upfile where filename=? and userid=?";
		try {
			conn=DbUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, mfFileName);
			ps.setInt(2, id);
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		List<UpFile> ulist=FindAllById(id);
		return ulist;
	}
	public List<UpFile> modifyFileByFileName(int id, String mfContentType,String mfFileName)throws Exception {
		Connection conn=null;
		String sql="update d_upfile set filename=? where userid=? and filename=?";
		try {
			conn=DbUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, mfContentType);
			ps.setInt(2, id);
			ps.setString(3, mfFileName);
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.closeConnection();
		}
		List<UpFile> ulist=FindAllById(id);
		return ulist;
	}
	
}
