package usecases;
import objects.*;
/**
 * Szereplő kötél használatát szimuláló use-case osztály, amikor a kötelet egy
 * lukon használja, onnan menekiti a játékosokat
 */
public class SzereploKotelLukrol implements UseCase{
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
		Kutato k = new Kutato("kutato");
		Kotel kotel = new Kotel();		
		StabilJegtabla stabilJ = new StabilJegtabla("mezo" ,null);
		Luk luk = new Luk("mezo2");
		Eszkimo e = new Eszkimo("eszkimo");
		
		Palya.setAktJatekos(k);
		e.setMezo(luk);
		k.setMezo(stabilJ);
		luk.setSzereplo(e);
		stabilJ.setSzereplo(k);
		stabilJ.setSzomszed(luk);
		luk.setSzomszed(stabilJ);
		
	
		k.Hasznal(kotel);
		
	}

	/**
	 * A use-case-hez tartozó leirás
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Szereplo kotelet hasznal egy szomszedos lukon";
	}

}
