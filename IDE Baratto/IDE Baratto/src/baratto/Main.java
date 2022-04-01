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
	
	public static void main(String[] args) {
		listaConfiguratori=new ListaConfiguratori();
		boolean repeat=true;
		do {
			MyMenu menu=new MyMenu("Baratto",MENUBARATTO);
			int voceSelezionata = menu.scegli();
			
			
			switch(voceSelezionata) {
			case 1:	
				//menu utente
				break;
			case 2:	
				
				menu=new MyMenu("Accesso",MENUACCESSOCONF);
				int selezione = menu.scegli();
				switch(selezione) {
					case 1:		
						c=listaConfiguratori.verificaCredenziali("accesso");
						break;
				
					case 2:		
						c=listaConfiguratori.verificaCredenziali("reg");
						break;
					}//fine switch accesso
				
				if(c!=null) {
					do {
					menu=new MyMenu("CONFIGURATORE: "+c.nome,MENUCONFIGURATORE);
					selezione = menu.scegli();
					
					switch(selezione) {
					case 1:		//aggiunta nuova radice
						Nuova_radice();
						//oppure
						Nuovo_figlio();
						
						
						break;
					case 2:		//visualizza strutture
							//implementare visulaizzazione
						MostraStrutture();
						break;	
					}
					}while(selezione!=0);
				}
				break;
			case 0:
				System.out.println(BelleStringhe.incornicia("ARRIVEDERCI"));
				repeat=false;
				break;
			}		
		}while(repeat==true);
	}

	private static void MostraStrutture() {
		//mostrare lista alberi
		for(int i=0;i<listaAlberi.size();i++) {
		System.out.println(listaAlberi.get(i).getNome());
		}
		
	}

	private static void Nuovo_figlio() {	//da fare
		
		//prima di fare il figlio bisogna fare la visualizzazione di ALMENO TUTTE LE RADICI
	}

	private static void Nuova_radice() {	//da finire
		boolean test;
		String n;
		ArrayList<String>campo=new ArrayList<String>();
		Categoria cat;
		
		//NOME CATEGORIA
		n=InputDati.leggiStringaNonVuota("inseririsci nome categoria");
		//da controllare unicità nome
		cat=new Categoria(n);
		
		
		//CAMPI CATEGORIA
		//cat.campi_standard();
		
		test=InputDati.yesOrNo("vuoi inserire dei campi per questa categoria");
		while(test==true)
		{
			campo.add(InputDati.leggiStringaNonVuota("inserisci un nuovo campo"));
			//da controllare unicita del nome del campo
			//cat.nuovoCampo(campo);
			test=InputDati.yesOrNo("vuoi inserire altri campi");
		}
		cat.setCampi(campo);
		Categoria radice=new Categoria(n);	
		listaAlberi.add(radice);
		
	}

	
}


