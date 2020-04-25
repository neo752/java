package org.dang.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyUtil {
	public static void copy(File src, File dest) throws IOException {
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		byte[] bbs = new byte[1024];
		int length = -1;
		while ((length = fis.read(bbs)) != -1) {
			fos.write(bbs, 0, length);
		}
		fis.close();
		fos.flush();
		fos.close();
	}
}
