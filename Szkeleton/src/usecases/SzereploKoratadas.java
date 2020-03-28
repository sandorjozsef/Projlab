package usecases;
import objects.*;
public class SzereploKoratadas implements UseCase {

	/*
	 * A körök átadását a szereplők között szimuláló use-case osztály
	 */
	@Override
	public void run() {
		/*
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		StabilJegtabla mezo = new StabilJegtabla(null);
		Kutato k = new Kutato();
		Kutato k2 = new Kutato();
		
		Palya.setAktJatekos(k);
		
		k2.setMezo(mezo);
		mezo.setSzereplo(k2);
		Palya.addMezo(mezo);
		Palya.addSzereplo(k);
		Palya.addSzereplo(k2);
		
		/*
		 * Futtatjuk a szekvenciát
		 * reseteljük a Palya tartalmát
		 */
		k.Vegeztem();
		Palya.clear();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/*
		 * A use-case-hez tartózó leirás
		 */
		return "Szereplo atadja a koret";
	}

}
