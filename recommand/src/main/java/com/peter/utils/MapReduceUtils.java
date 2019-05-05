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
	 * ����Job 
	 * @param configuration 
	 * @param jobClass ������
	 * @param inputpath ����·��
	 * @param inputFormat �����ʽ������
	 * @param mapperClass
	 * @param mapKeyClass mapper�����key
	 * @param mapValueClass mapper�����value
	 * @param outputpath ���·��
	 * @param outputFormat �����ʽ������
	 * @param reducerClass
	 * @param outkeyClass �����key
	 * @param outvalueClass �����value
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
        
        job.setInputFormatClass(inputFormat);//����������ν������ļ�������һ��һ�����ݵĽ�����
        job.setOutputFormatClass(outputFormat);
        Path outputpath = new Path(output);
        outputpath.getFileSystem(configuration).delete(outputpath, true);//�����ǰ���Ŀ¼���ڣ�ɾ��֮���Ա���.FileAlreadyExistsException
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
        
        job.setInputFormatClass(inputFormat);//����������ν������ļ�������һ��һ�����ݵĽ�����
        job.setOutputFormatClass(outputFormat);
        DBInputFormat.setInput(job, inputTableClass, inputTableName, conditions, orderBy, inputFieldNames);
        Path outputpath = new Path(output);
        outputpath.getFileSystem(configuration).delete(outputpath, true);//�����ǰ���Ŀ¼���ڣ�ɾ��֮���Ա���.FileAlreadyExistsException
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
        
        job.setInputFormatClass(inputFormat);//����������ν������ļ�������һ��һ�����ݵĽ�����
        job.setOutputFormatClass(outputFormat);
        DBInputFormat.setInput(job, inputTableClass, inputTableName, conditions, orderBy, inputFieldNames);
        DBOutputFormat.setOutput(job, outputTableName, outputFieldNames);
        
        return job;
	}
	/**
	 * ����job
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
