
public class Alkatresz implements Targy {
	public void Kepesseg(Szereplo felhasznalo)
	{
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N"))
		{
			System.out.print("Bejelentheto az adott Alkatresz? (Y/N) ");
			answer = System.console().readLine();
			if (answer.equals("Y")) 
			{
				Palya.AlkatresztKezel(true);
			}
			else if (answer.equals("N"))
			{
				Palya.AlkatresztKezel(false);
			}
		}
	}
}
