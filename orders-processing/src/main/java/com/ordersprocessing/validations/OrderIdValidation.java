package com.ordersprocessing.validations;

import com.ordersprocessing.exceptions.InvalidOrderException;
import com.ordersprocessing.model.Order;

public class OrderIdValidation implements ValidationStrategy {

	@Override
	public void validate(Order order) {
		// TODO Auto-generated method stub
		
		 if(order.getKey().getOrderId()== null
	                || order.getKey().getOrderId().isBlank()) {

	            throw new InvalidOrderException(
	                    "Invalid OrderId");
	        }
		
	}

}
