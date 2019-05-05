package com.peter.mapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RecommandMapper extends  Mapper<LongWritable,Text,Text,Text>
{
	private Text outKey = new Text();
	private Text outValue = new Text();
	private List<String> cacheList = new ArrayList<String>();
	
	/***
	 * 	将整合数据文件缓存到内存中，每一行为一个字符串，是所有行构成list
	 */
	@Override
	protected void setup(Context context)throws IOException, InterruptedException {
		FileReader fr = new FileReader("itemUserScore5");
		FileReader fr1 = new FileReader("itemUserScore6");//第一次reducer的结果
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line = br.readLine()) != null)
		{
			cacheList.add(line);
		}
		fr.close();
		br = new BufferedReader(fr1);
		while((line = br.readLine()) != null)
		{
			cacheList.add(line);
		}
		fr1.close();
		br.close();
	}
	
	
	/**
	 * 以
	 * 	1商品的推荐列表：1		A_9.87,B_2.38,C_23.90
		1商品的操作记录：1		A_2,C_5
		为例
	 */
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException 
	{
		String item_matrix1 = value.toString().split("\t")[0];//推荐列表商品号 1
		String[] user_score_array_matrix1 = value.toString().split("\t")[1].split(",");//推荐列表 A_9.87,B_2.38,C_23.90
		
		for(String line : cacheList)//商品的操作记录列表
		{
			String item_matrix2 = line.toString().split("\t")[0];//操作记录商品号 1
			String[] user_score_array_matrix2 = line.toString().split("\t")[1].split(",");//操作记录  A_2,C_5
			
			if(item_matrix1.equals(item_matrix2))//如果推荐列表商品号==操作记录商品号，证明是同一商品，才能操作
			{
				for(String user_score : user_score_array_matrix1)//对于推荐列表中每一个用户  A_9.87,B_2.38,C_23.90
				{
					boolean flag = false;//默认操作过标志位
					String user_matrix1 = user_score.split("_")[0];//用户ID 
					String score_matrix1 = user_score.split("_")[1];//推荐度
					
					for(String user_score2 : user_score_array_matrix2)//对于操作记录中的每一条记录  A_2,C_5
					{
						String user_matrix2 = user_score2.split("_")[0];
						//用户ID
						if(user_matrix1.equals(user_matrix2))//如果两个ID相等 如A_9.87 和A_2 则证明用户A操作过该商品
						{
							flag = true;
						}
					}
					if(flag == false)//如果用户A没有操作过该物品
					{
						outKey.set(user_matrix1);//将用户ID作为Key
						outValue.set(item_matrix1 + "_" +score_matrix1 );//将商品ID_推荐度作为value
						context.write(outKey, outValue);//写入结果集
					}
				}
			}
		}
	}
}