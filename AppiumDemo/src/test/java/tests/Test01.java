package tests;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Test01 extends BaseClass {
	
	@Test
	public void googleTestSample() throws InterruptedException{
		
		//md.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(2000);
		md.findElement(By.id("io.cloudgrey.the_app:id/EchoBox"));
		
		/*md.get("https://www.google.co.in/");
		md.findElement(By.xpath("//input[contains(@name,'q')]")).sendKeys("Mobile Automation");
		md.findElement(By.xpath("//input[contains(@name,'q')]")).sendKeys(Keys.ENTER);
		System.out.println("Hi, This is my first Android sample test.");*/
	}

}
