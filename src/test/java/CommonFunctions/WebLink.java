package CommonFunctions;

import org.openqa.selenium.WebElement;

public class WebLink 
{
	public void clickLink(WebElement link)
	{
		if(WebElementCommon.isClickable(link))
		{
			link.click();
		}
	}

}
