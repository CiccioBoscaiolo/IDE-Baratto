package baratto;

import java.util.ArrayList;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

//questo commento è stato fatto in data 30/03/22 
public class Main {
	public final static String[] MENUBARATTO={"Utente","Configuratore"};
	public final static String[] MENUACCESSOCONF={"Accedi","Registrati"};
	public final static String[] MENUCONFIGURATORE= {"aggiungi categoria","visualizza categorie"};
	
	
	//private static Lista_alberi listaAlberi;
	private static ArrayList<Categoria> listaAlberi=new ArrayList <Categoria>();
	private static ListaConfiguratori listaConfiguratori;
	private static Configuratore c;
	private static int ID=0;
	
	public static void main(String[] args) {
		listaConfiguratori=new ListaConfiguratori();
		boolean repeat=true;
		
		//do {
			MyMenu menu;
			//menu=new MyMenu("Baratto",MENUBARATTO);
			//int voceSelezionata = menu.scegli();
			int selezione;
			/*
			switch(voceSelezionata) {
			case 1:	
				//menu utente
				break;
			case 2:	
				
				menu=new MyMenu("Accesso",MENUACCESSOCONF);
				selezione = menu.scegli();
				switch(selezione) {
					case 1:		
						c=listaConfiguratori.verificaCredenziali("accesso");
						break;
				
					case 2:		
						c=listaConfiguratori.verificaCredenziali("reg");
						break;
					}//fine switch accesso
				
				if(c!=null) {
					*/do {
					menu=new MyMenu("CONFIGURATORE: ",MENUCONFIGURATORE);
					selezione = menu.scegli();
					
					boolean leaf;
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
				}/*
				break;
			case 0:
				System.out.println(BelleStringhe.incornicia("ARRIVEDERCI"));
				repeat=false;
				break;
			}		
		}while(repeat==true);
	}*/

	private static void MostraStrutture() {
		//mostrare lista alberi
		for(int i=0;i<listaAlberi.size();i++) {
		System.out.println(listaAlberi.get(i).getID()+" "+listaAlberi.get(i).getNome());
		}
		
	}

	

	private static void Nuova_cat(boolean leaf) {	//da finire
		ID++;
		boolean test;
		String n;
		ArrayList<String>campo=new ArrayList<String>();
		Categoria cat;
		
		//NOME CATEGORIA
		n=InputDati.leggiStringaNonVuota("inseririsci nome categoria");
		//da controllare unicità nome
		
		
		cat=new Categoria(n,ID);
		
		
		if(leaf==true) {		//se la categoria è figlia entro qua
			MostraStrutture();
			int tmp=InputDati.leggiIntero("scegli il padre ", 0, listaAlberi.size());
			listaAlberi.get(tmp).addFiglio(cat);		//setto il collegamento padre-figlio
			campo=listaAlberi.get(tmp).getCampi();		//prendo i campi dal padre
			
		}
		listaAlberi.add(cat);
		
		
		
		//inserimento campi
		test=InputDati.yesOrNo("vuoi inserire dei campi per questa categoria ");
		while(test==true)
		{
			campo.add(InputDati.leggiStringaNonVuota("inserisci un nuovo campo "));
			//da controllare unicita del nome del campo
			test=InputDati.yesOrNo("vuoi inserire altri campi?");
		}
		cat.setCampi(campo);
	}

	
}


