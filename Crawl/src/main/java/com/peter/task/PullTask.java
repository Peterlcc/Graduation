package com.peter.task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.peter.bean.CrawlJob;
import com.peter.utils.CrawlUtil;

public class PullTask extends Thread {
	private BlockingQueue<CrawlJob> pullJobs = new ArrayBlockingQueue<CrawlJob>(50);
	private int pullTaskSize = 40;
	private CrawlUtil crawlUtil = new CrawlUtil();

	public CrawlJob getJob() {
		try {
			return pullJobs.take();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (pullJobs.size() < pullTaskSize) {
					CrawlJob crawlJob = crawlUtil.getJob();
					if (crawlJob != null) {
						pullJobs.put(crawlJob);
					}
					else {
						System.out.println("任务已经用光");
						break;
					}
				} else {
					TimeUnit.SECONDS.sleep(3);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
