package test;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pageObject.SwitchTenant;

public class HandleSearchInSurgeriesTest extends base
{
	@Test
	public void SearchInSurgery() throws Exception
	{
	driver=initialize();
	driver.get(p.getProperty("url2"));
	driver.manage().window().maximize();
	//Thread.sleep(5000);
	SwitchTenantTest t=new SwitchTenantTest(driver);
	t.ChangeTenant("Default");
	ValidLogin vc = new ValidLogin();
	vc.testLogin(driver,1);
	}
	
	@Test
	public void testfail()
	{
		Assert.assertEquals(4,2);
	}


}
