package pagesDetails;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

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

		driver.close();

	}

}
