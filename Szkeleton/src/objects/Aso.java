package objects;

import java.io.Serializable;

import view.GrafNezet;



/**
 * Targy interfészt implementál, úgy lehet használni, mint a Lapat-ot,
 * csak 3 használat után eltörik (használhatatlanná válik).
 * @author Aviato
 */
public class Aso implements Targy, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8412355569771891943L;
	
	/**
	 * Azt mutatja meg, hogy még hányszor lehet használni, mielőtt eltörik.
	 */
	private int elettartam = 3;
	
	/**
     * Az Aso-nak az ásó képességét megvalósító függvény.
     * @param felhasznalo A paraméterként kapott Szereplo-nek a Mezo-jén lévő hó mennyiségét csökkenti 2-vel.
     * Ez után ha már nem lehet használni (elattartam <= 0), akkor meghívja az Eldob függvényét, aminek paramétereként magát az Aso-t adja.
     */
	@Override
	public void Kepesseg(Szereplo felhasznalo) 
	{
		felhasznalo.getMezo().HoHozzaad(-2);
		--elettartam;
		if (elettartam <= 0)
			felhasznalo.Eldob(this);
	}

	/**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Aso Stringgel tér vissza
     */
	@Override
	public String Name() 
	{
		return "Aso";
	}

	@Override
	public void FrissitNezet(GrafNezet n) {
		n.FrissitAso(this);
	}
	
}
