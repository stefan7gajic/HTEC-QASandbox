package qaSandbox.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qaSandbox.pageObject.LoginPage;
import qaSandbox.readingFromTxtFile.ReadingFromTxtFile;

public class LoginTest {
	
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
	public void logPage() {
		loginPage = new LoginPage(driver, ReadingFromTxtFile.readXPaths());
		driver.get(LoginPage.LOG_URL);
	}
	
	@Test(priority = 1)
	public void forgotPassword() {
		loginPage.clickOnForgotPassword();
		loginPage.wait(5000);
		
		Assert.assertEquals(loginPage.emailInstructions(), "Enter your email to receive instructions");	
	}
	
	@Test(priority = 2)
	public void forgotPasswordIncorrectEmail() {
		loginPage.clickOnForgotPassword();
		loginPage.wait(5000);
		loginPage.typeEmail("stefanzgajic.com");
		loginPage.clickOnSendButton();
		loginPage.wait(5000);
		
		WebElement element = driver.findElement(By.id("validation-msg"));	
		Assert.assertEquals(element.isDisplayed(), true);	
	}
	
	@Test(priority = 3)
	public void loginWithIncorrectPassword() {
		loginPage.typeEmail("stefanzgajic@gmail.com");
		loginPage.typePassword("qasandboxsifra");
		loginPage.clickOnLoginButton();
		loginPage.wait(5000);
		
		WebElement element = driver.findElement(By.id("validation-msg"));	
		Assert.assertEquals(element.isDisplayed(), true);	
	}
	
	@Test(priority = 4)
	public void loginWithIncorrectEmail() {
		loginPage.typeEmail("stefangajic@gmail.com");
		loginPage.typePassword("qasandboxsifra7");
		loginPage.clickOnLoginButton();
		loginPage.wait(5000);
		
		WebElement element = driver.findElement(By.id("validation-msg"));	
		Assert.assertEquals(element.isDisplayed(), true);
	}
	
	@Test(priority = 5)
	public void loginWithCorrectData() {
		loginPage.typeEmail("stefanzgajic@gmail.com");
		loginPage.typePassword("qasandboxsifra7");
		loginPage.clickOnLoginButton();
		loginPage.wait(5000);
		
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[1]/a"));	
		Assert.assertEquals(element.isDisplayed(), true);
		
		loginPage.clickOnLogoutButton();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
