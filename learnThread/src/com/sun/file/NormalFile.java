package com.sun.file;

import java.io.File;

/**
 * 使用普通方法查找某文件下的文件数量
 * @author Administrator
 *
 */
public class NormalFile {

	public static void main(String[] args) {
		File file = new File("g:\\");
		Long start = System.currentTimeMillis();
		int fileC = fileCount(file);
		System.out.println("count=>"+fileC);
		System.err.println("time=>"+(System.currentTimeMillis()-start));
	}
	
	public static int fileCount(File file) {
		int count = 0;
		File[] f = file.listFiles();
		for (File files : f) {
			if (files.isDirectory()) {
				count += fileCount(files);
			}else {
				count ++;
			}
		}
		return count;
	}
}
