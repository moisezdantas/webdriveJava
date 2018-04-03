package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	
	public static WebDriver createChrorme() {
		System.setProperty("webdriver.chrome.driver", "C:\\java\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();

		// Timeout
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.get("http://www.juliodelima.com.br/taskit/");
		
		return navegador;
	}
}
