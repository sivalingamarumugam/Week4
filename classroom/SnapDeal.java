package week4.day1.classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");		
		WebElement mensFashion = driver.findElementByXPath("(//span[contains(text(),'Men')])[2]");
		Actions builder = new Actions(driver);
		builder.moveToElement(mensFashion).perform();
		WebDriverWait wait = new WebDriverWait(driver,120);
		WebElement element = driver.findElementByXPath("(//a[@href='https://www.snapdeal.com/products/men-apparel-shirts'])[1]");
		/*
		 * wait.until(ExpectedConditions.visibilityOf(element));
		 * wait.until(ExpectedConditions.elementToBeClickable(element));
		 */
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", element);		
		WebElement shirt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='product-title'][1]")));
		builder.moveToElement(shirt).perform();
		WebElement quickView = driver.findElementByXPath("(//div[@class='clearfix row-disc']//div)[1]");
		quickView.click();
		driver.close();

	}

}
