package com.demoqaWidgets.AutoComplete;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoComplete_Single_Color {

WebDriver driver;
	
	@BeforeMethod
	public void driverInitialize() {
		try {
			
	   driver = new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   driver.get("https://demoqa.com/");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void FunctionMethod() {
		try {
			//scrollDown
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(7000);
			//ClickOn_Widgets	
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div/div[3]")).click();
			Thread.sleep(2000);
			//scrollDown
			JavascriptExecutor js1 = (JavascriptExecutor) driver;  
			js1.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(4000);
			//ClickOn_AutoComplete
			driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[2]")).click();
			Thread.sleep(2000);
			//Providing input value
			WebElement clickable = driver.findElement(By.xpath("//div[@id='autoCompleteSingleContainer']"));
			clickable.click();
			Thread.sleep(2000);
			WebElement inputvalue = driver.findElement(By.xpath("//div[@class='auto-complete__input']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(inputvalue).perform();
			actions.sendKeys("red").perform();
			Thread.sleep(2000);
			actions.sendKeys(Keys.DOWN).perform();
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	@AfterMethod
	public void closeApplication() {
		//Closing the Application
		driver.quit();
	}
}



