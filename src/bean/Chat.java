package bean;
import java.io.Serializable;
import java.util.List;
import java.util.Date;
import java.util.Collections;
import java.util.ArrayList;

public class Chat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Mensagem> mensagens = Collections.synchronizedList(new ArrayList<Mensagem>());
	
	public void setMensagens(List<Mensagem> mensagem){
		this.mensagens = mensagem;
	}
	
	public void addMensagem(String textoMsg, String autor) {
		Mensagem mensagem = new Mensagem();
		mensagem.setConteudo(textoMsg);
		mensagem.setAutor(autor);
		mensagem.setData(new Date());
		
		mensagens.add(mensagem);
	}
	
	public List<Mensagem> getMensagens(){
		return mensagens;
	}
	
	public Mensagem getMensagem(int id) {
		Mensagem result = null;
		
		if(mensagens.size() > id){
			result = mensagens.get(id);
		}
		
		return result;
		
	}
}