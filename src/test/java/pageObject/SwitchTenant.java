package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchTenant 
{
	public WebDriver driver;
	
	
		By ChangeLink= By.xpath("//span[@class='ng-star-inserted']/following-sibling::a");
		
		By ToggelBtn= By.xpath("//input[@name='SwitchToTenant']");
		
		By TenantName= By.xpath("//input[@name='tenancyNameInput']");
		
		By SwitchTenantBtn=By.xpath("//button[@class='btn btn-primary btn-sm save-button']");
		
		

	public WebElement ClickOnChangeTenant(WebDriver driver)
	{
		return driver.findElement(ChangeLink);
		
	}
	
	
	public WebElement ClickOnToggleBtn(WebDriver driver)
	{
		return driver.findElement(ToggelBtn);
		
	}
	public WebElement EnterTenantName(WebDriver driver)
	{
		return driver.findElement(TenantName);
		
	}
	
	public WebElement ClickSwitchToTenantBtn(WebDriver driver)
	{
		return driver.findElement(SwitchTenantBtn);
		
	}
	
}
