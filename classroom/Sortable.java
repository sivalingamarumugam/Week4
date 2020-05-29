package week4.day1.classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		driver.switchTo().frame(0);
		WebElement item_1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item_4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		int x = item_4.getLocation().getX();
		int y = item_4.getLocation().getY();
		
		Actions builder = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		builder.dragAndDrop(item_1, item_4).perform(); it is not working
		builder.dragAndDropBy(item_1, x, y).perform();
	}

}
