package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverFactory;

public class CucumberHooks {
	
	@Before
	public static void setUp() {
		System.out.println("====Invoking the Driver=====");
		DriverFactory.setUpDriver();
		System.out.println("====Invoked the Driver=====");
	}
	
	@After
	public static void tearDown() {
		System.out.println("====Closing the Driver=====");
		DriverFactory.shutDown();
		System.out.println("====Closed the Driver=====");
	}

}
