package singh.abbey;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class SourceCreate extends Base{

	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void intallizationTheBrowser() throws InterruptedException, IOException {
		
		driver = initalizeDriver();
			
	}

	@Test(dataProvider = "getData_4", priority = 1, groups = { "Regression" })
	public void Sourcecreate(String source, String sourceName, String vendor, String description) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='/sources']")).click();
		driver.findElement(By.xpath("//button[@class='button is-primary']")).click();

		WebElement element = driver.findElement(By.xpath("//select[@name='type']"));
		Select select = new Select(element);
		select.selectByVisibleText(source);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(sourceName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Create New Vendor']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@name='name'])[2]")).sendKeys(vendor);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@class='textarea']")).sendKeys(description);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='button button is-primary is-medium']")).click();
		Thread.sleep(5000);
		 }
		
	@DataProvider
	public Object[][] getData_4() {
		Object[][] data = new Object[1][4];

		data[0][0] = "Data Source";
		data[0][1] = "Rohit";
		data[0][2] = "shiva";
		data[0][3] = "This is a testing demo source.";
		

		return data;
	}
	

		 @AfterMethod 
		 public void CloseTheBrowser() {
			 driver.close();
		 

	}

}