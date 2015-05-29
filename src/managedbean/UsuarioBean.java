package managedbean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import bean.Usuario;

@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioBean implements Serializable{
	
	public UsuarioBean() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{localizadorMB}")
	private LocalizadorBean gerenciarLocalizador = new LocalizadorBean();
	
	@ManagedProperty(value="#{chatMB}")
	private ChatBean chat;
	
	private Usuario usuario = new Usuario();
	private boolean autenticado;
	
	public void signIn(){
		setAutenticado(true);
	}
	
	public void signOut(){
		gerenciarLocalizador.getGerenciador().removeUsuario(usuario);
		usuario = new Usuario();
		setAutenticado(false);
	}
	
	public int getPosicaoUsiario() {
		return gerenciarLocalizador.getGerenciador().getPosicaoUsuario(usuario) + 1;
	}
	
	public void startChat(){
		gerenciarLocalizador.getGerenciador().addUsuario(usuario);
		chat.reset(usuario.getEmail(), usuario.getNome());
	}
	
	
	public boolean isAutenticado() {
		return autenticado;
	}
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
