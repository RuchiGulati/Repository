package pageKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.Cart_Objects;

public class Cart_Page {
	private WebDriver driver;

	//private By txt_CartItem = By.id("//span[contains(text(),'TOYZONE EDUCATIONAL RIDER Rideon')]");
	//h2[contains(text(),'Shopping Cart')]/../..//span[contains(text(),'TOYZONE EDUCATIONAL RIDER Rideon')]

	public Cart_Page(WebDriver driver) {
		this.driver=driver;
	}

	public String getPageTitle(){
		return driver.getTitle();
	}

	public boolean verifyCart(){
		Assert.assertTrue(driver.findElement(Cart_Objects.txt_CartItem).isDisplayed(), "Fail: Item added in cart is not present in Cart");
		return true;
	}
}
