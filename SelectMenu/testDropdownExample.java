package com.demoqaWidgets.SelectMenu;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testDropdownExample {

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
			js1.executeScript("window.scrollBy(0,550)", "");
			Thread.sleep(2000);
			//ClickOn_Select Menu
			driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[9]")).click();
			Thread.sleep(2000);
			//Select Value
			WebElement select_Value = driver.findElement(By.id("withOptGroup"));
			select_Value.click();
			Thread.sleep(2000);
			List <WebElement> select_Value1 = driver.findElements(By.xpath("//div[@class='mt-2 row'][1]/div/div/div/div"));
			System.out.println(select_Value1.size());
			for(int i=0;i<select_Value1.size();i++) {
				System.out.println("Iteration"+i + " "+ select_Value1.get(i).getText());
				if(select_Value1.get(i).getText().contains("A root option")) {
					select_Value1.get(i).click();
					break;
				}
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	@AfterMethod
	public void closeApplication() {
		//Closing the Application
		//driver.quit();
	}
}
