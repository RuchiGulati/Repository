package pageKeywords;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.Product_Objects;

public class Product_Page {
	private WebDriver driver;

	public Product_Page(WebDriver driver) {
		this.driver=driver;
	}

	public void clickAddToCart() throws InterruptedException{
		// Fetching Window handle to switch selenium to product page
		Set<String> allWindowHandles = driver.getWindowHandles();
		String childWindowHandle = new String();
		for(String handle :allWindowHandles){
			//System.out.println("Window Handle is: " + handle);
			childWindowHandle = handle;
		}
		driver.switchTo().window(childWindowHandle);
		//System.out.println(driver.switchTo().window(childWindowHandle).getTitle());
		driver.findElement(Product_Objects.btn_AddToCart).click();	
	}
}
