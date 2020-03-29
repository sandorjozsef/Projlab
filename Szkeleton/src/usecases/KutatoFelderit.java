package usecases;
import objects.*;

/**
 * Kutató mező felderitését szimuláló use-case osztály
 */
public class KutatoFelderit implements UseCase {

	@Override
	public void run() {
		/**
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		Kutato k = new Kutato();
		StabilJegtabla akt_mezo = new StabilJegtabla(null);
		InstabilJegtabla mezo = new InstabilJegtabla(null,2);
		
		Palya.setAktJatekos(k);
		k.setMezo(akt_mezo);
		akt_mezo.setSzereplo(k);
		mezo.setSzomszed(akt_mezo);
		akt_mezo.setSzomszed(mezo);
		
		/**
		 * Futtatjuk a szekvenciát
		 * 
		 */
		k.SpecKepesseg(mezo);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/**
		 * A use-case-hez tartózó leirás
		 */
		return "Kutato megprobal mezot felderiteni";
	}

}
