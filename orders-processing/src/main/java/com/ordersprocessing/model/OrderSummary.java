package com.ordersprocessing.model;


public class OrderSummary {

	    private String customerId;
	    private int totalQuantity;
	    private double totalSpend;
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public int getTotalQuantity() {
			return totalQuantity;
		}
		public void setTotalQuantity(int totalQuantity) {
			this.totalQuantity = totalQuantity;
		}
		public double getTotalSpend() {
			return totalSpend;
		}
		public void setTotalSpend(double totalSpend) {
			this.totalSpend = totalSpend;
		}
		public OrderSummary() {
			super();
			// TODO Auto-generated constructor stub
		}
		public OrderSummary(String customerId, int totalQuantity, double totalSpend) {
			super();
			this.customerId = customerId;
			this.totalQuantity = totalQuantity;
			this.totalSpend = totalSpend;
		}
		@Override
		public String toString() {
			return "OrderSummary [customerId=" + customerId + ", totalQuantity=" + totalQuantity + ", totalSpend="
					+ totalSpend + "]";
		}

	 
	}

