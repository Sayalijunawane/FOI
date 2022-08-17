package CommonFunctions;

import org.openqa.selenium.WebElement;

public class WebElementCommon {

	/*
	 * This function is to check/verify element is present in DOM
	 * param : WebElement
	 * retrun : boolean
	 */
	public static boolean ispresent(WebElement ele)
	{
		boolean isPresent=false;
		if(ele.isDisplayed())
		{
			isPresent=true;
			System.out.println("ele present");
		}
		return isPresent;
		
	}
	
	/*
	 * This function is to check eather it is clickable or not
	 */
	public static boolean isClickable(WebElement ele)
	{
		boolean isClick=false;
		if(ispresent(ele))
		{
			if(ele.isEnabled())
			{
				isClick=true;;
				System.out.println("ele is clickable");
			}
		}
		return isClick;
	}

}
