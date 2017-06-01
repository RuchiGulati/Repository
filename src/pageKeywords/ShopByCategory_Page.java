package pageKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopByCategory_Page {
	private WebDriver driver;

	public ShopByCategory_Page(WebDriver driver) {
		this.driver=driver;
	}

	public String getPageTitle(){
		return driver.getTitle();
	}

	public void clickCategory(String category){
		driver.findElement(By.partialLinkText(category)).click();
	}
}

