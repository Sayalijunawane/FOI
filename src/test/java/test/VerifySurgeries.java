package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import CommonFunctions.DateCOmmon;
import CommonFunctions.ReadExcel;
import CommonFunctions.WebButton;
import CommonFunctions.WebLink;
import CommonFunctions.WebTextBox;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import jxl.Cell;
import jxl.read.biff.BiffException;
import pageObject.Surgeries;

public class VerifySurgeries extends ReadExcel
{
	
	String serviceoption;
	WebDriver driver;
	String[] PatientDetails;
	//click on surgeries left navigation menu
	public void ClickonSurgeriesLink(WebDriver driver)
	{
		this.driver=driver;
		Surgeries s=new Surgeries();
		WebElement link=s.ClickonSurgeries(driver);
		WebLink w=new WebLink();
		w.clickLink(link);
		
	}
	
	public void ClickOnAddSurgery(WebDriver driver)
	{
		this.driver=driver;
		Surgeries s=new Surgeries();
		WebElement add=s.ClickOnAddNewSurgery(driver);
		WebButton b=new WebButton();
		b.click(add);
	}
	
	public void ClickAddNewPatient(WebDriver driver)
	{
		Surgeries s=new Surgeries();
		WebElement addPatient=s.AddNewPatient(driver);
		WebButton b=new WebButton();
		b.click(addPatient);
	}
	
	public String addMRNNumber(WebDriver driver) throws InterruptedException, BiffException, IOException
	{
		this.driver=driver;
		//Surgeries s=new Surgeries();
		//Thread.sleep(1000);
		//WebElement addPatient=s.AddMRNNumber(driver);
		//addPatient.sendKeys("12345");
		/*WebTextBox mrnnumber=new WebTextBox();
		mrnnumber.sendInput(addPatient, "1234");*/

		String excelpath= System.getProperty("user.dir")+"/Resources/LoginDetailofcompany.xls";
		System.out.println("chro path="+excelpath);
		
		//driver=initialize();
		
		
		
		ReadExcel readexcel=new ReadExcel();
		readexcel.ReadExcelFile(excelpath,1);
		String user1 = "";
		String value = null;
		System.out.println("rows are"+readexcel.excel_row);
		System.out.println("col are"+readexcel.excel_col);
		System.out.println("before for loop");
		for(int i=1;i< readexcel.excel_row;i++)  //row
		{
			System.out.println("I value"+i);
			user1 = "";
			for(int j=0;j<readexcel.excel_col;j++) //col
			{
				System.out.println("j value"+j);
				Cell c=readexcel.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				user1=user1+" "+value;
			}
			String[] PatientDetails = user1.split(" ");
			System.out.println("patient detail array"+Arrays.toString(PatientDetails));
			String MRN_Number=PatientDetails[1];
			String FName=PatientDetails[2];
			String Lname=PatientDetails[3];
		
			String DOB=PatientDetails[4];
			String serviceop=PatientDetails[5];
			String stay_classification=PatientDetails[6];
			serviceoption=serviceop;
			
			System.out.println("service op value"+serviceoption);
			System.out.println("after for loop");	
			System.out.println("Tenancy Name="+PatientDetails[1]);
			System.out.println(PatientDetails[2]);
			System.out.println(PatientDetails[3]);
			System.out.println(PatientDetails[4]);
			System.out.println(PatientDetails[5]);
			System.out.println(PatientDetails[6]);
			//driver=initialize();
			
			Surgeries s1=new Surgeries();
			Thread.sleep(1000);
			s1.AddMRNNumber(driver).sendKeys(MRN_Number);
			s1.fname(driver).sendKeys(FName);
			s1.lname(driver).sendKeys(Lname);
			
			
		}
		
		return serviceoption;
			
	}
	
