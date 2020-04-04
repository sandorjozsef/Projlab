package objects;

import java.io.Serializable;

import indent.Indentor;

/**
 * Targy interf�szt implement�l, �gy lehet haszn�lni, mint a Lapat-ot, 
 * csak 3 haszn�lat ut�n elt�rik (haszn�lhatatlann� v�lik).
 * @author Aviato
 */
public class Aso implements Targy, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8412355569771891943L;
	private int elettartam = 3;
	
	/**
	 * Az Aso-nak az �s� k�pess�g�t megval�s�t� f�ggv�ny.
	 * @param felhasznalo A param�terk�nt kapott Szereplo-nek a Mezo-j�n l�v� h� mennyis�g�t cs�kkenti 2-vel
	 */
	@Override
	public void Kepesseg(Szereplo felhasznalo) 
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".Kepesseg()");	
		felhasznalo.getMezo().HoHozzaad(-2);
		--elettartam;
		if (elettartam <= 0)
			felhasznalo.Eldob(this);
		Indentor.degLevel();
	}

	/**
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return Aso Stringgel t�r vissza
	 */
	@Override
	public String Name() 
	{
		return "Aso";
	}
	
}
