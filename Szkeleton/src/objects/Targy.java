package objects;
<<<<<<< HEAD

import view.Nezheto;

=======
import view.*;
>>>>>>> branch 'master' of https://github.com/sandorjozsef/Projlab.git
/**
 * Ez egy olyan interfész, ami a tárgyat szimbolizálja, annak egy képességével.
 * @author Aviato
 */
public interface Targy extends Nezheto {
    /**
     * A Targy képességét végrehajtó függvény.
     * @param felhasznalo Ez a Szereplo használja az adott Targy-at
     */
    public void Kepesseg(Szereplo felhasznalo); 
    
    /**
     * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
     * @return A leszármazott fogja meghatározni  
     */
    public String Name();
    
    @Override
    public abstract void FrissitNezet(GrafNezet n);
}