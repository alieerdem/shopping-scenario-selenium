package automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pageobjectmodel.PageObjects;

public class TestMethods extends BaseClass {
	
	
	@Test (priority = 0)
	public void signUp() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//open the page
		driver.navigate().to(baseUrl);
		
		//click on sign in button
		driver.findElement(By.className("login")).click();
		//enter unique email address to create an account
		PageObjects.emailAddress.sendKeys(PageObjects.email);
		//click on create an account button
		PageObjects.createAccountButton.click();
		
		//fill all required fields with valid inputs		
		driver.findElement(PageObjects.firstName).sendKeys("test");
		driver.findElement(PageObjects.lastName).sendKeys("test");
		driver.findElement(PageObjects.password).sendKeys(PageObjects.passwd);
		driver.findElement(PageObjects.address).sendKeys("test");
		driver.findElement(PageObjects.city).sendKeys("test");
		
		//select first item as state from dropdown
		Select dropdown = new Select(driver.findElement(PageObjects.state));
		dropdown.selectByIndex(1);
		
		driver.findElement(PageObjects.postalCode).sendKeys("55555");
		driver.findElement(PageObjects.mobilePhone).sendKeys("1112223344");
		driver.findElement(PageObjects.registerButton).click();
		
		//check if account is created
		String url = driver.getCurrentUrl();
		assertEquals(url, PageObjects.myAccountPageUrl);
	}
	
	@Test (priority = 1)
	public void login() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.navigate().to(baseUrl);
		driver.findElement(By.className("login")).click();
		
		driver.findElement(PageObjects.emailLogin).sendKeys(PageObjects.email);
		driver.findElement(PageObjects.passwordLogin).sendKeys(PageObjects.passwd);
		driver.findElement(PageObjects.submitLogin).click();
		
		String url = driver.getCurrentUrl();
		assertEquals(url, PageObjects.myAccountPageUrl);
	}
	
	
	@Test (priority =2)
	public void proceedToCheckout() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);		
		
		login();
		//go home page
		driver.findElement(PageObjects.homeButton).click();
		
		//click on add to cart
		Actions action = new Actions(driver);
		WebElement product = driver.findElement(PageObjects.product);
		action.moveToElement(product).moveToElement(driver.findElement(PageObjects.addToCart)).click().build().perform();
		
		//proceed to check out
		driver.findElement(PageObjects.proceedCheckOut).click();
		
		//get prica, address, shipping cost and validate that they are not null.
		String price = driver.findElement(By.className("price")).getText();
		String address = driver.findElement(By.className("address_city")).getText();
		String shippingCost = driver.findElement(By.id("total_shipping")).getText();
		assertNotNull(price);
		assertNotNull(address);
		assertNotNull(shippingCost);
		
		//proceed to check out
		driver.findElement(PageObjects.proceedCheckOut2).click();
		//proceed to check out
		driver.findElement(PageObjects.proceedCheckOut3).click();
		
		//click on checkbox 'terms of services'
		driver.findElement(PageObjects.termsOfServices).click();
		//proeed to check out
		driver.findElement(PageObjects.proceedCheckOut4).click();
		
		//choose payment 'bay by bank wire'
		driver.findElement(PageObjects.bankwire).click();

		//confirm my order
		driver.findElement(PageObjects.confirmOrder).click();
		
		//get order completed message and assert it
		String orderCompleted = driver.findElement(PageObjects.orderCompletedMsg).getText();
		assertEquals(orderCompleted, PageObjects.orderCompletedMessage);
	}
	
	//return random email to validate unique email requirement
    public static String randomEmail() {
        return "random" + UUID.randomUUID().toString() + "@email.com";
    }
}
