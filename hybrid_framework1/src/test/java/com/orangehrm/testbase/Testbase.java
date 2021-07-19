package com.orangehrm.testbase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.utilities.ConfigDataProvider;
import com.orangehrm.utilities.Helper;
import com.orangehrm.utilities.XLSXDataProvider;


 public class Testbase {
	 
	public static  WebDriver driver=null;
	public ConfigDataProvider configdata;
	public XLSXDataProvider XLSXdata;
	
	
	public  ExtentHtmlReporter htmlreporter;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeSuite
	public void setupsuite()
	{
		configdata = new ConfigDataProvider();
		XLSXdata = new XLSXDataProvider();
	}
	@BeforeTest
	public void setupextent()
	{
	File fs=new File("./Report/ashwini" +Helper.customdate()+" .html");
		
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
	
 @Parameters("browsername")
	 @BeforeMethod
	public void setup(@Optional("chrome")String browsername)
	{
	 if(browsername.equals("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		 driver=new ChromeDriver();
		 
	 }
	 
	 else if (browsername.equals("Firefox"))
	 {
		 System.setProperty("webdriver.geko.driver", "./Driver/gekodriver.exe");
		 driver=new FirefoxDriver(); 
		 
	 }
	 
	 
	 else if (browsername.equals("IE"))
	 {
		 System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
		 driver=new InternetExplorerDriver(); 
		 
	 }
	//	 driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 
	 
	 driver.get(configdata.geturl());
 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
 @AfterMethod
 public void terdown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"status get fail" + result.getName());
			test.log(Status.FAIL,"status get fail" + result.getThrowable());
			String screenshotpath =Helper.capturescreenshot(result.getName(),driver);
			
			
			test.addScreenCaptureFromPath(screenshotpath);
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"status is pass" + result.getName());
		
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP,"status is skipped"+result.getName());

		}
		driver.quit();
	}
}
