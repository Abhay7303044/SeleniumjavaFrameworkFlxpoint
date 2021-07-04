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
import org.testng.annotations.Test;

import resources.Base;

public class CreateAndDeleteChannel extends Base {

	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void intallizationTheBrowser() throws InterruptedException, IOException {

		driver = initalizeDriver();

	}

	@Test()
	public void IntegrationChannel() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
	//------------   create the channel -------
		
		driver.findElement(By.xpath("//a[@href='/channels']")).click();
		driver.findElement(By.xpath("//button[@class='button is-primary']")).click();

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Shopify Test13");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//textarea[@class='textarea']")).sendKeys("Testing demo");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='button button is-primary is-medium']")).click();
		Thread.sleep(5000);

		List<WebElement> option = driver
				.findElements(By.xpath("//tr[@class='integrations-col']/td[@class='is-skinny-no-wrap']"));
		for (int i = 0; i < option.size(); i++) {
			if (option.get(i).getText().contains("Shopify Test13")) {

				driver.findElements(By.xpath("//a[@class='button is-medium']")).get(i).click();
				break;
			}
		}
		
		// -----------   Select the publish product and overwrite the data ------------------

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@class='sidebar-menu-item'])[5]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@class='sidebar-menu-item'])[5]/div[2]/ul/li[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='button is-primary']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		
		// ----- Select the Shopify channel ---------------
		
		driver.findElement(By.xpath("//div[@id='5']")).click();
		Thread.sleep(1000);
		
		/*	driver.findElement(By.xpath("//button[@class='button m-l-md']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class='connectionTab'])[2]")).click();
		Thread.sleep(1000);
		
		//----------- create the connection -------------------------
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Shopify connection3");

		WebElement conElement = driver.findElement(By.xpath("//select[@name='connection']"));
		Select connection = new Select(conElement);
		connection.selectByVisibleText("API- Basic Auth");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='location-id']")).sendKeys("31558172720");
		driver.findElement(By.xpath("//input[@name='api-key']")).sendKeys("c8531a40b196f718fdafb5b208d08a56");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("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");
		driver.findElement(By.xpath("//input[@name='store-url']")).sendKeys("HTTPS://{YOUR-SHOP-NAME}.MYSHOPIFY.COM");
		
		driver.findElement(By.xpath("//span[text()='Test Connection']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//button[@class='button button is-primary is-medium'])[2]")).click();
		Thread.sleep(2000);   */
		
		
		
				driver.findElement(By.xpath("//div[@class='connection-tile']")).click();  
		
			
		
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@type='button']")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	Thread.sleep(4000);
	
	//----------------------- select a mapping template ---------------------
	
	WebElement mapElement = driver.findElement(By.xpath("//div[@class='select is-fullwidth']/select[@name='mapping_event_id']"));
	Select mapSelect = new Select(mapElement);
	mapSelect.selectByVisibleText("Shopify Publish Products");
	Thread.sleep(3000);  
	
	driver.findElement(By.xpath("//button[@class='button button is-primary is-medium m-t-lg']")).click();
	Thread.sleep(3000);
	
	//---------------------delete the channel-----------------------------
	
	driver.findElement(By.xpath("(//li[@class='sidebar-menu-item'])[8]")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@class='button is-warning is-medium']")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("DELETE CHANNEL");
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[@class='button is-danger is-medium m-t-md is-right']")).click();
	Thread.sleep(1000);
	
	}
	}	
	

