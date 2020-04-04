package objects;
import java.io.Serializable;
import java.util.*;

/**
 * Ez egy absztrakt oszt�ly, amely egy �p�tm�nyt szimboliz�l.
 * @author Aviato
 */
public abstract class Epulet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3497283089797488934L;

	/**
	 * Absztrakt f�ggv�ny, amivel az adott �p�tm�ny speci�lis k�pess�g�t lehet megadni.
	 * @param szereplok Rajta �ll� Szereplo-ket mutatja, akikre vonatkozik a spec. k�pess�g
	 */
	public abstract void Levon(ArrayList<Szereplo> szereplok);
	
	/**
	 * Absztrakt f�ggv�ny, az adott Epulet megsemmis�l�s�t vizsg�lja, hogy �rv�nyes-e.
	 */
	public abstract boolean Amortizacio();
	
	/**
	 * Absztrakt f�ggv�ny, a Mezo-t �rt t�mad�s hat�s�t fogja lek�pezni.
	 */
	public abstract void Tamadas();
	
	/**
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return A konkr�t lesz�rmazott fogja meghat�rozni
	 */
	public abstract String Name();
}
