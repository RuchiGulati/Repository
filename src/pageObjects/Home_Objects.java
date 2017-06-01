package pageObjects;

import org.openqa.selenium.By;

public class Home_Objects {

	public static By lnk_SignIn = By.xpath(".//*[@id='nav-link-yourAccount']/span[1]");
	public static By btn_SignIn = By.xpath(".//*[@id='nav-flyout-ya-signin']/a/span");
	public static By lnk_SignOut = By.xpath("//span[contains(text(),'Sign Out')]");
	public static By lnk_AmazonPay = By.partialLinkText("Amazon Pay");
	public static By lnk_ShopByCategory = By.id("nav-link-shopall");
	public static By txt_Search = By.id("twotabsearchtextbox");
	public static By btn_Search = By.xpath("//input[@class = 'nav-input' and @type = 'submit']");
	public static By lnk_Cart = By.id("nav-cart");
	public static By lnk_CartCount = By.id("nav-cart-count");

}
