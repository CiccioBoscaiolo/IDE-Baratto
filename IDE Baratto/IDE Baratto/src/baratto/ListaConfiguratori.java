package baratto;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class ListaConfiguratori {
	
	private ArrayList<Configuratore> listaConfiguratori=new ArrayList <Configuratore>();

	public void nuovo(Configuratore c) {
		listaConfiguratori.add(c);
	}
	public Configuratore getConfiguratore(int i) {
		return listaConfiguratori.get(i);
	}
	public void setConfiguratore(Configuratore c, int i) {
		listaConfiguratori.set(i, c);
	}
	public boolean ricerca(Configuratore c) {
		for(int i=0;i<listaConfiguratori.size();i++) {
			if(listaConfiguratori.get(i).nome.equals(c.nome))
				return true;
			
		}
		return false;
		
	}
	
	public void stampatutti() {
		for(int i=0;i<listaConfiguratori.size();i++) {
			System.out.println(listaConfiguratori.get(i).getNome()+" "+listaConfiguratori.get(i).getPsw()+"\n");
		}
	}
	public Configuratore verificaCredenziali(String motivo) {
		String nome,psw;
		Configuratore c=null;
		boolean ritenta=false,flag=false;
		do {
			nome=InputDati.leggiStringaNonVuota("Inserire nome utente");
			psw=InputDati.leggiStringaNonVuota("Inserire password");
			c=new Configuratore(nome,psw);
			flag=false;
			ritenta=true;
			
			
			if(motivo=="accesso" && ricerca(c)){
				System.out.println("banane");
				flag=true;
				ritenta=false;
			}
			else if(motivo=="new") {
				if(!ricerca(c)) {
					nuovo(c);
					flag=true;
					ritenta=false;
				}
				else {
					System.out.println("\nUsername già utilizzato");
				}
			}
			else if(motivo.equals("reg") && nome.equals("admin") && psw.equals("admin")){
				System.out.println("Benvenuto nuovo configuratore \n inserisci nuove credenziali");
				ritenta=true;
				flag=true;
				motivo="new";
		}
			if(flag==false) {
				ritenta=InputDati.yesOrNo("\nERRORE \nVuoi riprovare ad autenticarti?");
				if(!ritenta) return null;
			}
		}
		while(ritenta);
		return c;
	}
	
}

