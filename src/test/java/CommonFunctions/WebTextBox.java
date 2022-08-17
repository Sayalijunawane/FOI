 package CommonFunctions;

import org.openqa.selenium.WebElement;

public class WebTextBox 
{
//for sendinput in text box
	public static void sendInput(WebElement textBox, String text)
	{
		if(WebElementCommon.isClickable(textBox)){
			textBox.sendKeys(text);
		}
	}
	
}
