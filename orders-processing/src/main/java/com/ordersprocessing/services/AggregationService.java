package com.ordersprocessing.services;

//============================
//9. AggregationService.java
//============================



import org.springframework.stereotype.Service;

import com.ordersprocessing.model.Order;
import com.ordersprocessing.repo.DummyDatabase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AggregationService {

 public void aggregate() {

     Map<String, List<Order>> grouped =

             DummyDatabase.orders
                     .stream()
                     .collect(Collectors.groupingBy(
                             Order::getCustomerId));

     grouped.forEach((customerId, orders) -> {

         int totalQuantity =

                 orders.stream()
                         .mapToInt(Order::getQuantity)
                         .sum();

         double totalSpend =

                 orders.stream()
                         .mapToDouble(o ->
                                 o.getQuantity()
                                         * o.getPrice())
                         .sum();

         System.out.println(
                 customerId
                         + " -> Qty : "
                         + totalQuantity
                         + " Spend : "
                         + totalSpend);
     });
 }
}
