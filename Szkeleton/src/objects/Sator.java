package objects;

import java.util.ArrayList;
import indent.Indentor;
/**
 * Targy-at implement�l�, Epulet-b�l lesz�rmaz� oszt�ly. Teh�t egy Mezo-r�l fel lehet venni,
 * majd haszn�lat�val fel�ll�tani, ami egy k�r ut�n megsz�nik.
 * @author Aviato
 */
public class Sator extends Epulet implements Targy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2877347695156132464L;
	private int elettartam = Palya.getSzereplokSzama();
	
	/**
	 * A Sator fel�ll�t�s�t v�gzi el.
	 * @param felhasznalo Neki az aktmezo-j�re �ll�tja fel
	 */
	@Override
	public void Kepesseg(Szereplo felhasznalo) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Kepesseg()");
		felhasznalo.getMezo().setEpulet(this);
		Indentor.degLevel();
	}

	/**
	 * Nem csin�l semmit, mert az id�j�r�st�l megv�di a benne tart�zkod�kat.
	 * @param szereplok A rajta tart�zkod� Szereplo-k �sszess�ge 
	 */
	@Override
	public void Levon(ArrayList<Szereplo> szereplok) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Levon()");
		Indentor.degLevel();
	}

	/**
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return Sator Stringgel t�r vissza
	 */
	@Override
	public String Name() 
	{
		return "Sator";
	}

	/**
	 * Az el�reged�s�t hivatott megval�s�tani
	 * @return Egy boolean, ami azt mutatja meg, hogy �sszeomlik (true) vagy m�g haszn�lhat� (false)
	 */
	@Override
	public boolean Amortizacio() 
	{
		return (--elettartam <= 0);
	}
	
	/**
	 * Egy Medve t�mad�st�l nem v�di meg a benne l�v� Szereplo-ket,
	 * teh�t a JatekVege(false) f�ggv�nyh�v�st v�gzi.
	 */
	@Override
	public void Tamadas() 
	{
		Palya.JatekVege(false);
	}

}
