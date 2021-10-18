package qaSandbox.pageObject;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	WebDriver driver;
	Map<String, String> xPaths;
	
	public static String TESTCASESBUTTON = "TESTCASESBUTTON";
	
	public DashboardPage(WebDriver driver, Map<String, String> xPaths) {
		this.driver = driver;
		this.xPaths = xPaths;
	}
	
	public void clickOnTestCaseButton() {
		driver.findElement(By.xpath(xPaths.get(TESTCASESBUTTON))).click();
	}

}
