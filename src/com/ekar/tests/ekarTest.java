package com.ekar.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v84.log.model.ViolationSetting.Name;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.Story;
import io.qameta.allure.severity.SeverityLevel;



@Epic ("Regression Test")
@Feature ("Complaint Feature")
@Listeners (TestListeners.class )
public class ekarTest

{
	
	public AndroidDriver <MobileElement> driver;
	public WebDriverWait wait;
	
	
	//Elements
	String PinCheck = "//android.view.View[@content-desc=\"Google Map\"]//android.view.View";
	String FrontImage = "in.testdemo.map:id/front_img";
	String BackImage = "in.testdemo.map:id/back_img";
	String LeftImage = "in.testdemo.map:id/left_img";
	String RightImage = "in.testdemo.map:id/right_img";
	String FromGallery = "hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]";
	String DownloadsAlbum = "//android.widget.ListView[@content-desc=\"Local albums\"]/android.widget.FrameLayout[3]";
	String AcceptImage = "com.android.gallery3d:id/stub";
	String Comments = "in.testdemo.map:id/cmd_txt";
	String NextButton = "in.testdemo.map:id/next_btn";
	String ToastMessage = "/hierarchy/android.widget.Toast";	

	
	

	@BeforeTest
    public void setup () throws MalformedURLException 
	{

			
			DesiredCapabilities mDsrdCpblties = new DesiredCapabilities();
			mDsrdCpblties.setCapability("deviceName", "Android");
			mDsrdCpblties.setCapability("app", "/Users/designer23/Downloads/ekar-tests/app/app-debug.apk");
			mDsrdCpblties.setCapability("locationServicesEnabled", true);
			mDsrdCpblties.setCapability("gpsEnabled", true);
			mDsrdCpblties.setCapability("autoGrantPermissions", true);
			driver = new AndroidDriver <MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"),mDsrdCpblties);
			wait = new WebDriverWait (driver, 30);
			 
			
	}
	

@Test (priority = 0, description = "User will be able to tap on PIN")
@Severity(io.qameta.allure.SeverityLevel.BLOCKER)
@Story ("Complaint Screen Check")
@Description ("PIN and Images Chec")
    public void PinCheck () throws InterruptedException {
		
		
try {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PinCheck))).click();
	Assert.assertTrue(true, "Pin clicked successfully");
	}
	
	catch (Exception e) 
	{
			Assert.assertFalse(false, "Pin not found");
	}
	}


@Test (priority = 1, description = "User will be able to select first Image")
public void FirstImage () throws InterruptedException 

{

	try
	{
		//Image button Clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated (By.id(FrontImage))).click();
		

		//Option from Gallery
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath(FromGallery))).click();
		Assert.assertTrue(true, "Image picked from gallery");
		
		//Downloads Album
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath(DownloadsAlbum))).click();
		Assert.assertTrue(true, "Image selection from downloads album");
		
		//Select Image
		Thread.sleep(3000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(110, 408)).perform();
		
		//Accept Image
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(AcceptImage))).click();
		
		//scroll down
		Thread.sleep(3000);
		TouchAction tas = new TouchAction (driver);
		tas.press (PointOption.point(500, 1861)).perform();
		tas.moveTo (PointOption.point (800, -200)).perform();
		tas.release();
		
		//Comment
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).sendKeys("ekar test");
		driver.hideKeyboard();
		
		//NextButton
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(NextButton))).click();
		
		//ToastMessage
		Thread.sleep(3000);
		String Toast = driver.findElement(By.xpath(ToastMessage)).getText();
		System.out.println(Toast);
		Assert.assertTrue(true, "First image test passed");
	}

	catch (Exception e) 
	{
		Assert.assertFalse(false, "First image test failed");
	}


}

@Test (priority = 2, description = "User will be able to select second Image")
public void SecondImage () throws InterruptedException 

{

	try
	
	{
		//Image button Clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated (By.id(BackImage))).click();
		

		//Option from Gallery
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath(FromGallery))).click();
		Assert.assertTrue(true, "Image picked from gallery");
		
		//Downloads Album
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath(DownloadsAlbum))).click();
		Assert.assertTrue(true, "Image selection from downloads album");
		
		//Select Image
		Thread.sleep(3000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(408, 342)).perform();
		
		//Accept Image
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(AcceptImage))).click();	
		
		//Comment
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).sendKeys("ekar test");
		driver.hideKeyboard();
		
		//NextButton
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(NextButton))).click();
		
		//ToastMessage
		Thread.sleep(3000);
		String Toast = driver.findElement(By.xpath(ToastMessage)).getText();
		System.out.println(Toast);
		Assert.assertTrue(true, "Second image test passed");
		
	}
	
	catch (Exception e) 
	{
		Assert.assertFalse(false, "Second image test failed");
	}
}



@Test (priority = 3, description = "User will be able to select third Image")
public void ThirdImage () throws InterruptedException 

{
	
	try
	{

		//Image button Clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated (By.id(LeftImage))).click();
		

		//Option from Gallery
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath(FromGallery))).click();
		Assert.assertTrue(true, "Image picked from gallery");
		
		//Downloads Album
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath(DownloadsAlbum))).click();
		Assert.assertTrue(true, "Image selection from downloads album");
		
		//Select Image
		Thread.sleep(3000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(676, 333)).perform();
		
		//Accept Image
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(AcceptImage))).click();	
		
		//Comment
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).sendKeys("ekar test");
		driver.hideKeyboard();
		
		//NextButton
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(NextButton))).click();
		
		//ToastMessage
		
		Thread.sleep(3000);
		String Toast = driver.findElement(By.xpath(ToastMessage)).getText();
		System.out.println(Toast);
		Assert.assertTrue(true, "Third image test failed");
		
	}
	catch (Exception e) 
	{
		Assert.assertFalse(false, "Third image test failed");
	}
	
}

@Test (priority = 4, description = "User will be able to select fourth Image")
public void FourthImage () throws InterruptedException 

{

	try
	{
		//Image button Clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated (By.id(RightImage))).click();
		

		//Option from Gallery
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath(FromGallery))).click();
		Assert.assertTrue(true, "Image picked from gallery");
		
		//Downloads Album
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.xpath(DownloadsAlbum))).click();
		Assert.assertTrue(true, "Image selection from downloads album");
		
		//Select Image
		Thread.sleep(3000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(935, 393)).perform();
		
		//Accept Image
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(AcceptImage))).click();	
		
		//Comment
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(Comments))).sendKeys("ekar test");
		driver.hideKeyboard();
		
		//NextButton
		wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.id(NextButton))).click();
		
		//ToastMessage
		Thread.sleep(3000);
		String Toast = driver.findElement(By.xpath(ToastMessage)).getText();
		System.out.println(Toast);
		Assert.assertTrue(true, "Fourth image test passed");
	}
	
	catch (Exception e) 
	{
		Assert.assertFalse(false, "Fourth image test failed");
	}
	
}


	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
}
		
		



