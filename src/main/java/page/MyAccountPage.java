package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(), 'My account')]") 
	WebElement MYACCOUNT_HEADER;
	@FindBy(how = How.XPATH, using = "//a[@title='Information']") 
	WebElement PERSONAL_INFO_BUTTON;
	
	
	public void verifyMyAccountPage() {
		Assert.assertEquals(MYACCOUNT_HEADER.getText(), "MY ACCOUNT", "wRONG pAGE");
	}
	
	public void clickMyPersonalInfoButton() {
		PERSONAL_INFO_BUTTON.click();
	}

}
