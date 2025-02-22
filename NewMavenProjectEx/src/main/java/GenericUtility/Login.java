package GenericUtility;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login  {
	WebDriver driver=null;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement user_name;
	 
	@FindBy(name="user_password")
	private WebElement user_password;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement Signout;
	
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement move;
	
	public void login() throws IOException
	{
		GenericFileUtility p=new GenericFileUtility();
		String usr=p.getDataFromPrpperties("user");
		String pwd=p.getDataFromPrpperties("password");
		System.out.println("user");
		System.out.println("pwd");
		user_name.sendKeys(usr);
		user_password.sendKeys(pwd);
		submitButton.click();
	}
	public void logout()
	{
		Signout.click();
	}
	public void move()
	{
		move.click();
	}
	
}
