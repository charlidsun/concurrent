package com.sun.file;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 使用工作窃取法，查询文件的数量
 * 
 * @author Administrator
 *
 */
public class Stealing {

	public static void main(String[] args) {
		File file = new File("d:\\");
		long start = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		FileTask customTask = new FileTask(file);
		Future future = forkJoinPool.submit(customTask);
		try {
			System.err.println("forkJoin -----> 文件数目" + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.err.println("forkJoin -----> 耗时"+(System.currentTimeMillis()-start)+"ms");
	}
}

// 任务
class FileTask extends RecursiveTask<Integer> {

	File file;

	public FileTask(File file) {
		this.file = file;
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected Integer compute() {

		File[] f = file.listFiles();
		int count = 0;

		for (File files : f) {

			if (files.isDirectory()) {

				FileTask ft = new FileTask(files);
				ft.fork();
				count += ft.join();

			} else {
				count++;
			}
		}
		return count;
	}

}