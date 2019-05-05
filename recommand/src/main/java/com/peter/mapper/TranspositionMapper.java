package com.peter.mapper;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TranspositionMapper extends Mapper<LongWritable,Text,Text,Text>
{
	private Text outKey = new Text();
	private Text outValue = new Text();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String[] rowAndline = value.toString().split("\t");
		String row = rowAndline[0];
		String[] lines = rowAndline[1].split(",");
		for(String line : lines)
		{
			String colunm = line.split("_")[0];
			String valueStr = line.split("_")[1];
			outKey.set(colunm);
			outValue.set(row + "_" + valueStr);
			context.write(outKey, outValue);
		}
	}
}