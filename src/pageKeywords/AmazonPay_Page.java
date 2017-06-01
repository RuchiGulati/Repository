package pageKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.AmazonPay_Objects;

public class AmazonPay_Page {
	private WebDriver driver;

	public AmazonPay_Page(WebDriver driver) {
		this.driver=driver;
	}

	public String getPageTitle(){
		return driver.getTitle();
	}

	public void ViewStmt(){
		driver.findElement(AmazonPay_Objects.img_ViewStmt).click();
		System.out.println("Clicked on View Statement");
	}
}
