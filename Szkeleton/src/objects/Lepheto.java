package objects;

import indent.Indentor;
/**
 * 
 * @author Aviato
 *
 */
public abstract class Lepheto {
	/**
	 * Az aktuális tartózkodási Mezo
	 */
	protected Mezo aktmezo;

	/**
	 * Visszaadja az aktuális mezõt (aktmezo).
	 * 
	 * @return Az aktuális mezõ
	 */
	public Mezo getMezo() {
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + Name() + ".getMezo()");
		Indentor.degLevel();
		return aktmezo;
	}

	/**
	 * Beállitja az aktuális tartózkodási mezõt. Inicializáló függvény nem jelezzük a
	 * konzolon, hogy lefutott.
	 * @param mezo Az új Mezo, amin tartózkodik.
	 */
	public void setMezo(Mezo mezo) {
		aktmezo = mezo;
	}
	
	/**
	 * Az Mezo-k közti váltást lehet meghívásával megtenni.
	 * @param cel Az új Mezo, amire át szeretnénk lépni
	 */
	public abstract void Atlep(Mezo cel);
	
	/**
	 * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
	 * @return A konkrét leszármazott fogja meghatározni
	 */
	public abstract String Name();
}
