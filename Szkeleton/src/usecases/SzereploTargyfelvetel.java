package usecases;
import objects.*;
/**
 * Szereplő mezőről való tárgyfelvétélét szimuláló use-case osztály
 */
public class SzereploTargyfelvetel implements UseCase {

	@Override
	public void run() {
		/**
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		// TODO Auto-generated method stub
	Kutato k = new Kutato();
	StabilJegtabla mezo = new StabilJegtabla(new Lapat());	
	
	
	Palya.setAktJatekos(k);
	k.setMezo(mezo);
	mezo.setSzereplo(k);
	/**
	 * Futtatjuk a szekvenciát
	 * 
	 */
	k.Felvesz();
	
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/**
		 * A use-case-hez tartózó leirás
		 */
		return "Szereplo targyat probal felvenni";
	}

}