	public void dob(WebDriver driver) throws InterruptedException, BiffException, IOException
	{
		this.driver=driver;
		int i;
		String day = null,month = null,year;
		ReadExcel readexcel=new ReadExcel();
		readexcel.ReadExcelFile("C:\\Users\\SayaliJunawane\\Desktop\\LoginDetailofcompany.xls",1);
		String user1 = "";
		String value = null;
		System.out.println("rows are"+readexcel.excel_row);
		System.out.println("col are"+readexcel.excel_col);
		System.out.println("before for loop");
		for( i=1;i< readexcel.excel_row;i++)  //row
		{
			System.out.println("I value"+i);
			user1 = "";
			for(int j=0;j<readexcel.excel_col;j++) //col
			{
				System.out.println("j value"+j);
				Cell c=readexcel.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				user1=user1+" "+value;
			}
			String[] PatientDetails = user1.split(" ");
			System.out.println("patient detail array in dob"+Arrays.toString(PatientDetails));
			String date=PatientDetails[4];
			String[]date1=date.split("/");
			System.out.println("date is="+Arrays.toString(date1));
			day=date1[0];
			month=date1[1];
			year=date1[2];
			System.out.println("Day is"+date1[0]);
			System.out.println("month is"+date1[1]);
			System.out.println("year is"+date1[2]);	
	}
		
		Surgeries s1=new Surgeries();
		s1.PatientDob(driver).click();
		
		
		String[] mon=month.split("0");
		String monthvalue=mon[1];
		
		
		//public static int parseInt(String s);
				int m=Integer.parseInt(monthvalue);  
				
				//int m=month;
				DateCOmmon d= new DateCOmmon();
				String MonName=d.selectMonth(m);
		
		//WebElement dob=s1.SelectMonthofDob(driver);
		//to select month
		while(!driver.findElement(By.xpath("//div[@class='bs-datepicker-head']//button[@class='current ng-star-inserted']")).getText().contains(MonName))
		{
			driver.findElement(By.xpath("//div[@class='bs-datepicker-head']//button[@class='previous']")).click();
		}
		
		
		
		//to select date
		List<WebElement> dates=driver.findElements(By.xpath("//bs-datepicker-container[@aria-label='calendar']//td[@role='gridcell']"));
		int count=driver.findElements(By.xpath("//bs-datepicker-container[@aria-label='calendar']//td[@role='gridcell']")).size();
		System.out.println("count of date is"+count);
		
		d.SelectDate(driver, day, dates);
		
		
	}
	
	public void SelectService(WebDriver driver) throws InterruptedException, BiffException, IOException
	{
		
		//System.out.println("adding data again");
		//String demo=addMRNNumber(driver);
		//String serviceop=PatientDetails[5];
		//System.out.println("demo is"+demo);
		
	
		
		WebElement service=driver.findElement(By.xpath("//span[(text()='Select Service')]"));
		service.click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//p-dropdown[@name='service']/div/div/div/ul/p-dropdownitem"));
		
		Thread.sleep(2000);
		
		for(int i=0;i<allOptions.size();i++)
		{
			System.out.println(allOptions.get(i).getText());
			
			if(allOptions.get(i).getText().equalsIgnoreCase("Spine"))
			{
				Thread.sleep(5000);
				 allOptions.get(i).click();
				 System.out.println("Before break"+allOptions.get(i).getText());
					
	                break;
			}
			System.out.println("after loop"+allOptions.get(i).getText());
		}
	}
	public void Select_StayClassification(WebDriver driver) throws InterruptedException, BiffException, IOException
	{
		this.driver=driver;
		ReadExcel readexcel=new ReadExcel();
		readexcel.ReadExcelFile("C:\\Users\\SayaliJunawane\\Desktop\\LoginDetailofcompany.xls",1);
		String user1 = "";
		String value = null;
		String stay_classificationfromexcel = null;
		
		for(int i=1;i< readexcel.excel_row;i++)  //row
		{
			System.out.println("I value"+i);
			user1 = "";
			for(int j=0;j<readexcel.excel_col;j++) //col
			{
				System.out.println("j value"+j);
				Cell c=readexcel.excel_Sheet.getCell(j,i);	
				value=c.getContents();
				user1=user1+" "+value;
			}
			String[] PatientDetails = user1.split(" ");
			
			stay_classificationfromexcel=PatientDetails[6];
			
		}
		
		WebElement stayClassifications=	driver.findElement(By.xpath("//p-dropdown[@name='stayClassification']/div/span"));
		stayClassifications.click();
		
		////p-dropdown[@name='stayClassification']/div/div/div
		List<WebElement> allOptions1 = driver.findElements(By.xpath("//p-dropdown[@name='stayClassification']/div/div/div/ul/p-dropdownitem"));
		
		for( int i = 0; i<=allOptions1.size()-1; i++) 
		{
			
            if(allOptions1.get(i).getText().equalsIgnoreCase(stay_classificationfromexcel)) 
            {
                allOptions1.get(i).click();
                break;

            }
	

		}
	}
	
