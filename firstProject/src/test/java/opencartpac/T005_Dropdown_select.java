package opencartpac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T005_Dropdown_select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        
        driver.findElement(By.linkText("Desktops")).click();
        
        driver.findElement(By.linkText("Mac (1)")).click();
        
        Select sortby=new Select(driver.findElement(By.id("input-sort")));
        sortby.selectByIndex(5);
        
        
        
        
		
	}

}
