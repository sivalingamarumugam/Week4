package week4.day1.classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTextToChange {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element= driver.findElement(By.xpath("//button[@id='btn']"));
		wait.until(ExpectedConditions.textToBePresentInElement(element, "Click ME!"));
		element.click();

	}

}
