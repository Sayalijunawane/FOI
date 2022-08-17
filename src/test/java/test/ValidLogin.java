package test;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObject.LoginPage;

public class ValidLogin extends base {
	@Test
	public void testLogin(WebDriver driver,int caseNumber) throws IOException, BiffException, InterruptedException
	{
		
		String excelpath= System.getProperty("user.dir")+"/Resources/LoginDetailofcompany.xls";
		System.out.println("chro path="+excelpath);
		
		//driver=initialize();
		FileInputStream fis=new FileInputStream(excelpath);
		
		//FileInputStream fis=new FileInputStream("C:\\Users\\SonaliPujari\\CommonFiles\\LoginDetails1.xls");
		//workbook>>sheets>>cells>>content
		Workbook workbook=Workbook.getWorkbook(fis);
		Sheet sheet=workbook.getSheet(0);
	
		int row=sheet.getRows();
		int col=sheet.getColumns();
	
		String user1 = "";
		String value = null;
		for(int i=1;i<row;i++)  //row
		{
			user1 = "";
			for(int j=0;j<col;j++) //col
			{
				
				Cell c=sheet.getCell(j,i);	
				value=c.getContents();
				user1=user1+" "+value;
				
			}
		
			System.out.println(user1.trim());
			String[] NameArray = user1.split(" ");
			String uname=NameArray[1];
			String password=NameArray[2];
			System.out.println(NameArray[1]);
			System.out.println(NameArray[2]);
			if (driver == null)
			{
			driver=initialize();
			
			driver.get(p.getProperty("url"));
			driver.manage().window().maximize();
			
			}
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
				//If credentials are invalid then find the invalid credential message and click ok
				driver.findElement(By.xpath("//*[text()='Ok']")).click();
				driver.close();
			}
			catch(Exception e)
			  {
				//If credentials are valid then follow the valid credential flow
				switch(caseNumber) {
				
				case 1:
					VerifySurgeries v=new VerifySurgeries();
					v.ClickonSurgeriesLink(driver);
					
					Search s = new Search();
					s.ReadDataFromExel(driver);
					s.FilterByStatus(driver);
					//s.FilterbyDate(driver);
					//s.clickonUnapprovedSurgeryBille(driver);
					//s.clickonUnbilledPerctRecords(driver);
					break;
				case 2:
					VerifyPatients p=new VerifyPatients();
					p.ClickonSurgeriesLink(driver);
					p.search(driver);
					
				default:
				}

				
				
			  }
	
		}
			
	

	}
}
