package pageObjects;

import org.openqa.selenium.By;

public class ViewBalance_Objects {

	public static By ttl_PayBalance = By.xpath("//h1/span[contains(text(),'Amazon Pay balance')]");
	public static By ttl_Balance = By.className("rupee-symbol-heading");
	public static By lnk_Recharge = By.partialLinkText("Top-up your balance");

}
