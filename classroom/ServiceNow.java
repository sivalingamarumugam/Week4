package week4.day2.classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceNow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev60453.service-now.com/");
		driver.switchTo().frame("gsft_main");
		//driver.findElement(By.id("user_name")).sendKeys("admin",Keys.TAB,"India@123",Keys.ENTER);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();	
		System.out.println(driver.getTitle());
		driver.close();
	}

}
