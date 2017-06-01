package pageObjects;

import org.openqa.selenium.By;

public class ProductList_Objects {

	public static By txt_Product = By.xpath("//a[@title = 'TOYZONE EDUCATIONAL RIDER Rideon']");
	public static By list_Product = By.xpath("//li[starts-with(@id, 'result_')]");

}
