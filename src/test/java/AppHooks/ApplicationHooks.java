package AppHooks;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	@Before(order =0)
	public void getproperty() {
		configreader=new ConfigReader();
		prop=configreader.init_prop();
		}
	
	
		
		@Before(order =1)
			public void launchBrowser() {
			String browsername=prop.getProperty("browser");
			driverfactory=new DriverFactory();
			driver=driverfactory.init_driver(browsername);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
			
			@After(order=0)
			public void quitbrowser() {
				driver.quit();
			}
			
			@After(order=1)
			public void Teardown(Scenario sc) {
				
				if(sc.isFailed())
				{
					//take screenshot
					String screenshotname=sc.getName().replaceAll(" ", "_");
					byte [] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
					sc.attach(sourcepath,"image/png",screenshotname);
					
				}
			}
			
			
					
			
		
	
	
	
	
	

}
