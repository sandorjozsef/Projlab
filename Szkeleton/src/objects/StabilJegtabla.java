package objects;

import indent.Indentor;
/**
 *	olyan oszt�ly amely a j�t�kban szerepl� stabilj�gt�bl�t testes�ti meg,
 *	�gy ilyen t�pus� mez�r�l nem lehet v�zbe esni soha, valamint az eszkim�knak
 *	van lehet�s�gik iglut �p�teni r�
 */
public class StabilJegtabla extends Jegtabla{
	/**
	 * 
	 */
	private static final long serialVersionUID = 233506423267307648L;
	public StabilJegtabla(Targy targy){
		super(targy);
		this.targy=targy;
	}
	/**
	 *	f�ggv�ny ami befogadja a belepo szereplot a regi mezorol
	 *	ha szomsz�dos mezorol jon
	 */
	public boolean Befogad(Szereplo belepo, Mezo regi)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Befogad()");
		if(isSzomszed(regi)) 
		{
			this.szereplok.add(belepo);
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
	/**
	 *	fel�ldefini�lt f�ggv�ny ami �p�letet �p�t a mez�re
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
	 *	fel�ldefini�lt f�ggv�ny ami nem engedi hogy StabilJegtablarol
	 *	kimenek�tsenek b�rkit is, ez�rt nem csin�l semmit
	 */
	public void Kimenekit(Mezo cel)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"StabilJegtabla.Kimenekit()");
		Indentor.degLevel();
	}
	/**
	 * 	tudatja a kiirat�sn�l hogy egy StabilJegtablan v�gzik az esetlegesen
	 *	mezobol nem fel�ldefini�lt f�ggv�nyt 
	 */
	public String Name() {
		return "StabilJegtabla";
	}

}
