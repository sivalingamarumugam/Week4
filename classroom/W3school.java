package week4.day2.classroom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3school {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.driver.silentOutput","true");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		String input = "Siva";
		alert.sendKeys(input);
		alert.accept();
		String outPut = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(outPut);
		if(outPut.contains(input))
		{
			System.out.println(outPut+ "contains :" +input);
		}
		else
		{
			System.out.println("not contain");
		}
		
driver.close();
	}

}
