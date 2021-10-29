package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YourPersonalInfoPage extends BasePage{

	WebDriver driver;

	public YourPersonalInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='firstname']") 
	WebElement FIRST_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='lastname']") 
	WebElement LAST_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='email']") 
	WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='days']") 
	WebElement DOB_DAY_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='months']") 
	WebElement DOB_MONTH_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='years']") 
	WebElement DOB_YEAR_FIELD;
	
	public void enterFirstName(String firstName) {
		FIRST_NAME_FIELD.clear();
		FIRST_NAME_FIELD.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		LAST_NAME_FIELD.clear();
		LAST_NAME_FIELD.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		EMAIL_FIELD.clear();
		EMAIL_FIELD.sendKeys(email);
	}
	
	public void enterDOB(String day, String month, String year) {
		selectDropDown(DOB_DAY_FIELD, day);
		selectDropDown(DOB_MONTH_FIELD, month);
		selectDropDown(DOB_YEAR_FIELD, year);
	}
	
	

}
