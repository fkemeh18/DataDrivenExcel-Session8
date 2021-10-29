package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

public class BrowserFactory {

	static WebDriver 	driver;
	static String 		browser;
	static String		url;
	
	public static void config() {
		//BufferedReader InputStream FileReader Scanner
		Properties property = new Properties();
		try {
			InputStream inputStream = new FileInputStream("src\\main\\java\\config"
					+ "\\config.properties");
			property.load(inputStream);
			 browser 	= property.getProperty("browser");
			 url 		= property.getProperty("url"); 
			 System.out.println(browser);
			 System.out.println(url);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver init() {
		config();
		
		if(browser.equalsIgnoreCase("gc")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("mse")){
			System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
