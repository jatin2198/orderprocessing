package com.ordersprocessing.validations;

import org.springframework.stereotype.Component;

import com.ordersprocessing.exceptions.InvalidOrderException;
import com.ordersprocessing.model.Order;

@Component
public class QuantityValidation
        implements ValidationStrategy {

	@Override
	    public void validate(Order order) {
		// TODO Auto-generated method stub
		
        if( order.getQuantity() <= 0) {

            throw new InvalidOrderException(
                    "Invalid Quantity");
        }

		
	    }

 

}