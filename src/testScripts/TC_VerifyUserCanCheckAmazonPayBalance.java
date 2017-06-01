package testScripts;

import org.testng.annotations.Test;

import FunctionLibrary.TestBaseSetup;
import pageKeywords.AmazonPay_Page;
import pageKeywords.Home_Page;
import pageKeywords.Login_Page;
import pageKeywords.ViewBalance_Page;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_VerifyUserCanCheckAmazonPayBalance {

	WebDriver driver;
	@Parameters({"Browser", "URL"})
	@BeforeClass
	public void beforeClass(String Browser, String URL) {
		TestBaseSetup testBaseSetup = new TestBaseSetup();
		driver = testBaseSetup.launchBrowser(Browser, URL);
	}

	@Test
	public void VerifyUserCanCheckAmazonPayBalance() throws InterruptedException {
		System.out.println("--Executing Test Case To Verify User Can Check Amazon Pay Balance---");
		Home_Page homePage = new Home_Page(driver);
		homePage.clickSignIn();
		Login_Page loginPage = new Login_Page(driver);
		loginPage.login("ruchisgulati@gmail.com", "8698466655r");
		homePage.clickAmazonPay();
		AmazonPay_Page amazonPayPage = new AmazonPay_Page(driver);
		//System.out.println(payPage.getPageTitle());
		Assert.assertTrue(amazonPayPage.getPageTitle().contains("Amazon Pay"), "Fail: Not on Amazon Pay Page");
		amazonPayPage.ViewStmt();
		ViewBalance_Page viewBalancePage = new ViewBalance_Page(driver);
		System.out.println(viewBalancePage.getPageTitle());
		Assert.assertTrue(viewBalancePage.verifyPayBalance(), "Fail: Page Verification failed");
		homePage.clickSignOut();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		driver.close();
	}
}
