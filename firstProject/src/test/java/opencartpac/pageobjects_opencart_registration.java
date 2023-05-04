package opencartpac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageobjects_opencart_registration {
	WebDriver driver;
	By AccountLink=By.partialLinkText("My Account");
	By RegisterLink=By.linkText("Register");		
By firstname=By.id("input-firstname");
By lastname=By.name("lastname");
By email=By.xpath("//input[@name='email']");
By password=By.cssSelector("input.form-control[name='password']");
	By subscriptionyes=By.id("input-newsletter-yes");
	By submitbutton=By.xpath("//button[@type='submit']");
	public pageobjects_opencart_registration(WebDriver driver) {
		
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public void clickonaccount()
	{
		driver.findElement(AccountLink).click();
	}
	
	public void clickonregister()
	{
		driver.findElement(RegisterLink).click();
	}
	
	public void enterfirstname(String fname)
	{
		driver.findElement(firstname).sendKeys(fname);
	}
	
	public void enterlastname(String lname)
	{
		driver.findElement(lastname).sendKeys(lname);
	}
	
	public void enteremail(String emailid)
	{
		driver.findElement(email).sendKeys(emailid);
	}
	
	public void enterpassword(String pword)
	{
		driver.findElement(password).sendKeys(pword);
	}
	
	public Boolean entersubsciption()
	{
		Boolean flag;
		flag=driver.findElement(subscriptionyes).isSelected();
		return flag;
	}
	
	public void clickonsubmit()
	{
		driver.findElement(submitbutton).click();
	}
	
	public Boolean submitdisplayed()
	{
		Boolean flag1;
		flag1=driver.findElement(submitbutton).isDisplayed();
		return flag1;
	}
	
	public String submitgettext()
	{
		String txt=driver.findElement(submitbutton).getText();
		
		return txt;
	}
	
	
	public void close()
	{
		driver.quit();
	}
}
