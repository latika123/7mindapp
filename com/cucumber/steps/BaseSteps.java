//Author: Latika

package cucumber.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import utils.DriverFactory;
import utils.DriverManager;

public class BaseSteps {

	public static int driverTimeOut = 50;
	public WebDriverWait wait;
	public AndroidDriver<?> driver;
	public static Properties configProperty;

	public void initializeTheDriver() {

		try {
			FileInputStream fi = new FileInputStream(
					new File(System.getProperty("user.dir") + "//com//resources//config.properties"));
			configProperty = new Properties();
			try {
				configProperty.load(fi);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		driver = new DriverFactory().createDriverInstance(configProperty.getProperty("platformname"),
				configProperty.getProperty("devicename"),configProperty.getProperty("platformversion"),
				configProperty.getProperty("apppackage"),configProperty.getProperty("appactivity"));
		DriverManager.setDriver(driver);
		DriverManager.setImplicitWait(driver);
		DriverManager.maximizeDriver(driver);
	}

	public void waitForElement(By by) {

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	protected static void waitForPageLoad(ExpectedCondition<?> pageLoadCondition) {

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), driverTimeOut);
		wait.until(pageLoadCondition);

	}

	public static boolean isPageLoad(ExpectedCondition<?> pageLoadCondition) {
		try {
			waitForPageLoad(pageLoadCondition);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementPresent(By by) {
		try {
			DriverManager.getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected void teardownTheDriver() {

		try {
			DriverManager.closeDriver(DriverManager.getDriver());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
