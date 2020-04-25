package org.dang.action;

import java.util.ArrayList;
import java.util.List;

import org.dang.dao.FileDao;
import org.dang.dao.user.FileDaoImpl;
import org.dang.entity.UpFile;
import org.dang.entity.User;
import org.dang.util.Constant;

public class CheckLoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	public String execute() {
		try {
			if(session.getAttribute(Constant.SESSION_UPFILE)!=null){
				return "success";
			}
			FileDao fdao = new FileDaoImpl();
			int id = ((User) session.getAttribute(Constant.SESSION_USER)).getId();
			List<UpFile> flist = new ArrayList<UpFile>();
			flist = fdao.FindAllById(id);
			session.setAttribute(Constant.SESSION_UPFILE, flist);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
}