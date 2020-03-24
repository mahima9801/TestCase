package com.capgemini.ims.model;

import java.time.LocalDate;

public class ProductModel {
	private int prod_Id;
	private String place;
	private LocalDate date; 
	private String status;
	public ProductModel(int prod_Id, String place, LocalDate date, String status) {
		super();
		this.prod_Id = prod_Id;
		this.place = place;
		this.date = date;
		this.status = status;
	}
	public int getProd_Id() {
		return prod_Id;
	}
	public void setProd_Id(int prod_Id) {
		this.prod_Id = prod_Id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public LocalDate getDate(){
		return date;
	}
	public void setDate(LocalDate date){
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
