package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import indent.*;

/**
 * Az Eszkimo osztály példányai 5 testhővel kezdik a játékot, és tudnak iglut
 * építeni speciális képességként.
 * 
 * @author Sándor József
 *
 */
public class Eszkimo extends Szereplo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7931023977094485080L;

	public Eszkimo() {
		super();
		testho = 5;
	}

	/**
	 * Amennyiben a cel megegyezik az Eszkimo aktmezo attribútumával, akkor meghívja
	 * ennek a Mezőnek a setIglu() függvényét. Az egyezést a Skeleton fázisban a
	 * felhasználóhoz intézett kérdés alapján dönti el.
	 */
	public void SpecKepesseg(Mezo cel) {
		if (!Lephet())
			return;
		
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Eszkimo.SpecKepesseg()");

		if (cel.equals(aktmezo)) {
			Iglu iglu = new Iglu();
			cel.setEpulet(iglu);
		}

		Indentor.degLevel();

	}

	/**
	 * tudatja a kiiratásnál hogy egy Eszkimo végzi az esetlegesen Szereplo-ből nem
	 * felüldefiniált függvényt
	 */
	@Override
	public String Name() {
		// TODO Auto-generated method stub
		return "Eszkimo";
	}

}
