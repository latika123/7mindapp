package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	@SuppressWarnings("rawtypes")
	public AndroidDriver<?> createDriverInstance(String platformname, String devicename, String platformversion,
			String apppackage, String appactivity) {
		AndroidDriver<?> driver = null;

		if (platformname.equalsIgnoreCase("Android")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformversion);
			cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apppackage);
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appactivity);
			cap.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
			cap.setCapability("disableWindowAnimation", true);
			cap.setCapability("autoAcceptAlerts", true);
		//	cap.setCapability("skipDeviceInitialization", true);
			//cap.setCapability("skipServerInstallation", true);
			cap.setCapability("clearSystemFiles", true);
			cap.setCapability("app", "/Users/latikasoni/Downloads/de.sevenmind.android_2021-10-12.apk");

			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				DriverManager.setDriver(driver);
				//
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return driver;

	}

	public static void destory() {

		DriverManager.getDriver().quit();

	}

}
