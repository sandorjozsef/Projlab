package objects;
import java.io.Serializable;

import view.GrafNezet;


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
     * @param felhasznalo Ennek a Szereplo-nek növeli a testho attribútumát eggyel
     * (meghívja a TesthoHozzaad függvényét) és eldobatja a targy listából a referenciáját (meghívja az Eldob függvényét,aminek paraméteréül önmagát adja)
     */
	public void Kepesseg(Szereplo felhasznalo, Mezo m)
	{
		felhasznalo.TesthoHozzaad(1);
		felhasznalo.Eldob(this);
	}
	
	/**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Elelem Stringgel tér vissza
     */
	public String Name() {
		return "Elelem";
	}

	@Override
	public void FrissitNezet(GrafNezet n) {

		n.FrissitElelem(this);

	}
}
