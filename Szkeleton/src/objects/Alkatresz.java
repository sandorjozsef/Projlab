package objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import indent.Indentor;
/**
 * Targy interfészt megvalósító osztály, aminek 3 példányával történõ felvevés
 * és Kepesseg használatot követõen meg lehet nyerni a játékot.
 * @author Aviato
 */
public class Alkatresz implements Targy {
	/**
	 * A paraméterként kapott Szereplo hívta meg a függvényt, amely megpróbálja bejelenteni magát a Palya számára.
	 * Ezt úgy teszi, hogy ezt a változót továbbítja a Palya számára az AlkatresztKezel függvényen keresztül.
	 * @param felhasznalo Jelen esetben lényegtelen, de általában az a Szereplo, aki tárolja az adott Alkatresz-t
	 */
	@Override
	public void Kepesseg(Szereplo felhasznalo)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"Alkatresz.Kepesseg()");
		String answer = "";
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
		}
		Indentor.degLevel();
	}
	
	/**
	 * Kiiratáshoz használt függvény, amely az osztály nevét adja vissza egy Stringben.
	 * @return Alkatresz Stringgel fog visszatérni
	 */
	@Override
	public String Name() {
		return "Alkatresz";
	}
}
