package baratto;

import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;


public class Main {
	public final static String[] MENUBARATTO={"utente","configuratore"};
	public final static String[] MENUACCESSOCONF={"Accedi","Registrati"};
	public final static String[] MENUCONFIGURATORE= {"aggiungi categoria","visualizza categorie"};
	
	private static ListaConfiguratori listaConfiguratori;
	private static Configuratore c=null;
	
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
					menu=new MyMenu("CONFIGURATORE: "+c.nome,MENUCONFIGURATORE);
					selezione = menu.scegli();
					
					switch(selezione) {
					case 1:		//aggiiungi categoria
							//implementare aggiunta di radice o di figli
						break;
					case 2:		//visualizza strutture
							//implementare visulaizzazione
						break;	
					
					}
				}
				break;
			case 0:
				System.out.println(BelleStringhe.incornicia("ARRIVEDERCI"));
				repeat=false;
				break;
			}		
		}while(repeat==true);
	}
}


