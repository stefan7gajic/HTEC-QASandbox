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
import qaSandbox.pageObject.DashboardPage;
import qaSandbox.pageObject.LoginPage;
import qaSandbox.pageObject.TestCasesPage;
import qaSandbox.readingFromTxtFile.ReadingFromTxtFile;

public class UseCaseTest {
	
	WebDriver driver;
	DashboardPage dashboardPage;
	TestCasesPage testCasesPage;
	LoginPage loginPage;
	
	@BeforeClass 
	public void openBrowserAndLogin() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(LoginPage.LOG_URL);
		loginPage = new LoginPage(driver, ReadingFromTxtFile.readXPaths());
		loginPage.typeEmail("stefanzgajic@gmail.com");
		loginPage.typePassword("qasandboxsifra7");
		loginPage.clickOnLoginButton();
		}
	
	@BeforeMethod
	public void testPage() {
		testCasesPage = new TestCasesPage(driver, ReadingFromTxtFile.readXPaths());
		
	}
	
	
	@Test(priority = 1)
	public void add5Tests() {
		dashboardPage = new DashboardPage(driver, ReadingFromTxtFile.readXPaths());
		loginPage.wait(5000);
		dashboardPage.clickOnTestCaseButton();
		loginPage.wait(5000);
		for (int i = 1; i <= 5; i++) {
			testCasesPage.addNewTest("Use Case" + " " + i, "Expected Result" + " " + i, "Test Step" + " " + i);
			loginPage.wait(500);
			
			WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[1]"));	
			Assert.assertEquals(element.isDisplayed(), true);
			
			loginPage.wait(5000);
		}	
	}
	
	@Test(priority = 2)
	public void addTestWithSameTitle() {
		testCasesPage.addNewTest("Use Case 1","Expected Result 1","Test Step 1");
		loginPage.wait(5000);
		
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div[2]/div[1]/div[1]/div/label/label"));	
		Assert.assertEquals(element.isDisplayed(), true);
		
		dashboardPage.clickOnTestCaseButton();
		loginPage.wait(5000);
	}
	
	@Test(priority = 3)
	public void deleteCreatedCases() {
		
		testCasesPage.clickOnCase(TestCasesPage.CASE1);
		testCasesPage.clickOnDelete();
		testCasesPage.clickOnRemove();
		loginPage.wait(1000);
		
		WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[1]"));	
		Assert.assertEquals(element.isDisplayed(), true);
		
		testCasesPage.clickOnCase(TestCasesPage.CASE2);
		testCasesPage.clickOnDelete();
		testCasesPage.clickOnRemove();
		loginPage.wait(1000);
		
		WebElement element1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[1]"));	
		Assert.assertEquals(element1.isDisplayed(), true);
		loginPage.wait(5000);
		
		testCasesPage.clickOnCase(TestCasesPage.CASE3);
		testCasesPage.clickOnDelete();
		testCasesPage.clickOnRemove();
		loginPage.wait(1000);
		
		WebElement element2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[1]"));	
		Assert.assertEquals(element2.isDisplayed(), true);
		loginPage.wait(5000);
		
		testCasesPage.clickOnCase(TestCasesPage.CASE4);
		testCasesPage.clickOnDelete();
		testCasesPage.clickOnRemove();
		loginPage.wait(1000);
		
		WebElement element3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[1]"));	
		Assert.assertEquals(element3.isDisplayed(), true);
		loginPage.wait(5000);
		
		testCasesPage.clickOnCase(TestCasesPage.CASE5);
		testCasesPage.clickOnDelete();
		testCasesPage.clickOnRemove();
		loginPage.wait(1000);
		
		WebElement element4 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[1]"));	
		Assert.assertEquals(element4.isDisplayed(), true);
		loginPage.wait(5000);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
