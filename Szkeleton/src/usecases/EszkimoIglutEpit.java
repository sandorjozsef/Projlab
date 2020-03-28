package usecases;
import objects.*;
/*
 * Eszkimó igu épitését szimuláló use-case osztály
 */
public class EszkimoIglutEpit implements UseCase{

	@Override
	public void run() {
		/*
		 * létrehozzuk a szükséges objektumokat és felállitjuk a köztük lévő kapcsolatot 
		 * a kommunikációs diagramm alapján a Palya-t egyik esetben sem kell létrehozni, mert
		 * statikus osztály, de minden esetleges használat után töröljük a tartalmát a clear() függvényével,
		 * hogy ez ne befolyásolja a többi use-case teszt futását
		 */
		// TODO Auto-generated method stub
		StabilJegtabla akt_mezo = new StabilJegtabla(null);
		Eszkimo sz = new Eszkimo();
		Palya.setAktJatekos(sz);
		sz.setMezo(akt_mezo);
		akt_mezo.setSzereplo(sz);
		
		/*
		 * Futtatjuk a szekvenciát
		 *
		 */
		sz.SpecKepesseg(akt_mezo);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		/*
		 * A use-case-hez tartózó leirás
		 */
		return "Eszkimo megprobal iglut tenni egy mezore";
		
	}

}
