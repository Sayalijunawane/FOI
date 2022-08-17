package CommonFunctions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.base;

public class DateCOmmon extends base
{
	public void SelectDate(WebDriver driver,String day,List<WebElement> dates) throws InterruptedException
	{
		this.driver=driver;
		String[]day2=day.split("0");
		System.out.println("day is"+day2[1]);
		for(int i=0;i<dates.size();i++)
		{
			System.out.println("date is"+dates.get(i).getText());
			System.out.println("date before for loop"+day);
			if(dates.get(i).getText().contains(day2[1]))
			{
				System.out.println("date in for loop"+day);
				Thread.sleep(2000);
				//dates.get(i).click();
				 System.out.println("Before break"+dates.get(i).getText());
				 dates.get(i).click();
	              break;
	               
			}
			System.out.println("after loop"+dates.get(i).getText());
		}
	}
	
	public String selectMonth(int month)
	{
		
		String monthName = null;
		switch(month) 
		{
			case 1: monthName= "January";
			break;
			case 2:monthName= "February";
			break;
			case 3: monthName= "March";
			break;
			case 4: monthName= "April";
			break;
			case 5: monthName= "May";
			break;
			case 6: monthName= "June";
			break;
			case 7: monthName= "July";
			break;
			case 8: monthName= "August";
			break;
			case 9: monthName= "September";
			break;
			case 10: monthName= "October";
			break;
			case 11: monthName= "November";
			break;
			case 12: monthName= "December";
			break;
		}
		return monthName;
	}

}
