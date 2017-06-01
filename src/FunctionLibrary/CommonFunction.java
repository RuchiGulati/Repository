package FunctionLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunction {
	static WebDriver driver;

	public static String getData(){
		return null;

	}
	
	public static String getPageTitle(){
		return driver.getTitle();
	}

	public static WebElement getElement(By locator){	
		return driver.findElement(locator);

	}

	public 	static void clickAndSwitchingToNewTab(){

	}

	public 	static void switchingBackToOldTab(){

	}
}