	public void Select_HospitalName(WebDriver driver) throws InterruptedException
	{
		WebElement Hname=driver.findElement(By.xpath("//span[(text()='Select Hospital')]"));
		Hname.click();
		Thread.sleep(2000);
		List<WebElement> allOptions2=driver.findElements(By.xpath("//p-dropdown[@id='hospitalName']/div/div[3]/div/ul/p-dropdownitem"));
		for(int i = 0; i<=allOptions2.size()-1; i++) 
		{
            if(allOptions2.get(i).getText().equalsIgnoreCase("rtyr")) 
            {
                allOptions2.get(i).click();
                break;
             }
         }
	}
	
	public void Select_surgeon (WebDriver driver) throws InterruptedException
	{
		WebElement suregonProvider=driver.findElement(By.xpath("//p-dropdown[@name='primarySurgeonId']"));
		suregonProvider.click();	
		List<WebElement> allOptions3=driver.findElements(By.xpath("//p-dropdown[@name='primarySurgeonId']//following::div/ul[@role='listbox']"));
		
		for(int i = 0; i<=allOptions3.size()-1; i++) 
		{
            if(allOptions3.get(i).getText().contains("Rohit Pingale")) 
            {
                allOptions3.get(i).click();
                break;

            }
	

		}
		
	}
	
	public void Select_MotorAccident(WebDriver driver) throws InterruptedException
	{
		int a = driver.findElements(By.xpath("//input [@name='vehicle']")).size();  
		System.out.println("vehical raido button"+a);  
     		for( int i=1;i<=a;i++)  
     		{  
     			driver.findElements(By.xpath("//input[@name='vehicle']")).get(1).click();  
     		} 
	}
	
	public void Select_PatientTranster(WebDriver driver) throws InterruptedException
	{	Thread.sleep(1000);
		int b=  driver.findElements(By.xpath("//input[@name='transter']")).size();
     	System.out.println("patient transter"+b);  
     		for(int i=1;i<=b;i++)  
     		{  
     			driver.findElements(By.xpath("//input[@name='transfer']")).get(1).click();  
     		} 
    		Thread.sleep(5000);
	}
	
