package opencartpac;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pagefactory_opencart_registration {
	WebDriver driver;
	//By AccountLink=By.partialLinkText("My Account");
	@FindBy(partialLinkText="My Account")
	WebElement AccountLink;
	//By RegisterLink=By.linkText("Register");
	@FindBy(linkText="Register")
	WebElement RegisterLink;
//By firstname=By.id("input-firstname");
	@FindBy(id="input-firstname")
	WebElement firstname;
//By lastname=By.name("lastname");
	@FindBy(name="lastname")
	WebElement lastname;
	
//By email=By.xpath("//input[@name='email']");
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
//By password=By.cssSelector("input.form-control[name='password']");
	@FindBy(css="input.form-control[name='password']")
	WebElement password;
	
	//By subscriptionyes=By.id("input-newsletter-yes");
	
	@FindBy(id="input-newsletter-yes")
	WebElement subscriptionyes;
	
	//By submitbutton=By.xpath("//button[@type='submit']");
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbutton;
	
	

	public void clickonaccount()
	{
		AccountLink.click();
	}
	
	public void clickonregister()
	{
		RegisterLink.click();
	}
	
	public void enterfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void enterlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void enteremail(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	public void enterpassword(String pword)
	{
		password.sendKeys(pword);
	}
	
	public Boolean entersubsciption()
	{
		Boolean flag;
		flag=subscriptionyes.isSelected();
		return flag;
	}
	
	public void clickonsubmit()
	{
		submitbutton.click();
	}
	
	public Boolean submitdisplayed()
	{
		Boolean flag1;
		flag1=submitbutton.isDisplayed();
		return flag1;
	}
	
	public String submitgettext()
	{
		String txt=submitbutton.getText();
		
		return txt;
	}
	
	
	public void close()
	{
		driver.quit();
	}
}
