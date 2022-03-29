package baratto;

import it.unibs.fp.mylib.*;	

public class Configuratore {
	String nome,psw;
	public Configuratore(String nome,String psw) {
		this.nome=nome;
		this.psw=psw;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
}	
