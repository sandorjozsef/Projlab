package usecases;
import objects.*;
public class SzereploKotelLukrol implements UseCase{
	/**
	 * Szereplő kötél használatát szimuláló use-case osztály, amikor a kötelet egy
	 * lukon használja, onnan menekiti a játékosokat
	 */
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
		Kotel kotel = new Kotel();		
		StabilJegtabla stabilJ = new StabilJegtabla(null);
		Luk luk = new Luk();
		Eszkimo e = new Eszkimo();
		
		Palya.setAktJatekos(k);
		e.setMezo(luk);
		k.setMezo(stabilJ);
		luk.setSzereplo(e);
		stabilJ.setSzereplo(k);
		stabilJ.setSzomszed(luk);
		luk.setSzomszed(stabilJ);
		
		/**
		 * Futtatjuk a szekvenciát
		 * 
		 */
		k.Hasznal(kotel);
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/**
		 * A use-case-hez tartózó leirás
		 */
		return "Szereplo kotelet hasznal egy szomszedos lukon";
	}

}
