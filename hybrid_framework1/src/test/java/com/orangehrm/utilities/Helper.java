package com.orangehrm.utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Helper {

	public static void selectdropdownvalue(WebElement ele,String visiabletext)
	{
		new Select(ele).selectByVisibleText(visiabletext);;
	}
	
	public static void selectdropdownvalue(WebElement ele,int index)
	{
		new Select(ele).selectByIndex(index);
	}
	
	public static void selectdropdownvalue(String value,WebElement ele)
	{
		new Select(ele).selectByValue(value);
	}
	
	public static String customdate()
	{
	 String dateformat =new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	 
	 return dateformat;
	}
	
	public  static String capturescreenshot(String screenshotname,WebDriver driver) throws IOException
	{
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		String scrnpath=System.getProperty("user.dir")+"./screenshots/"+screenshotname+ customdate()+".png";
		File desfile=new File(scrnpath);
		FileHandler.copy(srcfile, desfile);
		
		return scrnpath;
	}
}
