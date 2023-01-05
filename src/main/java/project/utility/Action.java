package project.utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import project.mediator.Driver;

public class Action {

	static Actions act = new Actions(Driver.GetDriver());

	public static void Tab()
	{
		act.keyDown(Keys.LEFT_CONTROL);
		act.keyDown(Keys.TAB);
	//	act.keyUp(Keys.TAB);
		act.keyUp(Keys.LEFT_CONTROL);

	}
	public static void CloseTab()
	{
		Driver.GetDriver().close();
	}
	public static void Escape()
	{
		
		act.keyDown(Keys.ESCAPE);
		act.keyUp(Keys.ESCAPE);
		act.perform();
	}
}
