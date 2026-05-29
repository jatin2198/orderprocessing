package com.ordersprocessing.services;



import org.springframework.batch.core.launch.JobLauncher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

 @Autowired
 private JobLauncher jobLauncher;

 @Autowired
 private org.springframework.batch.core.job.Job job;
 @RetryableTopic(
	        attempts = "3",
	        dltTopicSuffix = "-dlt"
	)
 @KafkaListener(
         topics = "file-topic",
         groupId = "group1")
 public void consume(String filePath)
         throws Exception {

     System.out.println(
             "Received : " + filePath);

     org.springframework.batch.core.job.parameters.JobParameters params =
             new org.springframework.batch.core.job.parameters.JobParametersBuilder()
                     .addString("filePath", filePath)
                     .addLong(
                             "time",
                             System.currentTimeMillis())
                     .toJobParameters();

     jobLauncher.run(job, params);
 }
 @DltHandler
 public void consumeDlt(String message){

	    System.out.println(
	            "DLT Message : " + message);
	}
}
