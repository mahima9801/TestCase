package com.capgemini.ims.dao.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.ims.dao.ProductDAOImpl;
import com.capgemini.ims.exception.NoDataFoundException;

public class ProductDAOTest {
	ProductDAOImpl productdaoimpl;
		Integer OrderIdlist[] = {101,102,103,104}; 
	@Before
	public void setup(){
		productdaoimpl = new ProductDAOImpl();
	}
	
	@Test
	public void testGetId(){
		List<Integer> list = productdaoimpl.getId();
		assertArrayEquals(OrderIdlist,list.toArray());
	}
	
	@Test
	public void testupdateproductStatus(){
		try {
			assertEquals("data updated",productdaoimpl.updateproductStatus(101, "Hyderabad", LocalDate.of(2019, 01, 15), "Packaging"));
		} catch (NoDataFoundException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testgetData()
	{
		assertEquals("101\nHyderabad\n2019-01-15\nPackaging", productdaoimpl.getData(101));
	}

	
	@After
	public void teardown(){
		productdaoimpl = null;
	}


}
