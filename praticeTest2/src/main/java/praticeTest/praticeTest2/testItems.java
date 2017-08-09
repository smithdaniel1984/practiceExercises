package praticeTest.praticeTest2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class testItems {
	
	WebDriver driver;
	
	By needHelpTab = By.className("ats-help");
	By xboxLinkHover = By.linkText("Xbox One");
	By allGames = By.linkText("All Games");
	By selectGame = By.linkText("Madden NFL 18 G.O.A.T. Edition");
	By scrollRight = By.xpath("//*[@id='chained']/a[2]");

	public testItems(WebDriver driver)
	{
		this.driver = driver;
	}
	public void helpLink()
	{
		driver.findElement(needHelpTab).click();
	}
	public void xboxLink()
	{
		WebElement hover;
		Actions action = new Actions(driver);
		hover = driver.findElement(xboxLinkHover);
		
		action.moveToElement(hover);
		action.perform();
		
		driver.findElement(allGames).click();
	}
	public void gameSelect()
	{
		driver.findElement(selectGame).click();
	}
	public void homePagePicScroll()
	{
		driver.findElement(scrollRight).click();
	}
}
