package com.demo;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;



public class TVDriverClass {
	
	@SuppressWarnings("deprecation")

	public static void main(String[] args)throws Exception {
		// Driver code 
		
		Configuration conf=new Configuration();
		Job job=new Job(conf,"InvalidTV7");
		job.setJarByClass(TVDriverClass.class);
		job.setMapOutputKeyClass(NullWritable.class);
		job.setMapOutputValueClass(Text.class);
		
		
		job.setMapperClass(InvalidTvMapper.class);
		job.setNumReduceTasks(0);
		
		job.setInputFormatClass(TextInputFormat.class);	
		job.setOutputFormatClass(TextOutputFormat.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);

	}

}
