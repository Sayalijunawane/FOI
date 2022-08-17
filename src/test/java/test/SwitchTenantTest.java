package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObject.SwitchTenant;

public class SwitchTenantTest 
{
	public WebDriver driver;
	public SwitchTenantTest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void ChangeTenant(String tenantName) throws Exception
	{
		
		SwitchTenant s=new SwitchTenant();
		s.ClickOnChangeTenant(driver).click(); //click on change Tenant Link
		s.ClickOnToggleBtn(driver).click();    //click on toggle
		s.EnterTenantName(driver).sendKeys(tenantName);
		s.ClickSwitchToTenantBtn(driver).click();//switch to tenant
	}
	

}
