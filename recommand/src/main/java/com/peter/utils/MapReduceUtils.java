package com.peter.utils;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.OutputFormat;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MapReduceUtils {
	/**
	 * 创建Job 
	 * @param configuration 
	 * @param jobClass 驱动类
	 * @param inputpath 输入路径
	 * @param inputFormat 输入格式化的类
	 * @param mapperClass
	 * @param mapKeyClass mapper输出的key
	 * @param mapValueClass mapper输出的value
	 * @param outputpath 输出路径
	 * @param outputFormat 输出格式化的类
	 * @param reducerClass
	 * @param outkeyClass 输出的key
	 * @param outvalueClass 输出的value
	 * @return
	 * @throws IOException
	 */
	public static Job buildJob(
			Configuration configuration,
			Class<?> jobClass,
			String inputpath,
            Class<? extends InputFormat> inputFormat,
            Class<? extends Mapper> mapperClass,
            Class<?> mapKeyClass,
            Class<?> mapValueClass,
            String output,
            Class<? extends OutputFormat> outputFormat,
            Class<? extends Reducer> reducerClass,
            Class<?> outkeyClass,
            Class<?> outvalueClass,
            int reduceNum) throws IOException {
		String jobName = jobClass.getSimpleName();
        Job job = Job.getInstance(configuration, jobName);
        
        job.setJarByClass(jobClass);
        
        job.setMapperClass(mapperClass);
        job.setMapOutputKeyClass(mapKeyClass);
        job.setMapOutputValueClass(mapValueClass);
        
        if (reducerClass != null) {
        	job.setNumReduceTasks(reduceNum);
            job.setReducerClass(reducerClass);
            job.setOutputKeyClass(outkeyClass);
            job.setOutputValueClass(outvalueClass);
        }
        
        job.setInputFormatClass(inputFormat);//就是设置如何将输入文件解析成一行一行内容的解析类
        job.setOutputFormatClass(outputFormat);
        Path outputpath = new Path(output);
        outputpath.getFileSystem(configuration).delete(outputpath, true);//如果当前输出目录存在，删除之，以避免.FileAlreadyExistsException
        FileInputFormat.setInputPaths(job, inputpath);
        FileOutputFormat.setOutputPath(job, outputpath);
        
        return job;
	}
	public static Job buildDBJob1(
			Configuration configuration,
			Class<?> jobClass,
			
			String driverName,
			String url,
			String dbuser,
			String dbpasswd,
			
            Class<? extends InputFormat> inputFormat,
            Class<? extends Mapper> mapperClass,
            
            Class<?> mapKeyClass,
            Class<?> mapValueClass,
            
            Class<? extends OutputFormat> outputFormat,
            
            Class<? extends Reducer> reducerClass,
            Class<?> outkeyClass,
            Class<?> outvalueClass,
            int reduceNum,
            
            Class<? extends DBWritable> inputTableClass,
            String inputTableName,
            String conditions,
            String orderBy,
            String[] inputFieldNames,
            
            String output
            ) throws IOException {
		DBConfiguration.configureDB(configuration, driverName, url, dbuser, dbpasswd);
		String jobName = jobClass.getSimpleName();
        Job job = Job.getInstance(configuration, jobName);
        
        job.setJarByClass(jobClass);
        
        job.setMapperClass(mapperClass);
        job.setMapOutputKeyClass(mapKeyClass);
        job.setMapOutputValueClass(mapValueClass);
        
        if (reducerClass != null) {
        	job.setNumReduceTasks(reduceNum);
            job.setReducerClass(reducerClass);
            job.setOutputKeyClass(outkeyClass);
            job.setOutputValueClass(outvalueClass);
        }
        
        job.setInputFormatClass(inputFormat);//就是设置如何将输入文件解析成一行一行内容的解析类
        job.setOutputFormatClass(outputFormat);
        DBInputFormat.setInput(job, inputTableClass, inputTableName, conditions, orderBy, inputFieldNames);
        Path outputpath = new Path(output);
        outputpath.getFileSystem(configuration).delete(outputpath, true);//如果当前输出目录存在，删除之，以避免.FileAlreadyExistsException
        FileOutputFormat.setOutputPath(job, outputpath);
        return job;
	}
	public static Job buildDBJob(
			Configuration configuration,
			Class<?> jobClass,
			
			String driverName,
			String url,
			String dbuser,
			String dbpasswd,
			
            Class<? extends InputFormat> inputFormat,
            Class<? extends Mapper> mapperClass,
            
            Class<?> mapKeyClass,
            Class<?> mapValueClass,
            
            Class<? extends OutputFormat> outputFormat,
            
            Class<? extends Reducer> reducerClass,
            Class<?> outkeyClass,
            Class<?> outvalueClass,
            int reduceNum,
            
            Class<? extends DBWritable> inputTableClass,
            String inputTableName,
            String conditions,
            String orderBy,
            String[] inputFieldNames,
            
            Class<?> outputTableClass,
            String outputTableName,
            String[] outputFieldNames
            ) throws IOException {
		String jobName = jobClass.getSimpleName();
        Job job = Job.getInstance(configuration, jobName);
        
        job.setJarByClass(jobClass);
        
        job.setMapperClass(mapperClass);
        job.setMapOutputKeyClass(mapKeyClass);
        job.setMapOutputValueClass(mapValueClass);
        
        if (reducerClass != null) {
        	job.setNumReduceTasks(reduceNum);
            job.setReducerClass(reducerClass);
            job.setOutputKeyClass(outkeyClass);
            job.setOutputValueClass(outvalueClass);
        }
        
        job.setInputFormatClass(inputFormat);//就是设置如何将输入文件解析成一行一行内容的解析类
        job.setOutputFormatClass(outputFormat);
        DBInputFormat.setInput(job, inputTableClass, inputTableName, conditions, orderBy, inputFieldNames);
        DBOutputFormat.setOutput(job, outputTableName, outputFieldNames);
        
        return job;
	}
	/**
	 * 运行job
	 * @param job
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void doJob(Job job) throws ClassNotFoundException, IOException, InterruptedException {
		boolean waitForCompletion = job.waitForCompletion(true);
		System.exit(waitForCompletion?0:1);
	}
}
