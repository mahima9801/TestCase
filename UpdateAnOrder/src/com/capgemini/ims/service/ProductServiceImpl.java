package com.capgemini.ims.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.ims.dao.ProductDAOImpl;
import com.capgemini.ims.exception.NoDataFoundException;

public class ProductServiceImpl {
ProductDAOImpl ups = new ProductDAOImpl();
	
	public String updateStatusService(int Id, String place, LocalDate date, String status) throws NoDataFoundException{
		
		String result = "Not valid id";
		List<Integer> list = ups.getId();//fetch all the ids of product
		if(Id<0){
			result="No negative Id. Enter a positive Id";
		}
		if(Id==0){
			result = "Id cannot be 0";
			return result;
		}
		for(Integer i:list){
			if(i==Id){
				result=ups.updateproductStatus(Id, place, date, status);
			}
			else{
				throw new NoDataFoundException();
			}
		}
		return result;
	}
	
	public boolean validateService(int Id) throws NoDataFoundException{
		boolean check = false;
		for(Integer i : ups.getId()){
			if(i == Id){
				check=true;
			}
		}
		if(check){
			return check;
		}
		else{
			throw new NoDataFoundException();
		}
		
		
	}
	public boolean dateValidate(String date){
		if(date.matches("\\d{4}-\\d{2}-\\d{2}")){
			return true;
		}
		else{
			return false;
		}
	}
	public List<Integer>getId(){
		return ups.getId();
	}
	

}
