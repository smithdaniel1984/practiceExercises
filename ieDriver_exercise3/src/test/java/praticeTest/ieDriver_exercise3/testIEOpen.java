package praticeTest.ieDriver_exercise3;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testIEOpen {
	
	WebDriver driver;
	String IEbrowserPath = "C:\\Users\\daniel.smith\\Desktop\\selenium_training\\IEDriverServer.exe";
	String ChromebrowserPath = "C:\\Users\\daniel.smith\\Desktop\\selenium_training\\chromedriver.exe";
	String w3url = "http://www.w3schools.com/html/html_forms.asp";
	String gamestopUrl = "http://www.gamestop.com";
	String Username = "tomsmith";
	String Password = "SuperSecretPassword!";
	setupTest objects;
	
	Random random = new Random();
	int selection = random.nextInt(3);
	
	
	@BeforeTest
	public void chromesetUp()
	{
		System.setProperty("webdriver.chrome.driver", ChromebrowserPath);
		driver = new ChromeDriver();	
	}
	@Test(priority = 0)
	public void navigate_to_gamestop()
	{
		driver.navigate().to(w3url);
		
		objects = new setupTest(driver);
		
		objects.w3Radios(selection);
	}
	@Test(priority = 1)
	public void dataTable()
	{
		objects = new setupTest(driver);
		
		objects.dataTable();
	}
	@Test(priority = 2)
	public void asserts()
	{
		objects = new setupTest(driver);
		
		objects.assertSteps(Username, Password);
	}
}