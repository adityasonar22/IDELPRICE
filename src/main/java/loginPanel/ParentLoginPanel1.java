package loginPanel;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import basePackage.BaseInit;
import utilityPackage.MyMethods;

public class ParentLoginPanel1 extends BaseInit {
	
	@BeforeSuite
	public void checkTestSuite() throws Exception {
		
		startUP();
		
		boolean output = MyMethods.checkTestSuiteExecution(ts, "Sheet1", "loginPanel");
		
		if(!output) {
			
			throw new SkipException("Execution mode of the TestSuite Web Site Panel is set NO ");
		}
	}
}
