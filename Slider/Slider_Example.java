package com.demoqaWidgets.Slider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Slider_Example {

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
			//ClickOn_Slider
			driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[4]")).click();
			Thread.sleep(2000);
			//MoveOn_Slider
			WebElement slide= driver.findElement(By.xpath("//input[@type='range']"));
		    System.out.println(slide.getLocation());
		    System.out.println(slide.getSize());
		    
			Actions actions = new Actions(driver);
			actions.dragAndDropBy(slide, 100, 0).perform();
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

