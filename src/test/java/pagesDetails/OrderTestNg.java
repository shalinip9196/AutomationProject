package pagesDetails;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderTestNg {
	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.ca/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
		driver.findElement(By.id("ap_email")).sendKeys("dark");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("password#");

		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.id("signInSubmit")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img")));
		ac.moveToElement(
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/a/div/div/div/div[1]/img")))
				.click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span")));
		String data = driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[4]/form/label/span")).getText();
		Assert.assertEquals(data, "9 orders");

		WebElement spandropdown = driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]"));

		spandropdown.click();
		WebElement dropdownValue = driver.findElement(By.id("time-filter_0"));

		dropdownValue.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span")));
		String data1 = driver.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/form/label/span")).getText();
		Assert.assertEquals(data1, "2 orders");

		WebElement spandropdown1 = driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]"));
		spandropdown1.click();
		WebElement dropdownValue1 = driver.findElement(By.id("time-filter_3"));

		dropdownValue1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span")));
		String data2 = driver.findElement(By.xpath("/html/body/div[1]/section/div/div[4]/form/label/span")).getText();
		Assert.assertEquals(data2, "7 orders");

		String data3 = driver
				.findElement(By
						.xpath("/html/body/div[1]/section/div/div[9]/div/div[1]/div/div/div/div[2]/div[1]/span[2]/bdi"))
				.getText();
		Assert.assertEquals(data3, "702-5000333-3004215");

		WebElement orderimage = driver.findElement(By.xpath(
				"/html/body/div[1]/section/div/div[9]/div/div[2]/div/div/div/div[1]/div/div/div/div[1]/div/a/img"));

		Assert.assertEquals(orderimage.isDisplayed(), true);

		List<WebElement> elementcount = driver.findElements(By.className("order-card"));
		System.out.println(elementcount.size());
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div/div[3]/ul/li[4]")));
		ac.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/ul/li[4]"))).click().build()
				.perform();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div[4]/div[2]/label/span")));
		String data4 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[4]/div[2]/label/span"))
				.getText();
		Assert.assertEquals(data4, "3 cancelled orders");

	}

}
