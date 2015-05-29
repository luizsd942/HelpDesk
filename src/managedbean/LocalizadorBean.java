package managedbean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import negocios.GerenciadorHelpDesk;

@ManagedBean(name="localizadorMB")
@ApplicationScoped
public class LocalizadorBean {
	
	public LocalizadorBean() {
		gerenciador = new GerenciadorHelpDesk();
	}
	private GerenciadorHelpDesk gerenciador;

	public void setGerenciador(GerenciadorHelpDesk gerenciador) {
		this.gerenciador = gerenciador;
	}
	public LocalizadorBean(GerenciadorHelpDesk gerenciador) {
		gerenciador = new GerenciadorHelpDesk();
	}
	public GerenciadorHelpDesk getGerenciador() {
		return gerenciador;
	}
}