import java.util.ArrayList;

public class Noglu extends Epulet{
	public void Levon(ArrayList<Szereplo> szereplok)
	{
		for (int i = 0; i < szereplok.size(); i++)
		{
			szereplok.get(i).TesthoHozzaad(-1);
		}
	}
}
