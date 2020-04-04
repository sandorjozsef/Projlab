package objects;

import java.util.ArrayList;

import indent.Indentor;
/**
 *    olyan osztály amely felelős azért hogy egy adott mezot
 *    ne érjen hóvihar, ha az adott mezo stabiljegtabla és
 *    jogosult erre a privilégiumra
 *		áá
 */
public class Iglu extends Epulet{
    /**
     *  nem csinál semmit, hiszen ha iglu van a mezőn akkor nem kell levonni
     */
    @Override
    public void Levon(ArrayList<Szereplo> szereplok) {
        // TODO Auto-generated method stub
        Indentor.incLevel();
        System.out.println(Indentor.getIndent()+"Iglu.Levon()");
        Indentor.degLevel();
       
       
    }
    /**
     *    tudatja a kiiratásnál hogy egy Iglun végzik az esetlegesen
     *    mezobol nem felüldefiniált függvényt    
     */
    public String Name() {
        return "Iglu";
    }
   
    /**
     *
     */
    @Override
    public boolean Amortizacio()
    {
        return false;
    }
   
    /**
     *
     */
    @Override
    public void Tamadas()
    {}
}
