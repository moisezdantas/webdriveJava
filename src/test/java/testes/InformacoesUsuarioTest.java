package testes;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshort;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTeste.csv")
public class InformacoesUsuarioTest {
	private WebDriver navegador;
	
	@Rule
	public TestName test = new TestName();
	
	@Before
	public void setUp() {
		navegador = Web.createChrorme();
		
		// Clicar no link que peossui o texto "Sign in"
		navegador.findElement(By.linkText("Sign in")).click();

		// Identificando o formulario de login
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

		// Digitar no campo com nome "login" que está detrno do formulário de id
		// "signinbox" o texto "julio001"
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

		// Digitar no campo com nome "password" que está detrno do formulário de id
		// "signinbox" o texto "123456"
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

		// Clicar no link com o texto "SIGN IN"
		navegador.findElement(By.linkText("SIGN IN")).click();

		// Clicar em um link que possui a class "me"
		navegador.findElement(By.className("me")).click();

		// Clicar em um link que possue o texto "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
	}
	
	//@Test
	public void testAdicionarUmaInformacaoAdicionarUsuario() {
		
		//Clicar em um botao atraves do xpath
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		//Identificar a poup onde esta o formulario de id addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		
		//No combo de name type escoler opção "Phone"
		WebElement campoType =popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");;
		
		//No campo de name "contact" digitar o telefone + 55119999999999
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511999999999");
		
		//Clicar no lonk de text "SAVE" que está na popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		
		//No mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
		String message = navegador.findElement(By.id("toast-container")).getText(); 
		assertEquals("Your contact has been added!", message);
	}
	
	@Test
	public void testAdicionarUmaInformacaoAdcionalDoUsuario(@Param(name="tipo")String tipo,@Param(name="contato")String contato, @Param(name="mensagem")String mensagemEsperada) {
		//clicar no elemento pelo seu path //button[data-target=\"addmoredata\"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		// Identificar a popup onde está o formulario de id addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata")); 
		
		//No combo de nome "type" escolhe a opção "Phone"
		WebElement campoType = navegador.findElement(By.name("type")); 
		new Select(campoType).selectByVisibleText(tipo);
		
		//No campo de name "contact" digitar "+5511999999999"
		popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);
		
		//Clicar no link de text "SAVE" que está na poup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
				
		//Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!";
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		
		assertEquals(mensagemEsperada, mensagem);
		
	}
	
	@Test
	public void removerContatoUsuario(@Param(name="telefone")String telefone, @Param(name="mensagem")String mensagemEsperada) {
		//clicar no elemento pelo seu path //span[text()="+5511999999999"]/flollowing-sibling::a
		navegador.findElement(By.xpath("//span[text()=\""+ telefone +"\"]/following-sibling::a")).click();
		
		// Confirmar janela script
		navegador.switchTo().alert().accept();
		
		//Validar que a mensagem apresentada foi Rest in peace, dear phone!
		WebElement messagemPop = navegador.findElement(By.id("toast-container")); 
		String messagem = messagemPop.getText();
		assertEquals("Rest in peace, dear phone!", messagem);
		
		String screenshortArquivo = "C:\\logs\\" + Generator.dataHoraParaArquivo() +  test.getMethodName() + ".png";
		
		Screenshort.tirar(navegador, screenshortArquivo);
		
		//Aguardar até 10 segundos para que a janela desapareca
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(messagemPop));
		
		//Clicar no link com texto "logout" 
		navegador.findElement(By.linkText("Logout")).click();	
	}
	
	@After
	public void tearDown() {
		//fechar browser
		//navegador.close();
	}
	
}
