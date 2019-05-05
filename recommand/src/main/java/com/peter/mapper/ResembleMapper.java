package com.peter.mapper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;

public class ResembleMapper extends Mapper<LongWritable,Text,Text,Text>
{
	private Text outKey = new Text();
	private Text outValue = new Text();
	private List<String> cacheList = new ArrayList<String>();
	private DecimalFormat df = new DecimalFormat("0.00");//格式化数字
	
	/*
	 * 	将整合后的数据文件缓存到内存中，每一行为一个字符串，是所有行构成list
	 */
	@Override
	protected void setup(Context context)throws IOException, InterruptedException {
		FileReader fr = new FileReader("itemUserScore1");
		FileReader fr1 = new FileReader("itemUserScore2");
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
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		System.out.println("map,key=" + key + ",value=" + value.toString());
		String[] rowAndline = value.toString().split("\t");//value ：1	A_2,C_5
		String row_matrix1 = rowAndline[0];//获取行号1
		String[] column_value_array_matrix1 = rowAndline[1].split(",");//分别获取 A_2和C_5
		//余弦相似度：同一人对两个物品的评分相乘的和除以两个物品的评分的模的积
		
		//1.|x|=sqrt(x1^2+x2^2+...)求当前物品模
		double denominator1 = 0;//分母
		for(String colunm : column_value_array_matrix1)//对于向量1的每一个分量
		{
			String score = colunm.split("_")[1];//获取评分
			denominator1 +=  Double.valueOf(score) * Double.valueOf(score);//计算分量的平方并累加到模方
		}
		denominator1 = Math.sqrt(denominator1);//开跟号得到模
		
		//2.求其他各物品的模
		for(String line : cacheList)
		{
			String[] rowAndline2 = line.toString().split("\t");
			String row_matrix2 = rowAndline2[0];
			String[] column_value_array_matrix2 = rowAndline2[1].split(",");	
			double denominator2 = 0;
			for(String colunm : column_value_array_matrix2)
			{
				String score = colunm.split("_")[1];
				denominator2 +=  Double.valueOf(score) * Double.valueOf(score);
			}
			denominator2 = Math.sqrt(denominator2);
			//3.求同一个用户对两个物品的评分的积累加求和
			int numerator = 0;
			for(String column_value_matrix1 : column_value_array_matrix1)//对于向量1的每一列(分量) A_2,C_5
			{
				//当前物品
				String column_maxtrix1 = column_value_matrix1.split("_")[0];//获得用户ID
				String value_matrix1 = column_value_matrix1.split("_")[1];//获得分数
				//其他各物品
				for(String column_value_matrix2 : column_value_array_matrix2)//对于向量2的每一列(分量) A_10,B_3
				{
					String column_maxtrix2 = column_value_matrix2.split("_")[0];
					String value_matrix2 = column_value_matrix2.split("_")[1];
					
					//如果是同一个用户分量相乘不同用户累加
					if(column_maxtrix2.equals(column_maxtrix1))
					{
						numerator += Integer.valueOf(value_matrix1) * Integer.valueOf(value_matrix2);
					}
				}
			}
			//求余弦
			double cos = numerator / (denominator1 * denominator2);

			if(cos == 0)
				continue;
			outKey.set(row_matrix1);//输出的key值设置为左侧矩阵的行号
			outValue.set(row_matrix2 + "_" + df.format(cos));//输出的value值设置为右侧转置矩阵的行号(实际矩阵的列号)_该位置的值
			context.write(outKey, outValue);
		}
	}
}