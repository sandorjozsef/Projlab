package objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

import indent.Indentor;
/**
 * Targy interf�szt megval�s�t� oszt�ly, aminek 3 p�ld�ny�val t�rt�n� felvev�s
 * �s Kepesseg haszn�latot k�vet�en meg lehet nyerni a j�t�kot.
 * @author Aviato
 */
public class Alkatresz implements Targy ,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7878735886482320510L;
	private boolean bejelentheto = true;
	
	/**
	 * A param�terk�nt kapott Szereplo h�vta meg a f�ggv�nyt, amely megpr�b�lja bejelenteni mag�t a Palya sz�m�ra.
	 * Ezt �gy teszi, hogy ezt a v�ltoz�t tov�bb�tja a Palya sz�m�ra az AlkatresztKezel f�ggv�nyen kereszt�l.
	 * @param felhasznalo Jelen esetben l�nyegtelen, de �ltal�ban az a Szereplo, aki t�rolja az adott Alkatresz-t
	 */
	@Override
	public void Kepesseg(Szereplo felhasznalo)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+ Name() + ".Kepesseg()");
		/*String answer = "";
		while(!answer.equals("Y") && !answer.equals("N"))
		{
			System.out.print(Indentor.getIndent() + " - Bejelentheto az adott Alkatresz? (Y/N) ");
			try 
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				answer = reader.readLine();
			}
			catch (Exception e)
			{
				System.err.println(e.getMessage());
			}
			if (answer.equals("Y")) 
			{
				Palya.AlkatresztKezel(true);
			}
			else if (answer.equals("N"))
			{
				Palya.AlkatresztKezel(false);
			}
		}*/
		Palya.AlkatresztKezel(bejelentheto);
		Indentor.degLevel();
	}
	
	/**
	 * Kiirat�shoz haszn�lt f�ggv�ny, amely az oszt�ly nev�t adja vissza egy Stringben.
	 * @return Alkatresz Stringgel fog visszat�rni
	 */
	@Override
	public String Name() {
		return "Alkatresz";
	}
}
