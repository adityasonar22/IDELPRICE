package utilityPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



import basePackage.BaseInit;

	public class MyMethods extends BaseInit {
		
		
		

		public static void signIn(String email,String pin) {
			
			isElementPresent("ip_SignIN_xpath").click();
			isElementPresent("ip_EmailId_xpath").sendKeys(email);
			isElementPresent("btn_ligIN_xpath").click();
			isElementPresent("ip_pin_xpath").sendKeys(pin);
			isElementPresent("btn_submit_xpath").click();
			MyMethods.getScreenShot("UserSingINWithDATA", driver);
			
		}
		
		
		public static void signOUT() {
			
			isElementPresent("btn_myaccount_xpath").click();
			isElementPresent("btn_logOUT_xpath").click();
			isElementPresent("btn_popboxYes_xpath").click();
		}
		
		
		public static void adminSignIN(String username,String pwd) {
			
			isElementPresent("ip_emailadmin_xpath").sendKeys(username);
			isElementPresent("ip_passwordadmin_xpath").sendKeys(pwd);
			isElementPresent("btn_seepwdAdmin_xpath").click();
			isElementPresent("btn_loginAdmin_xpath").click();
			MyMethods.getScreenShot("AdminSignInWithData", driver);
		}
		
		
		public static void adminSignOUT() {
			
			isElementPresent("btn_logout1Admin_xpath").click();
			isElementPresent("btn_logoutAdmin_xpath").click();
			
		}
		
		
		public static boolean checkTestSuiteExecution(ExcelFileReader data, String sheetName, String testSuiteName) {
			int rows = data.totalRow(sheetName);
			for(int row=1;row<rows;row++) {
				String testsuiteName = data.getData(sheetName, row, 0);
					if(testSuiteName.equalsIgnoreCase(testsuiteName)) {
						String exeMode = data.getData(sheetName, row, 2);{
							if(exeMode.equalsIgnoreCase("Y")) 
								return true;
							else 
								return false;
				}
			}
		}return false;
	}	
			
			
		public static boolean checkTestCaseEcecution(ExcelFileReader data, String sheetName, String testCaseName) {
				int rows =data.totalRow(sheetName);
				for(int row=1;row<rows;row++) {
					String testcaseName = data.getData(sheetName, row, 0);
						if(testCaseName.equalsIgnoreCase(testcaseName)) {
							String exeMode = data.getData(sheetName, row, 2);{
								if(exeMode.equalsIgnoreCase("Y"))
									return true;
								else
									return false;
						 }
			         }
	              }return false;
			}	
		
		
		public static Object[][] getTestData(ExcelFileReader data,String sheetName) {
			
				int rows = data.totalRow(sheetName);
				int cols= data.totalColumn(sheetName);
				
				Object[][] myData = new Object[rows-1][cols];
				
				for (int row=1;row<rows;row++) {
					
					for(int col=1;col<cols;col++) {
						
						myData[row-1][col] = data.getData(sheetName, row, col);
					}
				}return myData;
			}
			
		
			
		public static String getScreenShot(String imageName, WebDriver driver) {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File scrFile = ts.getScreenshotAs(OutputType.FILE);
				String path = System.getProperty("user.dir") + "\\src\\main\\resources\\screenShots\\" + imageName + System.currentTimeMillis() + ".png";
				// System.out.println(path);
				File destination = new File(path);
				try {
					FileHandler.copy(scrFile, destination);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				return path;
			}
		
		
		
		
		
			
	}
		
	
	
		




