package objects;
/**
 * Ez egy olyan interf�sz, ami a t�rgyat szimboliz�lja, annak egy k�pess�g�vel.
 * @author Aviato
 */
public interface Targy {
	/**
	 * A Targy képességét v�grehajt� f�ggv�ny.
	 * @param felhasznalo Ez a Szereplo a haszn�l�
	 */
	public void Kepesseg(Szereplo felhasznalo);
	
	/**
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return A lesz�rmazott fogja meghat�rozni
	 */
	public String Name();
}
