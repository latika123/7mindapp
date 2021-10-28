package utils;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

	@SuppressWarnings("rawtypes")
	public static ThreadLocal<AndroidDriver> driver = new ThreadLocal<AndroidDriver>();

	@SuppressWarnings("rawtypes")
	public static AndroidDriver getDriver() {
		return DriverManager.driver.get();
	}

	@SuppressWarnings("rawtypes")
	public static void setDriver(AndroidDriver driver) {
		DriverManager.driver.set(driver);
	}

	@SuppressWarnings("rawtypes")
	public static void setImplicitWait(AndroidDriver driver) {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@SuppressWarnings("rawtypes")
	public static void maximizeDriver(AndroidDriver driver) {
		DriverManager.getDriver().manage().window().maximize();
	}

	@SuppressWarnings("rawtypes")
	public static void closeDriver(AndroidDriver driver) {
		driver.quit();
	}

}
