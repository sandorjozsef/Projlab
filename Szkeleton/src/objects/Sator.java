package objects;

import java.util.ArrayList;

import view.GrafNezet;

/**
 * Targy-at implementáló, Epulet-ből leszármazó osztály. Tehát egy Mezo-ről fel lehet venni,
 * majd használatával felállítani, ami egy kör után megszűnik.
 * @author Aviato
 */
public class Sator extends Epulet implements Targy { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2877347695156132464L;

	/**
	 * A Sator élettartamát mutatja meg, vagyis azt, hogy hányszor lehet rá meghívni
	 * az Amortizacio függvényét anélkül, hogy összeomlana.
	 */
    private int elettartam = Palya.getSzereplokSzama();
    
    /**
     * A Sator felállítását végzi el.
     * @param felhasznalo Neki az aktmezo-jére állítja fel
     */
    @Override
    public void Kepesseg(Szereplo felhasznalo, Mezo m) 
    {
        felhasznalo.getMezo().setEpulet(this);
        felhasznalo.Eldob(this);
    } 

    /**
     * Nem csinál semmit, mert az időjárástől megvédi a benne tartózkodókat.
     * @param szereplok A rajta tartózkodó Szereplo-k összessége 
     */
    @Override
    public void Levon(ArrayList<Szereplo> szereplok) 
    {
 
    } 

    /**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Sator Stringgel tér vissza
     */
    @Override
    public String Name() 
    {
        return "Sator";
    }

    /**
     * Az elöregedését hivatott megvalósítani
     * @return Egy boolean, ami azt mutatja meg, hogy összeomlik (true) vagy még használható (false)
     */
    @Override
    public boolean Amortizacio() 
    {
        return (--elettartam <= 0);
    }
    
    /**
     * Egy Medve támadástól nem védi meg a benne lévő Szereplo-ket,
     * tehát a JatekVege(false) függvényhívást végzi.
     */
    @Override
    public void Tamadas() 
    {
        Palya.JatekVege(false);
    }

	@Override
	public void FrissitNezet(GrafNezet n) {

		n.FrissitSator(this);

	}
}