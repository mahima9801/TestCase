package com.capgemini.ims.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.capgemini.ims.model.ProductModel;

public class Product {
	public Product(){
		
	}
	static Map<Integer, ProductModel> prod = new HashMap<>();
	static{
		prod.put(101, new ProductModel(101,"Hyderabad",LocalDate.of(2019, 01, 15), "Packaging"));
		prod.put(102, new ProductModel(102, "Gurugram",LocalDate.of(2018, 05, 24), "Dispatched"));
		prod.put(103, new ProductModel(103, "Bangalore",LocalDate.of(2019, 05, 26), "Dispatched"));
		prod.put(104, new ProductModel(104, "Pune",LocalDate.of(2020, 01, 19), "Not delivered"));
	}
	static public Map<Integer, ProductModel> get(){
		return prod;
	}

}
