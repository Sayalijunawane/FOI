package CommonFunctions;

import org.openqa.selenium.WebElement;

public class WebButton {

	public static void click(WebElement ele)
	{
		if(WebElementCommon.isClickable(ele))
		{
			ele.click();
		}
	}

}
