package org.dang.dao;

import java.util.List;

import org.dang.entity.UpFile;


public interface FileDao {
	public  List<UpFile> FindAllById(int id)throws Exception;
	public void addfile(UpFile uf) throws Exception;
	public List<UpFile> DelFileByFileName(int id,String mfFileName)throws Exception;
	public List<UpFile> modifyFileByFileName(int id, String mfContentType,String mfFileName)throws Exception;
}
