package testingFrameWorks;

import java.util.concurrent.TimeUnit;

//import javax.jws.Oneway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.ReadExcel;

public class Demo {
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

	@BeforeTest
	public void precondition() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/simil/Desktop/Selenium/Workspace/SeleniumProject/chromedriver");
		driver = new ChromeDriver();

		wait = new WebDriverWait(driver, 10);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://newtours.demoaut.com/");
	}

	@Test(priority = 1)
	public void login() {
		try {
			String credentials[][] = ReadExcel
					.getData("/Users/simil/Desktop/Selenium/Workspace/FrameWork/Testdata.xlsx", "Sheet1");
			for (int i = 1; i < credentials.length; i++) {
				String username = credentials[i][0];
				String password = credentials[i][1];

				driver.findElement(By.xpath(
						"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"))
						.clear();
				driver.findElement(By.xpath(
						"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"))
						.sendKeys(username);
				;

				driver.findElement(By.xpath(
						"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input"));
				driver.findElement(By.xpath(
						"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input"))
						.sendKeys(password);
				;

				driver.findElement(By.xpath(
						"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input"))
						.click();

				String error_exp = "Welcome back to Mercury Tours!";
				System.out.println(error_exp);

				String error_act = driver.findElement(By.xpath(
						"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b"))
						.getText();
				System.out.println(error_act);

				Assert.assertEquals(error_act, error_exp);
				driver.navigate().back();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.quit();
	}

	@Test(priority = 3)
	public void Onewayselect() throws InterruptedException {

		driver = new ChromeDriver();

		wait = new WebDriverWait(driver, 10);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://newtours.demoaut.com/");

		driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"))
				.clear();
		driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"))
				.sendKeys("mercury");
		;

		driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input"));
		driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input"))
				.sendKeys("mercury");
		;

		driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input"))
				.click();

	}
}
