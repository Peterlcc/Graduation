package com.peter.job;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.peter.mapper.MultiplyMapper;
import com.peter.reducer.MultiplyReducer;
import com.peter.utils.MapReduceUtils;

public class MultiplyJob extends Configured implements Tool{

	public static void main(String[] args) throws Exception {
		int run = ToolRunner.run(new Configuration(), new MultiplyJob(), args);
		System.exit(run);
	}

	public int run(String[] args) throws Exception {
		Job job = MapReduceUtils.buildJob(getConf(), MultiplyJob.class,
				args[0], TextInputFormat.class,
				MultiplyMapper.class, Text.class, Text.class,
				args[1], TextOutputFormat.class, 
				MultiplyReducer.class, Text.class, Text.class,2);
		job.addCacheArchive(new URI("/user/icss/mr/input/transposition/part-r-00000" + "#itemUserScore3"));
		job.addCacheArchive(new URI("/user/icss/mr/input/transposition/part-r-00001" + "#itemUserScore4"));
		return job.waitForCompletion(true)?1:-1;
	}

}
