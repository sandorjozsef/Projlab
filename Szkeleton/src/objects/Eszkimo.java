package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import view.GrafNezet;



/**
 * Az Eszkimo osztály példányai 5 testhővel kezdik a játékot, és tudnak iglut
 * építeni speciális képességként. Az Eszkimó a Szereplő leszármazottja.
 * 
 * @author Aviato
 *
 */
public class Eszkimo extends Szereplo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7931023977094485080L;

	/**
	 * Szereplő konstruktora, meghívja az ős konstruktorát
	 * A testhő attribútumát 5-re állítja.
	 * @param id
	 */
	public Eszkimo(String id) {
		super(id);
		testho = 5;
	}

	/**
	 * Először ellenőrzi, hogy léphet-e
	 * Amennyiben a cel megegyezik az Eszkimo aktmezo attribútumával, akkor
	 * létrehoz egy Iglu objektumot, majd meghívja
	 * ennek a Mezőnek a setEpulet() függvényét az imént létrehozott igluval.
	 * @param cel
	 */
	public void SpecKepesseg(Mezo cel) {
		if (!Lephet())
			return;
		
		
		if (cel!=null && cel.equals(aktmezo)) {
			Iglu iglu = new Iglu();
			cel.setEpulet(iglu);
		}


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

	@Override
	public void Autolepes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Erintkezik() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void FrissitNezet(GrafNezet n) {

		n.FrissitEszkimo(this, Palya.getAktJatekos() == this);

	}

}
