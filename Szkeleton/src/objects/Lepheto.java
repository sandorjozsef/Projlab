package objects;

import indent.Indentor;

public abstract class Lepheto {
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
	 * Be�llitja a mez�t, amin a szerepl� �ll Inicializ�l� f�ggv�ny nem jelezz�k a
	 * konzolon, hogy lefutott
	 */
	public void setMezo(Mezo mezo) {
		aktmezo = mezo;
	}
	
	public abstract void Atlep(Mezo cel);
	
	public abstract String Name();
}
