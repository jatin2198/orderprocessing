package com.ordersprocessing.model;

//@Entity//
public class Order {

	//Id

	private OrderKey key;
	//
    private String customerId;
    private String productId;
    private Integer quantity;
    private double price;
    private String timestamp;
	
	public OrderKey getKey() {
		return key;
	}
	public void setKey(OrderKey key) {
		this.key = key;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Order(String orderId, String customerId, String productId, int quantity, double price, String timestamp) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + ", price=" + price + ", timestamp=" + timestamp + "]";
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
