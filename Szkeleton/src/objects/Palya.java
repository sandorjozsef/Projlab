package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import indent.Indentor;

public final class Palya {
	private static Szereplo aktJatekos;
	private static ArrayList<Szereplo> szereplok= new ArrayList<Szereplo>();
	private static ArrayList<Mezo> mezok = new ArrayList<Mezo>();

	private Palya() {}

	public static void Leptet() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.Leptet()");
		
		
		//TODO : keres kov szereplo
		Szereplo kov;
		int akt=szereplok.lastIndexOf(aktJatekos);
		if(akt==szereplok.size()-1) {
			kov=szereplok.get(0);
		}
		else {
			kov=szereplok.get(akt+1);
		}
		kov.setLepesszam(4);
		Mezo mezo=kov.getMezo();
		mezo.Hatas(kov);
		Hovihar();
		aktJatekos=kov;
		
		
		Indentor.degLevel();
	}

	public static void Hovihar() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.Hovihar()");
		
		
		for(Mezo m : mezok){
			//TODO : random mezok
			m.Hoeses();
		}
		
		
		Indentor.degLevel();
	}
	
	public static void JatekVege(boolean nyert) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.JatekVege()");
		
		
		Indentor.degLevel();
	}

	public static void JatekotKezd() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.JatekotKezd()");
		
		
		Indentor.degLevel();
	}

	public static void AlkatresztKezel(boolean bejelentheto) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.AlkatreszKezel()");
		
		//TODO : if alkatreszek==3
		String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.print(Indentor.getIndent()+"Megvan a harom alkatresz? (Y/N) ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer1 = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (answer1.equals("Y")) {
				Mezo mezo = aktJatekos.getMezo();
				int szerep_szam = mezo.getSzereplokSzama();
				//TODO: if maxJatekos==szerepszam
				String answer2 = "";
				while (!answer2.equals("Y") && !answer2.equals("N")) {
					System.out.print(Indentor.getIndent()+"Az osszes szereplo egy mezon all? (Y/N) ");
					
					try {
						answer2 = reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (answer2.equals("Y")) {
						JatekVege(true);
					}
				}
			}
		}
		Indentor.degLevel();
	}

	public static void MezokOsszekot() {
		
	}
	public static void addMezo(Mezo mezo) {
		
		mezok.add(mezo);
		
		
	}
	public static void addSzereplo(Szereplo sz) {
		
		szereplok.add(sz);
		
		
	}
	public static void setAktJatekos(Szereplo sz) {
		
		aktJatekos = sz;
		
		
	}
	public static void clear() {
		
		mezok.clear();
		szereplok.clear();
		
		
	}
}
