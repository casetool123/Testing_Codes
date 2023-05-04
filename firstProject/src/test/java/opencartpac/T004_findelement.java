package opencartpac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T004_findelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		
		driver.findElement(By.partialLinkText("Account")).click();
		driver.findElement(By.linkText("Register")).click();
		List <WebElement> element = (List<WebElement>) driver.findElement(By.xpath("//a[@class='list-group-item']"));
		
		for(WebElement label:element) {
			String textvalue = label.getText();
			System.out.println("Text is :" + textvalue);
		}
	}

}
