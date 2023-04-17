package com.demoqaWidgets.DatePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Date_And_Time {

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
			//ClickOn_DatePicker
			driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[3]")).click();
			Thread.sleep(2000);
			//ClickOn_Datefield
			driver.findElement(By.id("dateAndTimePickerInput")).click();
			Thread.sleep(2000);
			//Select Month
			driver.findElement(By.className("react-datepicker__month-read-view--down-arrow")).click();
			Thread.sleep(2000);
			WebElement month = driver.findElement(By.xpath("//div[@class='react-datepicker__month-option'][5]"));
			month.click();
			//Select Year
			driver.findElement(By.xpath("//span[@class='react-datepicker__year-read-view--down-arrow']")).click();
			Thread.sleep(2000);
			WebElement year = driver.findElement(By.xpath("//div[@class='react-datepicker__year-option'][8]"));
			year.click();
			//Select Day
			driver.findElement(By.xpath("//div[@class='react-datepicker__week'][3]/div[4]")).click();
			Thread.sleep(2000);
			//Select Time
			driver.findElement(By.xpath("//div[@class='react-datepicker__time-box']//li[@class='react-datepicker__time-list-item '][60]")).click();
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
