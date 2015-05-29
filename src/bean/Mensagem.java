package bean;

import java.io.Serializable;
import java.util.Date;
public class Mensagem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String autor;
	private String conteudo;
	private Date data;
	
	public Mensagem() {
	}
	public Mensagem(String autor, String conteudo, Date data) {
		this.autor = autor;
		this.conteudo = conteudo;
		this.data = data;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
