package pageKeywords;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.ProductList_Objects;

public class ProductList_Page {
	private WebDriver driver;

	public ProductList_Page(WebDriver driver) {
		this.driver=driver;
	}

	public void selectProduct(String Product) throws InterruptedException{
		//Fetching window handle before clicking product, just to check that 1st window handle in Set array is of parent
		//String parentWindowHandle = driver.getWindowHandle();
		//System.out.println("Parent Window Handle is: " + parentWindowHandle);

		System.out.println("Selecting " + driver.findElement(ProductList_Objects.txt_Product).getText()+ " Product");
		driver.findElement(ProductList_Objects.txt_Product).click();
	}

	public boolean verifyPriceFilter(Integer lowPrice, Integer highPrice){
		List<WebElement> allproducts = driver.findElements(ProductList_Objects.list_Product);
		int i=0;
		for(WebElement product: allproducts){
			float productCost = Float.parseFloat(product.findElement(By.xpath("//li[@id='result_"+i+"']//span[contains(@class,'s-price')]")).getText());
			System.out.println(productCost);
			if(productCost < lowPrice || productCost > highPrice){
				return false;
			}
			i=i+1;
		}
		return true;
	}
}
