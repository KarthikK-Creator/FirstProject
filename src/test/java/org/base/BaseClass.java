package org.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService build;
	
	// Start Appium Server
	public void startAppiumServer() {
		
		// Start the Server through automation - initialize server reference
		build = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		// Start the Server
		build.start();
	}
	
	// Launch Application
	public void launchApplication(String deviceName, String appPath) throws MalformedURLException {
		
		// Call Appium Server
		startAppiumServer();
		
		// Create object for UIAutomator2Options
		UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
		uiAutomator2Options.setCapability("deviceName", deviceName);
		uiAutomator2Options.setCapability("app", appPath);
		
		// Initialize object for AndroidDriver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),uiAutomator2Options);
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	// Mouse Click
	public void mouseClick(WebElement element) {
		element.click();
	}
	
	// Scroll
	public void scrollItem(String scrollTo) {
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+scrollTo+"\"));"));
	}
	
	// Mobile Key Actions
	public void keyActions(String actionKey) {
		if(actionKey.equals("BACK")) {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}else {
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
		}
	}
	
	//Send input
	public void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}	
	
	// Quit App and Server
	public void endAll() {
		driver.quit();
		build.stop();
	}
}
