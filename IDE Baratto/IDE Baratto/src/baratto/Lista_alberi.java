package baratto;

import java.util.ArrayList;

public class Lista_alberi {

	private ArrayList<Albero_categoria> listaAlberi=new ArrayList <Albero_categoria>();

	public void nuovo(Albero_categoria c) {
		listaAlberi.add(c);
	}
	
	public void Nuovo_Albero(Albero_categoria albero) {
		listaAlberi.add(albero);
	}
}
