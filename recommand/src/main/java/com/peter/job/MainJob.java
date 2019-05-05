package com.peter.job;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.jobcontrol.ControlledJob;
import org.apache.hadoop.mapreduce.lib.jobcontrol.JobControl;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.peter.mapper.MultiplyMapper;
import com.peter.mapper.RecommandMapper;
import com.peter.mapper.ResembleMapper;
import com.peter.mapper.ScoreMapper;
import com.peter.mapper.TranspositionMapper;
import com.peter.reducer.MultiplyReducer;
import com.peter.reducer.ResembleReducer;
import com.peter.reducer.ScoreReducer;
import com.peter.reducer.TranspositionReducer;
import com.peter.utils.MapReduceUtils;

public class MainJob {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		Configuration conf = new Configuration();
		Job job1 = MapReduceUtils.buildJob(conf, ScoreJob.class,
				"/user/icss/mr/score", TextInputFormat.class,
				ScoreMapper.class, Text.class, Text.class,
				"/user/icss/mr/input/score", TextOutputFormat.class, 
				ScoreReducer.class, Text.class, Text.class,2);
		
		ControlledJob controlledJob1=new ControlledJob(job1.getConfiguration());
		controlledJob1.setJob(job1);
		
		Job job2 = MapReduceUtils.buildJob(conf, ResembleJob.class,
				"/user/icss/mr/input/score", TextInputFormat.class,
				ResembleMapper.class, Text.class, Text.class,
				"/user/icss/mr/input/resemble", TextOutputFormat.class, 
				ResembleReducer.class, Text.class, Text.class,2);
		job2.addCacheArchive(new URI("/user/icss/mr/input/score/part-r-00000" + "#itemUserScore1"));
		job2.addCacheArchive(new URI("/user/icss/mr/input/score/part-r-00001" + "#itemUserScore2"));
		
		ControlledJob controlledJob2=new ControlledJob(job2.getConfiguration());
		controlledJob2.setJob(job2);
		controlledJob2.addDependingJob(controlledJob1);
		
		Job job3 = MapReduceUtils.buildJob(conf, TranspositionJob.class,
				"/user/icss/mr/input/score", TextInputFormat.class,
				TranspositionMapper.class, Text.class, Text.class,
				"/user/icss/mr/input/transposition", TextOutputFormat.class, 
				TranspositionReducer.class, Text.class, Text.class,2);
		ControlledJob controlledJob3=new ControlledJob(job3.getConfiguration());
		controlledJob3.setJob(job3);
		controlledJob3.addDependingJob(controlledJob2);
		
		Job job4 = MapReduceUtils.buildJob(conf, MultiplyJob.class,
				"/user/icss/mr/input/resemble", TextInputFormat.class,
				MultiplyMapper.class, Text.class, Text.class,
				"/user/icss/mr/input/multiply", TextOutputFormat.class, 
				MultiplyReducer.class, Text.class, Text.class,2);
		job4.addCacheArchive(new URI("/user/icss/mr/input/transposition/part-r-00000" + "#itemUserScore3"));
		job4.addCacheArchive(new URI("/user/icss/mr/input/transposition/part-r-00001" + "#itemUserScore4"));
		ControlledJob controlledJob4=new ControlledJob(job4.getConfiguration());
		controlledJob4.setJob(job4);
		controlledJob4.addDependingJob(controlledJob3);
		
		Job job5 = MapReduceUtils.buildJob(conf, RecommandJob.class,
				"/user/icss/mr/input/multiply", TextInputFormat.class,
				RecommandMapper.class, Text.class, Text.class,
				"/user/icss/mr/input/recommand", TextOutputFormat.class, 
				ResembleReducer.class, Text.class, Text.class,2);
		job5.addCacheArchive(new URI("/user/icss/mr/input/score/part-r-00000" + "#itemUserScore5"));
		job5.addCacheArchive(new URI("/user/icss/mr/input/score/part-r-00001" + "#itemUserScore6"));
		ControlledJob controlledJob5=new ControlledJob(job5.getConfiguration());
		controlledJob5.setJob(job5);
		controlledJob5.addDependingJob(controlledJob4);
		
		JobControl jobControl=new JobControl("mainjob");
		jobControl.addJob(controlledJob1);
		jobControl.addJob(controlledJob2);
		jobControl.addJob(controlledJob3);
		jobControl.addJob(controlledJob4);
		jobControl.addJob(controlledJob5);
		
		Thread t = new Thread(jobControl);
        t.start();

        while (true) {
            if (jobControl.allFinished()) {
                //如果作业成功完成，就打印成功作业的信息
                System.out.println(jobControl.getSuccessfulJobList());
                jobControl.stop();
                break;
            } else
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }

		
	}
}
