package week4.day1.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		ChromeOptions defaultAlert = new ChromeOptions();
//		defaultAlert.addArguments("--disable-notifications-");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/shop/women']"))));
		WebElement women = driver.findElement(By.xpath("//a[@href='/shop/women']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(women).build().perform();
		WebElement jacket_coats = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/women-jackets-coats']"))));
		jacket_coats.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='title-count']")));
		String totalcount_text1 = driver.findElement(By.xpath("//span[@class='title-count']")).getText().replaceAll("items", "");
		String totalcount_text2 = totalcount_text1.replaceAll("- ", "").trim();
		int totalcount = Integer.parseInt(totalcount_text2);
		System.out.println(totalcount);
		String coatCount_text = driver.findElement(By.xpath("//input[@value='Coats']/following::span")).getText().replaceAll("\\p{P}", "");
		int coatCount = Integer.parseInt(coatCount_text);
		String jacketCount_text = driver.findElement(By.xpath("//input[@value='Jackets']/following::span")).getText().replaceAll("[\\[\\](){}]", "");
		int jacketCount = Integer.parseInt(jacketCount_text);
		if(totalcount==coatCount+jacketCount)
		{
			System.out.println("count matched");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Coats']/following::span")));
		driver.findElement(By.xpath("//input[@value='Coats']/following::span")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("FilterDirectory-searchInput"))));
		searchBox.sendKeys("MANGO");
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[@class=' common-customCheckbox']"))));
		checkbox.click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();		
//		List<WebElement> brand = driver.findElements(By.xpath("//div/h3[@class='product-brand']"));
//		Thread.sleep(2000);
//		System.out.println(brand.size());
//		for (WebElement webElement : brand) {			
//			String brandname = webElement.getText();
//			if(brandname.equalsIgnoreCase("MANGO")) {
//				System.out.println("coat brand is "+brandname);
//			}			
//		}
		List<WebElement> brandNames = driver.findElements(By.xpath("//div/h3[@class='product-brand']"));
		Thread.sleep(2000);
		int totalProd = brandNames.size();
		System.out.println(totalProd);
		int count = 0;

		for (int i =1;i<=brandNames.size()-1;i++) {
			//String eachBrandName = brandNames.get(i).getText();
			
			String eachBrandName = driver.findElement(By.xpath("(//div[@class='product-productMetaInfo']/h3)["+i+"]")).getText();
			if (eachBrandName.equalsIgnoreCase("MANGO"))
				count++;
			else
				System.out.println(eachBrandName);
			
		}
		System.out.println(count);
		ac.moveToElement(driver.findElement(By.xpath("//div[@class='sort-sortBy']"))).perform();
		
		WebElement discount = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[@class='sort-label ' and text()='Better Discount']"))));
		discount.click();
		Thread.sleep(1000);
		WebElement price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
		System.out.println(price.getText());
		ac.moveToElement(price).perform();
		WebElement wishList = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@class='product-actionsButton product-wishlist ']"))));
		wishList.click();
		driver.close();
	}
	
	
	}


