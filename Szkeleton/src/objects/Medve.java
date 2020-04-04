package objects;
import java.io.Serializable;

import indent.Indentor;

/**
 * A Medve egy olyan oszt�ly, ami tud Mezo-t v�ltani, teh�t a Lepheto-b�l sz�rmazik.
 * @author Aviato
 */
public class Medve extends Lepheto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455595600003604288L;

	/**
	 * Automatikus l�ptet�s a k�vetkez� Mezo-re.
	 * @param cel Az �j Mezo, ami biztos, hogy szomsz�dos az el�z�vel, mert a kontroller fogja kiv�lasztani
	 */
	@Override
	public void Atlep(Mezo cel) 
	{
		aktmezo.MedveKiad();
		cel.setMedve(this);
		setMezo(cel);
		Tamadas();
	}

	/**
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return Medve Stringgel t�r vissza
	 */
	@Override
	public String Name() 
	{
		return "Medve";
	}

	/**
	 * A medve t�mad�s�t v�gzi el, amit az aktmezo-j�nek tov�bb�tja.
	 */
	public void Tamadas()
	{
		aktmezo.Tamadas();
	}
}
