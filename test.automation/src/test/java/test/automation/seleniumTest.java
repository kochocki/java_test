package test.automation;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumTest {
	static WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 10);

	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://swiatbaterii.pl/");
	}

	@Before
	public void goToUrl() {
		driver.get("http://swiatbaterii.pl/");
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void addToBasket() throws IOException {
		WebElement search = driver.findElement(By.id("search_query_top"));
		search.sendKeys("t500");

		WebElement searchButton = driver.findElement(By
				.className("button_mini"));
		searchButton.click();

		WebElement product = driver.findElement(By
				.xpath(".//*[@id='product_list']/li[1]/div[1]/h3/a"));
		wait.until(ExpectedConditions.elementToBeClickable(product));
		product.click();

		WebElement addToCart = driver.findElement(By
				.xpath(".//*[@id='add_to_cart']/input"));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();

		WebElement comeBack = driver.findElement(By
				.xpath(".//*[@id='content']/a[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(comeBack));
		comeBack.click();

		WebElement shoppingCart = driver.findElement(By
				.xpath(".//*[@id='shopping_cart']/a/span[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
		shoppingCart.click();

		WebElement productInBasket = driver.findElement(By
				.id("product_221_0_0_0"));

		wait.until(ExpectedConditions.elementToBeClickable(productInBasket));
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(
				"C:\\Users\\krzysztof\\Desktop\\screenshot.png"));
		assertTrue(productInBasket.isDisplayed());
	}

	@Test
	public void validateRegister() throws IOException, InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.className("reg")));
		driver.findElement(By.className("reg")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("email_create")));
		driver.findElement(By.id("email_create")).sendKeys("email@email.com");
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("SubmitCreate")));
		driver.findElement(By.id("SubmitCreate")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("submitAccount")));
		driver.findElement(By.id("submitAccount")).click();
		assertTrue(driver.findElement(By.className("error")).isDisplayed());

	}

	@Test
	public void changeLanguageTest() throws InterruptedException {
		String baseUrl = driver.getCurrentUrl();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("lng_gb")));
		driver.findElement(By.xpath(".//*[@id='lng_gb']/a")).click();
		while (baseUrl.equals(driver.getCurrentUrl()))
			;
		assertEquals("http://swiatbaterii.pl/gb/", driver.getCurrentUrl());
	}
}
