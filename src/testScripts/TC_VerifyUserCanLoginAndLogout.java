package testScripts;

import org.testng.annotations.Test;

import FunctionLibrary.TestBaseSetup;
import pageKeywords.Home_Page;
import pageKeywords.Login_Page;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC_VerifyUserCanLoginAndLogout {
	WebDriver driver;
	@Parameters({"Browser", "URL"})
	@BeforeClass
	public void beforeClass(String Browser, String URL) {
		//TestBaseSetup testBaseSetup = new TestBaseSetup();
		//driver = testBaseSetup.launchBrowser(Browser, URL);
		driver = TestBaseSetup.launchBrowser(Browser, URL);
	}

	@Test
	public void verifyUserCanLoginAndLogout() throws InterruptedException {
		System.out.println("---Executing Test Case To Verify User Can Login And Logout---");
		Home_Page homePage = new Home_Page(driver);
		homePage.clickSignIn();
		Login_Page loginPage = new Login_Page(driver);
		Assert.assertTrue(loginPage.getPageTitle().contains("Amazon Sign In"), "Fail: Not on Sign In Page");
		loginPage.login("ruchisgulati@gmail.com", "8698466655r");
		Assert.assertTrue(homePage.verifySignIn(), "Fail: Sign Out Link is not present");
		homePage.clickSignOut();
		Assert.assertTrue(loginPage.getPageTitle().contains("Amazon Sign In"), "Fail: Not on Sign In Page");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
