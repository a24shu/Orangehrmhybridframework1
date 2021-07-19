package com.orangehrm.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

 public WebDriver driver;
 
 
 @FindBy(name="txtUsername")
 WebElement username;
 
 

 @FindBy(name="txtPassword")
 WebElement password;
 

 @FindBy(id="btnLogin")
 WebElement loginbutton;

public Loginpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements( driver,this);
}

public HomePage loginhrm(String uname,String upass) {
	 
	 //username.sendKeys("Admin");
	 //password.sendKeys("admin123");
//	 loginbutton.click();
	 
	 username.sendKeys(uname);
	 password.sendKeys(upass);
	 loginbutton.click();
	 
	return new HomePage(driver);
	 
	 
 }
	
}
