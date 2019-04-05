package com.peter.run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.peter.bean.CrawlJob;
import com.peter.parse.Parser;
import com.peter.task.PullTask;
import com.peter.task.PushTask;
import com.peter.utils.CrawlUtil;

public class CrawlApplication 
{
	private static Map<String, Thread> threads=new HashMap<String, Thread>();
	private static List<Parser> houseParsers=new ArrayList<Parser>(); 
	
	static {
		threads.put("pullTask", new PullTask());
		threads.put("pushTask", new PushTask());
		
		
	}
	
    public static void main( String[] args )
    {
        CrawlJob job=new CrawlJob();
        job.setJobType(0);
        job.setUrl("https://bj.lianjia.com/");
        CrawlUtil crawlUtil = new CrawlUtil();
        crawlUtil.upload(job);
        initThreads();
        PullTask pullTask=(PullTask) threads.get("pullTask");
        PushTask pushTask=(PushTask) threads.get("pushTask");
        while(true)
        {
        	if(pushTask.getSize()<40)
        	{
        		job=pullTask.getJob();
        		if(job==null) break;
        		List<CrawlJob> list = houseParsers.get(job.getJobType()).parse();
        		for (CrawlJob crawlJob : list) {
					pushTask.addJob(crawlJob);
				}
        	}
        }
    }

	private static void initThreads() {
		for(String key:threads.keySet())
		{
			threads.get(key).start();
		}
	}
}
