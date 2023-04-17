package com.demoqaWidgets.DatePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Select_Date {

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
			driver.findElement(By.id("datePickerMonthYearInput")).click();
			Thread.sleep(2000);
			//Select_Month
			WebElement select_month = driver.findElement(By.className("react-datepicker__month-select"));
			select_month.click();
			Select select = new Select(select_month);
			select.selectByIndex(5);
			//Select_Year
			WebElement select_year = driver.findElement(By.className("react-datepicker__year-select"));
			select_year.click();
			Select select1 = new Select(select_year);
			select1.selectByVisibleText("1980");
			//Select_Day
			WebElement select_day = driver.findElement(By.xpath("//div[@class='react-datepicker__week']/div[7]"));
			select_day.click();
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

