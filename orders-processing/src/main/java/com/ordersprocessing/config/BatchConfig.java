package com.ordersprocessing.config;





import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.job.builder.JobBuilder;

import org.springframework.batch.core.launch.support.RunIdIncrementer;

import org.springframework.batch.core.repository.JobRepository;

import org.springframework.batch.core.step.builder.StepBuilder;

import org.springframework.batch.item.file.FlatFileItemReader;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;

import org.springframework.batch.item.file.mapping.DefaultLineMapper;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.StepScope;

import org.springframework.core.io.FileSystemResource;

import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

 @Autowired
 private JobRepository jobRepository;

 @Autowired
 private PlatformTransactionManager transactionManager;

 @Autowired
 private OrderProcessor processor;

 @Autowired
 private OrderWriter writer;

 @Bean
 @org.springframework.batch.core.configuration.annotation.StepScope
 public FlatFileItemReader<Order> reader(
         @Value("#{jobParameters['filePath']}")
         String filePath) {

     FlatFileItemReader<Order> reader =
             new FlatFileItemReader<>();

     reader.setResource(
             new FileSystemResource(filePath));

     reader.setLinesToSkip(1);

     DefaultLineMapper<Order> mapper =
             new DefaultLineMapper<>();

     DelimitedLineTokenizer tokenizer =
             new DelimitedLineTokenizer();

     tokenizer.setNames(
             "orderId",
             "customerId",
             "productId",
             "quantity",
             "price",
             "timestamp");

     BeanWrapperFieldSetMapper<Order> fieldSetMapper =
             new BeanWrapperFieldSetMapper<>();

     fieldSetMapper.setTargetType(Order.class);

     mapper.setLineTokenizer(tokenizer);

     mapper.setFieldSetMapper(fieldSetMapper);

     reader.setLineMapper(mapper);

     return reader;
 }

 @Bean
 public Step step() {

     return new StepBuilder(
             "step",
             jobRepository)

             .<Order, Order>chunk(
                     10,
                     transactionManager)

             .reader(reader(null))

             .processor(processor)

             .writer(writer)
             
             // resilience
             .faultTolerant()

             // skip invalid records
             .skip(InvalidOrderException.class)

           

             // max skipped records
             .skipLimit(100)

             .build();
 }

 @Bean
 public Job job() {

     return new JobBuilder(
             "job",
             jobRepository)

             .incrementer(new RunIdIncrementer())
             .listener(batchJobListener)
             .start(step())

             .build();
 }
}
