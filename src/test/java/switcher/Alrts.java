package switcher;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alrts {
	
	static WebDriver driver = null;

	public static void a10() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
	}
	
	public static void a20() throws InterruptedException
	{
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		Thread.sleep(1600);
		driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button")).click();
		Alert alt1 = driver.switchTo().alert();
		Thread.sleep(1600);
		alt1.accept();
		driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button")).click();
		Alert alt2 = driver.switchTo().alert();
		Thread.sleep(1600);
		alt2.dismiss();
		driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button")).click();
		Alert alt3 = driver.switchTo().alert();
		Thread.sleep(1600);
		alt3.sendKeys("Done with Alerts");
		alt3.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		a10();
		a20();

	}

}
