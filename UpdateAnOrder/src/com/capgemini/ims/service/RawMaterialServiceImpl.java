package com.capgemini.ims.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.ims.dao.RawMaterialDAOImpl;
import com.capgemini.ims.exception.NoDataFoundException;

public class RawMaterialServiceImpl {
	RawMaterialDAOImpl uds = new RawMaterialDAOImpl();
	
	public String updateStatusService(int Id, String place,LocalDate date, String status) throws NoDataFoundException{
		
		String result = "Not valid id";
		List<Integer> list = uds.getId();//fetch all the ids of raw material
		if(Id<0){
			result="No negative Id. Enter the positive Id";
			return result;
		}
		if(Id==0){
			result="Id cannot be 0";
		}
		for(Integer i:list){
			if(i==Id){
				result=uds.updaterawStatus(Id, place,date, status);
			}
			else{
				throw new NoDataFoundException();
			}
		}
		return result;
	}
	
	public boolean validateService(int Id) throws NoDataFoundException{
		boolean check = false;
		for(Integer i : uds.getId()){
			if(i== Id){
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
			return uds.getId();
		}
	

}
