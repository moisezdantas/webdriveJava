package suporte;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshort {
	
	public static void tirar(WebDriver navegador, String arquivo) {
		File screenshort = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshort, new File(arquivo));
		} catch (IOException e) {
			System.out.println("Houveram problemas ao copiar o arquivo para pasta : " + e.getMessage());
		}
	}
}
