package objects;

import java.util.*;

public final class Palya {
	private static Szereplo aktJatekos;
	private static ArrayList<Szereplo> szereplok;
	private static ArrayList<Mezo> mezok;

	public Palya() {

	}

	public static void Leptet() {
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
	}

	public static void Hovihar() {
		for(Mezo m : mezok){
			//TODO : random mezok
			m.Hoeses();
		}
		
	}

	public static void JatekVege(boolean nyert) {

	}

	public static void JatekotKezd() {

	}

	public static void AlkatresztKezel(boolean bejelentheto) {
		//TODO : if alkatreszek==3
		String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.print("Megvan a három alkatrész? (Y/N) ");
			answer1 = System.console().readLine();
			if (answer1.equals("Y")) {
				Mezo mezo = aktJatekos.getMezo();
				int szerep_szam = mezo.getSzereplokSzama();
				//TODO: if maxJatekos==szerepszam
				String answer2 = "";
				while (!answer2.equals("Y") && !answer2.equals("N")) {
					System.out.print("Az összes szereplő egy mezőn áll? (Y/N) ");
					answer2 = System.console().readLine();
					if (answer2.equals("Y")) {
						JatekVege(true);
					}
				}
			}
		}
	}

	public static void MezokOsszekot() {
		//
	}
}
