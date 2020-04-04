package objects;

import indent.Indentor;
/**
 * 	olyan oszt�ly amely a j�t�kban szerepl� Lukat testes�ti meg
 * 	�s a j�t�kszab�lyoknak megfelel�en ha egy szerepl� ide l�p 
 * 	akkor mindig v�zbe esik, �s egy id� ut�n meghal ha nem siker�l
 * 	�tl�pnie egy m�sik mezob�l lesz�rmazott oszt�lyra
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
	 *	megpr�b�lja befogadni a param�terk�nt megkapott szerepl�t, a r�gi mez�j�r�l,
	 *	felt�ve hogy a szerepl� szomsz�dos mez�r�l �rkezik
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
	 * ha valaki lukra prob�l meg epuletet epiteni, akkor nem t�rt�nik semmi
	 */
	@Override
	public void setEpulet(Epulet e) {
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
