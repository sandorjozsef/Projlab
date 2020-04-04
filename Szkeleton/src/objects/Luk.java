package objects;

import indent.Indentor;
/**
 *     olyan osztály amely a játékban szereplő Lukat testesíti meg
 *     és a játékszabályoknak megfelelően ha egy szereplő ide lép
 *     akkor mindig vízbe esik, és egy idő után meghal ha nem sikerül
 *     átlépnie egy másik mezoből leszármazott osztályra
 */
public class Luk extends Mezo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4378829119523386212L;
	public Luk() {
		super();
	}
	/**
     *    megpróbálja befogadni a paraméterként megkapott szereplőt, a régi mezőjéről,
     *    feltéve hogy a szereplő szomszédos mezőről érkezik
     */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.Befogad()");
		
		if(isSzomszed(regi)) {
			szereplok.add(belepo);
			Hatas(belepo);
			if (medve != null)
				medve.Tamadas();
			Indentor.degLevel();
			return true;
		}else {
			Indentor.degLevel();
			return false;
		}
		
		
	}
	
	/**
     *    Ha a Lukra szereplő érkezik akkor az biztos elázik, így meghívja
     *    az elázik függvényt
     */
    public void Hatas(Szereplo sz)
    {
        Indentor.incLevel();
        System.out.println(Indentor.getIndent()+"Luk.Hatas()");
        sz.Elazik();
        Indentor.degLevel();
       
    }
    /**
     * ha valaki lukrol probál meg tárgyat felvenni, akkor nem jár sikerrel
     */
    @Override
    public Targy Atad() {
        // TODO Auto-generated method stub
        Indentor.incLevel();
        System.out.println(Indentor.getIndent()+"Luk.Atad()");
        Indentor.degLevel();
        return null;
       
    }
    /**
     * ha valaki lukra probál meg epuletet epiteni, akkor nem történik semmi
     */
    @Override
    public void setEpulet(Epulet e) {
        // TODO Auto-generated method stub
        Indentor.incLevel();
        System.out.println(Indentor.getIndent()+"Luk.setIglu()");
        Indentor.degLevel();
       
       
    }
    /**
     *     tudatja a kiiratásnál hogy egy Lukon végzik az esetlegesen
     *    mezobol nem felüldefiniált függvényt
     */
    public String Name() {
        return "Luk";
       
    }
}
