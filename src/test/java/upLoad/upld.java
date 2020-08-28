package upLoad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upld {
	
	static WebDriver driver = null;

	public static void u10() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
	}

	public static void u20() {
		u10();
		driver.findElement(By.linkText("File Upload")).click();
		try {
			Thread.sleep(1600);
			driver.findElement(By.id("file-upload")).sendKeys("F:\\MDM\\Snapshots\\Column2.png");
			driver.findElement(By.id("file-submit")).click();
			System.out.println(driver.findElement(By.xpath("//h3")).getText());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		u20();

	}

}
