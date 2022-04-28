package baratto;




import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class ListaConfiguratori {
	private static final String REGNAME = "admin";
	private static final String REGPSW = "admin";
	private static final String BENVENUTO = "\nBenvenuto nuovo configuratore \n inserisci nuove credenziali\n";
	private static final String ERRORE ="\nerrore, vuoi riprovare?\t";
	
	
	private ArrayList<Configuratore> listaConfiguratori=new ArrayList <Configuratore>();

	public void nuovo(Configuratore c) {
		listaConfiguratori.add(c);
	}
	//set e get
	public Configuratore getConfiguratore(int i) {
		return listaConfiguratori.get(i);
	}
	public void setConfiguratore(Configuratore c, int i) {
		listaConfiguratori.set(i, c);
	}
	
	//altri metodi 
	public Configuratore ricerca(Configuratore c) {
		for(int i=0;i<listaConfiguratori.size();i++) {
			if(listaConfiguratori.get(i).nome.equals(c.nome))
				return listaConfiguratori.get(i);
			
		}
		return null;
		
	}
	public void stampatutti() {
		for(int i=0;i<listaConfiguratori.size();i++) {
			System.out.println(listaConfiguratori.get(i).getNome()+" "+listaConfiguratori.get(i).getPsw()+"\n");
		}
	}
	public Configuratore verificaCredenziali(boolean firstAccess) {
		Configuratore c=null;
		boolean ritenta=false,flag=false, error=false,esci=false;
		do {
			c=inserimentoCredenziali();
			flag=false;
			ritenta=true;
			
			
			if(!firstAccess) {
					if (ricerca(c)!=null)	return ricerca(c);		//credenziali trovate
					else {											//credenziali non trovate
						ritenta=InputDati.yesOrNo(ERRORE);
						if(!ritenta) {
							return null;
						}
						else continue;
					}
				
			}
			else if(firstAccess){
				if (c.nome.equals(REGPSW) && c.psw.equals(REGPSW)) {
					System.out.println(BENVENUTO);
					do{
						System.out.println("\nprova\n");
						c=inserimentoCredenziali();
						if(ricerca(c)!=null) {
							System.out.println("\nERRORE \n");
							ritenta=InputDati.yesOrNo(ERRORE);
							if(!ritenta) {
								return null;
							}
							else continue;
						}
					}while(ricerca(c)!=null);
				}
				else System.out.println("credenziali per la registrazione errate\n");
			}
			}
			while(ritenta);
			return c;
		}
		
			
			
			
			
			
			
			
			
			
			
			
			
			/*
			
			if(motivo=="accesso" && ricerca(c)){		//cerco e trovo
				
				//SFOGLIARE ARRAY PER TROVARE IL CONFIGURATORE.... scegli tu "come" 
				
				flag=true;
				ritenta=false;
			}
			else if(motivo.equals("new") && c.nome.equals(REGNAME) && c.psw.equals(REGPSW)){
				System.out.println("Benvenuto nuovo configuratore \n inserisci nuove credenziali");
				ritenta=true;
				flag=true;
				motivo="new";
			}
			else if(motivo=="new") {					//nuovo utente
				if(!ricerca(c)) {						//utente inesistente
					listaConfiguratori.add(c);
					flag=true;
					ritenta=false;
				}
				else {									//utente già presente
					System.out.println("\nUsername già utilizzato");
				}
			}
			
			if(flag==false) {
				ritenta=InputDati.yesOrNo("\nERRORE \nVuoi riprovare ad autenticarti?");
				if(!ritenta) return null;
			}
		}
		while(ritenta);
		return c;
	}
	*/
		private Configuratore inserimentoCredenziali() {
		// TODO Auto-generated method stub
			String nome;
			String psw;
			Configuratore c;
			nome=InputDati.leggiStringaNonVuota("Inserire nome utente");
			psw=InputDati.leggiStringaNonVuota("Inserire password");
			c= new Configuratore(nome,psw);
			return c;
	}

}