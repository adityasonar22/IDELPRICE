package loginPanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilityPackage.MyMethods;

public class CheckFunctions extends ParentLoginPanel1 {
	
	ExtentHtmlReporter reporter;
	ExtentReports  reports;
	ExtentTest test;
	
	
	
	@BeforeTest
	public void checkTestCase() {
		
	boolean output = MyMethods.checkTestCaseEcecution(tsa, "Sheet1",this.getClass().getSimpleName());
	
	if(!output) {
		
		throw new SkipException("Execution mode of the test cases"+this.getClass().getSimpleName()+"is set to NO");
	}
	
}
	
	@Test(priority=1)
	public void testWithdrawals() throws InterruptedException {
		
		reporter = new ExtentHtmlReporter("./src/main/resources/reports/IdelPriceReports.html");
		
		reporter.config().setDocumentTitle("Idel Price Test Reports");
		reporter.config().setReportName("Idel Price Withdrawal End to End Functionality");
		reporter.config().setTheme(Theme.DARK);
		
		
		
		reports = new ExtentReports();
		
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Team Name", "TIGER");
		reports.setSystemInfo("Tester Name", "ADITYA SONAR");
		
		reports.attachReporter(reporter);
		test =reports.createTest("CheckFunctions");
		
		driver.get(sitedata.getProperty("url"));
		Thread.sleep(2000);
		logs.info("User URL is Loaded");
		test.log(Status.INFO, "User URL is Loaded");
		MyMethods.getScreenShot("UserURLLoaded", driver);
		
		MyMethods.signIn("adityajetester@gmail.com", "1234");
		Thread.sleep(2000);
		logs.info("User is SignIN");
		test.log(Status.INFO, "User is SignIN Successfully");
		MyMethods.getScreenShot("UserSignIn", driver);
		
		isElementPresent("btn_myaccount_xpath").click();
		Thread.sleep(2000);
		
		String currentMoney = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/p")).getText();
		logs.info("Your Current balance Before withdraw: "+currentMoney);
		test.log(Status.INFO, "User current balance before withdrawal"+currentMoney);
		
		isElementPresent("btn_withdeawalAdmin_xpath").click();
		Thread.sleep(2000);
		
		WebElement choseNeetwork = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/form/div[2]/select"));
		Select sel = new Select(choseNeetwork); 
		sel.selectByVisibleText("Test method");
		MyMethods.getScreenShot("SelectCat", driver);
		
		isElementPresent("ip_widEnterAmount_xpath").sendKeys("10");
		Thread.sleep(2000);
		MyMethods.getScreenShot("SelectCat1", driver);
		
		isElementPresent("ip_enterUPIIDuser_xpath").sendKeys("12345");
		Thread.sleep(2000);
		MyMethods.getScreenShot("SelectCat2", driver);
		
		isElementPresent("btn_eithdrawalBtnUser_xpath").click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/a[8]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Withdraw History")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/table/tbody/div/div[1]/h2/button")).click();
		Thread.sleep(2000);
		
		String withdrowHistory = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/table/tbody/div/div[1]/div/div/div[1]")).getText();
		logs.info("Withdrawl History:"+withdrowHistory);
		test.log(Status.INFO, "User Withdrawal History"+withdrowHistory);
		Thread.sleep(2000);
		MyMethods.getScreenShot("WithdrawlHistory", driver);
		
		driver.navigate().back();
		
		driver.navigate().back();
		
		String afterWitdrawl = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/p")).getText();
		logs.info("Your current balance after withdraw is: "+ afterWitdrawl);
		test.log(Status.INFO, "User current balance after withdrawal"+afterWitdrawl);
		MyMethods.getScreenShot("AfterWithdrawl", driver);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(2000);
		
		isElementPresent("btn_myaccount_xpath").click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/button[2]")).click();
		Thread.sleep(2000);
		
		isElementPresent("btn_popboxYes_xpath").click();
		logs.info("User is Logout");
		test.log(Status.INFO, "User LOGOUT");
		
	
	}
	
	
	@Test(priority=2)
	public void checkFunctionality() throws InterruptedException {
		
		
		
		driver.get(sitedata.getProperty("adminURL"));
		Thread.sleep(2000);
		logs.info("Admin URL is Loaded");
		test.log(Status.INFO, "Admin URL is Loaded");
		MyMethods.getScreenShot("AdminURL", driver);
		
		MyMethods.adminSignIN("admin29", "Test@123");
		Thread.sleep(10000);
		logs.info("admin is Log In");
		test.log(Status.INFO, "Admin LogIn Successfully");
		MyMethods.getScreenShot("AdminLogin", driver);
		
		isElementPresent("btn_withdrawaladmin_xpath").click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Pending Withdrawals")).click();
	    Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[6]/a")).click();
		
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div/div/button[1]")).click();
		Thread.sleep(2000);
		logs.info("Pending withdrawl is approved");
		test.log(Status.INFO, "Admin approve panding withdrawal");
		MyMethods.getScreenShot("PandingWID Approve", driver);
		
		Thread.sleep(5000);
		
		driver.navigate().refresh();
		
		}
		
	@Test(priority=3)
	public void Withdrawals() throws InterruptedException {
		
		driver.get(sitedata.getProperty("url"));
		Thread.sleep(2000);
		logs.info("User URL is Upload");
		test.log(Status.INFO, "User URL Loaded");
		
		
		MyMethods.signIn("adityajetester@gmail.com", "1234");
		Thread.sleep(2000);
		logs.info("User is Loged IN");
		test.log(Status.INFO, "Admin SingIN Successfully");
		MyMethods.getScreenShot("UserLogIN", driver);
		
		isElementPresent("btn_myaccount_xpath").click();
		Thread.sleep(2000);
		
		String currentMoney = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/p")).getText();
		logs.info("Your Current balance After withdraw: "+currentMoney);
		test.log(Status.INFO, "Current Balance after withdrawal"+currentMoney);
		MyMethods.getScreenShot("CurrentMoney", driver);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[2]/a[5]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/div[1]/h2/button")).click();
		
		test.log(Status.PASS, "Test Case is Execution Successfully");
		
		reports.flush();
	}
	
}
	
	


