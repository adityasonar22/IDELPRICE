package basePackage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import utilityPackage.ExcelFileReader;

public class BaseInit {
	
	public static WebDriver driver = null;
	
	public static Properties storagedata = null;
	public static Properties sitedata = null;
	
	public static ExcelFileReader ts = null;
	public static ExcelFileReader tsa = null;
	
	
	
	
	public static Logger logs;
	
	public void startUP() throws Exception {
		
		if(driver==null) {
			
			logs = Logger.getLogger("devpinoyLogger");
			
			sitedata = new Properties();
			FileInputStream fi  = new FileInputStream("./src/main/resources/propertiesData/SiteData.properties");
			sitedata.load(fi);
			logs.info("Site data properties file is loaded");
			
			storagedata = new Properties();
			fi = new FileInputStream("./src/main/resources/propertiesData/ObjectStorage.properties");
			storagedata.load(fi);
			logs.info("Object Storage properties file is loaded");
			
			
			logs.info("Browser will be launching");
			String browserVal = sitedata.getProperty("browser");
			
			if(browserVal.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "D:\\Browsers Driver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();
				logs.info("Chrome browser launched");
				
			}else if(browserVal.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "");
				driver= new FirefoxDriver();
				logs.info("Firefox browser launched");
				
			}else {
				
				logs.info("There is no browser defined");
				
			}
			
			
			driver.manage().window().maximize();
			logs.info("Window is Maximized");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			logs.info("Time unit is defined");
			
			driver.manage().deleteAllCookies();
			logs.info("Coolies has been deleted");
			
			
			ts = new ExcelFileReader("./src/main/resources/testInformation/TestSuites.xlsx");
			tsa = new ExcelFileReader("./src/main/resources/testInformation/websitePanel.xlsx");
			logs.info("Excel file object has been created...");
			
		}
}
	
	
	
	public static WebElement isElementPresent(String propKey) {
		
		try {
			
			if(propKey.contains("xpath")) {
				return driver.findElement(By.xpath(storagedata.getProperty(propKey)));
				
			}else if(propKey.contains("name")) {
				return driver.findElement(By.name(storagedata.getProperty(propKey)));
			
			}else if(propKey.contains("linkText")) {
				return driver.findElement(By.linkText(storagedata.getProperty(propKey)));
				
			}else if(propKey.contains("id")) {
				return driver.findElement(By.id(storagedata.getProperty(propKey)));
				
			}else if(propKey.contains("partialLinkText")) {
				return driver.findElement(By.partialLinkText(storagedata.getProperty(propKey)));
				
			}else if(propKey.contains("tagname")) {
				return driver.findElement(By.tagName(storagedata.getProperty(propKey)));
				
			}else if(propKey.contains("className")) {
				return driver.findElement(By.className(storagedata.getProperty(propKey)));
				
			}else if(propKey.contains("cssSelector")) {
				return driver.findElement(By.cssSelector(storagedata.getProperty(propKey)));
				
			}else {
				
				logs.info(propKey+"Key is not found in properties file");
			}
			
			
	     }catch(Exception e) {
			
			
			
			
		}
		
		return null;
	}
	
}
