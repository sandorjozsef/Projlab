package objects;
import java.util.ArrayList;
import indent.Indentor;

public class Noglu extends Epulet{
	
	
	public void Levon(ArrayList<Szereplo> szereplok)
	{
		Indentor.incLevel();
		System.out.println(Indentor.getIndent() + "Noglu.Levon");
		
		
		for (int i = 0; i < szereplok.size(); i++)
		{
			szereplok.get(i).TesthoHozzaad(-1);
		}
		
		Indentor.degLevel();
	}
}
