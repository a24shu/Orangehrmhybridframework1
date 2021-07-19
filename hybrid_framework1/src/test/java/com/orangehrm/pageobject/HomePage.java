package com.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(id="menu_admin_viewAdminModule")
	@CacheLookup
	WebElement admin;

	@FindBy(id="menu_admin_UserManagement")
	@CacheLookup
	WebElement UserManagement;

	@FindBy(id="menu_admin_viewSystemUsers")
	@CacheLookup
	WebElement user;

	

	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	public Adduserpage navigatetoadduserpage()
	{
		Actions action= new Actions(driver);
				
	action.moveToElement(admin).moveToElement(UserManagement).moveToElement(user).click().build().perform();
		
		return new Adduserpage(driver);
	
		
	}
}
