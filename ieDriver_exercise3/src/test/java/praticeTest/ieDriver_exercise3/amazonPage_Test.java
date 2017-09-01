package praticeTest.ieDriver_exercise3;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazonPage_Test {
	
	WebDriver driver;
	amazonPage_Elements page;
	
	String IEbrowserPath = "C:\\Users\\Smith\\git\\practiceExercises\\ieDriver_exercise3\\Drivers\\MicrosoftWebDriver.exe";
	String ChromebrowserPath = "C:\\Users\\Smith\\git\\practiceExercises\\ieDriver_exercise3\\Drivers\\chromedriver.exe";
	String url = "http://www.amazon.com";
	String item = "xbox one";
	
	@BeforeTest
	public void testSetup()
	{
		System.setProperty("webdriver.chrome.driver", ChromebrowserPath);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//Positioning the page on the right side of the screen
		//driver.manage().window().setPosition(new Point(960, 0));
		//driver.manage().window().setSize(new Dimension(960, 1040));
	}
	@Test(priority = 0)
	public void navigateToAmazon()
	{
		driver.navigate().to(url);
	}
	@Test(priority = 1)
	public void search_for_item()
	{
		page = new amazonPage_Elements(driver);
		
		page.search(item);
	}
	@Test(priority = 2)
	public void selecting_an_item()
	{
		//clicking next for next page
		page = new amazonPage_Elements(driver);
		page.clickNext_itemFind();
		
		//Get the price of the item
		page.getPrice();
	}
	@Test(priority = 10)
	public void return_home()
	{
		page = new amazonPage_Elements(driver);
		
		page.go_home();
	}
	@Test(priority = 3)
	public void click_on_gamePic()
	{
		page = new amazonPage_Elements(driver);
		page.gamePic_click();
	}
	@Test(priority = 4)
	public void add_to_cart()
	{
		page = new amazonPage_Elements(driver);
		page.addToCart();
	}
	@Test(priority = 5)
	public void view_shopping_cart()
	{
		page = new amazonPage_Elements(driver);
		page.viewCart();
	}
}
