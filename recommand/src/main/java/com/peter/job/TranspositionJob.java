package com.peter.job;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.peter.mapper.TranspositionMapper;
import com.peter.reducer.TranspositionReducer;
import com.peter.utils.MapReduceUtils;

public class TranspositionJob extends Configured implements Tool{

	public static void main(String[] args) throws Exception {
		int run = ToolRunner.run(new Configuration(), new TranspositionJob(), args);
		System.exit(run);
	}

	public int run(String[] args) throws Exception {
		Job job = MapReduceUtils.buildJob(getConf(), TranspositionJob.class,
				args[0], TextInputFormat.class,
				TranspositionMapper.class, Text.class, Text.class,
				args[1], TextOutputFormat.class, 
				TranspositionReducer.class, Text.class, Text.class,2);
		return job.waitForCompletion(true)?1:-1;
	}

}

