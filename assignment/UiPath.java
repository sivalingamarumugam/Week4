package week4.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiPath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		driver.findElement(By.id("buttonLogin")).click();
		Actions ac = new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=' Vendors']")));
		WebElement vendor = driver.findElement(By.xpath("//button[text()=' Vendors']"));
		ac.moveToElement(vendor).perform();
		WebElement search_vendor = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/vendors/search']"))));
		search_vendor.click();
		driver.findElement(By.id("vendorName")).sendKeys("Blue Lagoon");
		driver.findElement(By.id("buttonSearch")).click();
		String country = driver.findElement(By.xpath("//table[@class='table']//tr/td[5]")).getText();
		System.out.println(country);
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
		

	}

}
