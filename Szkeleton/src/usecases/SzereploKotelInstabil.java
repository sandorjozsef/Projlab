package usecases;
import objects.*;
/**
 * Szereplő kötél használatát szimuláló use-case osztály, amikor a kötelet egy
 * instabil mezon használja, onnan menekíti a játékosokat
 */
public class SzereploKotelInstabil implements UseCase{
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
	
		// TODO Auto-generated method stub
		Kutato k = new Kutato();
		Kotel kotel = new Kotel();		
		StabilJegtabla stabilJ = new StabilJegtabla(null);
		InstabilJegtabla instabilJ = new InstabilJegtabla(null,3);
		Eszkimo e = new Eszkimo();
		
		Palya.setAktJatekos(k);
		e.setMezo(instabilJ);
		k.setMezo(stabilJ);
		instabilJ.setAlatta(e);
		stabilJ.setSzereplo(k);
		stabilJ.setSzomszed(instabilJ);
		instabilJ.setSzomszed(stabilJ);
		
	
		k.Hasznal(kotel);
		
	}

	/**
	 * A use-case-hez tartázó leírás
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo kotelet hasznal egy szomszedos instabil mezon";
	}

}