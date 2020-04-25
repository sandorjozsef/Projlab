package objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 * A Szereplo-höz tartozó olyan fajta ruha, amely kezdetben van rajta.
 * Ha ilyen viselete közben esik valaki vízbe, akkor el tud ázni és idővel megfagyni, ami a játék vesztését vonja maga után.
 * @author Aviato
 */
public class AlapRuha extends Ruha{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8985600671678347139L;
	/**
	 * Az AlapRuha-nak azt a tulajdonságát jelzi, hogy mennyire van elázva.
	 * Az értéke 0, ha száraz, 1, ha vizes, illetve 2, ha megfagy.
	 */
	private int elazasi_szint = 0;
	
	/**
     * Ez a függvény gondoskodik arról, hogy a vízben lévő Szereplo "vizesebb" legyen,
     * azaz elázzon, illetve megfagyjon.
     * @param sz Beállítja 0-ra a lepesszam attribútumát és  ha megfagyott (elazasi_szint == 2), akkor ezen a Szereplo-n hívja meg a Meghaltam függvényt.
     */
	@Override
	public void Elazik(Szereplo sz)
	{ 
		
		
		sz.setLepesszam(0);
		if (elazasi_szint == 2)
		{
			sz.Meghaltam();
		}
		elazasi_szint++;
		
	}
	
	/**
     * Ezzel a metódussal vízből kijövet meg tud száradni a ruha, ezzel biztosítva,
     * hogy újabb vízbe eséskor is meglegyen mindkét fázis (vizes és megfagyott).
     * elazasi_szint-et 0-ra állítja.
     */
	@Override
	public void Megszarit()
	{
		
		
		elazasi_szint = 0;
	}
	
	/**
    * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
    * @return Alapruha Stringgel fog visszatérni
    */
	@Override
	public String Name() {
		return "AlapRuha";
	}
}
