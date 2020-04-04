package objects;

import java.io.Serializable;

import indent.Indentor;
/**
 * 
 * @author Aviato
 *
 */
public abstract class Lepheto implements Serializable{
	private String id;
	public Lepheto(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -2198649095488230530L;
	
    /**
     * Az aktuális tartózkodási Mezo
     */
    protected Mezo aktmezo; 

    /**
     * Visszaadja az aktuális mezőt (aktmezo).
     * 
     * @return Az aktuális mező
     */
    public Mezo getMezo() {
        Indentor.incLevel();
        System.out.println(Indentor.getIndent() + Name() + ".getMezo()");
        Indentor.degLevel();
        return aktmezo;
    }

 

    /**
     * Beállitja az aktuális tartózkodási mezőt. Inicializáló függvény nem jelezzük a
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