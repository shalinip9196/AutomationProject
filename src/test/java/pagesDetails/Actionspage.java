package pagesDetails;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Actionspage {
	public static WebDriver driver;

	@SuppressWarnings("unlikely-arg-type")
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

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Tshirt");
		driver.findElement(By.id("nav-search-submit-button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-0-announce\"]")));

		ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"))).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s-result-sort-select_2")));
		WebElement choose = driver.findElement(By.id("s-result-sort-select_2"));
		choose.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-price-whole")));
		List<WebElement> prod = driver.findElements(By.className("s-asin"));
		System.out.println(prod.size());

		List<String> prodprice = new ArrayList<String>();

		for (int i = 0; i < prod.size(); i++) {

			WebElement proditem = prod.get(i);
			List<WebElement> check = proditem.findElements(By.className("a-price-whole"));
			if (check.size() > 0) {
				String price = check.get(0).getText();
				System.out.println("price list" + price);
				prodprice.add(price);
			}

		}
		System.out.println(prodprice.size());

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.s-pagination-item:nth-child(2)")));
		String value = driver.findElement(By.cssSelector("a.s-pagination-item:nth-child(3)")).getText();
		System.out.println(value);
		// driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[66]/div/div/span/span[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		WebElement bottom = driver.findElement(By.cssSelector("a.s-pagination-item:nth-child(3)"));

		bottom.click();
		System.out.println(value);
		Assert.assertEquals(value, "2");
		boolean duplicate = false;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		List<WebElement> page2 = driver.findElements(By.className("s-asin"));
		List<String> urlduplicate = new ArrayList<String>();

		for (int i = 0; i < prod.size(); i++) {

			if (prod.contains(page2)) {
				duplicate = true;

				String url = page2.get(i).getAttribute("href").toString();
				urlduplicate.add(url);

			}

		}
		if (urlduplicate.size() > 0) {
			duplicate = true;
		}
		System.out.println(duplicate);
		// pagination dupllcaite check
		Assert.assertEquals(duplicate, false);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement filter1 = driver.findElement(By.xpath("//*[@id=\"p_89/Amazon Essentials\"]"));
		filter1.click();
		// Assert.assertEquals(filter1.getText(), "Amazon Essentials");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement brand1 = driver.findElement(By.xpath("//*[@id=\"p_89/Hanes\"]/span/a/div"));
		brand1.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		// System.out.println(driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[1]")).getText());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement clear = driver
				.findElement(By.cssSelector("#brandsRefinements > ul > li.a-spacing-micro.s-list-item > span > a"));
		clear.click();

		WebElement filter = driver.findElement(By.xpath("//*[@id=\"p_89/Amazon Essentials\"]/span/a/div"));
		filter.click();
		System.out.println(filter.getText());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("s-asin")));
		List<WebElement> prod1 = driver.findElements(By.className("s-asin"));
		System.out.println(prod.get(0).getText());
		String result = "Amazon Essentials";
		Assert.assertTrue(prod1.get(0).getText().contains(result));

		driver.close();
	}

}
