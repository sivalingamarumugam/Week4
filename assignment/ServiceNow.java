package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.get("https://dev60453.service-now.com/");
		driver.switchTo().frame("gsft_main");
		//driver.findElement(By.id("user_name")).sendKeys("admin",Keys.TAB,"India@123",Keys.ENTER);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='filter']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("change");
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit' and text()='New']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Normal')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Normal')]")).click();
		driver.findElement(By.id("change_request.number")).click();
		String changeReqNumber= driver.findElement(By.id("change_request.number")).getAttribute("value");
		System.out.println(changeReqNumber);
		driver.findElement(By.xpath("//input[@id='change_request.short_description']/following::a")).click();
		String parentTab=driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();
		for (String tab : tabs) {
			if(!tab.equals(parentTab))
				driver.switchTo().window(tab);
		}
		driver.manage().window().maximize();
		String shortDesc = driver.findElement(By.xpath("//td/a")).getText();
		System.out.println(shortDesc);
		driver.findElement(By.xpath("//td/a")).click();
		driver.switchTo().window(parentTab);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@value='sysverb_insert']")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(changeReqNumber,Keys.ENTER);
		String issueText = driver.findElement(By.xpath("//td[text()='"+shortDesc+"']")).getText();
		System.out.println(issueText);
		if(issueText.equals(shortDesc)) {
			System.out.println("successful creation of change");
		}
		else
		{
			System.out.println("unsuccessful of creation of change");
		}
	driver.close();
	}
	

}
