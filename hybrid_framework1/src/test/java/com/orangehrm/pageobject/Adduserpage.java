package com.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utilities.Helper;

public class Adduserpage {
	@FindBy(id="btnAdd")
	@CacheLookup
	WebElement btnAdd;

	@FindBy(id="systemUser_userType")
	@CacheLookup
	WebElement systemuserdd;

	@FindBy(id="systemUser_employeeName_empName")
	@CacheLookup
	WebElement Empname;

	@FindBy(id="systemUser_userName")
	@CacheLookup
	WebElement Username;

	@FindBy(id="systemUser_status")
	@CacheLookup
	WebElement status;
	

	@FindBy(id="systemUser_password")
	@CacheLookup
	WebElement Password;
	

	@FindBy(id="systemUser_confirmPassword")
	@CacheLookup
	WebElement conpass;
	
	@FindBy(id="btnSave")
	@CacheLookup
	WebElement save;

	public  WebDriver driver;
	
	public Adduserpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
}
	
	public void addnewuser(String selectrole,String empname
,String username,String status,String password,String conpassword
)
	{
		try
		{
		btnAdd.click();
		Helper.selectdropdownvalue(systemuserdd,selectrole);
		Empname.sendKeys(empname);
		Username.sendKeys(username);
		Helper.selectdropdownvalue(systemuserdd, status);
		Password.sendKeys(password);
		conpass.sendKeys(conpassword);
		save.click();
		
	}
		catch(Exception e)
		{
			
		}
}
}