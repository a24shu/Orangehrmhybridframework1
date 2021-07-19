package com.demo.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Orangehrmtest {
	
	public  ExtentHtmlReporter htmlreporter;
	public ExtentReports report;
	public ExtentTest logger;
	
 public static	WebDriver driver;
 
	@BeforeTest

	public void setupextent()
	{
		File fs=new File("./Report/ashwini.html");
		
		htmlreporter =new ExtentHtmlReporter(fs);
		htmlreporter.config().setDocumentTitle("atuomtion report");
		htmlreporter.config().setReportName("functional name");
		htmlreporter.config().setTheme(Theme.DARK);
		
		report= new ExtentReports();
		report.attachReporter(htmlreporter);
		
		report.setSystemInfo("Hostname", "localhost");
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Testername","ashwini kande");
		report.setSystemInfo("Browser name","chrome");
		
	}
	@AfterTest
	public void endreport()
	{
		
		report.flush();
	}
	@BeforeMethod

	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
	
	}
	@Test
	public void verifytitletest()
	{
		logger=report.createTest("verifytitletest");
		String actualtitle=driver.getTitle();
		String expectedtitle="OrangeHRM";
		
		Assert.assertEquals(actualtitle, expectedtitle);
		
		
	}
	@Test
	public void verifylogotest() {
		logger=report.createTest("verifyylogotest");
		boolean status=driver.findElement(By.id("divLogo")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	
	public void terdown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,"status get fail"+result.getName());
			logger.log(Status.FAIL,"status get fail"+result.getThrowable());
			String screenshotpath =capturescreenshot(result.getName());
			logger.addScreenCaptureFromPath(screenshotpath);
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,"status is pass"+result.getName());
		
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP,"status is skipped"+result.getName());
 
		}
		driver.quit();
	}
	
	
	public  static String capturescreenshot(String screenshotname) throws IOException
	{
		 String dateformat =new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		String scrnpath="./screenshots/"+screenshotname+dateformat+".png";
		File desfile=new File(scrnpath);
		FileHandler.copy(srcfile, desfile);
		
		return scrnpath;
	}
}
