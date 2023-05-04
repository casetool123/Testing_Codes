package opencartpac;

import java.io.FileInputStream;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T003_opencart_PageFactory {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
String projectpath=System.getProperty("user.dir");

ExtentReports extent=new ExtentReports();
ExtentSparkReporter spark=new ExtentSparkReporter(projectpath+"opencart_result.html");
extent.attachReporter(spark);
ExtentTest test=extent.createTest("Opencart_Registration");


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
			System.out.println(firstname+lastname+emailid+password)	;	
			WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		pagefactory_opencart_registration obj=PageFactory.initElements(driver, pagefactory_opencart_registration.class);
		
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
			test.pass("Yes Button is selected");
			
		}
		
		else
		{
			System.out.println("Yes Button is not selected");
			test.fail("Yes Button is not selected");
		}
		
		if(obj.submitdisplayed())
		{
			
			System.out.println("Submit button is displayed");
			test.pass("Submit button is displayed");
			//WebElement continu=driver.findElement(By.xpath("//button[@type='submit']"));;
			
			System.out.println("The text of continue button is:"+obj.submitgettext());
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
			obj.clickonsubmit();
		}	
		else
		{
			System.out.println("Submit button is not displayed");
			test.fail("Submit button is not displayed");
		}
		
driver.close();		
extent.flush();
	}

}
}

