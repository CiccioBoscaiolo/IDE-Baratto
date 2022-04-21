package baratto;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	
	private String nome;
	private static int ID=0;
	private List<String> campi= new ArrayList<String>(); 
	private List<Categoria> figli = new ArrayList<>(); 
	private Categoria padre;
	
	
	
	public Categoria(String nome) {
		this.nome=nome;
		ID++;
	}
	public void campi_standard() {
		campi.add("descrizione libera");
		campi.add("stato conservazione");
	}
	public void setCampi(List<String> campi) {
		for (String item : campi) {
		    nuovoCampo(item);
		}
	}
	public void nuovoCampo (String campo) {
		campi.add(campo);
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getCampi() {
		return campi;
	}
	public int getID() {
		return ID;
	}
	public String getNome() {
		return nome;
	}
	
	//aggiunta di un figlio
	public void addFiglio(Categoria figlio) {
		figlio.setpadre(this);	//ci dice che il padre è padre del figlio
		this.figli.add(figlio); //il figlio è figlio del padre
	}
	 
	//aggiungi più figli assieme
	/*public void addFigli(List <Categoria> figli) {
		figli.forEach(each -> each.setpadre(this));
		this.figli.addAll(figli);
	}*/
	 

	//METODI SET E GET
	public List<Categoria> getFigli() {
		return figli;
	}

	 
	private void setpadre(Categoria padre) {
		this.padre = padre;
	}
	 
	public Categoria getpadre() {
		return padre;
	}

}
