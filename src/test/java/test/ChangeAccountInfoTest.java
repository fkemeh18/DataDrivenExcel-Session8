package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import page.MyAccountPage;
import page.YourPersonalInfoPage;
import util.BrowserFactory;
import util.ExcelReader;

public class ChangeAccountInfoTest {

	WebDriver driver;
	ExcelReader xlreader = new ExcelReader("src\\main\\java\\data\\Session8-Excel.xlsx");
	String userName = xlreader.getCellData("LoginTestData", "UserName", 2);
	String password = xlreader.getCellData("LoginTestData", "Password", 2);
	
	String firstName 	= xlreader.getCellData("ChangeAccountInfoTestData", "firstName", 2);
	String lastName 	= xlreader.getCellData("ChangeAccountInfoTestData", "lastName", 2);
	String email 		= xlreader.getCellData("ChangeAccountInfoTestData", "email", 2);
	String dayDOB 		= xlreader.getCellData("ChangeAccountInfoTestData", "dOB", 2);
	String monthDOB 	= xlreader.getCellData("ChangeAccountInfoTestData", "dOB", 3);
	String yearDOB 		= xlreader.getCellData("ChangeAccountInfoTestData", "dOB", 4);
	
	@Test
	public void validUserShouldBeAbleToChangeAccountInfo() throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage loginPage = 
				PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.pressLoginButton();
		
		MyAccountPage myAccountPage = 
				PageFactory.initElements(driver, MyAccountPage.class);
		myAccountPage.verifyMyAccountPage();
		myAccountPage.clickMyPersonalInfoButton();
		
		YourPersonalInfoPage yourPersonalInfoPage = 
				PageFactory.initElements(driver, YourPersonalInfoPage.class);
		yourPersonalInfoPage.enterFirstName(firstName);
		yourPersonalInfoPage.enterLastName(lastName);
		yourPersonalInfoPage.enterEmail(email);
		yourPersonalInfoPage.enterDOB(dayDOB, monthDOB, yearDOB);
		Thread.sleep(2000);
		
		BrowserFactory.tearDown();
	}
	
}
