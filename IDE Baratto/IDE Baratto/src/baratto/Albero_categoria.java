package baratto;

import java.util.ArrayList;
import java.util.List;
 
// CIAOOOOOOOOOOOO

public class Albero_categoria<Categoria> {

//tre variabili (una categoria, un'istanza dell'albero e una lista dell'istanza dell'albero ???
private Categoria cat = null;	//radice
private List<Albero_categoria<Categoria>> figli = new ArrayList<>(); 
private Albero_categoria<Categoria> padre = null;
 
//costruttore che mi genera 1 radice
public Albero_categoria(Categoria cat) {
this.cat = cat;
}
 
//aggiunta di un figlio
public Albero_categoria<Categoria> addFiglio(Albero_categoria<Categoria> figlio) {
	figlio.setpadre(this);	//ci dice che il padre è padre del figlio
	this.figli.add(figlio); //il figlio è figlio del padre
	return figlio;
}
 
//aggiungi più figli assieme
public void addFigli(List<Albero_categoria<Categoria>> figli) {
	figli.forEach(each -> each.setpadre(this));
	this.figli.addAll(figli);
}
 

//METODI SET E GET
public List<Albero_categoria<Categoria>> getFigli() {
	return figli;
}
 
public Categoria getcat() {
	return cat;
}
 
public void setcat(Categoria cat) {
	this.cat = cat;
}
 
private void setpadre(Albero_categoria<Categoria> padre) {
	this.padre = padre;
}
 
public Albero_categoria<Categoria> getpadre() {
	return padre;
}
 
}
