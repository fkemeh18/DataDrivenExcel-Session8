package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import page.MyAccountPage;
import util.BrowserFactory;
import util.ExcelReader;


public class LoginTest {

	WebDriver driver;
	ExcelReader xlreader = new ExcelReader("src\\main\\java\\data\\Session8-Excel.xlsx");
	String userName = xlreader.getCellData("LoginTestData", "UserName", 2);
	String password = xlreader.getCellData("LoginTestData", "Password", 2);
	
	@Test
	public void validuserShouldBeAbleToLogin() throws InterruptedException {
		driver = BrowserFactory.init();
		Thread.sleep(1500);
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password.toString());
		loginPage.pressLoginButton();
		Thread.sleep(2000);
		
		MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		myAccountPage.verifyMyAccountPage();
		
		BrowserFactory.tearDown();
		
	}
	
}
