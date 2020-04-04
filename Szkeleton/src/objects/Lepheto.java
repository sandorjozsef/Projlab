package objects;

import java.io.Serializable;

import indent.Indentor;
/**
 * 
 * @author Aviato
 *
 */
public abstract class Lepheto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2198649095488230530L;
	/**
	 * Az aktu�lis tart�zkod�si Mezo
	 */
	protected Mezo aktmezo;

	/**
	 * Visszaadja az aktu�lis mez�t (aktmezo).
	 * 
	 * @return Az aktu�lis mez�
	 */
	public Mezo getMezo() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".getMezo()");
		Indentor.degLevel();
		return aktmezo;
	}

	/**
	 * Be�llitja az aktu�lis tart�zkod�si mez�t. Inicializ�l� f�ggv�ny nem jelezz�k a
	 * konzolon, hogy lefutott.
	 * @param mezo Az �j Mezo, amin tart�zkodik.
	 */
	public void setMezo(Mezo mezo) {
		aktmezo = mezo;
	}
	
	/**
	 * Az Mezo-k k�zti v�lt�st lehet megh�v�s�val megtenni.
	 * @param cel Az �j Mezo, amire �t szeretn�nk l�pni
	 */
	public abstract void Atlep(Mezo cel);
	
	/**
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return A konkr�t lesz�rmazott fogja meghat�rozni
	 */
	public abstract String Name();
}
