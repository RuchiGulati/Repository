package FunctionLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBaseSetup {
	

	public static WebDriver launchBrowser(String Browser, String URL){
		WebDriver driver= null;
		
		if(Browser.equalsIgnoreCase("FF")||Browser.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
			//driver.manage().window().maximize();
			//driver.get(URL);
			//return driver;
		}
		else if(Browser.equalsIgnoreCase("GC")||Browser.equalsIgnoreCase("Chrome")||Browser.equalsIgnoreCase("googlechrome")){
			System.setProperty("webdriver.chrome.driver","../Amazon/Libraries/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			driver = new ChromeDriver(capabilities);
			//driver.get(URL);
			//return driver;
		}
		else if(Browser.equalsIgnoreCase("IE")||Browser.equalsIgnoreCase("InternetExplorer")||Browser.equalsIgnoreCase("Explorer")){
			System.setProperty("webdriver.ie.driver","../Amazon/Libraries/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriverService.IE_DRIVER_EXTRACT_PATH_PROPERTY,"../Amazon/libraries/IEDriverExtractTemp");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,URL);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
			capabilities.setCapability("requiredWindowFocus",true);
			driver = new InternetExplorerDriver(capabilities);
			//driver.manage().window().maximize();
			//return driver;
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}

}

