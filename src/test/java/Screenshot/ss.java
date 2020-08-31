package Screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ss {
	
	static WebDriver driver = null;

	public static void action() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.travelguru.com/");
		TakesScreenshot tss = (TakesScreenshot)driver;
		File Srcfile = tss.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("./ScrnShot/Try7.png");
		FileHandler.copy(Srcfile,DestFile);
	}

	public static void main(String[] args) throws IOException {
		action();

	}

}
