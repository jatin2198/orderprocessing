package com.ordersprocessing.validations;

import com.ordersprocessing.exceptions.InvalidOrderException;
import com.ordersprocessing.model.Order;

public class ProductValidation implements ValidationStrategy{

	@Override
	public void validate(Order order) {
		// TODO Auto-generated method stub
		
		if(order.getProductId() == null
                || order.getProductId().isBlank()) {

            throw new InvalidOrderException(
                    "Invalid ProductId");
        }
		
	}

}
