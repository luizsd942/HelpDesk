package managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.Atendente;
import bean.Usuario;

@ManagedBean(name="atendenteMB")
@SessionScoped
public class AtendenteBean implements Serializable{
	
	public AtendenteBean(){
	}

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{localizadorMB}")
	private LocalizadorBean gerenciarLocalizador = new LocalizadorBean();
	
	
	@ManagedProperty(value="#{chatMB}")
	private ChatBean chat;
	
	private Atendente atendente = new Atendente();
	private boolean autenticado;
	
	public void signIn(){
		if(atendente.getLogin().equals(atendente.getSenha())){
			gerenciarLocalizador.getGerenciador().addAtendente(atendente);
			setAutenticado(true);
		}
		else{
			FacesMessage msgm = new FacesMessage("Login ou Senha inválidos.");
			FacesContext.getCurrentInstance().addMessage(null, msgm);
		}
	}
	
	public void signOut(){
		gerenciarLocalizador.getGerenciador().removeAtendente(atendente);
		atendente = new Atendente();
		setAutenticado(false);
	}
	
	public void startChat(){
		Usuario usuario = gerenciarLocalizador.getGerenciador().getProxUsuario();
		String chatId = usuario.getEmail();
		gerenciarLocalizador.getGerenciador().createChat(chatId);
		chat.reset(chatId, atendente.getLogin());
	}
	
	
	public LocalizadorBean getGerenciarLocalizador() {
		return gerenciarLocalizador;
	}

	public void setGerenciarLocalizador(LocalizadorBean gerenciarLocalizador) {
		this.gerenciarLocalizador = gerenciarLocalizador;
	}

	public ChatBean getChat() {
		return chat;
	}

	public void setChat(ChatBean chat) {
		this.chat = chat;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public boolean isAutenticado() {
		return autenticado;
	}
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
	
	
}