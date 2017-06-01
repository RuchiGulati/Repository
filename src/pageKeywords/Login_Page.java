package pageKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageObjects.Login_Objects;

public class Login_Page {
	private WebDriver driver;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle(){
		return driver.getTitle();
	}

	private void setUserName(String userName_Email){
		driver.findElement(Login_Objects.txt_UserName).sendKeys(userName_Email);
	}

	private void setPassword(String password){
		driver.findElement(Login_Objects.txt_Password).sendKeys(password);
	}

	public void clickLogin(){
		driver.findElement(Login_Objects.btn_Login).click();
	}

	public void login(String userName_Email, String password){
		this.setUserName(userName_Email);
		this.setPassword(password);
		this.clickLogin();
	}
}
