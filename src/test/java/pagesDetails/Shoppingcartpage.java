package pagesDetails;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Shoppingcartpage {

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

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 12 case");
		driver.findElement(By.id("nav-search-submit-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-price-whole")));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().deleteAllCookies();
		// click on product
		driver.get(
				"https://www.amazon.ca/JETech-iPhone-6-1-Inch-Shockproof-Anti-Scratch/dp/B07QS4NMW6/ref=sr_1_1_sspa?crid=WBC2D3X64YW0&keywords=iphone+12+case&qid=1698873167&sprefix=iphone+12+case%2Caps%2C209&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");

		// wait for page load

		// click on size

		Actions ac1 = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-12-announce\"]")));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"a-autoid-12-announce\"]")));

		ac1.moveToElement(driver.findElement(By.xpath("//*[@id=\"a-autoid-12-announce\"]"))).build().perform();
		System.out.print("button clicked");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-12-announce\"]")));

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"a-autoid-12-announce\"]")));

//			  //click on add to cart
		ac.moveToElement(driver.findElement(By.id("submit.add-to-cart"))).click().build().perform();
		System.out.print("cart clciked");
//			  //page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//			  //click on cart
		WebElement carticon = driver.findElement(By.id("nav-cart-count"));
		carticon.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		// count quantity of cart
		WebElement Quantity = driver.findElement(By.id("sc-subtotal-label-activecart"));
		Assert.assertEquals(Quantity.getText(), "Subtotal (1 item):");
		// count price details
		WebElement pricedetails = driver.findElement(By.className("sc-price"));
		// Assert.assertEquals(pricedetails.getText(), "$12.99");

		// cart click on quantity
		ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]"))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity_2")));
		ac.moveToElement(driver.findElement(By.id("quantity_2"))).click().build().perform();

		// check quantity increased
		Assert.assertEquals(Quantity.getText(), "Subtotal (2 item):");
		Assert.assertEquals(pricedetails.getText(), "$25.98");

		// search product add to cart
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("towels large");
		driver.findElement(By.id("nav-search-submit-button")).click();

		driver.get(
				"https://www.amazon.ca/Polyte-Professional-Quick-Microfiber-Drying/dp/B07NVWR2R7/ref=sr_1_1_sspa?crid=2L58G9VSYB6IM&keywords=towles+large&qid=1698878484&sprefix=towles+large%2Caps%2C231&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
		Select option = new Select(driver.findElement(By.id("quantity")));
		option.selectByValue("4");

		WebElement options = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		options.click();
		WebElement option4 = driver.findElement(By.xpath("//*[@id=\"quantity\"]/option[4]"));
		option4.click();
		ac.moveToElement(driver.findElement(By.id("submit.add-to-cart-announce"))).click().build().perform();
		System.out.print("cart clciked");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"sw-atc-details-single-container\"]")));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("note");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.get(
				"https://www.amazon.ca/AmazonBasics-Writing-Narrow-Orchid-6-Pack/dp/B07TQ8567K/ref=sr_1_1_ffob_sspa?crid=3GT96THI13LBW&keywords=note&qid=1698883890&sprefix=note%2Caps%2C293&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		ac.moveToElement(driver.findElement(By.id("submit.add-to-cart"))).click().build().perform();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"sw-atc-details-single-container\"]")));
		WebElement carticon1 = driver.findElement(By.id("nav-cart-count"));
		carticon1.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement Quantityadd = driver.findElement(By.id("//*[@id=\"sw-atc-details-single-container\"]"));
		WebElement Quantityadd1 = driver.findElement(By.id("sc-subtotal-label-activecart"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Assert.assertEquals(Quantityadd1.getText(), "Subtotal (4 items):");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement towelprice = driver.findElement(By.id("sc-subtotal-amount-buybox"));
		Assert.assertEquals(towelprice.getText(), "$128.89");

		// remove all items
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement deletebtm = driver
				.findElement(By.cssSelector("span.a-size-small:nth-child(3) > span:nth-child(1) > input:nth-child(1)"));
		deletebtm.click();
		WebElement Empty = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div/h1"));

		Assert.assertEquals(Empty.getText(), "Your Amazon Cart is empty.");

		// delete particular item
		WebElement deletebtm1 = driver.findElement(By
				.xpath("//*[@id=\"sc-active-921af05e-16a6-4be4-ada9-f1f7f254c9e6\"]/div[4]/div/div[3]/div[1]/span[2]"));
		deletebtm1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-subtotal-amount-buybox\"")));
		WebElement towelprice1 = driver.findElement(By.id("sc-subtotal-amount-buybox"));

		List<WebElement> cartList = driver.findElements(By.cssSelector("#sc-active-cart .sc-action-delete input"));
		/*
		 * if(cartitem.size()>0) { for(int i=0;i<cartList.size();i++) {
		 * cartitem.get(i).click(); } }
		 */

		while (cartList.size() > 0) {
			WebElement item = cartList.get(0);
			item.click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			cartList = driver.findElements(By.cssSelector("#sc-active-cart .sc-action-delete input"));

		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		WebElement Empty1 = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div/h1"));
		Assert.assertEquals(Empty1.getText(), "Your Amazon Cart is empty.");

		Assert.assertEquals(towelprice.getText(), "$113.56");

	}

}
