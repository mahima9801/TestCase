package com.capgemini.ims.testcases;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.capgemini.ims.dao.test.ProductDAOTest;
import com.capgemini.ims.dao.test.RawMaterialDAOTest;
import com.capgemini.ims.service.test.ProductServiceTest;
import com.capgemini.ims.service.test.RawMaterialServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	ProductDAOTest.class,
	RawMaterialDAOTest.class,
	ProductServiceTest.class,
	RawMaterialServiceTest.class
})
public class AllTests {
	public static void main(String[] args) {
		Result results=JUnitCore.runClasses(AllTests.class);
		System.out.println("Test Result "+results.wasSuccessful());
		System.out.println("Failure tests count are: "+results.getFailureCount());
		System.out.println(results.getRunCount());
		List<Failure> failure=results.getFailures();
		for(Failure f:failure)
		{
			System.out.println("Failure is "+f);
		}
	}

}
