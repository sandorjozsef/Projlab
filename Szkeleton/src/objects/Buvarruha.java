package objects;
import java.io.Serializable;

import view.GrafNezet;


/**
 * Ez az osztály megvalósítja a Targy interfészt és leszármazottja a Ruha-nak.
 * Tehát egy Jegtabla-ról az Atad függvény segítségével fel lehet venni a Szereplo-nek és használata után ez lesz a Ruha-ja.
 * @author Aviato
 */
public class Buvarruha extends Ruha implements Targy, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1654342135967208709L;

	/**
     * A paraméterként kapott Szereplo-nek a Ruha-ját átállítja önmagára.
     * @param felhasznalo Ennek a Szereplo-nek állítja át a hozzá tartozó Ruha-t magára a Buvarruha-ra.
     */
	@Override
	public void Kepesseg(Szereplo felhasznalo)
	{
		felhasznalo.setRuha(this);
	}

	/**
     * Nem csinál semmit, mert a Buvarruha nem tud elázni és viselete közben megfagyni sem lehet.
     * @param szereplo Hozzá tartozik az adott Buvarruha
     */
	@Override
	public void Elazik(Szereplo szereplo) 
	{
	}
	
	/**
     * Nem csinál semmit, mert a Buvarruha nem tud elázni és ebből adódóan nincs miért megszáradjon.
     */
	@Override
	public void Megszarit() 
	{
	}
	
	/**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Buvarruha Stringgel tér vissza
     */
	@Override
	public String Name() {
		return "Buvarruha";
	}

	@Override
	public void FrissitNezet(GrafNezet n) {

		n.FrissitBuvarRuha(this);

	}
}
