package pages;

import base.TestBase;
import com.aventstack.extentreports.MediaEntityBuilder;

import constants.GlobalConstants;

import driverManager.DriverManager;
import extentManager.ExtentReport;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class LoginPage {

    TestBase base;
    GlobalConstants globalConstantsants;
    public LoginObjects loginObjects;

    public LoginPage()
    {
        base = new TestBase();
        globalConstantsants = new GlobalConstants();
        loginObjects = new LoginObjects();
        PageFactory.initElements(DriverManager.getDriver(),loginObjects);
    }

    
	public void launchapplixation() {
		
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		DriverManager.getDriver().get(globalConstantsants.appURL);
		base.waitvisibility(DriverManager.getDriver(), loginObjects.medicarelogo);
		DriverManager.getDriver().manage().window().maximize();
		 ExtentReport.getTest().pass("User launch the URL.",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
		
	}
	
	public void validatelogo() {
		
		base.waitvisibility(DriverManager.getDriver(), loginObjects.medicarelogo);
		Assert.assertTrue(loginObjects.medicarelogo.isDisplayed());
		
	}
	
	public void clickonlogin() {
		
		base.waitvisibility(DriverManager.getDriver(), loginObjects.loginclcik);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 ExtentReport.getTest().pass("Click on login.",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
		loginObjects.loginclcik.click();
	}
	
	public void setusername(String user,String pass) {
		
		base.waitvisibility(DriverManager.getDriver(), loginObjects.username);
		loginObjects.username.sendKeys(user);
		loginObjects.password.sendKeys(pass);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 ExtentReport.getTest().pass("Enter the user and password",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
	}
	
	public void login() {
		
		 ExtentReport.getTest().pass("Click on login button",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
		base.waitvisibility(DriverManager.getDriver(), loginObjects.loginbutton);
		loginObjects.loginbutton.click();
		
	//	Alert al = DriverManager.getDriver().switchTo().alert();
	//	al.accept();
		
	}
	
	public void Validateafterlogin() {
		
		String expected = DriverManager.getDriver().getTitle();
		String actual = "Medicare - Home";
		
		base.waitfortitle(DriverManager.getDriver(), "Medicare - Home");
		Assert.assertEquals(expected,actual );
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 ExtentReport.getTest().pass("Logged into application",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
		 
		
	}
	
	public void logout() {
		base.waitvisibility(DriverManager.getDriver(), loginObjects.clickclicknamelogo);
		loginObjects.clickclicknamelogo.click();
		loginObjects.clicklogout.click();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		ExtentReport.getTest().pass("Logged out of the application",MediaEntityBuilder.createScreenCaptureFromBase64String(base.getBase64()).build());
		
	}
}

class LoginObjects{
	

	 @FindBy(xpath ="//table[@id='productListTable']//td[2]")
	 List<WebElement> MoreProducts;
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement medicarelogo;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginclcik;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement loginbutton;
	
	@FindBy(xpath ="//a[@id='dropdownMenu1']")
	WebElement clickclicknamelogo;
	
	@FindBy(xpath ="//a[text()='Logout']")
	WebElement clicklogout;
	
	
}
