package com.demo;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class InvalidTvMapper extends Mapper<LongWritable ,Text ,NullWritable,Text>{

	public void map(LongWritable key,Text value,Context con) throws IOException, InterruptedException
	{
/*  Mapper code to remove entries with 'NA"*/

		String tvList=value.toString();
		String [] tv=tvList.split("\\|");
		
		if(tv[0].length()==2 || tv[1].equals("NA"))
		{
			//do nothing
		}
		else


		{
			
			con.write(NullWritable.get(), value);


		}}


}
