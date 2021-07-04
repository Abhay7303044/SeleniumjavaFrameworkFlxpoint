package singh.abbey;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class PublishProduct extends Base {
	
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void intallizationTheBrowser() throws InterruptedException, IOException {

		driver = initalizeDriver();

	}
	
	@Test(dataProvider = "getData_6", priority = 1, groups = { "Regression" })
	public void publish(String channels, String Listingstatus, String ChannelName) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@href='/products/virtuals/variants']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/products/listings/variants']")).click();
		Thread.sleep(3000);
		
		List<WebElement> element = driver.findElements(By.xpath("(//div[@class='items'])[7]/div[@class='item']"));
		for (WebElement webelement : element) {
			if (webelement.getText().contains(channels)) {
				webelement.click();
				break;
			}
		}
		Thread.sleep(3000);
		
		
		List<WebElement> element1 = driver.findElements(By.xpath("(//div[@class='items'])[2]/div[@class='item']"));
		for (WebElement webelement1 : element1) {
			if (webelement1.getText().contains(Listingstatus)) {
				webelement1.click();
				break;
			}
		}
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='action-icon is-header']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[@class='menu-item'])[2]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='submenu']/div")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='buttons is-centered']/button[@class='button is-primary']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@class='button is-primary search-action-button']")).click();
		Thread.sleep(1000);
		
		WebElement element2=	driver.findElement(By.xpath("//select[@name='channel_id']"));
		Select select1 = new Select(element2);
		select1.selectByVisibleText(ChannelName);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@class='button is-warning'])[2]")).click();
		Thread.sleep(3000);
		
}

	@DataProvider
	public Object[][] getData_6() {
		Object[][] data = new Object[1][3];

		data[0][0] = "Shopify";
		data[0][1] = "Not Listed";
		data[0][2] = "Shopify";
		
		

		return data;
	}
	
}




























