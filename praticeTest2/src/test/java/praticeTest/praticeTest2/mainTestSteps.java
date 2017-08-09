package praticeTest.praticeTest2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class mainTestSteps {
	
	public WebDriver driver;
	public String chromeBrowserPath = "C:\\Users\\daniel.smith\\Desktop\\selenium_training\\chromedriver.exe";
	public String webAddress = "http://www.gamestop.com";
	testItems items;
	String pageTitle = "http://www.gamestop.com/xbox-one";
	
	@BeforeTest 
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", chromeBrowserPath);
		driver = new ChromeDriver();	
		
		driver.navigate().to(webAddress);
	}
	
	@Test(priority = 0)
	public void helpMenuOpen()
	{
		items = new testItems(driver);
		items.helpLink();
	}
	@Test(priority = 1)
	public void gameSelect()
	{
		items = new testItems(driver);
		items.xboxLink();
	}
	@Test(priority = 2)
	public void selectGame()
	{
		items = new testItems(driver);
		items.gameSelect();
	}
	@Test(priority = 3)
	public void goBackToHomePage()
	{
		for(int i = 1; i <= 3; i++)
		{
			driver.navigate().back();
			if (i > 1)
			{
				System.out.println("Went back " + i + " times.");
			}
			else
				System.out.println("Went back " + i + "st time.");
		}
	}
	@Test(priority = 4)
	public void picScrollRight()
	{
		items = new testItems(driver);
		for (int i = 1; i <= 5; i++)
		{
			items.homePagePicScroll();
		}
	}
}