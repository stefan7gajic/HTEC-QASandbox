package qaSandbox.pageObject;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
	
	WebDriver driver;
	Map<String, String> xPaths;
	LoginPage loginPage;
	
	public static String NEWTESTCASEBUTTON = "NEWTESTCASEBUTTON";
	public static String TESTCASESARROW = "TESTCASEARROW";
	public static String TITLE = "TITLE";
	public static String EXPECTEDRESULT = "EXPECTEDRESULT";
	public static String TESTSTEP = "TESTSTEP";
	public static String AUTOMATED = "AUTOMATED";
	public static String SUBMIT = "SUBMIT";
	public static String CASE1 = "CASE1";
	public static String CASE2 = "CASE2";
	public static String CASE3 = "CASE3";
	public static String CASE4 = "CASE4";
	public static String CASE5 = "CASE5";
	public static String DELETE = "DELETE";
	public static String REMOVE = "REMOVE";
	
	
	public TestCasesPage(WebDriver driver, Map<String, String> xPaths) {
		this.driver = driver;
		this.xPaths = xPaths;
	}
	
	public void clickOnNewTestCaseButton() {
		driver.findElement(By.xpath(xPaths.get(NEWTESTCASEBUTTON))).click();
	}
	
	public void clickOnTestCaseArrow() {
		driver.findElement(By.xpath(xPaths.get(TESTCASESARROW))).click();
	}
	
	/*public void typeTitle(String title) {
		driver.findElement(By.xpath(xPaths.get(TITLE))).sendKeys(title);
	}
	
	public void typeExpectedResult(String result) {
		driver.findElement(By.xpath(xPaths.get(EXPECTEDRESULT))).sendKeys(result);
	}
	
	public void typeTestStep(String step) {
		driver.findElement(By.xpath(xPaths.get(TESTSTEP))).sendKeys(step);
	}
	
	public void clickAutomated() {
		driver.findElement(By.xpath(xPaths.get(AUTOMATED))).click();
	}
	
	public void clickOnSubmit() {
		driver.findElement(By.xpath(xPaths.get(SUBMIT))).click();
		
	}*/
	
	public void addNewTest(String title, String result, String step) {
		driver.findElement(By.xpath(xPaths.get(NEWTESTCASEBUTTON))).click();
		driver.findElement(By.xpath(xPaths.get(TITLE))).sendKeys(title);
		driver.findElement(By.xpath(xPaths.get(EXPECTEDRESULT))).sendKeys(result);
		driver.findElement(By.xpath(xPaths.get(TESTSTEP))).sendKeys(step);
		driver.findElement(By.xpath(xPaths.get(AUTOMATED))).click();
		driver.findElement(By.xpath(xPaths.get(SUBMIT))).click();		
	}
	
	public void clickOnCase(String c) {
		driver.findElement(By.xpath(xPaths.get(c))).click();
	}
	
	public void clickOnDelete() {
		driver.findElement(By.xpath(xPaths.get(DELETE))).click();
	}
	
	public void clickOnRemove() {
		driver.findElement(By.xpath(xPaths.get(REMOVE))).click();
	}
	}
