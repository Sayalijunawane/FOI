package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientObjects 
{
	public WebDriver driver;
	
	By Patients= By.xpath("//span[text()='Patients']");
	
	By search=By.xpath("//input[@placeholder='Search...']");
	
	By listofdata=By.xpath("//div[@class='p-datatable-wrapper']//  child :: table//following-sibling:: tbody/tr");
	
	public WebElement clickonPatients(WebDriver driver)
	{
		return driver.findElement(Patients);
	}

	public WebElement clickonSearch(WebDriver driver)
	{
		return driver.findElement(search);
	}

	public List<WebElement> ListofData(WebDriver driver)
	{
		return driver.findElements(listofdata);
	}
	
	}
