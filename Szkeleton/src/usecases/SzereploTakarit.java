package usecases;

import objects.*;
/**
 * Szereplő mezőről való hó eltakaritását szimuláló use-case osztály
 */
public class SzereploTakarit implements UseCase {
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
		// TODO Auto-generated method stub
		Kutato k = new Kutato();
		StabilJegtabla mezo = new StabilJegtabla(new Kotel());
		
		Palya.setAktJatekos(k);
		k.setMezo(mezo);
		mezo.setSzereplo(k);
	
		k.Takarit();
	}

	/**
	 * A use-case-hez tartózó leirás
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo havat takarit el";
	}

}
