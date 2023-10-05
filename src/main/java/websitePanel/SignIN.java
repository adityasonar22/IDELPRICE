package websitePanel;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilityPackage.MyMethods;

public class SignIN extends ParentWebsitePanel1 {
	
	@BeforeTest
	public void checkTestCase() {
		
	boolean output = MyMethods.checkTestCaseEcecution(tsa, "Sheet1",this.getClass().getSimpleName());
	
	if(!output) {
		
		throw new SkipException("Execution mode of the test cases"+this.getClass().getSimpleName()+"is set to NO");
	}
	
}
	
	@Test
	public void testCategory() throws Exception {
		
		driver.get(sitedata.getProperty("url"));
		
		MyMethods.signIn("adityajetester@gmail.com", "1234");
		
		isElementPresent("btn_myaccount_xpath").click();
		
		WebElement catDiv = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]"));
		
		List<WebElement> catList= catDiv.findElements(By.tagName("a"));
		
		System.out.println("All link size are:"+catList.size());
		
		for(int count=0;count<catList.size();count++) {
			
			String name = catList.get(count).getText();
			System.out.println(name);
			
			catList.get(count).click();
			Thread.sleep(2000);
			
			driver.navigate().back();
			Thread.sleep(2000);
			
			catDiv = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]"));
			
			catList= catDiv.findElements(By.tagName("a"));
			
			
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		
		isElementPresent("btn_backforLogOFF_xpath").click();
		MyMethods.signOUT();
	}
}
