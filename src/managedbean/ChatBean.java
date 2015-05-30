package managedbean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import bean.Chat;
import bean.Mensagem;

@ManagedBean(name="chatMB")
@SessionScoped
public class ChatBean implements Serializable{
	
	public ChatBean() {
	}
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{localizadorMB}")
	private LocalizadorBean gerenciarLocalizador;
	
	private int ultimaMensagem = 0;
	private String mensagem;
	private String chatId;
	private String nomeUsuario;
	
	public boolean isReady() {
		return gerenciarLocalizador.getGerenciador().haschat(getChatId());
	}
	
	public Chat getChat() {
		return gerenciarLocalizador.getGerenciador().getChat(chatId);
	}
	
	public void close() {
		gerenciarLocalizador.getGerenciador().closeChat(getChatId());
		reset(null, null);
	}
	
	public void enviarMensagem() {
		getChat().addMensagem(getMensagem(), getNomeUsuario());
		setMensagem("");
	}
	
	public List<Mensagem> getMensagens() {
		List<Mensagem> result = null;
		
		if (isReady()){
			result = getChat().getMensagens();
		}
		
		return result;
	}
	
	public void reset(String chatId, String nomeUsuario){
		setUltimaMensagem(0);
		setChatId(chatId);
		setNomeUsuario(nomeUsuario);
		setMensagem("");
	}
	
	public LocalizadorBean getGerenciarLocalizador() {
		return gerenciarLocalizador;
	}
	public void setGerenciarLocalizador(LocalizadorBean gerenciarLocalizador) {
		this.gerenciarLocalizador = gerenciarLocalizador;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public int getUltimaMensagem() {
		return ultimaMensagem;
	}
	public void setUltimaMensagem(int ultimaMensagem) {
		this.ultimaMensagem = ultimaMensagem;
	}
	
	public void recuperarUltimaMensagem(){
		
		try{
			RequestContext context = RequestContext.getCurrentInstance();
			if(isReady()){
				int ultimaMensagem = getUltimaMensagem();
				Mensagem mensagem = getChat().getMensagem(ultimaMensagem);
				if(mensagem != null){
					context.addCallbackParam("newMessage", true);
					context.addCallbackParam("newMessage", mensagem);
					setUltimaMensagem(ultimaMensagem + 1);
				}
			}
			else{
				context.addCallbackParam("close", true);
			}
		}catch(Throwable e){
			System.out.println("ERRO: " + getMensagem());
		}
	}
}
