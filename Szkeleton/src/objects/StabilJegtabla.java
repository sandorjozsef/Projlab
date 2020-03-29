package objects;

import indent.Indentor;

public class StabilJegtabla extends Jegtabla{
	public StabilJegtabla(Targy targy){
		super();
		this.targy=targy;
	}
	/*
	 *	f�ggv�ny ami befogadja a belepo szereplot a regi mezorol
	 *	ha szomsz�dos mezorol jon
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
	 *	Ha a StabilJegtablara szerepl� �rkezik akkor az biztos megsz�rad, �gy megh�vja
	 *	a megszarit f�ggv�nyt
	 */
	public void Hatas(Szereplo sz)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Hatas()");
		sz.Megszarit();
		Indentor.degLevel();
	}
	/*
	 *	fel�ldefini�lt f�ggv�ny ami iglut �p�t a mez�re
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
	 *	fel�ldefini�lt f�ggv�ny ami nem engedi hogy StabilJegtablarol
	 *	kimenek�tsenek b�rkit is, ez�rt nem csin�l semmit
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Kimenekit()");
		Indentor.degLevel();
	}
	/*
	 * 	tudatja a kiirat�sn�l hogy egy StabilJegtablan v�gzik az esetlegesen
	 *	mezobol nem fel�ldefini�lt f�ggv�nyt 
	 */
	public String Name() {
		return "StabilJegtabla";
	}

}
