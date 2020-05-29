package week4.day1.classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitToAppear {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/appear.html");		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element= driver.findElement(By.xpath("//b[contains(text(),'here Guys')]"));
		wait.until(ExpectedConditions.textToBePresentInElement(element, "Voila! I'm here Guys"));
		String text_to_present = element.getText(); 
		System.out.println(text_to_present);

	}

}
