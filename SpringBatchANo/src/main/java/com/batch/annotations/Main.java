package com.batch.annotations;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main 
{
	public static void main(String[] args)
	{
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.register(Main.class);
	context.refresh();
	//load jobLauncher details from job.xml file
	JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
	//load Job details from job.xml file
	Job job = (Job) context.getBean("loadJob");
	//run job
	JobExecution execution = jobLauncher.run(job, new JobParameters());
	System.out.println("Exit Status : " + execution.getStatus());
	}
}

