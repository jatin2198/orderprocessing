package com.ordersprocessing.services;




import com.ordersprocessing.model.Order;
import com.ordersprocessing.validations.ValidationStrategy;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.demo.validation.ValidationStrategy;

import org.springframework.batch.item.ItemProcessor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderProcessor
        implements ItemProcessor<Order, Order> {

    @Autowired
    private List<ValidationStrategy> validations;


    public Order process(Order order) {

        try {

            for(ValidationStrategy validation
                    : validations) {

                validation.validate(order);
            }

            return order;
        }

        catch (com.ordersprocessing.exceptions.InvalidOrderException ex) {

            System.out.println(
                    "Validation Failed : "
                            + ex.getMessage());

            return null;
        }

        
    }
}