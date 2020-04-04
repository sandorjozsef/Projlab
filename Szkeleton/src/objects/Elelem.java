package objects;
import java.io.Serializable;

import indent.Indentor;
/**
 * Ez az oszt�ly megval�s�tja a Targy interf�szt.
 * �lelmet reprezent�l, ami n�veli a testho adattagj�t egy Szereplo-nek.
 * @author Aviato
 */
public class Elelem implements Targy, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4429824372466305274L;

	/**
	 * Az adott Elelem elfogyaszt�sra ker�lt, ezzel megsz�nik.
	 * @param felhasznalo Ennek a Szereplo-nek n�veli a testho attrib�tum�t eggyel �s eldobatja a targy list�b�l a referenci�j�t
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
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return Elelem Stringgel t�r vissza
	 */
	public String Name() {
		return "Elelem";
	}
}
