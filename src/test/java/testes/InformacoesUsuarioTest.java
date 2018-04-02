package testes;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {

	@Test
	public void testAdicionarUmaInformacaoAdicionarUsuario() {
		System.setProperty("webdriver.chrome.driver", "/opt/selenium/chromedriver");
		
		WebDriver navegador = new ChromeDriver();
		
		navegador.get("http://www.juliodelima.com.br/taskit/");
		
		navegador.manage().window().maximize();
		
		
		
		assertEquals(1, 1);
	}
}
