package objects;
import indent.Indentor;
/**
 * Ez az osztály megvalósítja a Targy interfészt.
 * Élelmet reprezentál, ami növeli a testho adattagját egy Szereplo-nek.
 * @author Aviato
 */
public class Elelem implements Targy {
	/**
	 * Az adott Elelem elfogyasztásra került, ezzel megszûnik.
	 * @param felhasznalo Ennek a Szereplo-nek növeli a testho attribútumát eggyel és eldobatja a targy listából a referenciáját
	 */
	public void Kepesseg(Szereplo felhasznalo)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Elelem.Kepesseg()");
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
