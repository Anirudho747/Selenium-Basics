package Mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class M1 {
	
	static WebDriver driver = null;

	public static void M10() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
	}
	
	public static void M20() throws InterruptedException
	{
		WebElement allBooks = driver.findElement(By.xpath("//div[text()='All Books']"));
		WebElement clicker    = driver.findElement(By.xpath("//div[text()='All Books']//following::span[@class='dhx_tree-list-item__text' and text()='2009'][1]//preceding::div[@class='dxi dxi-menu-right dhx_tree-toggle-button'][1]"));
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", allBooks);
		//js.executeScript("arguments[0].click();", clicker);
		
		clicker.click();
		WebElement targetBook = driver.findElement(By.xpath("//span[@class='dhx_tree-list-item__text' and text()='Unlocking Android']"));
		WebElement source     = driver.findElement(By.xpath("//ul[@class='dhx_widget dhx_list ']"));
	    Actions actn = new Actions(driver);
	    actn.dragAndDrop(targetBook, source).build().perform();
	    Thread.sleep(3400);
	    
	    WebElement clickAt2013       = driver.findElement(By.xpath("//div[text()='All Books']//following::span[@class='dhx_tree-list-item__text' and text()='Java']//following::span[@class='dhx_tree-list-item__text' and text()='2013']//preceding::div[@class='dxi dxi-menu-down dhx_tree-toggle-button dhx_tree-toggle-button--open'][1]"));
	    clickAt2013.click();
	    clickAt2013.click();
	    driver.findElement(By.cssSelector("#treeSource > ul > li:nth-child(3) > ul > li:nth-child(1) > div > div.dxi.dxi-menu-right.dhx_tree-toggle-button")).click();
	    WebElement targetBook2 = driver.findElement(By.xpath("//span[@class='dhx_tree-list-item__text' and text()='Making Java Groovy']"));
	    //actn.dragAndDrop(targetBook2, source).build().perform();
	   // actn.clickAndHold(targetBook2).moveToElement(source).release().build().perform();
	    actn.dragAndDropBy(targetBook2, -100, 0).build().perform();
	}

	public static void main(String[] args) throws InterruptedException {
		M10();
		M20();
	}

}
