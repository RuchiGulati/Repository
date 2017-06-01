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

public class TC_VerifyUserCanApplyPriceFilter {
	WebDriver driver;
	@Parameters({"Browser", "URL"})
	@BeforeClass
	public void beforeClass(String Browser, String URL) {
		TestBaseSetup testBaseSetup = new TestBaseSetup();
		driver = testBaseSetup.launchBrowser(Browser, URL);
	}

	@Test
	public void VerifyUserCanApplyPriceFilter() throws InterruptedException {
		System.out.println("---Executing Test Case To Verify User Can Apply Price Filter---");
		Home_Page homePage = new Home_Page(driver);
		//homePage.clickSignIn();
		//Login_Page loginPage = new Login_Page(driver);
		//loginPage.login("ruchisgulati@gmail.com", "8698466655r");
		homePage.clickShopByCategory();
		ShopByCategory_Page shopByCategoryPage = new ShopByCategory_Page(driver);
		System.out.println("On Shop By Category Page");
		shopByCategoryPage.clickCategory("Snack Foods");
		Category_Page categoryPage = new Category_Page(driver);
		System.out.println("Selected Category: "+ "Snack Foods");
		categoryPage.setPriceFilter(500, 1000);
		Thread.sleep(5000);
		categoryPage.clickFilterGo();
		Thread.sleep(5000);
		System.out.println("Price Filter Applied Successfully");
		ProductList_Page productListPage = new ProductList_Page(driver);
		Assert.assertTrue(productListPage.verifyPriceFilter(500, 1000), "Fail: Price filter Verification failed");
		//homePage.clickSignOut();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
