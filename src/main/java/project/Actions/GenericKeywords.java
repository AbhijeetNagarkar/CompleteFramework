package project.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import project.Mediator.DriverRepository;

public class GenericKeywords {

	static AndroidDriver driver = DriverRepository.GetAndroidDriver();

	public static void EnterNumber(String number)
	{
		for (int i = 0; i < number.length(); i++) {
			
			switch (number.charAt(i))
			{
				case '0':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
							break;
				case '1':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
							break;
				case '2':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
							break;
				case '3':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
							break;
				case '4':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
							break;
				case '5':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
							break;
				case '6':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
							break;
				case '7':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
							break;
				case '8':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
							break;
				case '9':driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
							break;
							
				default:break;
			}
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public static void Click(WebElement ele)
	{
		ele.click();
	}
	public static void Click(By ele)
	{
		driver.findElement(ele).click();
	}
	
	
	public static void EnterText(WebElement ele,String text)
	{
		ele.sendKeys(text);
	}
	public static void EnterText(By ele,String text)
	{
		driver.findElement(ele).sendKeys(text);
	}
	
	public static void Back()
	{
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	public static void Home()
	{
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
}
