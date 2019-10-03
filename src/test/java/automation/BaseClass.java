package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass  {
	
	public static WebDriver driver;
	public static String baseUrl = "http://automationpractice.com";

	@BeforeMethod
	public static void setupApplication()
	{
		Reporter.log("### Browser Session START ###", true);
		
        System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
		
		Reporter.log("----Application Start----", true);
	}
	
	@AfterMethod
	public static void closeApplication()
	{
		driver.quit();
		Reporter.log("### Browser Session END ###", true);
	}

}