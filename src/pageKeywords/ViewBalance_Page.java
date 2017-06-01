package pageKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.ViewBalance_Objects;

public class ViewBalance_Page {
	private WebDriver driver;

	public ViewBalance_Page(WebDriver driver) {
		this.driver=driver;
	}

	public String getPageTitle(){
		return driver.getTitle();
	}

	public boolean verifyPayBalance(){
		Assert.assertTrue(getPageTitle().contains("Amazon Pay balance statement"), "Fail: Not on Balance Page");
		Assert.assertTrue(driver.findElement(ViewBalance_Objects.ttl_PayBalance).getText().contains("Amazon Pay balance"),"Fail: Amazon Pay balance title is not present");
		Assert.assertTrue(driver.findElement(ViewBalance_Objects.ttl_Balance).isDisplayed(),"Fail: Amazon Pay balance is not present");
		Assert.assertTrue(driver.findElement(ViewBalance_Objects.lnk_Recharge).isDisplayed(),"Fail: Recharge link is not present");
		return true;

	}
}

