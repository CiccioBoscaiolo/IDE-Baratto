package baratto;

import java.util.ArrayList;
import java.util.List;
 
// CIAOOOOOOOOOOOOO

public class Albero_categoria<item> {
	

//tre variabili (una categoria, un'istanza dell'albero e ??
private item cat = null;	//radice
private List<Albero_categoria<item>> figli = new ArrayList<>(); 
private Albero_categoria<item> padre = null;
 
//costruttore che mi genera 1 radice
public Albero_categoria(item cat) {
this.cat = cat;
}
 
//aggiunta di un figlio
public Albero_categoria<item> addFiglio(Albero_categoria<item> figlio) {
	figlio.setpadre(this);	//ci dice che il padre è padre del figlio
	this.figli.add(figlio); //il figlio è figlio del padre
	return figlio;
}
 

//METODI SET E GET
public List<Albero_categoria<item>> getFigli() {
	return figli;
}
 
public item getcat() {
	return cat;
}
 
public void setcat(item cat) {
	this.cat = cat;
}
 
private void setpadre(Albero_categoria<item> padre) {
	this.padre = padre;
}
 
public Albero_categoria<item> getpadre() {
	return padre;
}

}
