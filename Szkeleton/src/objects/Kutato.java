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

	public Kutato() {
		super();
	}

	/**
	 *  A metódusban meg lehet jelölni egy szomszédos vagy aktuális mezőt, amelyről
	 * megmondja a teherbírását. 
	 */
	public void SpecKepesseg(Mezo cel) {

		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Kutato.SpecKepesseg()");

		boolean szomszed = aktmezo.isSzomszed(cel);
		
		/*if (szomszed) {
			cel.Felderit();
		} else {
			String answer1 = "";
			while (!answer1.equals("Y") && !answer1.equals("N")) {
				System.out.print(Indentor.getIndent() + " - A felderitendo mezo az aktuális mezo? ? (Y/N) ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {
					answer1 = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (answer1.equals("Y")) {
					cel.Felderit();
				}
			}
		}*/
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
