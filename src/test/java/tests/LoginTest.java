package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
//import jdk.internal.org.jline.utils.Log;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest{
	
	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException{
		String filePath = System.getProperty("user.dir")+"/testdata1/testdata.xls";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount -1][2];
		
		for(int i =1;i<rowCount; i++) {
			data[i-1][0] = ExcelUtils.getCellData(i, 0);
			data[i-1][1] = ExcelUtils.getCellData(i, 1);
			
		}
		
		ExcelUtils.closeExcel();
		return data;
	}
	
	@Test(dataProvider = "LoginData")
	public void testValidLogin(String username,String password) {
		test = ExtentReportManager.createTest("login test");
		
		test.info("Navigation to URL");
		LoginPage loginpage = new LoginPage(driver);
		
		test.info("adding credentials");
		//loginpage.enterUsername("admin123@yourstore.com");
		//loginpage.enterPassword("admin");
		
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		
		test.info("clicking on login Button");
		loginpage.clickLogin();
		
		test.info("Verifying title of page");
		System.out.println(driver.getTitle());
		
	}
}
