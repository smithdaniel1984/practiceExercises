package praticeTest.ieDriver_exercise3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class amazonPage_Elements {

	WebDriver driver;
	WebDriverWait wait;
	
	String assertMessage = "Not on the home page! Charasel is not present.";
	
	By searchBar = By.id("twotabsearchtextbox");
	By searchIcon = By.className("nav-input");
	By nextPage = By.id("pagnNextString");
	By asCreed = By.linkText("Assassin's Creed Origins - Xbox One");
	By priceLbl = By.id("newPrice");
	By homeIcon = By.xpath("//*[@id='nav-logo']/a[1]/span[1]");
	By charasel = By.className("gw-critical-content");
	By gamePic = By.className("a-list-item");
	By picNext = By.xpath("//*[@id='gw-desktop-herotator']/div/div/div/div[3]/a/i");
	By addCart = By.id("add-to-cart-button");
	By cartItem = By.id("nav-cart-count");
	By item1Name = By.xpath("//*[@id='activeCartViewForm']/div[2]/div/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span");
		
	public amazonPage_Elements(WebDriver driver)
	{
		this.driver = driver;
	}
	public String search(String item)
	{
		WebElement searchBarEle = driver.findElement(searchBar);
		searchBarEle.click();
		searchBarEle.sendKeys(item);
		driver.findElement(searchIcon).click();
		return item;
	}
	public void clickNext_itemFind()
	{
		WebElement next = driver.findElement(nextPage);
		WebElement mafiaGame = driver.findElement(asCreed);
		
		//if statement to click next if the item is not on the current page
		if(mafiaGame.isDisplayed())
		{
			mafiaGame.click();
		}
		else
		{
			next.click();	
		}
		
	}
	public void getPrice()
	{
		WebElement price = driver.findElement(priceLbl);
		System.out.println("Price of the game is: " + price.getText());
	}
	public void go_home()
	{
		WebElement homeClick = driver.findElement(homeIcon);
		homeClick.click();
		
		WebElement rotator = driver.findElement(charasel);
		Assert.assertTrue(rotator.isEnabled(), assertMessage);
		
		//click the next button on the pictures
		for(int i = 1; i <= 5; i++)
		{
			driver.findElement(picNext).click();
		}
	}
	public void gamePic_click()
	{
		WebElement gamePic_ele = driver.findElement(gamePic);
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(gamePic_ele));
		
		gamePic_ele.click();
	}
	public void addToCart()
	{
		WebElement addtocart_ele = driver.findElement(addCart);
		addtocart_ele.click();
	}
	public void viewCart()
	{
		//cart items 
		WebElement cartItems = driver.findElement(cartItem);
		int numberOfItems = Integer.parseInt(cartItems.getText());
				
		if(numberOfItems > 0)
		{
			System.out.println("Number of items in the cart: " + numberOfItems);
		}
		else
		{
			System.out.println("Cart is currently empty: " + numberOfItems);
		}
		//Enter into view shopping cart
		cartItems.click();
		
		//Name of the item in the cart
		WebElement cartItem1 = driver.findElement(item1Name);
		System.out.println("Name of the item is: " + cartItem1.getText());
	}
}
