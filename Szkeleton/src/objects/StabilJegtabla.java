package objects;

import indent.Indentor;
/**
 *	olyan osztály amely a játékban szereplõ stabiljégtáblát testesíti meg,
 *	így ilyen típusú mezõrõl nem lehet vízbe esni soha, valamint az eszkimóknak
 *	van lehetõségik iglut építeni rá
 */
public class StabilJegtabla extends Jegtabla{
	public StabilJegtabla(Targy targy){
		super(targy);
		this.targy=targy;
	}
	/**
	 *	függvény ami befogadja a belepo szereplot a regi mezorol
	 *	ha szomszédos mezorol jon
	 */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Befogad()");
		if(isSzomszed(regi)) 
		{
			Hatas(belepo);
			if (medve != null)
				medve.Tamadas();
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
	 *	Ha a StabilJegtablara szereplõ érkezik akkor az biztos megszárad, így meghívja
	 *	a megszarit függvényt
	 */
	public void Hatas(Szereplo sz)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Hatas()");
		sz.Megszarit();
		Indentor.degLevel();
	}
	/**
	 *	felüldefiniált függvény ami iglut épít a mezõre
	 */
	@Override
	public void setEpulet(Epulet e)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.setIglu()");
		iglu = e;
		Indentor.degLevel();
	}
	/**
	 *	felüldefiniált függvény ami nem engedi hogy StabilJegtablarol
	 *	kimenekítsenek bárkit is, ezért nem csinál semmit
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Kimenekit()");
		Indentor.degLevel();
	}
	/**
	 * 	tudatja a kiiratásnál hogy egy StabilJegtablan végzik az esetlegesen
	 *	mezobol nem felüldefiniált függvényt 
	 */
	public String Name() {
		return "StabilJegtabla";
	}

}
