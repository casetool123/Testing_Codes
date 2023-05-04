package opencartpac;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T009_JavaScript_Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("alert('search the ipad');");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,900)");
		//driver.findElement(By.linkText("About Us")).click();
		
		
				
		
		
	}

}
