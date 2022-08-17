package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;


public class HandlePatientsSearchTest extends base
{
	@Test
	public void addNewSuregery() throws Exception
	{
	driver=initialize();
	driver.get(p.getProperty("url2"));
	driver.manage().window().maximize();
	//Thread.sleep(5000);
	SwitchTenantTest t=new SwitchTenantTest(driver);
	t.ChangeTenant("Default");
	ValidLogin vc = new ValidLogin();
	vc.testLogin(driver,2);
	}

}
