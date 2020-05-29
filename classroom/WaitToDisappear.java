package week4.day1.classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitToDisappear {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/disapper.html");
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement button = driver.findElement(By.xpath("//button[@id='btn']/b[contains(text(),'Keep looking at me!!')]"));
		wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(button)));
		System.out.println(driver.findElement(By.xpath("//div[@id='show']//strong")).getText());

	}

}
