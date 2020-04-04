package objects;
import java.io.Serializable;

import indent.Indentor;
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
     * @param felhasznalo Ennek a Szereplo-nek állítja a hozzá tartozó Ruha-t.
     */
	@Override
	public void Kepesseg(Szereplo felhasznalo)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Kepesseg()");
		felhasznalo.setRuha(this);
		Indentor.degLevel();
	}

	/**
     * Nem csinál semmit, mert a Buvarruha nem tud elázni és viselete közben megfagyni sem lehet.
     * @param szereplo Hozzá tartozik az adott Buvarruha
     */
	@Override
	public void Elazik(Szereplo szereplo) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Elazik()");
		Indentor.degLevel();
	}
	
	/**
     * Nem csinál semmit, mert a Buvarruha nem tud elázni és ebből adódóan nincs miért megszáradjon.
     */
	@Override
	public void Megszarit() 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Megszarit()");
		Indentor.degLevel();
	}
	
	/**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Buvarruha Stringgel tér vissza
     */
	@Override
	public String Name() {
		return "Buvarruha";
	}
}
