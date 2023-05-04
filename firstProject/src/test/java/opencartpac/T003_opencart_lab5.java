package opencartpac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T003_opencart_lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.findElement(By.partialLinkText("Account")).click();
		
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Fathima");
		driver.findElement(By.name("lastname")).sendKeys("bevi");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
		
		driver.findElement(By.cssSelector("input.form-control[name='password']")).sendKeys("welcome");
		
		
	WebElement subscribe=driver.findElement(By.id("input-newsletter-yes"));
		
	System.out.println("name Attribute value of yes button is:"+subscribe.getAttribute("name"));
	
		if(subscribe.isSelected())
		{
			System.out.println("Yes Button is selected");
		}
		
		else
		{
			System.out.println("Yes Button is not selected");
		}
		
		if(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed())
		{
			
			System.out.println("Submit button is displayed");
			WebElement continu=driver.findElement(By.xpath("//button[@type='submit']"));;
			
			System.out.println("The text of continue button is:"+continu.getText());
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		}	
		else
		{
			System.out.println("Submit button is not displayed");
		}
		
		
	}
	
}
