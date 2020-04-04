package usecases;

import objects.*;
/**
 * Szereplő stabil mezőre lépését szimuláló use-case osztály
 */
public class SzereploLepStabil implements UseCase {
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
		Eszkimo sz = new Eszkimo();
		InstabilJegtabla mezo1 = new InstabilJegtabla("mezo" ,null,4);
		StabilJegtabla mezo2 = new StabilJegtabla("mezo2" ,null);
		
		Palya.setAktJatekos(sz);
		sz.setMezo(mezo1);
		mezo1.setSzereplo(sz);
		mezo1.setSzomszed(mezo2);
		mezo2.setSzomszed(mezo1);
	
		sz.Atlep(mezo2);

	}

	/**
	 * A use-case-hez tartózó leirás
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo stabil jegtablara lep";
	}

}
