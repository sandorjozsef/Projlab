package objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import indent.Indentor;

public class Alkatresz implements Targy {
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
}
