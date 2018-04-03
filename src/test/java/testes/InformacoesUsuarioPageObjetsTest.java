package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import suporte.Web;

public class InformacoesUsuarioPageObjetsTest {

	private WebDriver navegador;
	
	@Before
	public void setUp() {
		navegador = Web.createChrorme();
		
	}
	
	@Test
	public void testAdicionarUmaInformacaoAdcionalDoUsuario() {
		new LoginPage(navegador)
		.clicarSignIn()
		.fazerLogin("julio0001", "123456")
		.clicarMe()
		.clicarAbaMoreDataAboutYou()
		.clicarBotaoAdMoreDataAboutYou();
	}
	
	@After
	public void tearDown() {
		navegador.quit();
	}
}
