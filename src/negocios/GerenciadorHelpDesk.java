package negocios;

import java.io.Serializable;
import java.util.*;
import bean.Atendente;
import bean.Chat;
import bean.Usuario;

public class GerenciadorHelpDesk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Usuario> filaDeEspera = Collections.synchronizedList(new ArrayList<Usuario>());
	private List<Atendente> atendentes = Collections.synchronizedList(new ArrayList<Atendente>());
	private Map<String, Chat> chats = Collections.synchronizedMap(new HashMap<String, Chat>());
	
	public int getAtendentesDisponiveis() {
		return atendentes.size();
	}
	
	public int getWaitingUsers() {
		return filaDeEspera.size();
	}
	
	public void addUsuario(Usuario user){
		if(!filaDeEspera.contains(user))
			filaDeEspera.add(user);
	}
	
	public void removeUsuario(Usuario user) {
		filaDeEspera.remove(user);
	}
	
	public void addAtendente(Atendente atend) {
		if(!atendentes.contains(atend))
			atendentes.add(atend);
	}
	
	public void removeAtendente(Atendente atend) {
		atendentes.remove(atend);
	}
	
	public Usuario getProxUsuario() {
		return filaDeEspera.remove(0);
	}
	
	public boolean haschat(String chatId){
		return chats.containsKey(chatId);
	}
	
	public Chat getChat(String chatId) {
		return chats.get(chatId);
	}
	
	public void createChat(String chatId) {
		chats.put(chatId, new Chat());
	}	
	
	public int getPosicaoUsuario(Usuario user) {
		return filaDeEspera.indexOf(user);
	}
	
	public void closeChat(String chatId) {
		chats.remove(chatId);
	}
}
