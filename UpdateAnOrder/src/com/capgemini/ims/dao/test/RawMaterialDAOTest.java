package com.capgemini.ims.dao.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.ims.dao.RawMaterialDAOImpl;
import com.capgemini.ims.exception.NoDataFoundException;

public class RawMaterialDAOTest {
	RawMaterialDAOImpl rawmaterialdaoimpl;
	Integer OrderIdlist[] = {1001, 1002, 1003, 1004} ;
	
	@Before
	public void setup(){
		rawmaterialdaoimpl = new RawMaterialDAOImpl();
	}
	
	@Test
	public void testgetId(){
		List<Integer> list = rawmaterialdaoimpl.getId();
		assertArrayEquals(OrderIdlist,list.toArray());
	}
	
	@Test
	public void updaterawStatus(){
		try {
			assertEquals("data updated",rawmaterialdaoimpl.updaterawStatus(1001, "Kanpur",LocalDate.of(2020, 03, 24), "Dispatched"));
		} catch (NoDataFoundException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testgetData(){
		assertEquals("1001\nKanpur\n2020-03-24\nDispatched",rawmaterialdaoimpl.getData(1001));
	}
	
	@After
	public void teardown(){
		rawmaterialdaoimpl = null;
	}

}
