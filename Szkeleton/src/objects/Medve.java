package objects;
import java.io.Serializable;

import indent.Indentor;

/**
 * A Medve egy olyan osztály, ami tud Mezo-t váltani, tehát a Lepheto-ből származik.
 * @author Aviato
 */
public class Medve extends Lepheto {

	public Medve(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = -8455595600003604288L;
 

    /**
     * Automatikus léptetés a következő Mezo-re.
     * @param cel Az új Mezo, ami biztos, hogy szomszédos az előzővel, mert a kontroller fogja kiválasztani
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
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return Medve Stringgel tér vissza
     */
    @Override
    public String Name() 
    {
        return "Medve";
    }

 

    /**
     * A medve támadását végzi el, amit az aktmezo-jének továbbítja.
     */
    public void Tamadas()
    {
        aktmezo.Tamadas();
    }
}