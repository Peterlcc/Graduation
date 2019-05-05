package com.peter.mapper;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ScoreMapper extends Mapper<LongWritable, Text, Text, Text> {
	private Text outKey = new Text();
	private Text outValue = new Text();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String[] values = value.toString().split(",");
		String userId=values[0];
		String itemId=values[1];
		String score=values[2];
		outKey.set(itemId);
		outValue.set(userId+"_"+score);
		context.write(outKey, outValue);
	}
}
