package objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
 * @author Aviato
 *
 */
public final class Palya{
	
	
	private static Szereplo aktJatekos;
	private static ArrayList<Szereplo> szereplok = new ArrayList<Szereplo>();
	private static ArrayList<Mezo> mezok = new ArrayList<Mezo>();
	private static int alkatreszek = 0;
	private static boolean randomHovihar = true;
	
	
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
		System.out.println("Nincs ilyen nevu mezo!: "+id);
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
		}
		else {
			kov=szereplok.get(akt+1);
		}
		aktJatekos=kov;
		aktJatekos.Autolepes();
		aktJatekos.setLepesszam(4);
		Mezo mezo=aktJatekos.getMezo();
		mezo.Hatas(aktJatekos);
		Hovihar();
		Mezofrissit();
		System.out.println("-'"+aktJatekos.getId()+"' kovetkezik-");
		
		
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
		if(randomHovihar) {
			for(int i = 0; i<mezok.size();i++) {
				if (rand.nextInt(2) == 1)
					mezok.get(i).Hoeses();
			
			}
		}
		else {
			mezok.get(0).Hoeses();
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
	 */
	public static void JatekotKezd(InputStream is) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.JatekotKezd()");
		if(BuildMap(is)) {
			aktJatekos = szereplok.get(0);
			System.out.println("-'"+aktJatekos.getId()+"' kovetkezik-");			
		}
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
			if(szerep_szam == szereplok.size()-1)
				JatekVege(true);
		}
		
		Indentor.degLevel();
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
		randomHovihar = true;
		
		
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
	public static boolean BuildMap(InputStream is) {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Palya.BuildMap()");
		clear();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));	
		 
		try {			
				
				if(is == System.in)				
					System.out.println("Epitsd fel a palyat, adj hozza szereplőket! ");
				boolean exit = false;
				int alkcount = 0;
				Random r = new Random();
				boolean randomMedve = true;
				
				
				while(!exit) {
					String sor = reader.readLine();
					String params[] = sor.split(" ");
					
					
					if(params[0].equals("ujmezo")) {
						Targy targy;
						Mezo mezo;
						switch(params[2].charAt(1)) {
							case 'T': targy = new Aso();
								break;
							case 'L': targy = new Lapat();
								break;
							case 'B': targy = new Buvarruha();
								break;
							case 'A': targy = new Alkatresz();
							if(params[2].charAt(0)!='L')alkcount++;
								break;
							case 'E': targy = new Elelem();
								break;
							case 'S': targy = new Sator();
								break;
							case 'K': targy= new Kotel();
								break;	
							case '*': targy = null;
								break;	
							default:
								throw new Exception("Hibas szintaktika!");
							}
							switch(params[2].charAt(0)) {
							case 'S': mezo = new StabilJegtabla(params[1],targy);
							break;
							case 'I': 
								if(params[2].substring(2,3).equals("R"))
									mezo = new InstabilJegtabla(params[1],targy, r.nextInt(3)+1);
								else 
									mezo = new InstabilJegtabla(params[1],targy, Integer.parseInt(params[2].substring(2,3)));
								break;
							case 'L': mezo = new Luk(params[1]);
							break;
							default: throw new Exception("Hibas szintaktika!");							
							}							
							if(params[2].substring(3,4).equals("R"))
								mezo.setHovastagsag(r.nextInt(8));
							else
								mezo.setHovastagsag(Integer.parseInt(params[2].substring(3,4)));
						mezok.add(mezo);
					}
					else if(params[0].equals("ujszereplo")){
						if(params[2].equals("eszkimo")) {
							szereplok.add(new Eszkimo(params[1]));
						}
						else if(params[2].equals("kutato")) {							
							szereplok.add(new Kutato(params[1]));
						}
					}
					else if(params[0].equals("osszekot")) {
						Mezo mezo1 = getMezo(params[1]);
						Mezo mezo2 = getMezo(params[2]);
						if(mezo1!=mezo2&&mezo1!=null&&mezo2!=null) {							
							mezo1.setSzomszed(mezo2);
							mezo2.setSzomszed(mezo1);
						}
					}
					else if(params[0].equals("randomhovihar")) {
						if(params[1].equals("1")) {
							randomHovihar = true;
						}
						else if(params[1].equals("0")) {
							randomHovihar = false;
						}
					}
					else if(params[0].equals("randommedve")) {
						if(params[1].equals("1")) {
							randomMedve = true;
						}
						else if(params[1].equals("0")) {
							randomMedve = false;
						}
					}
					else if(params[0].equals("***")) {
						exit = true;
					}
						
			}
			if(alkcount<3)
				throw new Exception("Nincs eleg alkatresz!");	
			if(szereplok.size()<3)
				throw new Exception("Nincs eleg szereplo!");	
			if(szereplok.size()*4>mezok.size())
				throw new Exception("Nincs eleg mezo!");	
			
			
			for(int i = 0; i<szereplok.size();i++) { 				
					szereplok.get(i).setMezo(mezok.get(0));
					mezok.get(0).setSzereplo(szereplok.get(i));
			}				
			Szereplo medve = new Medve(randomMedve, "medve");
			szereplok.add(medve);
			medve.setMezo(mezok.get(mezok.size()-1));
			mezok.get(mezok.size()-1).setSzereplo(medve);
			System.out.println("Palya sikeresen felepult, a szereplok a helyukon vannak!");
				
				
		}
		catch(Exception e) {
				// TODO Auto-generated catch block
				clear();
				System.out.println("Probald ujra!");
				e.printStackTrace();
				return false;
		}				
		Indentor.degLevel();
		return true;
	}
	public static void Megtekintes(int p,String mezoNev, BufferedWriter bw) {
		switch(p) {
		case 0:
			for(int i = 0; i<mezok.size();i++) {
				Mezo m = mezok.get(i);
				m.MezoInfo(bw);
				System.out.println();
			}
			break;
		case 1:
			aktJatekos.szereploInfo(bw);
			break;
		case 2:
			aktJatekos.targyInfo(bw);
			break;
		case 3:
			getMezo(mezoNev).MezoInfo(bw);
			System.out.println();
			break;
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
				alkatreszek = (int) data.get(3);					
				
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
