package objects;

import indent.Indentor;

public class StabilJegtabla extends Jegtabla{
	public StabilJegtabla(Targy targy){
		super();
		this.targy=targy;
	}
	/*
	 *	függvény ami befogadja a belepo szereplot a regi mezorol
	 *	ha szomszédos mezorol jon
	 */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Befogad()");
		if(isSzomszed(regi)) {
			Hatas(belepo);
			Indentor.degLevel();
			return true;
		}else {
			Indentor.degLevel();
			return false; 
		}
		
	}
	/*
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
	/*
	 *	felüldefiniált függvény ami iglut épít a mezõre
	 */
	@Override
	public void setIglu()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.setIglu()");
		Iglu iglu1 = new Iglu();
		iglu=iglu1;
		Indentor.degLevel();
	}
	/*
	 *	felüldefiniált függvény ami nem engedi hogy StabilJegtablarol
	 *	kimenekítsenek bárkit is, ezért nem csinál semmit
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Kimenekit()");
		Indentor.degLevel();
	}
	/*
	 * 	tudatja a kiiratásnál hogy egy StabilJegtablan végzik az esetlegesen
	 *	mezobol nem felüldefiniált függvényt 
	 */
	public String Name() {
		return "StabilJegtabla";
	}

}
