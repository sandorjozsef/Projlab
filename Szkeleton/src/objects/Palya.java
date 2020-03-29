package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import indent.Indentor;

/**
 * Felügyeli a játék menetét. Ő felelős a hóviharok generálásáért, továbbá ő hozza létre a
 * játékteret a különböző karakterisztikákkal együtt (hol legyenek elrejtve a tárgyak, hány mező
 * és milyen módon legyen elhelyezve, stb.).
 * Singleton statikus osztály
 * @author Sándor József
 *
 */
public final class Palya {
	private static Szereplo aktJatekos;
	private static ArrayList<Szereplo> szereplok= new ArrayList<Szereplo>();
	private static ArrayList<Mezo> mezok = new ArrayList<Mezo>();

	/**
	 * Statikus osztály, nem lehet kívülről hívható konstruktor
	 */
	private Palya() {}

	/**
	 * Ez a metódus adja át a lépésjogot a következő játékosnak.
	 * Hóvihart genrál
	 */
	public static void Leptet() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.Leptet()");
		
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

	/**
	 * Minden szereplő köre lejárta után meghívódik ez a metódus, ami
	 * csak bizonyos valószínűséggel generál ténylegesen hóvihart.
	 */
	public static void Hovihar() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.Hovihar()");
		
		for(Mezo m : mezok){
			//TODO : random mezok
			m.Hoeses();
		}
		
		Indentor.degLevel();
	}
	
	/**
	 * Jelzi a játék kimenetének végét az átadott paraméter
	 * függvényében. Akkor hívódik meg ha elsül a pisztoly (true), vagy ha valakinek
	 * elfogyott a testhője (false) vagy megfulladt (false).
	 * @param nyert
	 */
	public static void JatekVege(boolean nyert) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.JatekVege()");
	
		
		if(nyert) {
			System.out.println(Indentor.getIndent()+" - Jatek megnyerve");
		}
		else {			
			System.out.println(Indentor.getIndent()+" - Jatek elveszitve");
		}
		
		Indentor.degLevel();
	}

	/**
	 * Ezzel a metódussal kezdődik el a játék, vagyis létrejönnek az
	 * objektumok és az első szereplő megkapja a cselekvési jogot.
	 * A Skeleton fázisban még nincs megvalósítva.
	 */
	public static void JatekotKezd() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.JatekotKezd()");
		
		
		Indentor.degLevel();
	}

	/**
	 * Növeli a megtalált alkatrészek számát
	 * és vizsgálja, hogy mind a 3 alkatrészt megtalálták-e, valamint mindenki azonos mezőn
	 * áll-e. Ha az alkatrészt már bejelentették (a kapott paraméter false értékű) akkor csak
	 * vizsgálja, hogy készek a feltételek a játék megnyeréséhez, nem növekszik a megtalált
	 * alkatrészek száma.
	 * Jelen fázisban megkérdi a felhasználótól, hogy meg van-e mindhárom alkatrész és hogy ugyanazon a mezőn
	 * áll-e az összes szereplő
	 * @param bejelentheto
	 */
	public static void AlkatresztKezel(boolean bejelentheto) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.AlkatreszKezel()");
		
		//TODO : if alkatreszek==3
		String answer1 = "";
		while (!answer1.equals("Y") && !answer1.equals("N")) {
			System.out.print(Indentor.getIndent()+" - Megvan a harom alkatresz? (Y/N) ");
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
					System.out.print(Indentor.getIndent()+" - Az osszes szereplo egy mezon all? (Y/N) ");
					
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

	/**
	 *  Beállitja a szomszédságot a mezők közöt egy erre speciális algoritmussal
	 * Inicializáló függvény nem jelezzük a konzolon, hogy lefutott
	 */
	public static void MezokOsszekot() {
		
	}
	
	/**
	 *  Hozzáad a mezők listájához egy újat
	 * Inicializáló függvény nem jelezzük a konzolon, hogy lefutott
	 * @param mezo
	 */
	public static void addMezo(Mezo mezo) {
		mezok.add(mezo);
	}
	
	/**
	 *  Hozzáad a szereplők listájához egy újat
	 * Inicializáló függvény nem jelezzük a konzolon, hogy lefutott
	 * @param sz
	 */
	public static void addSzereplo(Szereplo sz) {
		szereplok.add(sz);
	}
	
	/**
	 * Beállitja az aktuálisan soron lévő játékost
	 * Inicializáló függvény nem jelezzük a konzolon, hogy lefutott
	 * @param sz
	 */
	public static void setAktJatekos(Szereplo sz) {
		aktJatekos = sz;
	}
	
	/**
	 *  Letörli a pálya listáinak tartalmát
	 * Inicializáló függvény nem jelezzük a konzolon, hogy lefutott
	 */
	public static void clear() {
		
		mezok.clear();
		szereplok.clear();
		
		
	}
}
