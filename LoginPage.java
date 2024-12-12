package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Open_Mrc.TnBaseClass;

public class LoginPage extends TnBaseClass{
	
	

	public WebDriver driver;
	
	@FindBy(id = "nav-link-accountList")
	private WebElement loginpg;
	
	@FindBy(xpath  = "//input[@type='email']")
	private WebElement Entermail;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continuebt;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement signin;

	@FindBy(xpath = "(//div[@class='a-alert-content'])[3]")
    private WebElement Emailinvalid;
	
	@FindBy(xpath = "(//div[@class='a-box-inner a-alert-container'])[1]")
    private WebElement passincorrect;
	
	@FindBy(xpath = "(//div[@class='a-alert-content'])[1]")
    private WebElement Emptymail;
	
	@FindBy(xpath = "(//div[@class='a-alert-content'])[3]")
    private WebElement Emptyppass;
	
	
	
    public LoginPage(WebDriver driver2) {
    	this.driver = driver2;
    	PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public boolean ValidLogin() {
    	
    	try {
	
    	launchUrl("https://www.amazon.in/");
    	clickButton(loginpg);
    	passInput(Entermail,"haripriyasri4214@gmail.com");
    	clickButton(continuebt); 
    	passInput(password,"1Jujutsukaisan@");
    	clickButton(signin);
    	driver.getTitle();
    	String title = driver.getTitle();
    	Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    	} catch (AssertionError e) {
	
		}
    	return false;
    	
    }
    
    public void InvalidEmailID() {
    	
    	launchUrl("https://www.amazon.in/");
    	clickButton(loginpg);
    	passInput(Entermail,"haripriyasri4214");
    	clickButton(continuebt);
     	passInput(password,"1Jujutsukaisan@");
    	clickButton(signin);
    	Assert.assertEquals(Emailinvalid.getText(), "your EMail is incorrect");
    }
    
    public void invalidPassword() {
    	
    	launchUrl("https://www.amazon.in/");
    	clickButton(loginpg);
    	passInput(Entermail,"haripriyasri4214@gmail.com");
    	clickButton(continuebt);
    	passInput(password,"1Jujutsun@");
    	clickButton(signin);
    	Assert.assertEquals(passincorrect.getText(), "your EMail is incorrect");
    }
    
    public void EmptyEmailID() {
    	
    	launchUrl("https://www.amazon.in/");
    	clickButton(loginpg);
    	passInput(Entermail,"");
    	clickButton(continuebt);
    	passInput(password,"1Jujutsukaisan@");
    	clickButton(signin);
    	Assert.assertEquals(Emptymail.getText(), "your EMail is incorrect");

    }
    
    public void EmptyPassError() {
    	
    	launchUrl("https://www.amazon.in/");
    	clickButton(loginpg);
    	passInput(Entermail,"");
    	clickButton(continuebt);
    	passInput(password,"1Jujutsukaisan@");
    	clickButton(signin);
    	Assert.assertEquals(Emptyppass.getText(), "your EMail is incorrect");
    	
    }
    
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void passInput(WebElement emailinvalid2, String string) {
		// TODO Auto-generated method stub
		
	}




















	private void clickButton(WebElement loginpg2) {
		// TODO Auto-generated method stub
		
	}




















	private void clickButton() {
		// TODO Auto-generated method stub
		
	}




















	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
