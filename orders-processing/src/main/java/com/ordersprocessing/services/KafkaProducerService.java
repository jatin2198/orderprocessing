package com.ordersprocessing.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

 @Autowired
 private KafkaTemplate<String, String> kafkaTemplate;

 public void sendMessage(String filePath) {

     kafkaTemplate.send(
             "file-topic",
             filePath);

     System.out.println(
             "Message Sent : " + filePath);
 }
}