	public void Click_Create(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).click();
	}
	
	public void Select_AssSurgeon(WebDriver driver) throws InterruptedException
	{
		WebElement asssergon=driver.findElement(By.xpath("//*[text()='Select Asst. Surgeon']"));
 		asssergon.click();
 		List <WebElement>AssSurgeon=driver.findElements(By.xpath("//p-dropdown[@id='assistantSurgeonId']//div/div[3]/div/ul/p-dropdownitem"));
 		//Sidheshwar Bagate
 		
 		for( int i = 0; i<=AssSurgeon.size()-1; i++) 
		{
			
            if(AssSurgeon.get(i).getText().equalsIgnoreCase("Sidheshwar Bagate")) 
            {
            	AssSurgeon.get(i).click();
                break;

            }
	

		}
 		
	}
	
	public void Select_MidLevelAssistant(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text()='Select MidLevel Asst. Surgeon']")).click();
 		List<WebElement> MidSuregon=driver.findElements(By.xpath("//p-dropdown[@id='midLevelAssistantId']/div/div[3]/div/ul/p-dropdownitem"));
 		
 		for(int i = 0; i<=MidSuregon.size()-1; i++) 
		{
			
            if(MidSuregon.get(i).getText().equalsIgnoreCase("Sidheshwar Bagate")) 
            {
            	MidSuregon.get(i).click();
                break;

            }
	

		}
 		
	}
	
	public void Select_CoSurgen(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
 		driver.findElement(By.xpath("//p-dropdown[@id='coSurgeonId']//div/div[2]")).click();
 		
 		List<WebElement> cosurgen=driver.findElements(By.xpath("//p-dropdown[@id='coSurgeonId']/div/div[3]/div/ul/p-dropdownitem"));
 		
 		for(int i = 0; i<=cosurgen.size()-1; i++) 
		{
			
            if(cosurgen.get(i).getText().equalsIgnoreCase("Gopinath Dongre Patil")) 
            {
            	cosurgen.get(i).click();
                break;

            }
	

		}
 		
	}
	
	
	public void Select_ServiceDate(WebDriver driver) throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//input[@id='ServiceDatePicker']")).click();
		
		//to select month
		while(!driver.findElement(By.xpath("//div[@class='bs-datepicker-head']//button[@class='current ng-star-inserted']")).getText().contains("May"))
		{
			driver.findElement(By.xpath("//div[@class='bs-datepicker-head']//button[@class='previous']")).click();
		}
		
		//to select date
		List<WebElement> serviceDates=driver.findElements(By.xpath("//bs-datepicker-container[@aria-label='calendar']//td[@role='gridcell']"));
		//int count=driver.findElements(By.xpath("//bs-datepicker-container[@aria-label='calendar']//td[@role='gridcell']")).size();
		//System.out.println("count of date is"+count);
		
		
		for( int i=0;i<serviceDates.size();i++)
		{
			System.out.println(serviceDates.get(i).getText());
			
			if(serviceDates.get(i).getText().equalsIgnoreCase("14"))
			{
				Thread.sleep(2000);
				//dates.get(i).click();
				 System.out.println("Before break"+serviceDates.get(i).getText());
				 serviceDates.get(i).click();
	              break;
	                
				//driver.findElement(By.xpath("//span[text()='"+allOptions.get(i).getText().trim()+"']")).click();
				//allOptions.get(i).click();
			}
			System.out.println("after loop"+serviceDates.get(i).getText());
		}
	}
	
	public void Click_Next(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
 		
		//click on next
		driver.findElement(By.xpath("//button[text()=' Next ']")).click();
	}
	
	public void Search_CPTcode(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@placeholder='Search CPT 10 Code or Keywords..']")).sendKeys("11044");
	}
	
	public void Click_add(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='addBtn']")).click();
	}
	public void Add_BoneSqCm(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='debridementSqcm']")).sendKeys("4");
		
		
	}
	
	public void Click_Save(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text()='Save']")).click();
	}
	
	public void Edit_Billing(WebDriver driver) throws InterruptedException
	{
		List<WebElement> Editlist1=driver.findElements(By.xpath("//p-table[@selectionmode='single']//following-sibling::div/table/tbody/tr/td[15]/i[1]"));
		for(int i=0;i<Editlist1.size();i++)
		{
			Editlist1.get(i).click();
			System.out.println("clicked for edit");
			
		}
	}
	
	public void Edit_side(WebDriver driver) throws InterruptedException
	{
		Select s=new Select(driver.findElement(By.xpath("//select[@name='side']")));
		s.selectByIndex(1);
	}
	
	public void ICD10_codes(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//p-table[@selectionmode='single']/div/div/table/tbody/tr/td[8]/div/i")).click();
		System.out.println("clicked on icd");
		
		List<WebElement> chkboxlist=driver.findElements(By.xpath("//div[starts-with(@class,'ng-trigger ng-trigger-animation')]/div/div/div[2]/div/div/div/div/p-checkbox"));
		int size=chkboxlist.size();
		System.out.println("size of checkbox is"+size);
		
		
		for(int i=0;i<size;i++)
		{
			chkboxlist.get(i).click();
			System.out.println("checkbox clicked");
			
		}
		
		
	}
	
	public void Click_saveafterEdit(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//p-table[@selectionmode='single']/div/div/table/tbody/tr/td[15]/i[1]")).click();
	}
	//on billing page
	public void Click_next1(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()=' Next ']")).click();
	}
	//surgical next
	public void Click_Changesnext(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()=' Next ']")).click();
	}
	//Summary next
	
	public void Click_summarynext(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()=' Next ']")).click();
	}
	
	//approve on chnages page
	public void Click_Approve(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Approve']")).click();
	}
	
	public void Click_Yesapprove(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text()='Yes']")).click();
	}
		
	public void Click_Submit(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text()=' Submit ']")).click();
	}
		
	public void Click_YesSubmit(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[text()='Yes']")).click();
	}
	
	
	public void SurgeriesMethod(WebDriver driver) throws BiffException, InterruptedException, IOException
	{
		//VerifySurgeries AddSurgerie=new VerifySurgeries();
		ClickonSurgeriesLink(driver);
		ClickOnAddSurgery(driver);
		ClickAddNewPatient(driver);
		
		addMRNNumber(driver);
		dob(driver);
		SelectService(driver);
		Select_StayClassification(driver);
		Select_HospitalName(driver);
		Select_surgeon(driver);
		Select_MotorAccident(driver);
		Select_PatientTranster(driver);
		Click_Create(driver);
		Select_AssSurgeon(driver);
		Select_MidLevelAssistant(driver);
		Select_CoSurgen(driver);
		Select_ServiceDate(driver);
		Click_Next(driver);
		Search_CPTcode(driver);
		Click_add(driver);
		Add_BoneSqCm(driver);
		Click_Save(driver);
		Edit_Billing(driver);
		Edit_side(driver);
		ICD10_codes(driver);
		Click_saveafterEdit(driver);
		Click_next1(driver);
		Click_Changesnext(driver);
		Click_summarynext(driver);
		Click_Approve(driver);
		Click_Yesapprove(driver);
		Click_Submit(driver);
		 Click_YesSubmit(driver);
	}
	
	
		
		
	
}