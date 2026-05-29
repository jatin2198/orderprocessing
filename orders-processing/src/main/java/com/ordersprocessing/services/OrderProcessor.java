package com.ordersprocessing.services;

//============================
//6. OrderProcessor.java
//============================

package com.example.demo.batch;

import com.example.demo.model.Order;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor
     implements ItemProcessor<Order, Order> {

 @Override
 public Order process(Order order) {

     if (order.getQuantity() <= 0) {
         return null;
     }

     if (order.getProductId() == null
             || order.getProductId().isBlank()) {

         return null;
     }

     return order;
 }
}
