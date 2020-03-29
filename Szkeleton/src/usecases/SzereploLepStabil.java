package usecases;

import objects.*;
/*
 * Szereplő stabil mezőre lépését szimuláló use-case osztály
 */
public class SzereploLepStabil implements UseCase {

	@Override
	public void run() {
		/*
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		// TODO Auto-generated method stub
		Eszkimo sz = new Eszkimo();
		InstabilJegtabla mezo1 = new InstabilJegtabla(null,4);
		StabilJegtabla mezo2 = new StabilJegtabla(null);
		
		Palya.setAktJatekos(sz);
		sz.setMezo(mezo1);
		mezo1.setSzereplo(sz);
		mezo1.setSzomszed(mezo2);
		mezo2.setSzomszed(mezo1);
		/*
		 * Futtatjuk a szekvenciát
		 * 
		 */
		sz.Atlep(mezo2);

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/*
		 * A use-case-hez tartózó leirás
		 */
		return "Szereplo stabil jegtablara lep";
	}

}
