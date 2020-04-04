package usecases;
import objects.*;
/**
 * Eszkimó iglu épitését szimuláló use-case osztály
 */
public class EszkimoIglutEpit implements UseCase{

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
		StabilJegtabla akt_mezo = new StabilJegtabla("mezo" ,null);
		Eszkimo sz = new Eszkimo("eszkimo");
		Palya.setAktJatekos(sz);
		sz.setMezo(akt_mezo);
		akt_mezo.setSzereplo(sz);
		
		
		sz.SpecKepesseg(akt_mezo);
	}

	/**
	 * A use-case-hez tartózó leírás
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Eszkimo megprobal iglut tenni egy mezore";
		
	}

}
