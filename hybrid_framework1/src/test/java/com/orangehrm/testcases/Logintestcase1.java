package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pageobject.Loginpage;
import com.orangehrm.testbase.Testbase;
public class Logintestcase1 extends Testbase

{
@Test
	
	public void logincase()
	{
	Loginpage login	=new Loginpage(driver);
	
	//login.loginhrm(configdata.getusername(),configdata.getpassword());
test=report.createTest("login orangehrm test");
	test.info("navigated to login page");
	login.loginhrm(XLSXdata.getcellstringdata("login", 0, 0), XLSXdata.getcellstringdata("login", 0, 1));
	
	test.info("enter valid username and pass and click on login button");
	
	String actualtitle=driver.getTitle();
	String expectedtitle="";
	
if(actualtitle.equals(expectedtitle))
{	
	Assert.assertTrue(true);
	test.pass("lgin page title is verified");

	
}
	else
	{
		test.fail("login page title not match");
		Assert.assertTrue(false);

		
	
	}

	

}
}