package org.dang.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import org.dang.util.Constant;
import org.dang.util.ImageCodeAction;




import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private InputStream is;
	
	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public String execute(){
		Map<Integer, BufferedImage> map=ImageCodeAction.getImage();
		int num=0;
		 Iterator< Integer> it = map.keySet().iterator();
		 while(it.hasNext()){
			 num=it.next();
		 }
		BufferedImage image=map.get(num);
		session.setAttribute(Constant.SESSION_CODEUP, num);
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		JPEGImageEncoder jpeg=JPEGCodec.createJPEGEncoder(bos);
		try {
			jpeg.encode(image);
			byte b[]=bos.toByteArray();
			is=new ByteArrayInputStream(b) ;
			return "success";
		} catch (ImageFormatException e) {
			e.printStackTrace();
			return "error";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		
		
	}
}
