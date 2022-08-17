package test;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import CommonFunctions.ReadExcel;
import jxl.Cell;
import jxl.read.biff.BiffException;

import pageObject.LoginPage;

public class ValidateLogin extends ReadExcel{
	@Test
	public void testLogin() throws BiffException, IOException, InterruptedException
	{
		String excelpath= System.getProperty("user.dir")+"/Resources/LoginDetails.xls";
		System.out.println("chro path="+excelpath);
		ReadExcel obj_to_read = new ReadExcel();
		obj_to_read.ReadExcelFile(excelpath,0);
		String user1 = "";
		String value = null;
		System.out.println("in read excel rows=" + obj_to_read.excel_row);
		
		System.out.println("in read excel cols=" + obj_to_read.excel_col);
		for(int i=1;i<obj_to_read.excel_row;i++)  //row
		{
			user1 = "";
			for(int j=0;j<obj_to_read.excel_col;j++) //col
			{
				
				Cell c= obj_to_read.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				user1=user1+" "+value;
				
			}
		
			System.out.println(user1.trim());
			String[] NameArray = user1.split(" ");
			String uname=NameArray[1];
			String password=NameArray[2];
			System.out.println(NameArray[1]);
			System.out.println(NameArray[2]);
			base obj = new base();
			WebDriver driver = obj.initialize();
			//driver=initialize();
			System.out.println("in read excel");
			obj.driver.get(obj.p.getProperty("url"));
			obj.driver.manage().window().maximize();
			
			LoginPage lp=new LoginPage(driver); 
			Thread.sleep(3000);
			lp.getemail().sendKeys(uname);
			Thread.sleep(3000);
			lp.getpassword().sendKeys(password);
			Thread.sleep(3000);
			lp.Login().click();
			
			Thread.sleep(3000);
			try
			{
				String actual=driver.findElement(By.xpath("//*[text()='Ok']")).getText();
				String expected="Ok";
				//String expetced= driver.findElement(By.xpath("//h2[text()='Invalid user name or password']")).getText();
				driver.findElement(By.xpath("//*[text()='Ok']")).click();
				Assert.assertEquals(actual, expected);
				driver.close();
			}
			catch(Exception e)
			  {
				String actual= driver.findElement(By.xpath("//h5[text()=' Dashboard ']")).getText();
				String Expected="Dashboard";
				Assert.assertEquals(actual, Expected);
				//System.out.println("ok.........");
			
			  }
	
		}
	}
}
