package usecases;

import objects.*;
/*
 * Szereplő lapát használatát szimuláló use-case osztály
 */
public class SzereploLapat implements UseCase {

	@Override
	public void run() {
		/*
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		// TODO Auto-generated method stub
		Kutato sz = new Kutato();
		StabilJegtabla mezo = new StabilJegtabla(null);
		Lapat lapat = new Lapat();
		
		
		Palya.setAktJatekos(sz);
		sz.setMezo(mezo);
		mezo.setSzereplo(sz);
		/*
		 * Futtatjuk a szekvenciát
		 * 
		 */
		sz.Hasznal(lapat);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/*
		 * A use-case-hez tartózó leirás
		 */
		return "Szereplo lapatot hasznal";
	}

}
