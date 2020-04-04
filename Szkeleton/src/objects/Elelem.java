package objects;
import java.io.Serializable;

import indent.Indentor;
/**
 * Ez az osztály megvalósítja a Targy interfészt.
 * Élelmet reprezentál, ami növeli a testho adattagját egy Szereplo-nek.
 * @author Aviato
 */
public class Elelem implements Targy, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4429824372466305274L;

	/**
     * Az adott Elelem elfogyasztásra került, ezzel megszűnik.
     * @param felhasznalo Ennek a Szereplo-nek növeli a testho attribútumát eggyel és eldobatja a targy listából a referenciáját
     */
	public void Kepesseg(Szereplo felhasznalo)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Kepesseg()");
		felhasznalo.TesthoHozzaad(1);
		felhasznalo.Eldob(this);
		Indentor.degLevel();
	}
	
	/**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Elelem Stringgel tér vissza
     */
	public String Name() {
		return "Elelem";
	}
}
