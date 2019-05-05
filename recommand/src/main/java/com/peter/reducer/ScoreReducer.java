package com.peter.reducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ScoreReducer extends Reducer<Text, Text, Text, Text> {
	private Text outKey = new Text();
	private Text outValue = new Text();
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String itemId = key.toString();
		Map<String, Integer> map=new HashMap<String, Integer>();
		for (Text value : values) {
			String[] splits = value.toString().split("_");
			String userId=splits[0];
			String score=splits[1];
			
			if (map.get(userId)==null) {
				map.put(userId, Integer.valueOf(score));
			}
			else
			{
				Integer preScore = map.get(userId);
				map.put(userId, Integer.valueOf(score)+preScore);
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(Map.Entry<String, Integer> entry : map.entrySet())
		{
			String userID = entry.getKey();
			String score = String.valueOf(entry.getValue());
			sb.append(userID + "_" + score + ",");
		}
		String line = null;
		if(sb.toString().endsWith(","))
		{
			line = sb.substring(0, sb.length()-1);
		}
		outKey.set(itemId);
		outValue.set(line);
		context.write(outKey, outValue);
	}
}
