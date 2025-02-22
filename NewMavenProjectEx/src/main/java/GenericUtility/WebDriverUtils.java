package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	public void Maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
	}
	public void DropDownMethod(WebElement dropdown_element)
	{
		Select select =new Select(dropdown_element);
		select.selectByValue("Option 1");  
		select.selectByIndex(2);       
				
	}
	public void Actions(WebElement move)
	{
		//Actions act=new Actions(driver);
	//	act.moveToElement(move).click().perform();	
	}	
}
