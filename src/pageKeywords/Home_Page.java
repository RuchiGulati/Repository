package pageKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import FunctionLibrary.CommonFunction;
import pageObjects.Home_Objects;

public class Home_Page {
	private WebDriver driver;

	public Home_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignIn() throws InterruptedException {
		WebElement signInLnk = driver.findElement(Home_Objects.lnk_SignIn);   
		//WebElement signInLnk = Generic_Keywords.getElement(Home_Objects.lnk_SignIn); 
		Actions action = new Actions(driver);   
		action.moveToElement(signInLnk).perform();       
		//System.out.println("Performed Mouse hover");   
		Thread.sleep(1000);   
		WebElement signInBtn = driver.findElement(Home_Objects.btn_SignIn);   
		action.moveToElement(signInBtn).perform();   
		signInBtn.click();      
		System.out.println("Clicked on SignIn");   
		Thread.sleep(1000);
	}

	public boolean verifySignIn() throws InterruptedException{
		Actions action = new Actions(driver);
		if(driver.findElement(Home_Objects.lnk_SignIn).getText().contains("Ruchi")){
			System.out.println("Pass: Hello Ruchi");
			WebElement signInLnk = driver.findElement(Home_Objects.lnk_SignIn);   
			action.moveToElement(signInLnk).perform();
			Thread.sleep(1000);
			WebElement signOutLnk = driver.findElement(Home_Objects.lnk_SignOut);
			action.moveToElement(signOutLnk).perform();
			String txt_SignOut = driver.findElement(Home_Objects.lnk_SignOut).getText();
			if(txt_SignOut.contains("Sign Out")){
				System.out.println("Pass: " + txt_SignOut);
				return true;
			}
		}
		return false;
	}

	public void clickSignOut() throws InterruptedException {
		Actions action = new Actions(driver); 
		WebElement signInLnk = driver.findElement(Home_Objects.lnk_SignIn);   
		action.moveToElement(signInLnk).perform(); 
		//System.out.println("Performed Mouse hover");   
		Thread.sleep(1000);   
		WebElement signOutLnk = driver.findElement(Home_Objects.lnk_SignOut);
		action.moveToElement(signOutLnk).perform(); 
		signOutLnk.click();      
		System.out.println("Clicked on SignOut");   
		Thread.sleep(1000);
	}

	public void clickAmazonPay() throws InterruptedException{
		driver.findElement(Home_Objects.lnk_AmazonPay).click();
		System.out.println("Clicked on AmazonPay");
		Thread.sleep(1000);
	}

	public void clickShopByCategory(){
		driver.findElement(Home_Objects.lnk_ShopByCategory).click();
	}

	public void clickSearch(String searchText){
		driver.findElement(Home_Objects.txt_Search).sendKeys(searchText);
		driver.findElement(Home_Objects.btn_Search).click();
	}

	public void clickCart(){
		driver.findElement(Home_Objects.lnk_Cart).click();
	}

	public boolean verifyCartCount(){
		String cartCount = driver.findElement(Home_Objects.lnk_CartCount).getText();
		if(Integer.parseInt(cartCount)>0){
			System.out.println(cartCount + " items in Cart");
			return true;
		}
		System.out.println(cartCount + " items in Cart");
		return false;
	}

}
