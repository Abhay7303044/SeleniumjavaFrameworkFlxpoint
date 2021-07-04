package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	
	public Properties prop;
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public  WebDriver initalizeDriver() throws IOException {

 prop = new Properties();	

FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

	prop.load(fis);
	
 String browserName=	prop.getProperty("browser");
//	String browserName=	System.getProperty("browser");

if(browserName.contains("chrome"))
{
	System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	
	if(browserName.contains("headless"))
	{
	options.addArguments("headless");
	} 
	 driver=new ChromeDriver(options);
}
else if (browserName.equals("firefox"))
{
  driver= new FirefoxDriver();
}
else if (browserName.equals("IE"))
{
	System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");  
	driver=new InternetExplorerDriver();  
}
driver.manage().window().maximize();

log.info("Driver is intialized");

driver.get(prop.getProperty("url"));
log.info("Navigate to landingPage");

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
return driver;
	}
		
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
	
		
	
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src,new File(destinationFile));
	
		
		return destinationFile;

		
	}	
	
}
