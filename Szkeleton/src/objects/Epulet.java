package objects;
import java.io.Serializable;
import java.util.*;
<<<<<<< HEAD

import view.Nezheto;

=======
import view.*;
>>>>>>> branch 'master' of https://github.com/sandorjozsef/Projlab.git
/**
 * Ez egy absztrakt osztály, amely egy építményt szimbolizál.
 * @author Aviato
 */
public abstract class Epulet implements Serializable, Nezheto{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3497283089797488934L;
	
    /**
     * Absztrakt függvény, amivel az adott építmény speciális képességét lehet megadni.
     * @param szereplok Rajta álló Szereplo-ket mutatja, akikre vonatkozik a függvény hatása
     */
    public abstract void Levon(ArrayList<Szereplo> szereplok);
   
    /**
     * Absztrakt függvény, az adott Epulet megsemmisülését vizsgálja, hogy érvényes-e.
     */
    public abstract boolean Amortizacio();
   
    /**
     * Absztrakt függvény, a Mezo-t ért támadás hatását fogja leképezni.
     */
    public abstract void Tamadas();
   
    /**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return A konkrét leszármazott fogja meghatározni
     */
    public abstract String Name();
    
    @Override
    public abstract void FrissitNezet(GrafNezet n);
}