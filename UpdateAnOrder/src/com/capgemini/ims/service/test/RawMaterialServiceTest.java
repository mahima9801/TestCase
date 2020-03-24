package com.capgemini.ims.service.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.ims.exception.NoDataFoundException;
import com.capgemini.ims.service.RawMaterialServiceImpl;

public class RawMaterialServiceTest {
	RawMaterialServiceImpl rawmaterialserviceImpl;
	Integer OrderIdlist[] = {1001, 1002, 1003, 1004};
	
	@Before
	public void setup(){
		rawmaterialserviceImpl = new RawMaterialServiceImpl();
	}
	@Test
	public void testGetId() {
		List<Integer> list=rawmaterialserviceImpl.getId();
		assertArrayEquals(OrderIdlist, list.toArray());
	}
	
	@Test
	public void testGetupdateStatusService(){
		try {
			assertEquals("101\nHyderabad\n2019-01-15\nPackaging",rawmaterialserviceImpl.updateStatusService(101,"Hyderabad",LocalDate.of(2019, 01, 15), "Packaging"));
		} catch (NoDataFoundException e) {
			System.out.println(e);
		}
	}
	
	@Test
    public void  testValidId()
    {	
    try {
		assertEquals("Not a valid Id", rawmaterialserviceImpl.updateStatusService(105,"Hyderabad",LocalDate.of(2019, 04, 15), "Packaging"));
	} catch (NoDataFoundException e) {
		System.out.println(e);
	}
    }
	
	@Test
    public void testzeroId()
    {
    	try {
			assertEquals("Id cannot be 0",rawmaterialserviceImpl.validateService(0));
		} catch (NoDataFoundException e) {
			System.out.println(e);
		}
    }
	
	@Test
	public void testNegativeId(){
		try {
			assertEquals("No negative Id. Enter a positive Id", rawmaterialserviceImpl.validateService(-1));
		} catch (NoDataFoundException e) {
			System.out.println(e);
		}
	}
	
	@After
	public void teardown(){
		rawmaterialserviceImpl = null;
	}

}
