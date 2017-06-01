package testScripts;

import org.testng.annotations.Test;

import FunctionLibrary.TestBaseSetup;
import pageKeywords.AmazonPay_Page;
import pageKeywords.Category_Page;
import pageKeywords.Home_Page;
import pageKeywords.Login_Page;
import pageKeywords.ShopByCategory_Page;
import pageKeywords.ViewBalance_Page;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_VerifyUserCanShopByCategory {
	WebDriver driver;
	@Parameters({"Browser", "URL"})
	@BeforeClass
	public void beforeClass(String Browser, String URL) {
		TestBaseSetup testBaseSetup = new TestBaseSetup();
		driver = testBaseSetup.launchBrowser(Browser, URL);
	}

	@Test
	public void VerifyUserCanShopByCategory() throws InterruptedException {
		System.out.println("---Executing Test Case To Verify User Can Shop By Category---");
		Home_Page homePage = new Home_Page(driver);
		homePage.clickSignIn();
		Login_Page loginPage = new Login_Page(driver);
		loginPage.login("ruchisgulati@gmail.com", "8698466655r");
		homePage.clickShopByCategory();
		ShopByCategory_Page shopByCategoryPage = new ShopByCategory_Page(driver);
		//System.out.println(shopByCategoryPage.getPageTitle());
		Assert.assertTrue(shopByCategoryPage.getPageTitle().contains("Amazon.in - Departments"), "Fail: Not on Amazon Shop By Category Page");
		System.out.println("On Shop By Category Page");
		shopByCategoryPage.clickCategory("Snack Foods");
		Category_Page categoryPage = new Category_Page(driver);
		System.out.println("Selected Category: "+ "Snack Foods");
		//System.out.println(categoryPage.getPageTitle());
		Assert.assertTrue(categoryPage.getPageTitle().contains("Snack Foods"), "Fail: Not on "+ "Toys" +" Category Page");
		homePage.clickSignOut();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
