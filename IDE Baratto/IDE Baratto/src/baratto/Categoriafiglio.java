package baratto;

import java.util.ArrayList;

public class Categoriafiglio extends Categoria{

	private int padre;
	public Categoriafiglio(String nome, ArrayList <String> campi,int padre) {
		super (nome);
		this.padre=padre;
	}
	public void setPadre(int padre) {
		this.padre = padre;
	}
	public int getPadre() {
		return padre;
	}
}
