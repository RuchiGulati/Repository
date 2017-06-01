package pageKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Category_Objects;

public class Category_Page {
	private WebDriver driver;

	public Category_Page(WebDriver driver) {
		this.driver=driver;
	}

	public String getPageTitle(){
		return driver.getTitle();
	}

	public void setPriceFilter(Integer lowPrice, Integer highPrice){
		//new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfAllElementsLocatedBy(btn_Filter));
		driver.findElement(Category_Objects.txt_LowPrice).sendKeys(lowPrice.toString());
		driver.findElement(Category_Objects.txt_HighPrice).sendKeys(highPrice.toString());
	}

	public void clickFilterGo(){
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(Category_Objects.btn_Filter)).click();
		//driver.findElement(btn_Filter).click();
	}
}
