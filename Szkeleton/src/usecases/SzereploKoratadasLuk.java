package usecases;
import objects.*;
	/*
	 * A körök átadását a szereplők között szimuláló use-case osztály
	 * Ebben az esetben a következő játékos lukon áll igy annak a hatása fog érvényesülni
	 * rá, ha megkapja a kört.
	 */
public class SzereploKoratadasLuk implements UseCase {

	
	@Override
	public void run() {
		/*
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		Luk mezo = new Luk();
		Kutato k = new Kutato();
		Eszkimo e = new Eszkimo();
		
		Palya.setAktJatekos(k);
		
		e.setMezo(mezo);
		mezo.setSzereplo(e);
		Palya.addMezo(mezo);
		Palya.addSzereplo(k);
		Palya.addSzereplo(e);
		
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
		return "Szereplo atadja a koret lukon allo szereplonek";
	}

}