package tests;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AppiumDriver md;

	@BeforeTest
	public void SetUp() {
		try {

			// File file = new File("Android App Test_v1.0.apk");
			// System.out.println("Relative path: " + file.getPath());
			// System.out.println("Absolute path: " + file.getAbsolutePath());
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xiaomi-redmi_5a");
			caps.setCapability(MobileCapabilityType.UDID, "bd45f4357d84");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.cloudgrey.the_app");
			// caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,""
			// caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
			caps.setCapability(MobileCapabilityType.APP,
					"C:\\Users\\nirmal.patel\\Documents\\2022_NirmalPatel_PracticeWork\\AppiumDemo\\src\\test\\resources\\apps\\TheTestApp.apk");
			// caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

			URL baseurl = new URL("http://127.0.0.1:4723/wd/hub/");
			md = new AppiumDriver(baseurl, caps);

		} catch (Exception e) {
			System.out.println("expection id due to: " + e.getCause());
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void demoAppTest() throws Throwable {
		// md.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(2000);
		md.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Echo Box']")).click();
		// Thread.sleep(1000);
		md.findElement(By.xpath("//android.widget.EditText[@content-desc='messageInput']")).sendKeys("Nirmal");
		md.findElement(By.xpath("//android.view.ViewGroup[@content-desc='messageSaveBtn']")).click();
		Assert.assertTrue(md.findElement(By.xpath("//android.widget.TextView[@content-desc='Nirmal']")).isDisplayed(),
				"");
		md.navigate().back();

	}

	@AfterTest
	public void tearDown() {
		md.close();
		md.quit();
	}

}
