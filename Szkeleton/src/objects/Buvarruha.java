package objects;
import java.io.Serializable;

import indent.Indentor;
/**
 * Ez az oszt�ly megval�s�tja a Targy interf�szt �s lesz�rmazottja a Ruha-nak.
 * Teh�t egy Jegtabla-r�l az Atad f�ggv�ny seg�ts�g�vel fel lehet venni a Szereplo-nek �s haszn�lata ut�n ez lesz a Ruha-ja.
 * @author Aviato
 */
public class Buvarruha extends Ruha implements Targy, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1654342135967208709L;

	/**
	 * A param�terk�nt kapott Szereplo-nek a Ruha-j�t �t�ll�tja �nmag�ra.
	 * @param felhasznalo Ennek a Szereplo-nek �ll�tja a hozz� tartoz� Ruha-t.
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
	 * Nem csin�l semmit, mert a Buvarruha nem tud el�zni �s viselete k�zben megfagyni sem lehet.
	 * @param szereplo Hozz� tartozik az adott Buvarruha
	 */
	@Override
	public void Elazik(Szereplo szereplo) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Elazik()");
		Indentor.degLevel();
	}
	
	/**
	 * Nem csin�l semmit, mert a Buvarruha nem tud el�zni �s ebb�l ad�d�an nincs mi�rt megsz�radjon.
	 */
	@Override
	public void Megszarit() 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Megszarit()");
		Indentor.degLevel();
	}
	
	/**
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return Buvarruha Stringgel t�r vissza
	 */
	@Override
	public String Name() {
		return "Buvarruha";
	}
}
