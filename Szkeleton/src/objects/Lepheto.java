package objects;

import indent.Indentor;

public abstract class Lepheto {
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
	 * Beállitja a mezõt, amin a szereplõ áll Inicializáló függvény nem jelezzük a
	 * konzolon, hogy lefutott
	 */
	public void setMezo(Mezo mezo) {
		aktmezo = mezo;
	}
	
	public abstract void Atlep(Mezo cel);
	
	public abstract String Name();
}
