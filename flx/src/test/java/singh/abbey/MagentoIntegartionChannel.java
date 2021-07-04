package singh.abbey;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.Base;

public class MagentoIntegartionChannel extends Base {

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
		driver.findElement(By.xpath("//a[@href='/channels']")).click();
		driver.findElement(By.xpath("//button[@class='button is-primary']")).click();

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("abhi testing magento 2.8");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//textarea[@class='textarea']")).sendKeys("Testing demo");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='button button is-primary is-medium']")).click();
		Thread.sleep(5000);

		List<WebElement> option = driver
				.findElements(By.xpath("//tr[@class='integrations-col']/td[@class='is-skinny-no-wrap']"));
		for (int i = 0; i < option.size(); i++) {
			if (option.get(i).getText().contains("abhi testing magento 2.8")) {

				driver.findElements(By.xpath("//a[@class='button is-medium']")).get(i).click();
				break;
			}
		}

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@class='sidebar-menu-item']/a)[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[@class='sidebar-menu-item'])[5]/ul/li[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='button is-primary']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Create an Integration']")).click();
		Thread.sleep(1000);

		WebElement element3 = driver.findElement(By.xpath("//select[@name='integrationTypeId']"));
		Select select3 = new Select(element3);
		select3.selectByVisibleText("Magento"); // publish/overwrite
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='root_category']")).sendKeys("aa");
		driver.findElement(By.xpath("//input[@name='attribute_set_id']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name='store_view_code']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name='website_code']")).sendKeys("1");

		driver.findElement(By.xpath("(//h5)[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='button is-info']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("magento connection");

		WebElement element4 = driver.findElement(By.xpath("//select[@name='connection']"));
		Select select4 = new Select(element4);
		select4.selectByVisibleText("Magento API");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='store_url']")).sendKeys("http://flxpoint.a2hosted.com");
		driver.findElement(By.xpath("//input[@name='access_token']")).sendKeys("7bnxhglo7gn8ywxmd00hl157sl4dbri7");
		
		
		driver.findElement(By.xpath("//button[@class='button button is-primary is-medium']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Test Connection']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//h5)[3]")).click();
		Thread.sleep(1000);

		WebElement element5 = driver.findElement(By.xpath("//select[@name='mapping_event_id']"));
		Select select5 = new Select(element5);
		select5.selectByVisibleText("Magento publish template");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//h5)[4]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='button button is-info']")).click();
		Thread.sleep(5000);	
	
	//-----------------------------get order---------------------------------------------------------
		driver.findElement(By.xpath("(//li[@class='sidebar-menu-item'])[5]/ul/li[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='button is-primary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Create an Integration']")).click();
		Thread.sleep(3000);

		WebElement element9 = driver.findElement(By.xpath("//select[@name='integrationTypeId']"));
		Select select9 = new Select(element9);
		select9.selectByVisibleText("Magento");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//h5)[2]")).click();
		Thread.sleep(1000);

		WebElement element10=	driver.findElement(By.xpath("//select[@name='connectionId']"));
		Select select10 = new Select(element10);
		select10.selectByVisibleText("magento connection");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Test Connection']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//h5)[3]")).click();
		Thread.sleep(1000);

		WebElement element11 = driver.findElement(By.xpath("//select[@name='mapping_event_id']"));
		Select select11 = new Select(element11);
		select11.selectByVisibleText("Magento Get Orders Template");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//h5)[4]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='button button is-info']")).click();
		Thread.sleep(3000);
	//-----------------------sync order ------------------------------------------------
		
		driver.findElement(By.xpath("(//li[@class='sidebar-menu-item'])[5]/ul/li[3]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='button is-primary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Create an Integration']")).click();
		Thread.sleep(3000);

		WebElement element12 = driver.findElement(By.xpath("//select[@name='integrationTypeId']"));
		Select select12 = new Select(element12);
		select12.selectByVisibleText("Magento");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='comment']")).sendKeys("Testing");

		driver.findElement(By.xpath("(//h5)[2]")).click();
		Thread.sleep(1000);

		WebElement element13=	driver.findElement(By.xpath("//select[@name='connectionId']"));
		Select select13 = new Select(element13);
		select13.selectByVisibleText("magento connection");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Test Connection']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//h5)[3]")).click();
		Thread.sleep(1000);

		WebElement element14 = driver.findElement(By.xpath("//select[@name='mapping_event_id']"));
		Select select14 = new Select(element14);
		select14.selectByVisibleText("Magento Sync Orders Template");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//h5)[4]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='button button is-info']")).click();
		Thread.sleep(3000);
		
		//-------------------------sync product ------------------------------------
		
				driver.findElement(By.xpath("(//li[@class='sidebar-menu-item'])[5]/ul/li[4]")).click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//button[@class='button is-primary']")).click();
				Thread.sleep(3000);	
				driver.findElement(By.xpath("//span[text()='Create an Integration']")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//span[@class='icon']")).click();
				Thread.sleep(1000);

				WebElement element6 = driver.findElement(By.xpath("//select[@name='integrationTypeId']"));
				Select select6 = new Select(element6);
				select6.selectByVisibleText("Magento");
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//input[@name='store_view_code']")).sendKeys("1");

				driver.findElement(By.xpath("(//h5)[2]")).click();
				Thread.sleep(1000);

				WebElement element7=	driver.findElement(By.xpath("//select[@name='connectionId']"));
				Select select7 = new Select(element7);
				select7.selectByVisibleText("magento connection");
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//span[text()='Test Connection']")).click();
				Thread.sleep(1000);

				driver.findElement(By.xpath("(//h5)[3]")).click();
				Thread.sleep(1000);

				WebElement element8 = driver.findElement(By.xpath("//select[@name='mapping_event_id']"));
				Select select8 = new Select(element8);
				select8.selectByVisibleText("Magento Sync Products Template");
				Thread.sleep(1000);

				driver.findElement(By.xpath("(//h5)[4]")).click();
				Thread.sleep(1000);

				driver.findElement(By.xpath("//button[@class='button button is-info']")).click();
				Thread.sleep(3000);
	
	
}
	 @AfterMethod 
	 public void CloseTheBrowser() {
		 driver.close();
}	
}

