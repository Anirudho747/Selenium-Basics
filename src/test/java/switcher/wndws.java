package switcher;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wndws {
	
	static WebDriver driver = null;

	public static void 	w10() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
	}
	
	public static void 	w20() {
		driver.findElement(By.linkText("Multiple Windows")).click();
		String win1 = driver.getWindowHandle();
		System.out.println(win1);
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> wndws = driver.getWindowHandles();
		System.out.println(wndws.toString());
		
		for(String s:wndws)
		{
			if(s.equals(win1))
			{
				driver.switchTo().window(s);
			}
		}
		driver.findElement(By.linkText("Click Here")).click();
		wndws = driver.getWindowHandles();
		System.out.println(wndws.toString());
		
		for(String s:wndws)
		{
			if(s.equals(win1))
			{
				driver.switchTo().window(s);
			}
		}
	}

	public static void main(String[] args) {
		w10();
		w20();
	}

}
