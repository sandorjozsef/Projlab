package objects;
/**
 * Ez egy olyan interfész, ami a tárgyat szimbolizálja, annak egy képességével.
 * @author Aviato
 */
public interface Targy {
	/**
	 * A Targy képességét végrehajtó függvény.
	 * @param felhasznalo Ez a Szereplo a használó
	 */
	public void Kepesseg(Szereplo felhasznalo);
	
	/**
	 * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
	 * @return A leszármazott fogja meghatározni
	 */
	public String Name();
}
