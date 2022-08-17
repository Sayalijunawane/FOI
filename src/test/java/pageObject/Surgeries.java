package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Surgeries 
{
	public WebDriver driver;
	
	By Surgeries=By.xpath("//*[text()='Surgeries']");
	
	By AddNewSurgery=By.xpath("//*[text()='Add New Surgery']");
	
	By AddNewPatient=By.xpath("//*[text()='New Patient']");
	
	By MRNNumber=By.xpath("//input[@id='hospitalMRNNumber']");
	
	By fname=By.xpath("//input[@id='patientFirstName']");
	
	By lname=By.xpath("//input[@id='patientLastName']");
	
	By ClickonDob= By.xpath("//input[@id='PatientDOB']");
	
	By SelectMonth=By.xpath("//div[@class='bs-datepicker-head']//button[@class='current ng-star-inserted']");
	
	By SelectService=By.xpath("//span[(text()='Select Service')]");
	
	By search=By.xpath("//span[@class='p-input-icon-right d-block']//following-sibling::input");
	
	By status=By.xpath("//p-multiselect[@optionlabel='status']//  descendant ::div[3]");
	
	By unapprovedTab=By.xpath("//span[contains(text(),'Unapproved ')]");
	
	By unbilled=By.xpath("//span[contains(text(),'Unbilled')]");
	
	By cancel=By.xpath("//span[contains(text(),'Cancelled')]");
	
	By willcall=By.xpath("//span[contains(text(),'Call')]");
	
	By date= By.xpath("//input[@placeholder='Filter By Date']");
	
	/*public Surgeries(WebDriver driver)
	{
		this.driver=driver;
	}
	*/
	
	public WebElement ClickonSurgeries(WebDriver driver)
	{
		return driver.findElement(Surgeries);
		
	}
	
	public WebElement ClickOnAddNewSurgery(WebDriver driver)
	{
		return driver.findElement(AddNewSurgery);
	}
	
	public WebElement AddNewPatient(WebDriver driver)
	{
		return driver.findElement(AddNewPatient);
	}
	
	public WebElement AddMRNNumber(WebDriver driver)
	{
		return driver.findElement(MRNNumber);
	}
	
	public WebElement fname(WebDriver driver)
	{
		return driver.findElement(fname);
	}
	public WebElement lname(WebDriver driver)
	{
		return driver.findElement(lname);
	}
	public WebElement PatientDob(WebDriver driver)
	{
		return driver.findElement(ClickonDob);
	}
	public WebElement SelectMonthofDob(WebDriver driver)
	{
		return driver.findElement(SelectMonth);
	}
	
	public WebElement Selectserviceoption(WebDriver driver)
	{
		return driver.findElement(SelectService);
	}
	public WebElement Selectsearch(WebDriver driver)
	{
		return driver.findElement(search);
	}
	
	public WebElement filterbyStatus(WebDriver driver)
	{
		return driver.findElement(status);
	}
	public WebElement ClickonUnapprovedTab(WebDriver driver)
	{
		return driver.findElement(unapprovedTab);

	}
	public WebElement ClickonUnbilledTab(WebDriver driver)
	{
		return driver.findElement(unbilled);
	}
	public WebElement ClickonCancelledTab(WebDriver driver)
	{
		return driver.findElement(cancel);
	}
	public WebElement ClickonWillcall(WebDriver driver)
	{
		return driver.findElement(willcall);
	}
	public WebElement FilterbyDate(WebDriver driver)
	{
		return driver.findElement(date);
	}

}
