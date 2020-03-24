package com.capgemini.ims.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.ims.dao.ProductDAOImpl;
import com.capgemini.ims.dao.RawMaterialDAOImpl;
import com.capgemini.ims.exception.NoDataFoundException;
import com.capgemini.ims.service.ProductServiceImpl;
import com.capgemini.ims.service.RawMaterialServiceImpl;

public class Main {
	public static void main(String args[]) throws NoDataFoundException {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Choose from the following:\n1.Raw Material Id\n2.Product Order Id\n3.Exit");
	int ch = sc.nextInt();
	switch(ch){
	case 1:
		RawMaterialServiceImpl obj = new RawMaterialServiceImpl();
		RawMaterialDAOImpl rs = new RawMaterialDAOImpl();
		System.out.println("Raw Material Ids are:"+obj.getId());
		System.out.print("Enter the Id:");
		int raw_id;
		while(true){
			raw_id = sc.nextInt();
			try{
				if(obj.validateService(raw_id)){
					break;
				}

		}catch(NoDataFoundException e){
			System.out.println("Order id doesn't exist.");
		}
	}
		System.out.print("Enter the updated place:");
		String raw_place = sc.next();
		System.out.print("Enter the expected delivery date:format:yyyy-mm-dd");
		String raw_date = sc.next();
		System.out.print("Enter the status:");
		String raw_status = sc.next();
		
			//validating date
			if(obj.dateValidate(raw_date)){
				//conversion to LocalDate
				LocalDate converteddate = LocalDate.parse(raw_date);
				System.out.println(obj.updateStatusService(raw_id, raw_place, converteddate, raw_status));
				System.out.println(rs.getData(raw_id));
			}
			else{
				break;
			}
		break;
	case 2:
		
	ProductServiceImpl obj1 = new ProductServiceImpl();
	ProductDAOImpl ps = new ProductDAOImpl();
		System.out.println("Raw Material Ids are:"+obj1.getId());
		System.out.print("Enter the Id:");
		int prod_id;
		while(true){
			prod_id = sc.nextInt();
			try{
				if(obj1.validateService(prod_id)){
					break;
				}

		}catch(NoDataFoundException e){
			System.out.println("Order id doesn't exist.");
		}
		}
		System.out.println("Enter the updated place:");
		String prod_place=sc.next();
		System.out.println("Enter the expected delivery date:format:yyyy-mm-dd");
		String prod_date = sc.next();
		System.out.println("Enter the status:");
		String prod_status = sc.next();
		//validate the date
		if(obj1.dateValidate(prod_date)){
			LocalDate converteddate1 = LocalDate.parse(prod_date);
			System.out.println(obj1.updateStatusService(prod_id, prod_place, converteddate1,prod_status));
			System.out.println(ps.getData(prod_id));
		}
		else{
			break;
		}
			
		
	default:
		System.out.println("Please select from the above list!");
	
	}
	sc.close();
	}
}

	
