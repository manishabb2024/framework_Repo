package GenericUtility;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public static TakesScreenshot sdriver;
	public GenericFileUtility fu=new GenericFileUtility();
 	public WebDriver driver=null;
 //	public javaUtils ju=new javaUtils();
 	//public GenericExcelUtility eu=new GenericExcelUtility();
 	public DatabaseUtility du=new DatabaseUtility();
 	public WebDriverUtils wu=new WebDriverUtils();	
 	public Login lg;
 	
 	//public static WebDriver sdriver=null;

 @BeforeSuite(alwaysRun=true)
 		public void configBasesuit() throws Throwable
 		{
 	
 			System.out.println("=====Connect to Database====");
 			
 			du.getconnectToDatabase();
 			
 		}
 	@BeforeClass(alwaysRun=true)
 	public void beforeclass() throws Throwable
 	{
 		System.out.println("===============Launch the browser======");
 		
 		//String BROWSER=fu.getDataFromPrpperties("browser");
 		String BROWSER=System.getProperty("browser");
 		//String BROWSER=fu.getDataFromPrpperties("browser");
 		System.out.println(BROWSER);
 		if(BROWSER.equals("chrome")) {
 			driver = new ChromeDriver();
 		}
 		else if(BROWSER.equals("firefox")) {
 			driver = new FirefoxDriver();
 		}
 		else if(BROWSER.equals("opera")) {
 			driver = new EdgeDriver();
 		}
 		else {
 			driver = new InternetExplorerDriver();
 		}
 		//sdriver=driver;
 		String url = fu.getDataFromPrpperties("url");
 		System.out.println();
 		driver.get(url); 			
 		wu.Maximize(driver);
 		wu.waitForPageToLoad(driver);
 		System.out.println("------its before class-----");
 	}
 	@BeforeMethod(alwaysRun=true)
 	public void beforeMethod() throws IOException
 	{
 		System.out.println("------Login page-----");
 		lg=new Login(driver);
 		lg.login();
 	}


@AfterMethod(alwaysRun=true)
 	public void afterMethod()
 	{
 		System.out.println("------LogoutPage-----");
 		lg.move();
 		lg.logout();
 	}


 	@AfterClass(alwaysRun=true)
 	public void Afterclass()
 	{
 		System.out.println("------its after class-----");
 		driver.quit();
 	}
 	@AfterSuite(alwaysRun=true)
 	public void Aftersuite() throws Throwable
 	{
 		System.out.println("------its after suite-----"); 		
 		du.con.close();;
 	}
}
