package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import indent.Indentor;
/**
 *	olyan absztrakt oszt�ly amely minden olyan mez� �se ami nem luk,
 * 	�gy a legf�bb k�l�nbs�ge, hogy van lehet�s�g t�rgyat t�rolni rajta,
 *	amit a szerepl�k felvehetnek r�la, ha nincs rajta h�
 */
public abstract class Jegtabla extends Mezo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7327036173303629364L;
	protected Targy targy;
	
	public Jegtabla(Targy t) {
		super();
		targy = t;
	}
	
	/**
	 *	�tadja a jegtablarol a t�rgyat, ha nincs rajta m�r h�,
	 *	majd kit�rli a saj�t attrib�tumai k�z�l
	 */
	public Targy Atad()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+Name()+".Atad()");
		if (this.gethoVastagsag()!=0) 
		{
			Indentor.degLevel();
			return null;
		}
		else
		{
			Targy t = targy;
			targy = null;
			Indentor.degLevel();
			return t;
		}
		
	}
}
