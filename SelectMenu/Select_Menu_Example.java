package com.demoqaWidgets.SelectMenu;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Select_Menu_Example {

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
			Actions actions = new Actions(driver);
			actions.moveToElement(select_Value).perform();
			actions.sendKeys(Keys.DOWN).perform();
			actions.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			//Select One
			WebElement select_One = driver.findElement(By.id("selectOne"));
			select_One.click();
			Thread.sleep(2000);
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(select_One).perform();
			actions1.sendKeys(Keys.DOWN).perform();
			actions1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			//Old Style Select Menu
			WebElement select_menu = driver.findElement(By.id("oldSelectMenu"));
			select_menu.click();
			Thread.sleep(2000);
			Select select = new Select(select_menu);	
			select.selectByVisibleText("Green");
			//scrollDown
			JavascriptExecutor js2 = (JavascriptExecutor) driver;  
			js2.executeScript("window.scrollBy(0,550)", "");
			//Multiselect Dropdown
			WebElement select_multi = driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div"));
			select_multi.click();
			Actions actions2 = new Actions(driver);
			actions2.moveToElement(select_multi).perform();
			actions2.sendKeys("Red").perform();
			actions2.sendKeys(Keys.ENTER).perform();
			actions2.sendKeys("Green").perform();
			actions2.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			//Standard_MultiSelect
			WebElement standard_multi = driver.findElement(By.id("cars"));
			standard_multi.click();
			Select sel = new Select(standard_multi);
			sel.selectByVisibleText("Volvo");
			sel.selectByVisibleText("Opel");
			sel.selectByVisibleText("Audi");
			
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
