package com.peter.task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.peter.bean.CrawlJob;
import com.peter.utils.CrawlUtil;

public class PushTask extends Thread {
	private BlockingQueue<CrawlJob> pushJobs = new ArrayBlockingQueue<CrawlJob>(50);
	private CrawlUtil crawlUtil = new CrawlUtil();

	public int getSize() {
		return pushJobs.size();
	}
	
	public void addJob(CrawlJob job) {
		try {
			if(job.getJobType()!=5)
				pushJobs.put(job);
			else {
				crawlUtil.saveJob(job);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (pushJobs.size() > 0) {
					crawlUtil.upload(pushJobs.take());
				}
				else {
					TimeUnit.SECONDS.sleep(5);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
