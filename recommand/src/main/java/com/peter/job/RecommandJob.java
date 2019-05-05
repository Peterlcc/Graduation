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

import com.peter.mapper.RecommandMapper;
import com.peter.reducer.ResembleReducer;
import com.peter.utils.MapReduceUtils;

public class RecommandJob extends Configured implements Tool{

	public static void main(String[] args) throws Exception {
		int run = ToolRunner.run(new Configuration(), new RecommandJob(), args);
		System.exit(run);
	}

	public int run(String[] args) throws Exception {
		Job job = MapReduceUtils.buildJob(getConf(), RecommandJob.class,
				args[0], TextInputFormat.class,
				RecommandMapper.class, Text.class, Text.class,
				args[1], TextOutputFormat.class, 
				ResembleReducer.class, Text.class, Text.class,2);
		job.addCacheArchive(new URI("/user/icss/mr/input/score/part-r-00000" + "#itemUserScore5"));
		job.addCacheArchive(new URI("/user/icss/mr/input/score/part-r-00001" + "#itemUserScore6"));
		return job.waitForCompletion(true)?1:-1;
	}

}
