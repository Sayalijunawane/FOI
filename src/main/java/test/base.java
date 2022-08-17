package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class base
{
	public static WebDriver driver;
	public Properties p;
	public static ExtentReports report=null;
	
	public static ExtentSparkReporter sparc=null;
	public static ExtentTest test=null;
	public WebDriver initialize() throws IOException
	{
		String path = System.getProperty("user.dir")+"/Resources/data.properties";
		System.out.println("path="+path);
		p=new Properties();
		FileInputStream fis=new FileInputStream(path);
		p.load(fis);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit)
		
		String BrowserName=p.getProperty("browser");
		if(BrowserName.equals("chrome"))
		{
			String chromedriverpath = System.getProperty("user.dir")+"/Resources/chromedriver.exe";
			System.out.println("chro path="+chromedriverpath);
			System.setProperty("webdriver.chrome.driver",chromedriverpath);
			driver=new ChromeDriver();
		}
		else if(BrowserName.equals("edge"))
		{
			String msedgedriverpath = System.getProperty("user.dir")+"/Resources/msedgedriver.exe";
			System.setProperty("webdriver.edge.driver",msedgedriverpath);
			driver=new EdgeDriver();
		}
		else if (BrowserName.equals("firefox"))
		{
			String geckodriverpath = System.getProperty("user.dir")+"/Resources/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",geckodriverpath);
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}
	
	/*@AfterTest
	public void closeBrowser()
	{
		System.out.println("you are in close browser");
		driver.close();
		
	}*/
	
	@BeforeSuite
public void reportInit()
{
	report=new ExtentReports();
	sparc=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
	report.attachReporter(sparc);
	report.setSystemInfo("Tester", "Sayali Junawane");
	
}
}
