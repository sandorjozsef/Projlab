package objects;

import view.GrafNezet;

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
        
        if(isSzomszed(regi)) 
        {
            this.szereplok.add(belepo);
            szereplok.forEach((sz)->sz.Erintkezik());
            Hatas(belepo);
            return true;
        }
        else 
        {
          
            return false; 
        }
        
    }
    /**
     *    Ha a StabilJegtablara szereplő érkezik akkor az biztos megszárad, így meghívja
     *    a megszarit függvényt
     */
    public void Hatas(Szereplo sz)
    {
      
        sz.Megszarit();
       
    }
    /**
     *    felüldefiniált függvény ami épületet épít a mezőre ha az fel van már derítve
     */
    @Override
    public void setEpulet(Epulet e)
    {
    
        if (getfelderitett())
        	iglu = e;
    
    }
    /**
     *    felüldefiniált függvény ami nem engedi hogy StabilJegtablarol
     *    kimenekítsenek bárkit is, ezért nem csinál semmit
     */
    public void Kimenekit(Mezo cel)
    {
     
    }
    /**
     *     tudatja a kiiratásnál hogy egy StabilJegtablan végzik az esetlegesen
     *    mezobol nem felüldefiniált függvényt 
     */
    public String Name() {
        return "StabilJegtabla";
    }
	@Override
	public void FrissitNezet(GrafNezet n) {
		// TODO Auto-generated method stub
		
	}

 

}