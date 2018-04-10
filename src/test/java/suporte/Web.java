package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Web {
	
	 public static final String USERNAME = "moisezdantas1";
	  public static final String AUTOMATE_KEY = "iUThuB8d3FTKds7g5qsp";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static WebDriver createChrorme() {
		System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();

		// Timeout
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.get("http://www.juliodelima.com.br/taskit/");
		
		return navegador;
	}
	public static WebDriver createBrowserStack() {
		  DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("browser", "Chrome");
	        caps.setCapability("browser_version", "60.0");
	        caps.setCapability("os", "Windows");
	        caps.setCapability("os_version", "10");
	        caps.setCapability("resolution", "1280x800");
	        caps.setCapability("browserstack.debug", "true");

	    WebDriver navegador = null;
		try {
			navegador = new RemoteWebDriver(new URL(URL), caps);
			navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			navegador.get("http://www.juliodelima.com.br/taskit/");
			
		} catch (MalformedURLException e) {
			System.out.println("Houveram problemas com a URL: " + e.getMessage());
		}
		
		return navegador;

	}
}
