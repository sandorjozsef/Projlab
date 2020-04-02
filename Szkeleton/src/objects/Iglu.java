package objects;

import java.util.ArrayList;

import indent.Indentor;
/**
 *	olyan oszt�ly amely felel�s az�rt hogy egy adott mezot
 *	ne �rjen h�vihar, ha az adott mezo stabiljegtabla �s
 *	jogosult erre a privil�giumra
 *  
 */
public class Iglu extends Epulet{
	/**
	 *  nem csin�l semmit, hiszen ha iglu van a mez�n akkor nem kell levonni
	 */
	@Override
	public void Levon(ArrayList<Szereplo> szereplok) {
		// TODO Auto-generated method stub
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Iglu.Levon()");
		Indentor.degLevel();
		
		
	}
	/**
	 *	tudatja a kiirat�sn�l hogy egy Iglun v�gzik az esetlegesen
	 *	mezobol nem fel�ldefini�lt f�ggv�nyt	 
	 */
	public String Name() {
		return "Iglu";
	}
	
	/**
	 * 
	 */
	@Override
	public boolean Amortizacio() 
	{
		return false;
	}
	
	/**
	 * 
	 */
	@Override
	public void Tamadas() 
	{}
}
