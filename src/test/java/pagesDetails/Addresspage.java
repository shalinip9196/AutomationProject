package pagesDetails;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Addresspage {
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
		driver.findElement(By.id("ap_email")).sendKeys("v.vignesh.0811@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Fresh@@1996");

		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.id("signInSubmit")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

		ac.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[3]/div[1]/a/div")));
		ac.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/div[1]/a/div"))).click()
				.build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/div[1]/a/div/div/h2")));
		ac.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/div[1]/a/div/div/h2")))
				.click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[2]/h2")));
		WebElement countrydropdown = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[2]/span/span/span/span"));
//		countrydropdown.click();
		WebElement dropdownValue1 = countrydropdown
				.findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span/span"));
		// WebElement dropdownValue1 =
		// driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId_37"));

		Assert.assertEquals(dropdownValue1.getText(), "Canada");

		driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("");
		driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("9489359852");
		driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("gerojjhjds");
		driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("afsd");
		driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("suieurieu");
		driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("V3T0R1");
		WebElement dropdownpre = driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion"));
		dropdownpre.click();
		WebElement Bc = driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_1"));
		Bc.click();

		driver.findElement(By.id("address-ui-widgets-use-as-my-default")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/a/span/span")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[2]/span/div/span[1]/span/button")));

		WebElement home = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[2]/span/div/span[1]"));
		home.click();
		WebElement expand = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[3]/div[1]/div"));
		expand.click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[6]/div[1]/a")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("preferredDeliveryLocationHOUSE")));
		WebElement fd = driver.findElement(By.name("preferredDeliveryLocationHOUSE"));
		fd.click();

		WebElement securit = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[3]/div[2]/a"));
		securit.click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[3]/div[2]/div/div[2]/span/input"))
				.sendKeys("1201");

		WebElement weekend = driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[3]/div[3]/a"));
		weekend.click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[3]/div[3]/div/div/div[1]/div[2]/ul/li[2]/span/span/span/button"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[3]/div[3]/div/div/div[2]/div[2]/ul/li[1]/span/span/span/button"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[3]/div[4]/a"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[3]/div[4]/div/div/span/div/textarea"))
				.sendKeys("Hi");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-button-input")));
		WebElement addaddressbut = driver.findElement(By.className("a-button-input"));
		addaddressbut.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-button-input")));
		String alert1 = driver.findElement(By.id("address-ui-widgets-enterAddressFullName-full-validation-alerts"))
				.getText();

		Assert.assertEquals(alert1, "Please enter a name.");

		driver.close();

	}
}
