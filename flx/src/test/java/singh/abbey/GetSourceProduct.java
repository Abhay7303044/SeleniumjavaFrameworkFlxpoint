package singh.abbey;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class GetSourceProduct extends Base {

	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	
	public void intallizationTheBrowser() throws InterruptedException, IOException {
		
		driver = initalizeDriver();
	}
	
	@Test(dataProvider = "getData_5", priority = 1, groups = { "Regression" })
	public void Gsp(String sourceName, String ConnectionName, String MappingTemplate) throws InterruptedException {
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys(prop.getProperty("username"));
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[@href='/sources']")).click();
	Thread.sleep(2000);
	

	
	List<WebElement> option = driver.findElements(By.xpath("//td[@class='is-skinny-no-wrap']/strong[@class='title is-size-6']"));
	for (int i = 0; i < option.size(); i++) {
		if (option.get(i).getText().contains("Rohit")) {
			
			driver.findElements(By.xpath("//a[@class='button is-medium']")).get(i).click();
			break;
		}
	}
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//li[@class='sidebar-menu-item']/a)[2]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[@class='sidebar-menu-item'])[2]/ul/li")).click();
	Thread.sleep(1000);
	
	
//	driver.findElement(By.xpath("//button[@class='button is-primary']")).click();
//	driver.findElement(By.xpath("//span[text()='Create an Integration']")).click();
	
	WebElement element=	driver.findElement(By.xpath("//select[@name='integrationTypeId']"));
	Select select = new Select(element);
	select.selectByVisibleText(sourceName);
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//h5)[2]")).click();
	Thread.sleep(1000);
	
	WebElement element1=	driver.findElement(By.xpath("//select[@name='connectionId']"));
	Select select1 = new Select(element1);
	select1.selectByVisibleText(ConnectionName);
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//span[text()='Test Connection']")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//h5)[3]")).click();
	Thread.sleep(1000);
	
	WebElement element2=	driver.findElement(By.xpath("//select[@name='mapping_event_id']"));
	Select select2 = new Select(element2);
	select2.selectByVisibleText(MappingTemplate);
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//h5)[4]")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[@class='button button is-info']")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("(//h5)[4]")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//div[@class='button is-primary'])[2]")).click();
	Thread.sleep(9000);
	
	}	
	
	@DataProvider
	public Object[][] getData_5() {
		Object[][] data = new Object[1][3];

		
		data[0][0] = "Shopify";
		data[0][1] = "Shopify Test";
		data[0][2] = "Shopify test template";
		

		return data;
	}
	
	
	
	
	
	
}