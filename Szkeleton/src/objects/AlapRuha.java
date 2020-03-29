package objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import indent.Indentor;
/**
 * A Szereplo-h�z tartoz� olyan fajta ruha, amely kezdetben van rajta.
 * Ha ilyen viselete k�zben esik valaki v�zbe, akkor el tud �zni �s id�vel megfagyni
 */
public class AlapRuha extends Ruha {
	@Override
	public void Elazik(Szereplo sz)
	{ 
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"AlapRuha.Elazik()");
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
	@Override
	public void Megszarit()
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent()+"AlapRuha.Megszarit()");
		Indentor.degLevel();
	}
	@Override
	public String Name() {
		return "AlapRuha";
	}
}
