import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AlapRuha extends Ruha {
	public void Elazik(Szereplo sz) throws IOException
	{ 
		String answer = "";
		while(!answer.equals("Y") && !answer.equals("N"))
		{
			System.out.print("Megfagyott az adott Szereplo? (Y/N) ");
			answer = System.console().readLine();
			if (answer.equals("Y")) 
			{
				sz.Meghaltam();
			}
			else if (answer.equals("N"))
			{}
		}
	}
	
	public void Megszarit()
	{}
}
