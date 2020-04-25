package org.dang.action.user;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.dang.action.BaseAction;
import org.dang.dao.FileDao;
import org.dang.dao.user.FileDaoImpl;
import org.dang.entity.UpFile;
import org.dang.entity.User;
import org.dang.util.Constant;
import org.dang.util.FileCopyUtil;

public class UploadAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private File mf;
	private String mfFileName;
	private String mfContentType;
	private String mfFileType;
	List<UpFile> flist;
	UpFile upfile;

	public String findfiles() {
		try {
			if(session.getAttribute(Constant.SESSION_UPFILE)!=null){
				return "success";
			}
			FileDao fdao = new FileDaoImpl();
			int id = ((User) session.getAttribute(Constant.SESSION_USER)).getId();
			flist = new ArrayList<UpFile>();
			flist = fdao.FindAllById(id);
			session.setAttribute(Constant.SESSION_UPFILE, flist);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String delupfile() {
		try {
			FileDao fdao = new FileDaoImpl();
			int id = ((User) session.getAttribute(Constant.SESSION_USER)).getId();
			flist = new ArrayList<UpFile>();
			flist = fdao.DelFileByFileName(id,mfFileName);
			session.setAttribute(Constant.SESSION_UPFILE, flist);
			
			String realPath = request.getRealPath("/upload");
			String filePath = realPath + File.separatorChar + mfFileName;
			File dest = new File(filePath);
				if(dest.exists()){
					dest.delete();
				}
				return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String modifyfile() {
		try {
			String realPath = request.getRealPath("/upload");
			String filePath = realPath + File.separatorChar + mfFileName;
			String filePath1 = realPath + File.separatorChar + mfContentType;
			if(filePath.equals(filePath1)){
				return "success";}
			File src = new File(filePath);
			File dest = new File(filePath1);
				if(src.exists()){
					FileCopyUtil.copy(src, dest);
					src.delete();
				}
				FileDao fdao = new FileDaoImpl();
				int id = ((User) session.getAttribute(Constant.SESSION_USER)).getId();
				flist = new ArrayList<UpFile>();
				flist = fdao.modifyFileByFileName(id,mfContentType,mfFileName);
				session.setAttribute(Constant.SESSION_UPFILE, flist);
				return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@SuppressWarnings("unchecked")
	public String upload() {
		String realPath = request.getRealPath("/upload");
		String filePath = realPath + File.separatorChar + mfFileName;
		File dest = new File(filePath);
		try {
			if(!dest.exists()){
				File f =new File(realPath);
				if(!f.exists()){
					f.mkdir();
				}
				FileCopyUtil.copy(mf, dest);
				FileDao fdao = new FileDaoImpl();
				int id=((User) session.getAttribute(Constant.SESSION_USER)).getId();
				upfile=new UpFile();
				upfile.setUserid(id);
				upfile.setFilename(mfFileName);
				String filetype=mfFileName.substring(mfFileName.lastIndexOf(".")+1);
				upfile.setFiletype(filetype);
				upfile.setContenttype(mfContentType);
				upfile.setAddtime( new Date(System.currentTimeMillis()));
				fdao.addfile(upfile);
				//更新session
				flist = (List<UpFile>)session.getAttribute(Constant.SESSION_UPFILE);
				flist.add(upfile);
				session.setAttribute(Constant.SESSION_UPFILE, flist);
				return "success";
			}
			return "false";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	
	public String getMfFileType() {
		return mfFileType;
	}

	public void setMfFileType(String mfFileType) {
		this.mfFileType = mfFileType;
	}

	public UpFile getUpfile() {
		return upfile;
	}

	public void setUpfile(UpFile upfile) {
		this.upfile = upfile;
	}

	public List<UpFile> getFlist() {
		return flist;
	}

	public void setFlist(List<UpFile> flist) {
		this.flist = flist;
	}

	public File getMf() {
		return mf;
	}

	public void setMf(File mf) {
		this.mf = mf;
	}

	public String getMfFileName() {
		return mfFileName;
	}

	public void setMfFileName(String mfFileName) {
		this.mfFileName = mfFileName;
	}

	public String getMfContentType() {
		return mfContentType;
	}

	public void setMfContentType(String mfContentType) {
		this.mfContentType = mfContentType;
	}

}
