package objects;

import indent.Indentor;
/**
 *    olyan osztály amely a játékban szereplő stabiljégtáblát testesíti meg,
 *    így ilyen típusú mezőről nem lehet vízbe esni soha, valamint az eszkimóknak
 *    van lehetőségik iglut építeni rá
 */
public class StabilJegtabla extends Jegtabla{
	/**
	 * 
	 */
	private static final long serialVersionUID = 233506423267307648L;
    public StabilJegtabla(String id,Targy targy){
        super(id, targy);
    }
    /**
     *    függvény ami befogadja a belepo szereplot a regi mezorol
     *    ha szomszédos mezorol jon, és visszatér true-val ha sikerült a befogadás, valamint false-al ha nem,
     *    ezek után minden szereplőn meghívódik az érintkezés, és végül a mező hatás függvénye
     */
    public boolean Befogad(Szereplo belepo, Mezo regi)
    {
        Indentor.incLevel();
        System.out.println(Indentor.getIndent()+"StabilJegtabla.Befogad()");
        if(isSzomszed(regi)) 
        {
            this.szereplok.add(belepo);
            szereplok.forEach((sz)->sz.Erintkezik());
            Hatas(belepo);
            Indentor.degLevel();
            return true;
        }
        else 
        {
            Indentor.degLevel();
            return false; 
        }
        
    }
    /**
     *    Ha a StabilJegtablara szereplő érkezik akkor az biztos megszárad, így meghívja
     *    a megszarit függvényt
     */
    public void Hatas(Szereplo sz)
    {
        Indentor.incLevel();
        System.out.println(Indentor.getIndent()+"StabilJegtabla.Hatas()");
        sz.Megszarit();
        Indentor.degLevel();
    }
    /**
     *    felüldefiniált függvény ami épületet épít a mezőre ha az fel van már derítve
     */
    @Override
    public void setEpulet(Epulet e)
    {
        Indentor.incLevel();
        System.out.println(Indentor.getIndent()+"StabilJegtabla.setIglu()");
        if (getfelderitett())
        	iglu = e;
        Indentor.degLevel();
    }
    /**
     *    felüldefiniált függvény ami nem engedi hogy StabilJegtablarol
     *    kimenekítsenek bárkit is, ezért nem csinál semmit
     */
    public void Kimenekit(Mezo cel)
    {
        Indentor.incLevel();
        System.out.println(Indentor.getIndent()+"StabilJegtabla.Kimenekit()");
        Indentor.degLevel();
    }
    /**
     *     tudatja a kiiratásnál hogy egy StabilJegtablan végzik az esetlegesen
     *    mezobol nem felüldefiniált függvényt 
     */
    public String Name() {
        return "StabilJegtabla";
    }

 

}