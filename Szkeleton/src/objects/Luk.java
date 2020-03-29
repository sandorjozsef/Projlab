package objects;

import indent.Indentor;

public class Luk extends Mezo{
	public Luk() {
		super();
	}
	/**
	 *	megpr�b�lja befogadni a param�terk�nt megkapott szerepl�t, a r�gi mez�j�r�l,
	 *	felt�ve hogy a szerepl� szomsz�dos mez�r�l �rkezik
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
	/**
	 *	Ha a Lukra szerepl� �rkezik akkor az biztos el�zik, �gy megh�vja
	 *	az el�zik f�ggv�nyt
	 */
	public void Hatas(Szereplo sz)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.Hatas()");
		sz.Elazik();
		Indentor.degLevel();
		
	}
	/**
	 * ha valaki lukrol prob�l meg t�rgyat felvenni, akkor nem j�r sikerrel
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
	 * ha valaki lukra prob�l meg iglut epiteni, akkor nem t�rt�nik semmi
	 */
	@Override
	public void setIglu() {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Luk.setIglu()");
		Indentor.degLevel();
		
		
	}
	/**
	 * 	tudatja a kiirat�sn�l hogy egy Lukon v�gzik az esetlegesen
	 *	mezobol nem fel�ldefini�lt f�ggv�nyt 
	 */
	public String Name() {
		return "Luk";
		
	}
}
