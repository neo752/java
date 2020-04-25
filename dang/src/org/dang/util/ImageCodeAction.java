package org.dang.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public class ImageCodeAction {
	
	public static Map<Integer, BufferedImage> getImage(){
		int width = 80, hight = 30;
		// 生成画布
		BufferedImage image = new BufferedImage(width, hight,
				BufferedImage.TYPE_INT_RGB);
		// 获得画笔
		Graphics g = image.getGraphics();
		// 添加背景颜色
		Random r = new Random();
		g.setColor(new Color(r.nextInt(150), r.nextInt(150), r
						.nextInt(150)));// 获得随机颜色
		g.fillRect(0, 15, width, hight);
		// 画干扰线
		for (int i = 0; i < 10; i++) {
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r
					.nextInt(255)));
			g.drawLine(r.nextInt(width), r.nextInt(hight),
					r.nextInt(width), r.nextInt(hight));
		}
		// 画字
			String c = "123456789";
			String o="+-*";
			g.setColor(new Color(255, 255, 255));
			g.setFont(new Font(null, Font.BOLD, r.nextInt(10) + 20));
			String num1=String.valueOf(c.charAt(r.nextInt(c.length())));
			String num2=String.valueOf(c.charAt(r.nextInt(c.length())));
			String oo=String.valueOf(o.charAt(r.nextInt(o.length())));
			int num=0;
			String	number = num1+oo+num2+"=?";
			if(oo.equals("+")){
				num=Integer.parseInt(num1)+Integer.parseInt(num2);
			}else if(oo.equals("-")){
				num=Integer.parseInt(num1)-Integer.parseInt(num2);
			}else if(oo.equals("*")){
				num=Integer.parseInt(num1)*Integer.parseInt(num2);
			}
		g.drawString(number, 10, 25);// 设置随机数后，设置这个数字图片的左下角xy座标。
		// 生成
	Map<Integer,BufferedImage> map=new HashMap<Integer, BufferedImage>();
	map.clear();
	map.put(num,image);
		return map;
	}

	
	
	
}
