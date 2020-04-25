package org.dang.util;
//package org.tarena.dang.util;
//
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.SimpleEmail;
//
//public class EmailUtil {
//	public static void sendEmail(String addr,String code){
//		SimpleEmail email = new SimpleEmail();
//		email.setHostName("smtp.sina.cn");
//		email.setAuthentication("administrator", "11111111");
//		email.setCharset("UTF-8");
//		try {
//			email.addTo(addr);
//			email.setFrom("administrator@sina.cn");//�����Authenticationʹ�õ��û���ͬ������ʧ��
//			email.setSubject("������֤");
//			StringBuffer sb = new StringBuffer();
//			sb.append("��ӭע�ᵱ����������ɵ�һ��ע�ᡣ");
//			sb.append("������Ҫ����������֤����֤��Ϊ:");
//			sb.append(code);
//			email.setMsg(sb.toString());
//			email.send();
//		} catch (EmailException e) {
////			e.printStackTrace(); 
//			System.out.println("�ʼ�����ʧ��");
//		}
//	}
//}
