package objects;


import java.io.IOException;
import java.io.InputStreamReader;

import indent.Indentor;

/**
 * A Kutato egy fajta Szereplo, mely azzal a képességgel bír, hogy fel tudja
 * deríteni a szomszédos vagy épp az aktuális mező teherbírását.
 * 
 * @author Sándor József
 *
 */
public class Kutato extends Szereplo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3048016287563747115L;

	public Kutato(String id) {
		super(id);
		testho = 4;
	}

	/**
	 *  A metódusban meg lehet jelölni egy szomszédos vagy aktuális mezőt, amelyről
	 * megmondja a teherbírását. 
	 */
	public void SpecKepesseg(Mezo cel) {
		if (!Lephet())
			return;
		
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Kutato.SpecKepesseg()");

		boolean szomszed = aktmezo.isSzomszed(cel);
		
		
		if(szomszed || cel.equals(aktmezo)) {
			cel.Felderit();
		}

		Indentor.degLevel();
	}

	/**
	 * tudatja a kiiratásnál hogy egy Kutato végzi az esetlegesen Szereplo-ből nem
	 * felüldefiniált függvényt
	 * 
	 */
	@Override
	public String Name() {
		// TODO Auto-generated method stub
		return "Kutato";
	}
}
