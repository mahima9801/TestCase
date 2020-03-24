package com.capgemini.ims.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.capgemini.ims.model.ProductModel;
import com.capgemini.ims.repository.Product;
import com.capgemini.ims.exception.NoDataFoundException;;

public class ProductDAOImpl {
Map<Integer, ProductModel> prod;
	
	public ProductDAOImpl(){
		prod = Product.get();
	}
	public List<Integer> getId(){
		List<Integer> OrderIdlist = new ArrayList<Integer>();
		
		for(Entry<Integer, ProductModel> map : prod.entrySet()){
			OrderIdlist.add(map.getKey());
		}
		return OrderIdlist;
	}
	//updating the status of products
	public String updateproductStatus(int Id, String place, LocalDate date, String status) throws NoDataFoundException{
		//String check="not valid id";
		String check="data updated";
		for(Entry<Integer, ProductModel> map : prod.entrySet()){
			if(map.getKey() == Id){
				map.getValue().setPlace(place);
				map.getValue().setDate(date);
				map.getValue().setStatus(status);
				
				break;
			}
			else{
				throw new NoDataFoundException();
			}
		}
		return check;
	}
	public String getData(Integer Id){
		String result = null;
		for(Map.Entry<Integer, ProductModel> obj:prod.entrySet()){
			if(obj.getKey().equals(Id))
			{
				result = obj.getValue().getProd_Id()+"\n"+obj.getValue().getPlace()+"\n"+obj.getValue().getDate()+"\n"+obj.getValue().getStatus();
			}
			}
			
		return result;
	}


}
