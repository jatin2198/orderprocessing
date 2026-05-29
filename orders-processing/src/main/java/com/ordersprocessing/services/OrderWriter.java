package com.ordersprocessing.services;




import com.ordersprocessing.model.Order;
import com.ordersprocessing.repo.DummyDatabase;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class OrderWriter
     implements org.springframework.batch.infrastructure.item.ItemWriter<Order> {

 @Override
 public void write(
         org.springframework.batch.infrastructure.item.Chunk<? extends Order> chunk) {

     DummyDatabase.orders
             .addAll(chunk.getItems());

     System.out.println(
             "Saved Records : "
                     + chunk.getItems().size());
 }
}
