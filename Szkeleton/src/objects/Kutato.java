package objects;


import java.io.IOException;
import java.io.InputStreamReader;

import view.GrafNezet;


/**
 * A Kutato egy fajta Szereplo, mely azzal a képességgel bír, hogy fel tudja
 * deríteni a szomszédos vagy épp az aktuális mező teherbírását.
 * 
 * @author Aviato
 *
 */
public class Kutato extends Szereplo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3048016287563747115L;

	/**
	 * Kutato konstruktora, meghívja az ős konstruktorát
	 * A testhő attribútumát 4-re állítja.
	 * @param id
	 */
	public Kutato(String id) {
		super(id);
		testho = 4;
	}

	/**
	 * Először ellenőrzi, hogy léphet-e
	 *  A metódus eldönti a paraméterként kapott mezőről, hogy felderíthető-e,
	 *  (aktuális vagy szomszédos), ha felderíthető, akkor meghívja a mező
	 *  Felderít függvényét.
	 */
	public void SpecKepesseg(Mezo cel) {
		if (!Lephet())			
			return;

		boolean szomszed = aktmezo.isSzomszed(cel);
		if(cel!=null && (szomszed || cel.equals(aktmezo))) {
			cel.Felderit();
		}

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
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
=======
		n.FrissitKutato(this, Palya.getAktJatekos() == this);
>>>>>>> branch 'master' of https://github.com/sandorjozsef/Projlab.git
	}
}
