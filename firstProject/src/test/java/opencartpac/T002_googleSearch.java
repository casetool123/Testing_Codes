package opencartpac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T002_googleSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		
		WebElement searchelement = driver.findElement(By.id("APjFqb"));
		searchelement.sendKeys("Test Methods");
		searchelement.submit();
		
		//driver.findElement(By.name("btnK")).click();
		System.out.println("The title of the page: " + driver.getTitle());
		
		driver.navigate().to("https://demo.opencart.com/");
		System.out.println("The title of the page: " + driver.getTitle());
		System.out.println("The URL of the page: " + driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println("The title of the page: " + driver.getTitle());
		System.out.println("The URL of the page: " + driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println("The title of the page: " + driver.getTitle());
		System.out.println("The URL of the page: " + driver.getCurrentUrl());
		
		System.out.println("The source of the page: " + driver.getPageSource().contains("store"));
	
		driver.quit();

	}

}
