package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.BaseClass;
import automation.TestMethods;

public class PageObjects {
	//variables to use in all methods
	public static String email = TestMethods.randomEmail();
	public static String passwd = "test1";
	
	//web elements
	public static WebElement signInButton = BaseClass.driver.findElement
			(By.className("login"));
	
	public static WebElement emailAddress = BaseClass.driver.findElement
			(By.id("email_create"));
	
	public static WebElement createAccountButton = BaseClass.driver.findElement
			(By.id("SubmitCreate"));
	
	//locators
	public static By firstName = By.id("customer_firstname");
	public static By lastName = By.id("customer_lastname");
	public static By password = By.id("passwd");
	public static By address = By.id("address1");
	public static By city = By.id("city");
	public static By state = By.id("id_state");
	public static By postalCode = By.id("postcode");
	public static By mobilePhone = By.id("phone_mobile");
	public static By registerButton = By.id("submitAccount");
	
	public static By emailLogin = By.id("email");
	public static By passwordLogin =By.id("passwd");
	public static By submitLogin = By.id("SubmitLogin");
	
	public static By homeButton = By.xpath("//*[@id=\"center_column\"]/ul/li/a");
	public static By product = By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img");
	public static By addToCart = By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]");
	public static By proceedCheckOut = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
	public static By proceedCheckOut2 = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
	public static By proceedCheckOut3 = By.name("processAddress");
	public static By proceedCheckOut4 = By.name("processCarrier");
	public static By termsOfServices = By.id("cgv");
	public static By bankwire = By.className("bankwire");
	public static By confirmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button");

	public static By orderCompletedMsg = By.xpath("//*[@id=\"center_column\"]/div/p/strong");
	
	//static url's and messages
	public static String myAccountPageUrl = BaseClass.baseUrl + "/index.php?controller=my-account";
	public static String orderCompletedMessage = "Your order on My Store is complete.";

}
