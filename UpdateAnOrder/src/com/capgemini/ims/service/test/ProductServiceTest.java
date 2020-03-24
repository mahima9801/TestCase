package com.capgemini.ims.service.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.ims.exception.NoDataFoundException;
import com.capgemini.ims.service.ProductServiceImpl;

public class ProductServiceTest {
	ProductServiceImpl productserviceimpl;
	Integer OrderIdlist[] = {101, 102, 103, 104};
	
	@Before
	public void setup(){
		productserviceimpl = new ProductServiceImpl();
	}
	@Test
	public void testGetId() {
		List<Integer> list=productserviceimpl.getId();
		assertArrayEquals(OrderIdlist, list.toArray());
	}
	
	@Test
	public void testGetupdateStatusService(){
		try {
			assertEquals("101\nHyderabad\n2019-01-15\nPackaging",productserviceimpl.updateStatusService(101,"Hyderabad",LocalDate.of(2019, 01, 15), "Packaging"));
		} catch (NoDataFoundException e) {
			System.out.println(e);
		}
	}
	
	@Test
    public void  testValidId()
    {	
    try {
		assertEquals("Not a valid Id", productserviceimpl.updateStatusService(105,"Hyderabad",LocalDate.of(2019, 04, 15), "Packaging"));
	} catch (NoDataFoundException e) {
		System.out.println(e);
	}
    }
	
	@Test
    public void testzeroId()
    {
    	try {
			assertEquals("Id cannot be 0",productserviceimpl.validateService(0));
		} catch (NoDataFoundException e) {
			System.out.println(e);
		}
    }
	
	@Test
	public void testNegativeId(){
		try {
			assertEquals("No negative Id. Enter a positive Id", productserviceimpl.validateService(-1));
		} catch (NoDataFoundException e) {
			System.out.println(e);
		}
	}
	
	/*@Test
	public void testdateValidate(){
		assertEquals("true", productserviceimpl.dateValidate("2019-04-15"));
	}*/
		
	@After
	public void teardown(){
		productserviceimpl = null;
	}

}
