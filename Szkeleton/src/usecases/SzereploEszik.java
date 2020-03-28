package usecases;
import objects.*;
public class SzereploEszik implements UseCase {
	/*
	 * Szereplő étel használatát szimuláló use-case osztály
	 */
	@Override
	public void run() {
		/*
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		// TODO Auto-generated method stub
		Kutato k = new Kutato();
		Elelem etel = new Elelem();
		Palya.setAktJatekos(k);
		
		/*
		 * Futtatjuk a szekvenciát
		 * 
		 */
		k.Hasznal(etel);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/*
		 * A use-case-hez tartózó leirás
		 */
		return "Szereplo etelt eszik";
	}

}
