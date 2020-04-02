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
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N")){
			System.out.print(Indentor.getIndent()+" - Van-e m�g h� a mez�n (Y/N) ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				answer = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (answer.equals("Y")) 
			{
				System.out.print(Indentor.getIndent()+" - Nem t�rt�nt �tad�s");
				Indentor.degLevel();
				return null;
			}else {
				Targy t = targy;
				targy = null;
				System.out.print(Indentor.getIndent()+" - T�rgy �tadva");
				Indentor.degLevel();
				return t;
			}
		}
		Indentor.degLevel();
		return null;
	}
}
