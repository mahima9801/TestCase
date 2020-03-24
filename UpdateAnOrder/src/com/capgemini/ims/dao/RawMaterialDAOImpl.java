package com.capgemini.ims.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.capgemini.ims.exception.NoDataFoundException;
import com.capgemini.ims.model.RawMaterialModel;
import com.capgemini.ims.repository.RawMaterial;


public class RawMaterialDAOImpl {
	Map<Integer, RawMaterialModel> raw;
	
	public RawMaterialDAOImpl(){
		raw = RawMaterial.get();
	}
	public List<Integer> getId(){
		List<Integer> OrderIdlist = new ArrayList<Integer>();
		
		for(Entry<Integer, RawMaterialModel> map : raw.entrySet()){
			OrderIdlist.add(map.getKey());
		}
		return OrderIdlist;
	}
	//updating the status of raw materials
	public String updaterawStatus(int Id, String place,LocalDate date, String status) throws NoDataFoundException{
		//String check="not a valid id";
		String check = "data updated";
		for(Entry<Integer, RawMaterialModel> map : raw.entrySet()){
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
	public String getData(int Id){
		String result = null;
		for(Map.Entry<Integer, RawMaterialModel> obj : raw.entrySet()){
			if(obj.getKey().equals(Id)){
			result = obj.getValue().getId()+"\n"+obj.getValue().getPlace()+"\n"+obj.getValue().getDate()+"\n"+obj.getValue().getStatus();
		}
		}
		return result;
	}

}
