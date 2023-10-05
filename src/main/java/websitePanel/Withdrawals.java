package websitePanel;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilityPackage.MyMethods;

public class Withdrawals extends ParentWebsitePanel1 {
	
	
	
	@BeforeTest
	public void checkTestCase() {
		
	boolean output = MyMethods.checkTestCaseEcecution(tsa, "Sheet1",this.getClass().getSimpleName());
	
	if(!output) {
		
		throw new SkipException("Execution mode of the test cases"+this.getClass().getSimpleName()+"is set to NO");
	}
}
	
	@Test
	public void testWithdrawals() throws InterruptedException {
		
		driver.get(sitedata.getProperty("url"));
		Thread.sleep(2000);
		
		MyMethods.signIn("adityajetester@gmail.com", "1234");
		Thread.sleep(2000);
		
		isElementPresent("btn_myaccount_xpath").click();
		Thread.sleep(2000);
		
		String currentMoney = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/p")).getText();
		logs.info("Your Current balance After withdraw: "+currentMoney);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/a[5]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/div[1]/h2/button")).click();
		
		
		
		
 }
}	
