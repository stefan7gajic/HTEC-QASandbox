package qaSandbox.pageObject;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	Map<String, String> xPaths;
	
	public static String LOG_URL = "https://qa-sandbox.ni.htec.rs/login";
	public static String EMAIL = "EMAIL";
	public static String PASSWORD = "PASSWORD";
	public static String LOGINBUTTON = "LOGINBUTTON";
	public static String FORGOTPASSWORD = "FORGOTPASSWORD";
	public static String EMAILINSTRUCTIONS = "EMAILINSTRUCTIONS";
	public static String SENDBUTTON = "SENDBUTTON";
	public static String LOGOUTBUTTON = "LOGOUTBUTTON";
	
	
	public LoginPage(WebDriver driver, Map<String, String> xPaths) {
		this.driver = driver;
		this.xPaths = xPaths;
	}

	public void typeEmail(String mail) {
		driver.findElement(By.xpath(xPaths.get(EMAIL))).sendKeys(mail);
	}

	public void typePassword(String pass) {
		driver.findElement(By.xpath(xPaths.get(PASSWORD))).sendKeys(pass);
	}

	public void clickOnLoginButton() {
		driver.findElement(By.xpath(xPaths.get(LOGINBUTTON))).click();
	}
	
	public void clickOnForgotPassword() {
		driver.findElement(By.xpath(xPaths.get(FORGOTPASSWORD))).click();
	}
	
	public String emailInstructions() {
		return driver.findElement(By.xpath(xPaths.get(EMAILINSTRUCTIONS))).getText();
	}
	
	public void clickOnSendButton() {
		driver.findElement(By.xpath(xPaths.get(SENDBUTTON))).click();
	}
	
	public void clickOnLogoutButton() {
		driver.findElement(By.xpath(xPaths.get(LOGOUTBUTTON))).click();
	}
	
	public void wait(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}

	
}
