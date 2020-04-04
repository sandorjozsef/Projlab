package objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
public final class Palya{
	
	
	private static Szereplo aktJatekos;
	private static ArrayList<Szereplo> szereplok= new ArrayList<Szereplo>();
	private static ArrayList<Mezo> mezok = new ArrayList<Mezo>();
	private static Medve medve;
	private static int maxJatekos;
	private static int alkatreszek = 0;
	
	
	/**
	 * Statikus osztály, nem lehet kívülről hívható konstruktor
	 */
	private Palya() {}

	public static int getSzereplokSzama()
	{
		return szereplok.size();
	}
	public static Szereplo getAktJatekos(){
		return aktJatekos;
	}
	public static ArrayList<Mezo> getMezok(){
		return mezok;
	}
	public static Mezo getMezo(String id) {
		for(int i = 0; i< mezok.size(); i ++){
			if(mezok.get(i).getId().equals(id)) 
				return mezok.get(i);  
		}
		System.out.println("Nincs ilyen nevu mezo!");
		return null;
		
		
	}
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
			//kor vege
			
			Mezo medveMezo = medve.getMezo();
			Random r = new Random();
			ArrayList<Mezo> szomszed = medveMezo.getSzomszed();			
			Mezo cel = szomszed.get(r.nextInt(medveMezo.getSzomszed().size()));
			medve.Atlep(cel);
		}
		else {
			kov=szereplok.get(akt+1);
		}
		kov.setLepesszam(4);
		Mezo mezo=kov.getMezo();
		mezo.Hatas(kov);
		Hovihar();
		Mezofrissit();
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
		Random rand = new Random();
		for(int i = 0; i<mezok.size();i++) {
			if (rand.nextInt(2) == 1)
				mezok.get(i).Hoeses();
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
		aktJatekos = null;
		clear();
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
	public static void JatekotKezd(InputStream is) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.JatekotKezd()");
		BuildMap(is);
		aktJatekos = szereplok.get(0);
		
		Indentor.degLevel();
	}

	/**
	 * Növeli a megtalált alkatrészek számát
	 * és vizsgálja, hogy mind a 3 alkatrészt megtalálták-e, valamint mindenki azonos mezőn
	 * áll-e. Ha az alkatrészt már bejelentették (a kapott paraméter false értékű) akkor csak
	 * vizsgálja, hogy készek a feltételek a játék megnyeréséhez, nem növekszik a megtalált
	 * alkatrészek száma.
	 * 
	 * @param bejelentheto
	 */
	public static void AlkatresztKezel(boolean bejelentheto) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.AlkatreszKezel()");
		
		if(bejelentheto)
			alkatreszek++;
		if(alkatreszek==3) {
			Mezo mezo = aktJatekos.getMezo();
			int szerep_szam = mezo.getSzereplokSzama();
			if(szerep_szam==maxJatekos)
				JatekVege(true);
		}
		
		Indentor.degLevel();
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
	/**
	 * felépiti a pályát egy megadott mátrix alapján, amit a paraméterként kapott input streamből olvas ki
	 * S - stabil jegtabla
	 * L - luk
	 * I - instabil jegtabla
	 * 
	 * A - alkatresz
	 * K - kotel
	 * L - lapat
	 * T - torekeny aso
	 * E - elelem
	 * B - buvarruha
	 * S - sator
	 * 
	 * Egy mezo leirasa: pl: IT13  instabil jegtabal, torekeny aso van rajta, 1 a teherbiras ,  3 a hovastagsag
	 * A mezoket space valasztja el
	 * 
	 * A palya jobb also sarka mindig stabil jegtabla kell, hogy legyen mert onnan indulnak a szereplok
	 * @param is 
	 */
	public static void BuildMap(InputStream is) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.BuildMap()");
		clear();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));	
		 
		try {
				if(is == System.in)
					System.out.print("Hany szereplo legyen? ");
				int sz = Integer.parseInt(reader.readLine());
				if(is == System.in)
					System.out.print("Milyen magas legyen a palya? ");
				int n = Integer.parseInt(reader.readLine());
				if(is == System.in)
					System.out.print("Milyen szeles legyen a palya? ");
				int m = Integer.parseInt(reader.readLine());
				if(is == System.in)
					
					
					
				if(n*m<sz*7) // minden szereplore 7 mezo jut
					throw new Exception("Tul kicsi palya!");
				if(is == System.in)				
					System.out.println("Add meg a palya felepiteset! ");
			
				
				
				Targy[][] initTargyak = new Targy[n][m];
				Mezo initMezok[][] = new Mezo[n][m];
				Random r= new Random();
				int alkcount = 0;
				for(int i = 0; i<n;i++) {	
					String sor = reader.readLine();
					String[] mezokIn = sor.split(" ");
					for(int j = 0; j< m; j++) {
						if(i==n-1 && j==n-1 && mezokIn[j].charAt(0)!='S') {
							throw new Exception("A kezdo mezo nem stabil jegtabla! (jobb also)");
						}
						switch(mezokIn[j].charAt(1)) {
						case 'T': initTargyak[i][j] = new Aso();
							break;
						case 'L': initTargyak[i][j] = new Lapat();
							break;
						case 'B': initTargyak[i][j] = new Buvarruha();
							break;
						case 'A': initTargyak[i][j] = new Alkatresz();
									if(mezokIn[j].charAt(0)!='L')alkcount++;
							break;
						case 'E': initTargyak[i][j] = new Lapat();
							break;
						case 'S': initTargyak[i][j] = new Buvarruha();
							break;
						case 'K': initTargyak[i][j] = new Aso();
							break;	
						case '*': initTargyak[i][j] = null;
							break;	
						default:
							throw new Exception("Hibas szintaktika!");
						}
						switch(mezokIn[j].charAt(0)) {
						case 'S': initMezok[i][j] = new StabilJegtabla("mezo"+i*j,initTargyak[i][j]);
							break;
						case 'I': 
									if(mezokIn[j].substring(2,3).equals("R"))
										initMezok[i][j] = new InstabilJegtabla("mezo"+i*j,initTargyak[i][j], r.nextInt(3)+1);
									else 
										initMezok[i][j] = new InstabilJegtabla("mezo"+i*j,initTargyak[i][j], Integer.parseInt(mezokIn[j].substring(2,3)));
							break;
						case 'L': initMezok[i][j] = new Luk("mezo"+i*j);
							break;
						default: throw new Exception("Hibas szintaktika!");							
						}
						if(mezokIn[j].substring(3,4).equals("R"))
							initMezok[i][j].setHovastagsag(r.nextInt(8));
						else
							initMezok[i][j].setHovastagsag(Integer.parseInt(mezokIn[j].substring(3,4)));
						
						
						if(j>0) {//beéllitjuk a szomszédokat: mindenkinek negy szomszed egyelore
							initMezok[i][j].setSzomszed(initMezok[i][j-1]);
							initMezok[i][j-1].setSzomszed(initMezok[i][j]);
						}
						if(i>0) {
							initMezok[i][j].setSzomszed(initMezok[i-1][j]);
							initMezok[i-1][j].setSzomszed(initMezok[i][j]);
						}
					}
				}
				if(alkcount<3)
					throw new Exception("Nincs eleg alkatresz!");
				for(int i = 0; i<n;i++)					
					for(int j = 0; j<m; j++) {
						mezok.add(initMezok[i][j]);	//feltoltju ka mezok listajat 					
					}				
				for(int i = 0; i<sz;i++) { // letrehozzuk a szereploket és a medvét, betesszuk oket a kezdo mezore
					Szereplo s;
					if(i%2==0)
						s = new Kutato("kutato"+i);
					else
						s = new Eszkimo("eszkimo"+i);
					szereplok.add(s);
					s.setMezo(initMezok[n-1][m-1]);
					initMezok[n-1][m-1].setSzereplo(s);
					
				}				
				medve = new Medve("medve");
				medve.setMezo(initMezok[0][0]);
				initMezok[0][0].setMedve(medve);
				System.out.println("Palya sikeresen felepult, a szereplok a helyukon vannak!");
				
				
		}
		catch(Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}				
		Indentor.degLevel();
	}
	public static void Megtekintes() {
		for(int i = 0; i<mezok.size();i++) {
			Mezo m = mezok.get(i);
			System.out.println(m.getId()+"-"+m.gethoVastagsag()+"-"+m.getSzereplokSzama()+"-"+m.getMedve());
		}
		
	}
	
	public static void Mezofrissit()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.Mezofrissit()");
		for(int i = 0; i<mezok.size();i++) {
			mezok.get(i).Amortizal();
		}
		
		Indentor.degLevel();
	}
	public static void Save(String fName) {
		File s = new File(fName);
		try {
			s.createNewFile();
			FileOutputStream fout = new FileOutputStream(s);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			ArrayList<Object> data = new ArrayList<Object>();
			data.add(aktJatekos);
			data.add(szereplok);
			data.add(mezok);
			data.add(medve);
			data.add(maxJatekos);
			data.add(alkatreszek);
			oout.writeObject(data);			
			
			oout.close();
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Jatek sikeresen mentve a '"+fName+"' fajlba!");
		
	}
	@SuppressWarnings("unchecked")
	public static void Load(String fName) {
		File l = new File(fName);
		if(l.exists()) {
			
			try {			
				FileInputStream fin = new FileInputStream(l);
				ObjectInputStream ois = new ObjectInputStream(fin);				
				ArrayList<Object> data = (ArrayList<Object>) ois.readObject();
				aktJatekos = (Szereplo) data.get(0);
				szereplok = (ArrayList<Szereplo>) data.get(1);
				mezok = (ArrayList<Mezo>) data.get(2);
				medve = (Medve) data.get(3);
				maxJatekos = (int) data.get(4);
				alkatreszek = (int) data.get(5);					
				
				ois.close();
				fin.close();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Jatek sikeresen betoltve a '"+fName+"' fajlbol!");
		}	
	}
	
}
