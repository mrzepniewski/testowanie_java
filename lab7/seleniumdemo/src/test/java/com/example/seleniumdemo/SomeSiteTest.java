package com.example.seleniumdemo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		// ChromeDrirver, FireforxDriver, ...
		System.setProperty("webdriver.chrome.driver", "c:\\TEMP\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void CheckingIfCorrectlyLoggedIn(){
		WebElement usernameField; 
		WebElement passwordField;
		WebElement backToLastButton;
		WebElement konto;
		WebElement logOut;
		WebElement textLogout;
		WebElement waitElement;
		WebElement logInButton; 
		
		driver.get("http://seansik.tv/");
		
		
		
		logInButton = driver.findElement(By.xpath(".//*[@title='Logowanie']"));
		logInButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='login_button']")));
		
		usernameField=driver.findElement(By.xpath(".//*[@id='username']"));
		passwordField= driver.findElement(By.xpath(".//*[@id='password']"));
		usernameField.sendKeys("java-testing-user");
		passwordField.sendKeys("password123");
		passwordField.submit();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='header']/div[1]/a")));
		backToLastButton = driver.findElement(By.xpath(".//*[@id='left']/div[1]/p[2]/a"));
		backToLastButton.click();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='roller']/div[3]/a")));
		konto = driver.findElement(By.xpath(".//*[@id='user-panel']/ul/li[1]"));
		assertEquals("Witaj java-testing-user",konto.getText());	
		
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user-panel']/ul/li[2]/a")));
		logOut = driver.findElement(By.xpath(".//*[@id='user-panel']/ul/li[4]/a"));
		logOut.click();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='left']/div[1]/p[2]/a")));
		textLogout = driver.findElement(By.xpath(".//*[@id='left']/div[1]/h3"));
		assertEquals("Wylogowywanie",textLogout.getText());
		
	
	}
	
	@Test
	public void CheckingIfCorrectlyLoggedInConfirmLoginWithSelect(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
	
		driver.get("http://seansik.tv/");
		
		WebElement logInButton = driver.findElement(By.xpath(".//*[@title='Logowanie']"));
		WebElement usernameField; 
		WebElement passwordField;
		WebElement backToLastButton;
		WebElement konto;
		WebElement logOut;
		WebElement textLogout;
		WebElement kontopraw;
		Select showAdult;
	    WebElement selected;
	    WebElement zapisz;
	    WebElement wrocButton;
	    WebElement emailField;
		
		logInButton.click();
		WebElement waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button")));
		usernameField=driver.findElement(By.xpath(".//*[@id='username']"));
		passwordField= driver.findElement(By.xpath(".//*[@id='password']"));
		usernameField.sendKeys("java-testing-user");
		passwordField.sendKeys("password123");
		passwordField.submit();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='header']/div[1]/a")));
		backToLastButton = driver.findElement(By.xpath(".//*[@id='left']/div[1]/p[2]/a"));
		backToLastButton.click();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='roller']/div[3]/a")));
		konto = driver.findElement(By.xpath(".//*[@id='user-panel']/ul/li[1]"));
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("c:\\TEMP\\selenium\\email.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(screenshot);
		assertEquals("Witaj java-testing-user",konto.getText());	
		
		kontopraw = driver.findElement(By.xpath(".//*[@id='user-panel']/ul/li[3]/a"));
		kontopraw.click();

		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='form-settings']/div[2]/table[2]/tbody/tr[2]/td/a")));
		showAdult= new Select(driver.findElement(By.xpath(".//*[@id='show_adult']")));
        selected = showAdult.getFirstSelectedOption();
        assertEquals("Nie pokazuj",selected.getText() );
       // System.out.println("\n\nJestem przy select\n\n");
        showAdult.selectByValue("1");
        selected=showAdult.getFirstSelectedOption();
        //System.out.println("\n\nJestem po select\n\n");
        assertEquals("Tak, poka¿", selected.getText());
        zapisz = driver.findElement(By.xpath(".//*[@id='form-settings']/div[2]/table[2]/tbody/tr[14]/td[2]/input"));
        zapisz.click();
        //System.out.println("\n\nJestem po zapisz\n\n");
        //wrocButton= driver.findElement(By.xpath(".//*[@id='left']/div[2]/div/p[2]/a"));
        //wrocButton.click();
        //System.out.println("\n\nJestem po wroc\n\n");
		
		logOut = driver.findElement(By.xpath(".//*[@id='user-panel']/ul/li[4]/a"));
		logOut.click();
		
		//System.out.println("\n\nJestem po wyloguj\n\n");
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='left']/div[1]/p[2]/a")));
		textLogout = driver.findElement(By.xpath(".//*[@id='left']/div[1]/h3"));
		assertEquals("Wylogowywanie",textLogout.getText());
		File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot2, new File("c:\\TEMP\\selenium\\email2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("Wylogowywanie",textLogout.getText());
		assertNotNull(screenshot2);
		
		logInButton = driver.findElement(By.xpath(".//*[@title='Logowanie']"));
		logInButton.click();
		waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button")));
		usernameField=driver.findElement(By.xpath(".//*[@id='username']"));
		passwordField= driver.findElement(By.xpath(".//*[@id='password']"));
		usernameField.sendKeys("java-testing-user");
		passwordField.sendKeys("password123");
		passwordField.submit();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='header']/div[1]/a")));
		
		backToLastButton = driver.findElement(By.xpath(".//*[@id='left']/div[1]/p[2]/a"));
		backToLastButton.click();
		kontopraw = driver.findElement(By.xpath(".//*[@id='user-panel']/ul/li[3]/a"));
		kontopraw.click();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='form-settings']/div[2]/table[2]/tbody/tr[2]/td/a")));
	   
		emailField= driver.findElement(By.xpath(".//*[@id='email']"));
	    
		assertThat("mrzepniewski@outlook.com",emailField.getAttribute("value").equals("mrzepniewski@outlook.com"));
	
		logOut = driver.findElement(By.xpath(".//*[@id='user-panel']/ul/li[4]/a"));
		logOut.click();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='left']/div[1]/p[2]/a")));
		textLogout = driver.findElement(By.xpath(".//*[@id='left']/div[1]/h3"));
		assertEquals("Wylogowywanie",textLogout.getText());
		
	}
	/*
	@Test
	public void CheckingIfCorrectlyLoggedInAndMailIsCorrect(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://seansik.tv/");
		
		element = driver.findElement(By.xpath(".//*[@title='Logowanie']"));
		element.click();
	
		WebElement waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button")));
		element = driver.findElement(By.xpath(".//*[@id='username']"));
		element.sendKeys("java-testing-user");
		element = driver.findElement(By.xpath(".//*[@id='password']"));
		element.sendKeys("password123");
		element.submit();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='header']/div[1]/a")));
		element = driver.findElement(By.xpath(".//*[@id='left']/div[1]/p[2]/a"));
		element.click();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='roller']/div[3]/a")));
		element = driver.findElement(By.xpath(".//*[@id='user-panel']/ul/li[3]/a"));
		element.click();
		waitElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='email']")));
		element = driver.findElement(By.xpath(".//*[@id='email']"));//*[@id='email']
		//screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("c:\\tmp\\selenium\\email.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(screenshot);
		assertThat("mrzepniewski@outlook.com",element.getAttribute("value").equals("mrzepniewski@outlook.com"));
		element = driver.findElement(By.xpath(".//*[@id='user-panel']/ul/li[4]/a"));
		element.click();
		waitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='left']/div[1]/p[2]/a")));
		element = driver.findElement(By.xpath(".//*[@id='left']/div[1]/h3"));
		assertEquals("Wylogowywanie",element.getText());
	   
	}
*/
	@AfterClass
	public static void cleanp() {
		driver.close();
		driver.quit();
	}
}
