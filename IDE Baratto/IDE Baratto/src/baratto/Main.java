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
		boolean repeat=true;
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
					ListaConfiguratori listaConfiguratori = new ListaConfiguratori();
					menu=new MyMenu("Accesso",MENUACCESSOCONF);
					selezione = menu.scegli();
					switch(selezione) {
						case 1:		
							c=listaConfiguratori.verificaCredenziali("login");
							break;
				
						case 2:		
							c=listaConfiguratori.verificaCredenziali("reg");
							break;
					}//fine switch accesso
					if(c==null) continue;
					menuConfig(c);
					break;
				case 0:
					System.out.println(BelleStringhe.incornicia("ARRIVEDERCI"));
					repeat=false;
					break;
			}
		}while(selezione!=0);
	}

	
	public static void menuConfig(Configuratore c){
		boolean leaf;
		int selezione;
		do {
			MyMenu menu = new MyMenu("CONFIGURATORE: ",MENUCONFIGURATORE);
			selezione = menu.scegli();
			
			
			switch(selezione) {
			case 1:		//aggiunta nuova radice
				leaf=false;
				Nuova_cat(leaf);
				
				
			case 2:
				leaf=true;
				Nuova_cat(leaf);
				
				break;
			case 3:		//visualizza strutture
					//implementare visulaizzazione
				MostraStrutture();
				break;	
			}
		}while(selezione!=0);
	}
	
	
	private static void MostraStrutture() {
		//mostrare lista alberi
		for(int i=0;i<listaRadici.size();i++) {
		System.out.println(listaRadici.get(i).getID()+" "+listaRadici.get(i).getNome());
		}
		
	}

	

	private static void Nuova_cat(boolean leaf) {	//da finire
		
		boolean test;
		String n;
		List<String>campo=new ArrayList<String>();
		Categoria cat;
		
		
		//NOME CATEGORIA
		n=InputDati.leggiStringaNonVuota("inseririsci nome categoria");
		//da controllare unicità nome
		
		
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
		test=InputDati.yesOrNo("vuoi inserire caltri campi per questa categoria ");
		while(test==true)
		{
			campo.add(InputDati.leggiStringaNonVuota("inserisci un nuovo campo "));
			//da controllare unicita del nome del campo
			test=InputDati.yesOrNo("vuoi inserire altri campi?");
		}
		cat.setCampi(campo);
	}

	
}


