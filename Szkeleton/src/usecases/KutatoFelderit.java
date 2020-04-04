package usecases;
import objects.*;

/**
 * Kutató mező felderitését szimuláló use-case osztály
 */
public class KutatoFelderit implements UseCase {
	/**
	 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
	 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
	 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
	 * hogy ez ne befolyásolja a többi use-case teszt futását. Az objektumok létrehozása után futtatjuk 
	 * meghivjuk a szekvenciában szereplő első metódust
	 *
	 */
	@Override
	public void run() {
		System.out.println(getName().toUpperCase());
		Kutato k = new Kutato();
		StabilJegtabla akt_mezo = new StabilJegtabla("mezo" ,null);
		InstabilJegtabla mezo = new InstabilJegtabla("mezo2" ,null,2);
		
		Palya.setAktJatekos(k);
		k.setMezo(akt_mezo);
		akt_mezo.setSzereplo(k);
		mezo.setSzomszed(akt_mezo);
		akt_mezo.setSzomszed(mezo);
		
	
		k.SpecKepesseg(mezo);
	}

	/**
	 * A use-case-hez tartózó leirás
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Kutato megprobal mezot felderiteni";
	}

}
