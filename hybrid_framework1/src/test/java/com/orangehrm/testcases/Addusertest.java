package com.orangehrm.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.pageobject.Adduserpage;
import com.orangehrm.pageobject.HomePage;
import com.orangehrm.pageobject.Loginpage;
import com.orangehrm.testbase.Testbase;

public class Addusertest extends Testbase
{

	@Test(dataProvider="getexceldata")
public void addnewusertest(String userrole,String empname,String username,String status,String password,String conpassword)

{
		Loginpage login=new Loginpage(driver);
	HomePage page=	login.loginhrm(XLSXdata.getcellstringdata("login", 0, 0), XLSXdata.getcellstringdata("login", 0, 1));

    Adduserpage adduser=page.navigatetoadduserpage();
    
    adduser.addnewuser(userrole, empname, username, status, password, conpassword);
}
	@DataProvider
	public Object[][] getexceldata()
	{
		Object[][] data=XLSXdata.exceltestdata("adduser");
		
		return data;
	}
	
	
} 
