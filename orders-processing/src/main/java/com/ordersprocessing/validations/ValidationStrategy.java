package com.ordersprocessing.validations;

import com.ordersprocessing.model.Order;

public interface ValidationStrategy {
	void validate(Order order);
}
