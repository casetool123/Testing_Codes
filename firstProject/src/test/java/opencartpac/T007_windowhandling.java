package opencartpac;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T007_windowhandling {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/windows");
		driver.findElement(By.id("multi")).click();
		System.out.println(driver.getWindowHandle());
		List<String> list=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(list.size());
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(list.get(2));
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
		
		
		
		
		
	}

}
