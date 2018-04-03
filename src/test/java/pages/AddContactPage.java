package pages;

import org.openqa.selenium.WebDriver;

public class AddContactPage extends BasePage {

	public AddContactPage(WebDriver navegador) {
		super(navegador);
	}
	
	public AddContactPage escolherTipoContato(String tipo) {
		
		return this;
	}
	
	public AddContactPage digitarContato(String contato) {
		
		return this;
	}

	public MePage clicarSalvar() {
		
		return new MePage(navegador);
	}
	
	public MePage adicionarContato(String tipo, String contato) {
		escolherTipoContato(tipo);
		digitarContato(contato);
		clicarSalvar();
		return new MePage(navegador);
	}
}
