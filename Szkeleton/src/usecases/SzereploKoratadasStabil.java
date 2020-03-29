package usecases;
import objects.*;
/**
 * A körök átadását a szereplők között szimulálás use-case osztály
 * Ebben az esetben a következő játékos stabil mezőn áll így annak a hatása fog érvényesülni
 * rá, ha megkapja a kört.
 */
public class SzereploKoratadasStabil implements UseCase {

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
		StabilJegtabla mezo = new StabilJegtabla(null);
		Kutato k = new Kutato();
		Eszkimo e = new Eszkimo();
		
		Palya.setAktJatekos(k);
		
		e.setMezo(mezo);
		mezo.setSzereplo(e);
		Palya.addMezo(mezo);
		Palya.addSzereplo(k);
		Palya.addSzereplo(e);
		
	
		k.Vegeztem();
		Palya.clear();
	}

	/**
	 * A use-case-hez tartÃ³zÃ³ leirÃ¡s
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo atadja a koret stabil mezon allo szereplonek";
	}

}
