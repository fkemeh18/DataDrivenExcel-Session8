package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void selectDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	
	public int randomNumberGenerator(int bound) {
		Random r = new Random();
		int newNumber = r.nextInt(bound);
		return newNumber;
	}
	
}
