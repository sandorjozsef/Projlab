package objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import indent.Indentor;

public class AlapRuha extends Ruha {
	public void Elazik(Szereplo sz)
	{ 
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"AlapRuha.Kepesseg()");
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N"))
		{
			System.out.print(Indentor.getIndent() + " - Megfagyott az adott Szereplo? (Y/N) ");
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
				sz.Meghaltam();
			}
			else if (answer.equals("N"))
			{}
		}
		Indentor.degLevel();
	}
	
	public void Megszarit()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"AlapRuha.Megszarit()");
		Indentor.degLevel();
	}
	public String Name() {
		return "AlapRuha";
	}
}
