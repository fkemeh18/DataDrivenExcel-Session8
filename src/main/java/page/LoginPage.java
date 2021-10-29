package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
//	By USERNAME_F 	= By.xpath("//input[@id='email']");
//	By PASSWORD_F 	= By.xpath("//input[@id='passwd']");
//	By LOGIN_B 		= By.xpath("//button[@name='SubmitLogin'"
//			+ "and @id='SubmitLogin']");
	
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement USERNAME_F; 
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement PASSWORD_F; 
	@FindBy(how = How.XPATH, using = "//button[@name='SubmitLogin' and @id='SubmitLogin']") WebElement LOGIN_B; 
	
	//Interactive Methods
	public void enterUserName(String userName) {
		USERNAME_F.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		PASSWORD_F.sendKeys(password);
	}
	
	public void pressLoginButton() {
		LOGIN_B.click();
	}
	
	//Technique Individual Methods
	public void testLogin(String userName, String password) {
		USERNAME_F.sendKeys(userName);
		PASSWORD_F.sendKeys(password);
		LOGIN_B.click();
	}
	
}
