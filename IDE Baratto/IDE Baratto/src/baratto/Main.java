package baratto;

import java.util.ArrayList;
import java.util.List;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

//questo commento è stato fatto in data 08-04
public class Main {
	public final static String[] MENUBARATTO={"Utente","Configuratore"};
	public final static String[] MENUACCESSOCONF={"Accedi","Registrati"};
	public final static String[] MENUCONFIGURATORE= {"aggiungi categoria","visualizza categorie"};

	
	
	//private static Lista_alberi listaAlberi;
	private static List<Categoria> listaRadici=new ArrayList <Categoria>();
	private static Configuratore c;
	
	
	public static void main(String[] args) {
		
		CicloMenuPrincipale();
	}
	
	public static void CicloMenuPrincipale(){
		//boolean repeat=true;
		int selezione;
		MyMenu menu;
		
		
		do {
			menu=new MyMenu("Baratto",MENUBARATTO);
			selezione= menu.scegli();
			switch(selezione) {
				case 1:	
					//menu utente
					continue;
				
				case 2:	
					menuAccessoConfiguratore();
					
					if(c==null) continue;
					menuConfiguratore(c);
					break;
				case 0:
					System.out.println(BelleStringhe.incornicia("ARRIVEDERCI"));
					//repeat=false;
					break;
			}
		}while(selezione!=0);
	}

	
	private static void menuAccessoConfiguratore() {
		ListaConfiguratori listaConfiguratori = new ListaConfiguratori();
		MyMenu menu=new MyMenu("Accesso",MENUACCESSOCONF);
		int selezione = menu.scegli();
		boolean firstAccess;
		
		switch(selezione) {
			case 1:		
				//LOGIN
				c=listaConfiguratori.verificaCredenziali(firstAccess=false);
				break;
	
			case 2:		
				//REGISTRAZIONE
				c=listaConfiguratori.verificaCredenziali(firstAccess=true);
				break;
		}
		
		
	}

	public static void menuConfiguratore(Configuratore c){
		boolean leaf;
		int selezione;
		do {
			MyMenu menu = new MyMenu("CONFIGURATORE: ",MENUCONFIGURATORE);
			selezione = menu.scegli();
			
			
			switch(selezione) {
			case 1:		
				//aggiunta nuova radice
				Nuova_cat(leaf=false);
				break;
				
			case 2:
				//aggiunta nuova foglia
				Nuova_cat(leaf=true);
				break;
				
			case 3:		
				//visualizza strutture
				//implementare visulaizzazione
				MostraStrutture();
				break;	
			}
		}while(selezione!=0);
	}
	
	
	private static void MostraStrutture() {
		//mostrare lista radici
		//implementare la possibilità di visualizzare figli annidati
		for(int i=0;i<listaRadici.size();i++) {
		System.out.println(listaRadici.get(i).getID()+" "+listaRadici.get(i).getNome());
		}
		
	}

	

	private static void Nuova_cat(boolean leaf) {	//da finire
		
		boolean duplicate,test;
		String n;
		List<String>campo=new ArrayList<String>();
		Categoria cat;
		
		
		do {
		n=InputDati.leggiStringaNonVuota("inseririsci nome categoria");
		for (Categoria item : listaRadici) {		//controllo unicità nome della categoria
			if(item.getNome()==n){
				continue;
			}
		}
		duplicate=false;
		}while(duplicate);
		
		
		cat=new Categoria(n);	//creo nuova categoria
		
		
		if(leaf==true) {		//se la categoria è figlia entro qua
			MostraStrutture();
			int tmp=InputDati.leggiIntero("scegli il padre ", 0, listaRadici.size());
			
			
			listaRadici.get(tmp).addFiglio(cat);		//setto il collegamento padre-figlio
			campo=listaRadici.get(tmp).getCampi();		//prendo i campi dal padre	
		}
		
		else {
			cat.campi_standard();
			listaRadici.add(cat);
		}
		
		
		
		
		
		//inserimento campi
		test=InputDati.yesOrNo("vuoi inserire altri campi per questa categoria ");
		while(test==true)
		{
			campo.add(InputDati.leggiStringaNonVuota("inserisci un nuovo campo "));
			//da controllare unicita del nome del campo
			test=InputDati.yesOrNo("vuoi inserire altri campi?");
		}
		cat.setCampi(campo);
	}

	
}


