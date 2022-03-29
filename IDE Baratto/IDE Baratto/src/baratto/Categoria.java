package baratto;

import java.util.ArrayList;

public class Categoria {

	private String nome;
	private int ID;
	private ArrayList <String> campi;
	
	public Categoria(String nome, ArrayList <String> campi) {
		this.nome=nome;
		this.campi= new ArrayList<String>();
		campi.add("descrizione libera");
		campi.add("stato conservazione");
	}
	public void setCampi(ArrayList<String> campi) {
		this.campi = campi;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<String> getCampi() {
		return campi;
	}
	public int getID() {
		return ID;
	}
	public String getNome() {
		return nome;
	}
}
