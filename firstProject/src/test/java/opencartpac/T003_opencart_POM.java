package opencartpac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T003_opencart_POM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
String projectpath=System.getProperty("user.dir");

		FileInputStream input=new FileInputStream(projectpath+"\\data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowcount=sheet.getPhysicalNumberOfRows();
		
		
		
		System.out.println(rowcount);
		for(int i=1;i<rowcount;i++)
		{
			String firstname=sheet.getRow(i).getCell(0).getStringCellValue();
			String lastname=sheet.getRow(i).getCell(1).getStringCellValue();
			String emailid=sheet.getRow(i).getCell(2).getStringCellValue();
			String password=sheet.getRow(i).getCell(3).getStringCellValue();
			
			System.out.println(firstname+lastname+emailid+password);
		
		
		
		
		
	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		pageobjects_opencart_registration obj=new pageobjects_opencart_registration(driver);
		driver.get("https://demo.opencart.com/");
		
		//driver.findElement(By.partialLinkText("Account")).click();
		obj.clickonaccount();
		//driver.findElement(By.linkText("Register")).click();
		obj.clickonregister();
		//driver.findElement(By.id("input-firstname")).sendKeys("Fathima");
		obj.enterfirstname(firstname);
		//driver.findElement(By.name("lastname")).sendKeys("bevi");
		obj.enterlastname(lastname);
		
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
		obj.enteremail(emailid);
		//driver.findElement(By.cssSelector("input.form-control[name='password']")).sendKeys("welcome");
		obj.enterpassword(password);
		
	//WebElement subscribe=driver.findElement(By.id("input-newsletter-yes"));
		
	//System.out.println("name Attribute value of yes button is:"+subscribe.getAttribute("name"));
	
		if(obj.entersubsciption())
		{
			System.out.println("Yes Button is selected");
		}
		
		else
		{
			System.out.println("Yes Button is not selected");
		}
		
		if(obj.submitdisplayed())
		{
			
			System.out.println("Submit button is displayed");
			//WebElement continu=driver.findElement(By.xpath("//button[@type='submit']"));;
			
			System.out.println("The text of continue button is:"+obj.submitgettext());
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
			obj.clickonsubmit();
		}	
		else
		{
			System.out.println("Submit button is not displayed");
		}
		
obj.close();		
	}

}
}

