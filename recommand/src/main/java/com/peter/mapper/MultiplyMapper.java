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

public class MultiplyMapper extends Mapper<LongWritable,Text,Text,Text>
{
	private Text outKey = new Text();
	private Text outValue = new Text();
	private List<String> cacheList = new ArrayList<String>();
	
	private DecimalFormat df = new DecimalFormat("0.00");
	
	/***
	 * 	将转置后的数据文件缓存到内存中，每一行为一个字符串，是所有行构成list
	 */
	@Override
	protected void setup(Context context)throws IOException, InterruptedException {
		FileReader fr = new FileReader("itemUserScore3");
		FileReader fr1 = new FileReader("itemUserScore4");
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
		String[] rowAndline = value.toString().split("\t");
		String row_matrix1 = rowAndline[0];//获得行号
		String[] column_value_array_matrix1 = rowAndline[1].split(",");		//获得各列
		for(String line : cacheList)
		{
			String[] rowAndline2 = line.toString().split("\t");
			String row_matrix2 = rowAndline2[0];	//获得转置矩阵line行的行号（原右矩阵的列号）
			String[] column_value_array_matrix2 = rowAndline2[1].split(",");//获得各类数据
			//相乘累加
			double result = 0;
			for(String column_value_matrix1 : column_value_array_matrix1)//对于左侧矩阵line行的每一列
			{
				String column_maxtrix1 = column_value_matrix1.split("_")[0];//获得列号
				String value_matrix1 = column_value_matrix1.split("_")[1];//获得该列的值
				
				for(String column_value_matrix2 : column_value_array_matrix2)//对于右侧矩阵的line行的每一列
				{
					String column_maxtrix2 = column_value_matrix2.split("_")[0];//获得列号
					String value_matrix2 = column_value_matrix2.split("_")[1];//获得该列的值
					//同一个物品的评分乘积不同物品累加
					if(column_maxtrix2.equals(column_maxtrix1))//这里也体现了为什么要标明列号，只有列号明确且相等，才证明是同一个位置的分量
					{
						result += Double.valueOf(value_matrix1) * Double.valueOf(value_matrix2);
					}
				}
			}
			if(result == 0)
				continue;
			
			outKey.set(row_matrix1);//输出的key值设置为左侧矩阵的行号
			outValue.set(row_matrix2 + "_" +df.format(result));//输出的value值设置为右侧转置矩阵的行号(实际矩阵的列号)_该位置的值
			context.write(outKey, outValue);
			
		}
	}
}
