package week4.day2.assignment;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		WebElement brand = driver.findElement(By.xpath("//a[@href='#' and text()='brands']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(brand).perform();
		WebElement popular = driver.findElement(By.xpath("//a[text()='Popular']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Popular']")));
		ac.moveToElement(popular).perform();
		driver.findElement(By.xpath("//a[@href='/brands/loreal-paris/c/595?eq=desktop']")).click();
		String parentTab = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();
		for (String tab : tabs) {
			if(!tab.equals(parentTab))
				driver.switchTo().window(tab);
			
		}
		System.out.println(driver.getTitle());
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='POPULARITY']/following::span")));
		driver.findElement(By.xpath("//span[@title='POPULARITY']/following::span")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Category']/following::div")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Category']/following::div")).click();;
		driver.findElement(By.xpath("//label[@for='chk_Shampoo_undefined']/div")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='listing-img'])[1]")));
		driver.findElement(By.xpath("(//img[@class='listing-img'])[1]")).click();
		String parentTab1 = driver.getWindowHandle();
		Set<String> tabs_1= driver.getWindowHandles();
		for (String tab : tabs_1) {
			if(!tab.equals(parentTab1))
				driver.switchTo().window(tab);			
		}
		driver.findElement(By.xpath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ']")).click();
		driver.findElement(By.xpath("//div[@class='AddToBagbox']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn full fill no-radius proceed ']")));
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		System.err.println("Error message : "+driver.findElement(By.xpath("//div[@class='popup-error']")).getText());
		driver.quit();

	}

}
