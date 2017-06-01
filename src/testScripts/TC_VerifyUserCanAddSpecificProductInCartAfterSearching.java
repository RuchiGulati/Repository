package testScripts;

import org.testng.annotations.Test;

import FunctionLibrary.TestBaseSetup;
import pageKeywords.Cart_Page;
import pageKeywords.Category_Page;
import pageKeywords.Home_Page;
import pageKeywords.Login_Page;
import pageKeywords.ProductList_Page;
import pageKeywords.Product_Page;
import pageKeywords.ShopByCategory_Page;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_VerifyUserCanAddSpecificProductInCartAfterSearching {
	WebDriver driver;
	@Parameters({"Browser", "URL"})
	@BeforeClass
	public void beforeClass(String Browser, String URL) {
		TestBaseSetup testBaseSetup = new TestBaseSetup();
		driver = testBaseSetup.launchBrowser(Browser, URL);
	}

	@Test
	public void VerifyUserCanAddSpecificProductInCartAfterSearching() throws InterruptedException {
		System.out.println("---Executing Test Case To Verify User Can Add Specific Product In Cart After Searching---");
		Home_Page homePage = new Home_Page(driver);
		//homePage.clickSignIn();
		//Login_Page loginPage = new Login_Page(driver);
		//loginPage.login("ruchisgulati@gmail.com", "8698466655r");
		homePage.clickSearch("TOYZONE EDUCATIONAL RIDER Rideon");
		System.out.println("Searched Product");
		ProductList_Page productListPage = new ProductList_Page(driver);
		productListPage.selectProduct("TOYZONE EDUCATIONAL RIDER Rideon");
		Product_Page productPage = new Product_Page(driver);
		productPage.clickAddToCart();
		Assert.assertTrue(homePage.verifyCartCount(), "Fail: Cart is Empty");
		homePage.clickCart();
		Cart_Page cartPage = new Cart_Page(driver);
		Assert.assertTrue(cartPage.verifyCart(), "Fail: Cart Validation failed");
		System.out.println("Pass: Cart contains added item");
		//homePage.clickSignOut();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
