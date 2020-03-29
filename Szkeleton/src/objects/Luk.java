package objects;

import indent.Indentor;

public class Luk extends Mezo{
	public Luk() {
		super();
	}
	/*
	 *	megpróbálja befogadni a paraméterként megkapott szereplõt, a régi mezõjérõl,
	 *	feltéve hogy a szereplõ szomszédos mezõrõl érkezik
	 */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.Befogad()");
		
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
	 *	Ha a Lukra szereplõ érkezik akkor az biztos elázik, így meghívja
	 *	az elázik függvényt
	 */
	public void Hatas(Szereplo sz)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.Hatas()");
		sz.Elazik();
		Indentor.degLevel();
		
	}
	/*
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
	/*
	 * ha valaki lukra probál meg iglut epiteni, akkor nem történik semmi
	 */
	@Override
	public void setIglu() {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.setIglu()");
		Indentor.degLevel();
		
		
	}
	/*
	 * 	tudatja a kiiratásnál hogy egy Lukon végzik az esetlegesen
	 *	mezobol nem felüldefiniált függvényt 
	 */
	public String Name() {
		return "Luk";
		
	}
}
