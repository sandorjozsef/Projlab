package usecases;

import objects.*;

/**
 * Szereplő alkatrész használatát szimuláló use-case osztály
 */
public class SzereploAlkatresz implements UseCase {
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
		StabilJegtabla mezo = new StabilJegtabla(null);
		Kutato akt_jatekos = new Kutato();
		Alkatresz alk = new Alkatresz();
		
		Palya.setAktJatekos(akt_jatekos);
		Palya.addMezo(mezo);
		Palya.addSzereplo(akt_jatekos);
		mezo.setSzereplo(akt_jatekos);
		akt_jatekos.setMezo(mezo);
		
	
		akt_jatekos.Hasznal(alk);
		Palya.clear();
	}

	/**
	 * A use-case-hez tartózó leirás
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo alkatreszt hasznal";
	}

}
