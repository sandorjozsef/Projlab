package objects;
import java.util.*;

/**
 * Ez egy absztrakt osztály, amely egy építményt szimbolizál.
 * @author Aviato
 */
public abstract class Epulet {
	/**
	 * Absztrakt függvény, amivel az adott építmény speciális képességét lehet megadni.
	 * @param szereplok Rajta álló Szereplo-ket mutatja, akikre vonatkozik a spec. képesség
	 */
	public abstract void Levon(ArrayList<Szereplo> szereplok);
	
	/**
	 * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
	 * @return A konkrét leszármazott fogja meghatározni
	 */
	public abstract String Name();
}
