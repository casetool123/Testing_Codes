package opencartpac;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T008_Lab6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//WebDriverManager.edgedriver().setup();
		//WebDriver driver=new EdgeDriver();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi 10 Power (Sporty Orange, 8GB RAM, 128GB Storage");
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("nav-search-submit-button"))));
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		
		
		List<String> list=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(list.size());
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.id("add-to-cart-button")).click();
//		Thread.sleep(9000);
	
		driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
		
		Select sortby=new Select(driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")));
        sortby.selectByIndex(2);
        
	}

}
