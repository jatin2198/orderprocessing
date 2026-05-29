package com.ordersprocessing.repo;


import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;

@Component
public class DummyDatabase {

 public static List<Order> orders = new ArrayList<>();
}