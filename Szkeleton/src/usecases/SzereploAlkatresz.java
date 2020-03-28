package usecases;

import objects.*;

/*
 * Szereplő alkatrész használatát szimuláló use-case osztály
 */
public class SzereploAlkatresz implements UseCase {

	@Override
	public void run() {
		/*
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		// TODO Auto-generated method stub
		StabilJegtabla mezo = new StabilJegtabla(null);
		Kutato akt_jatekos = new Kutato();
		Alkatresz alk = new Alkatresz();
		
		Palya.setAktJatekos(akt_jatekos);
		Palya.addMezo(mezo);
		Palya.addSzereplo(akt_jatekos);
		mezo.setSzereplo(akt_jatekos);
		akt_jatekos.setMezo(mezo);
		
		/*
		 * Futtatjuk a szekvenciát
		 * reseteljük a Palya tartalmát
		 */
		akt_jatekos.Hasznal(alk);
		Palya.clear();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/*
		 * A use-case-hez tartózó leirás
		 */
		return "Szereplo alkatreszt hasznal";
	}

}
