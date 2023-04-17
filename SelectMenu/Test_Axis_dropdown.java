package com.demoqaWidgets.SelectMenu;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Axis_dropdown {

WebDriver driver;
	
	@BeforeMethod
	public void driverInitialize() {
		try {
			
	   driver = new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void FunctionMethod() {
		try {
			
			//Select Title
			WebElement select_Value = driver.findElement(By.id("btnDropdownDemo"));
			select_Value.click();
			Thread.sleep(2000);
			List <WebElement> select_Value1 = driver.findElements(By.xpath("//div[@class='dropdown-menu show']"));
			System.out.println(select_Value1.size());
			String s = select_Value1.get(0).getText();
			System.out.println(s);
			for(int i=0;i<select_Value1.size();i++) {
				System.out.println("Iteration"+i + " "+ select_Value1.get(i).getText());
				if(select_Value1.get(i).getText().contains("CSS")) {
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


