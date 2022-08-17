package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctions.ReadExcel;
import jxl.Cell;
import jxl.read.biff.BiffException;
import pageObject.Surgeries;

public class Search extends base
{
	
	public void ReadDataFromExel(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		String excelpath= System.getProperty("user.dir")+"/Resources/LoginDetailofcompany.xls";
		System.out.println("chro path="+excelpath);
		ReadExcel read=new ReadExcel();
		read.ReadExcelFile(excelpath,2);
		
		String user1 = "";
		String value = null;
		
		System.out.println("rows are"+read.excel_row);
		System.out.println("col are"+read.excel_col);
		System.out.println("before for loop");
		for(int i=1;i< read.excel_row;i++)  //row
		{
			
			user1 = "";
			for(int j=0;j<read.excel_col;j++) //col
			{
				//System.out.println("j value"+j);
				Cell c=read.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				//user1=user1+" "+value;
			}
			user1=user1+" "+value;
			System.out.println("user1 value="+user1);
			//String searchValue1=user1.trim();
			String[] searchValue = user1.split(" ");
			//String test=searchValue[i];
			//System.out.println("test value"+test);
			//System.out.println("patient detail array"+Arrays.toString(searchValue));
			
			Surgeries s1=new Surgeries();
			Thread.sleep(1000);
			WebElement txtbox=s1.Selectsearch(driver);
			txtbox.sendKeys(searchValue);
			txtbox.sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			List<WebElement> data=driver.findElements(By.xpath("//tr[@class='p-element p-selectable-row ng-star-inserted']"));
			for(i=0;i<data.size();i++)
			{
				try
				{
						String newVal=data.get(i).getText();
						String expected="Marcel";
						System.out.println("new value is"+newVal);
			
						System.out.println("search value is"+user1);
						Thread.sleep(1000);
						if(newVal.contains(user1))
						{
							System.out.println("into assert conditions");
							Assert.assertEquals(user1,expected);
						}
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				 }
			}
			Thread.sleep(10000);
			txtbox.clear();
			
		}

	}
	
	public void FilterByStatus(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		System.out.println("into click");
		Surgeries s1=new Surgeries();
		s1.filterbyStatus(driver).click();
		//int a=driver.findElements(By.xpath("//p-multiselect[@optionlabel='name']//following-sibling::div[contains(@class,'overlayAnimation')]")).size();
		
		//list of checkboxes
		List<WebElement>checkbox=driver.findElements(By.xpath("//div[@class='p-checkbox-box']"));
		
		
		//path to value
		List<WebElement>status=driver.findElements(By.xpath("//span[@class='ng-star-inserted']//ancestor :: p-multiselectitem/li/span"));
	
		
		String excelpath= System.getProperty("user.dir")+"/Resources/SearchCrietria.xls";
		System.out.println("chro path="+excelpath);
		ReadExcel read=new ReadExcel();
		read.ReadExcelFile(excelpath,3);
		
		
		//ReadExcel read=new ReadExcel();
		//read.ReadExcelFile("C:\\Users\\SayaliJunawane\\Desktop\\LoginDetailofcompany.xls",3);
		
		String user1 = "";
		String value = null;
		
		System.out.println("rows are"+read.excel_row);
		System.out.println("col are"+read.excel_col);
		System.out.println("before for loop");
		for(int i=1;i< read.excel_row;i++)  //row
		{
			
			user1 = "";
			for(int j=0;j<read.excel_col;j++) //col
			{
				//System.out.println("j value"+j);
				Cell c=read.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				//user1=user1+" "+value;
			}
			user1=user1+" "+value;
			System.out.println("user1 value="+user1);
			String searchValue1=user1.trim();
			//String[] searchcriteria= searchValue1.split(",");
			//System.out.println(" searchcriteria value="+searchcriteria);
			for( int p=0;p<status.size();p++)
			{
				System.out.println("text="+status.get(p).getText());
				Thread.sleep(4000);
				if(status.get(p).getText().contains(searchValue1))
				{
					System.out.println("i value is="+status.get(p).getText());
					
					status.get(p).click();
					   break;
				}	
			}
			
			List<WebElement> data=driver.findElements(By.xpath("//tr[@class='p-element p-selectable-row ng-star-inserted']"));
			for(int q=0;q<data.size();q++)
			{
				try
				{
						String newVal=data.get(q).getText();
						String expected=" Submitted";
						System.out.println("new value is"+newVal);
			
						//System.out.println("search value is"+user1);
						Thread.sleep(1000);
						if(newVal.contains(user1))
						{
							System.out.println("into assert conditions");
							Assert.assertEquals(user1,expected);
						}
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				 }
			}
			
			
		}
			
		
			
	
		
	
	}
	

	
	
	//Move to unapproved surgery billa
	
	/*public void clickonUnapprovedSurgeryBille(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		Surgeries s=new Surgeries();
		s.ClickonUnapprovedTab(driver).click();
		
		//WebElement Search=driver.findElement(By.xpath("//span[@class='p-input-icon-right d-block']//following-sibling::input"));
		ReadDataFromExel(driver);
	}
	
	public void clickonUnbilledPerctRecords(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		Surgeries s=new Surgeries();
		s.ClickonUnbilledTab(driver).click();
		
		//WebElement Search=driver.findElement(By.xpath("//span[@class='p-input-icon-right d-block']//following-sibling::input"));
		ReadDataFromExel(driver);
	}
	
	public void clickonCancelled(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		Surgeries s=new Surgeries();
		s.ClickonCancelledTab(driver).click();
		
		//WebElement Search=driver.findElement(By.xpath("//span[@class='p-input-icon-right d-block']//following-sibling::input"));
		ReadDataFromExel(driver);
	}
	
	public void willCall(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		Surgeries s=new Surgeries();
		s.ClickonWillcall(driver).click();
		
		//WebElement Search=driver.findElement(By.xpath("//span[@class='p-input-icon-right d-block']//following-sibling::input"));
		ReadDataFromExel(driver);
	}
	
	
	*/
	
	
	public void FilterbyDate(WebDriver driver) throws InterruptedException
	{
		String MonthyearValueFrom;
		Surgeries s=new Surgeries();
		s.FilterbyDate(driver).click();
		//if today selected 
		
		driver.findElement(By.cssSelector(".available.ng-star-inserted.today.active.end-date.start-date")).click();
		System.out.println("today date selected");
		
	
	
	
	}		
}	