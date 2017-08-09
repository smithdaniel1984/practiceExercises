package praticeTest.ieDriver_exercise3;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class setupTest {
	
	WebDriver driver;
	String statement = "tconway@earthlink.net";
	String successfulText = "You logged into a secure area!";
		
	By searchBar = By.id("searchtext");
	By xboxOneLink = By.linkText("Xbox One");
	By maleRadio =  By.xpath("//*[@id='main']/input[3]");
	By femaleRadio = By.xpath("//*[@id='main']/input[4]");
	By otherRadio = By.xpath("//*[@id='main']/input[5]");
	By dataTables = By.linkText("Sortable Data Tables");
	By tableName = By.xpath("//*[@id='table1']/tbody");
	By columnHeaders = By.xpath("//*[@id='table1']/thead");
	By assertLink = By.linkText("Form Authentication");
	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//*[@id='login']/button/i");
	By subTitle = By.xpath("//*[@id='flash']");
	

	public setupTest(WebDriver driver)
	{
		this.driver = driver;
	}
	public void xboxOneLink()
	{
		WebElement xboxOne = driver.findElement(xboxOneLink);
		xboxOne.click();
	}
	public int w3Radios(int selection)
	{
		System.out.println("Random number is: " + selection);
		
		if(selection == 0)
		{
			driver.findElement(maleRadio).click();
		}
		else if(selection == 1)
		{
			driver.findElement(femaleRadio).click();
		}
		else
			driver.findElement(otherRadio).click();
		
		return selection;
	}
	public void dataTable()
	{
		driver.navigate().to("https://the-internet.herokuapp.com/");
		
		driver.findElement(dataTables).click();
		
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		List<WebElement> listcolumns = driver.findElements(By.tagName("th"));
		
		System.out.println("number of rows: " + rows.size());
		System.out.println("number of columns: " + listcolumns.size());
		
		for(int i = 1; i <= rows.size()/2-1; i++)
		{
			for(int j = 1; j <= 6; j++)
			{
				String output =(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr["+i+"]/td["+j+"]")).getText());
				if(output.equals(statement))
				{
					System.out.println("Row: " + i + " Column: " + j);
				}
			}
		}
	}
	public void assertSteps(String Username, String Password)
	{
		driver.navigate().to("https://the-internet.herokuapp.com/");
		
		driver.findElement(assertLink).click();
		
		WebElement name = driver.findElement(username);
		WebElement pass = driver.findElement(password);
		
		name.sendKeys(Username);
		pass.sendKeys(Password);
		
		driver.findElement(loginBtn).click();
		
		WebElement subtitle = driver.findElement(subTitle);
		String subTitleText = subtitle.getText();
	}
}